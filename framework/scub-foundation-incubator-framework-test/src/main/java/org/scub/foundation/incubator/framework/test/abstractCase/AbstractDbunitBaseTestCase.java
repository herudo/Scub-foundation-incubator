package org.scub.foundation.incubator.framework.test.abstractCase;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.RootLogger;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.DataTypeException;
import org.dbunit.dataset.datatype.DefaultDataTypeFactory;
import org.dbunit.dataset.datatype.IDataTypeFactory;
import org.dbunit.dataset.xml.FlatDtdWriter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hsqldb.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.scub.foundation.framework.core.test.DbUnitTestCaseException;

/**
 * Classe de Base pour les tests unitaires.
 * @author Goumard Stéphane (stephane.goumard@scub.net)
 */
public abstract class AbstractDbunitBaseTestCase extends AbstractSpringBaseTestCase {
    /**
     * Data Source pour les recuperer les connections.
     */
    private DataSource dataSource;

    /**
     * Logger.
     */
    private static final Logger LOGGER = RootLogger.getLogger(AbstractDbunitBaseTestCase.class);

    /**
     * Private port for HsqlDbServer.
     */
    private static final int PORT_HSQLDB_SERVER = 9015;

    /**
     * Recuperer le nom du bean spring pour la dataSource. Vous pouvez redefinir cette methode dans chaque test pour utiliser un nom de bean different.
     * @return par defaut le nom de Bean dataSource.
     */
    protected String getNameBeanDataSource() {
        return "dataSource";
    }

    /**
     * Recuperer le nom des fichiers xml dateSet des données. vous pouvez redefinir cette methode dans chaque test pour utiliser un dateSetDifferent.
     * @return le nom simple des fichier xml dateset présents dans la class path ex: new String[]{"dataset.xml"}.
     */
    protected String[] getXmlDateSet() {
        return new String[] {"dataset.xml"};
    }

    /**
     * Permet de donner une liste de tables du dataset dont on souhaite supprimer les données avec des delete where id avant de supprimer le delete all.
     * @return la liste des tables.
     */
    protected String[] getIncludeTableOnDeleteOperation() {
        return new String[0];
    }

    /**
     * {@inheritDoc}
     */
    @Before
    public void setUpBaseTestCase() throws Exception {
        dataSource = (DataSource) this.getBeanSpring(getNameBeanDataSource());
        final IDatabaseConnection connection = getConnection();

        try {
            DatabaseOperation.CLEAN_INSERT.execute(connection, getDataSet());
            executeRequetesSql(connection);

            // Creation of a DTD which will be used in the autocompletion of datasets
            final IDataSet dataSet = connection.createDataSet();
            final Writer out = new OutputStreamWriter(new FileOutputStream("conf/test/resources/database.dtd"));
            final FlatDtdWriter datasetWriter = new FlatDtdWriter(out);
            datasetWriter.setContentModel(FlatDtdWriter.CHOICE);
            datasetWriter.write(dataSet);

            // INDEXATION AUTOMATIQUE
            if (getClassManualIndexChanges().length > 0) {
                final SessionFactory sessionFactory = (SessionFactory) getBeanSpring(getSessionFactoryHibernageSearchBeanName());
                final Session session = sessionFactory.openSession();
                final FullTextSession fullTextSession = Search.getFullTextSession(session);
                fullTextSession.setFlushMode(FlushMode.MANUAL);
                fullTextSession.setCacheMode(CacheMode.IGNORE);
                final Transaction transaction = fullTextSession.beginTransaction();
                final int batchSize = 25;
                for (Class<?> clazz : getClassManualIndexChanges()) {
                    LOGGER.debug("Manual Indexe using flushToIndexes on " + clazz.getSimpleName());
                    final ScrollableResults results = fullTextSession.createCriteria(clazz).setFetchSize(batchSize).scroll(ScrollMode.FORWARD_ONLY);
                    int index = 0;
                    while (results.next()) {
                        index++;
                        fullTextSession.index(results.get(0));
                        if (index % batchSize == 0) {
                            fullTextSession.flushToIndexes();
                            fullTextSession.clear();
                        }
                    }
                }
                transaction.commit();
                session.close();
            }
        } catch (Exception e) {
            throw new DbUnitTestCaseException(e);
        } finally {
            connection.close();
        }
    }

    /** {@inheritDoc} */
    @After
    public void tearDownBaseTestCase() throws Exception {
        final IDatabaseConnection connection = getConnection();
        try {
            if (getIncludeTableOnDeleteOperation().length > 0) {
                deleteSqlStatement();
            }
            DatabaseOperation.DELETE_ALL.execute(connection, getDataSet());

            // PURGE DE L'INDEX HIBERNATE SEARCH
            if (getClassManualIndexChanges().length > 0) {
                final SessionFactory sessionFactory = (SessionFactory) getBeanSpring(getSessionFactoryHibernageSearchBeanName());
                final Session session = sessionFactory.openSession();
                final FullTextSession fullTextSession = Search.getFullTextSession(session);
                final Transaction transaction = fullTextSession.beginTransaction();
                for (Class<?> clazz : getClassManualIndexChanges()) {
                    LOGGER.debug("Manual Indexe purge indexe on " + clazz.getSimpleName());
                    fullTextSession.purgeAll(clazz);
                }
                transaction.commit();
                session.close();
            }
        } catch (Exception e) {
            throw new DbUnitTestCaseException(e);
        } finally {
            connection.close();
        }
    }

    /**
     * Permet de donner une liste de tables du dataset dont on souhaite supprimer les données avec des delete where id avant de supprimer le delete all.
     * @return la liste des tables.
     */
    protected String getSessionFactoryHibernageSearchBeanName() {
        return "sessionFactory";
    }

    /**
     * Permet de gérer manuellement une liste de classe indexé par hibernate search. Effectue une indexation de masse et un purge de chacune de ces classes
     * avant et apres chaque test unitaire.
     * @return la liste des tables.
     */
    protected Class<?>[] getClassManualIndexChanges() {
        return new Class[0];
    }

    /**
     * Supprimer les entrées des tables par delete where id ? avec deux pass pour gestion recursivité.
     * @throws SQLException Erreur sql non gérée.
     * @throws Exception Toutes les erreurs non gérée.
     */
    private void deleteSqlStatement() throws SQLException, Exception {
        final Connection connection = getConnection().getConnection();
        final Statement stmt = connection.createStatement();
        final DatabaseMetaData metaData = connection.getMetaData();
        for (String table : getIncludeTableOnDeleteOperation()) {
            final List<String> sqlDeleteTwoPassViolation = new ArrayList<String>();
            // RECUPERE LES CLES PRIMAIRE
            ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, table);
            String sqlSelect = "";
            final List<String> pks = new ArrayList<String>();
            while (primaryKeys.next()) {
                pks.add(primaryKeys.getString("COLUMN_NAME"));
                sqlSelect += primaryKeys.getString("COLUMN_NAME") + ",";
            }
            sqlSelect = sqlSelect.substring(0, sqlSelect.lastIndexOf(","));
            LOGGER.debug(" DELETESQLSTMT SELECT SQL : " + "select " + sqlSelect + " from " + table);
            final ResultSet resultSelect = stmt.executeQuery("select " + sqlSelect + " from " + table);
            while (resultSelect.next()) {
                String sqlDelete = "";
                for (int index = 1; index < resultSelect.getMetaData().getColumnCount() + 1; index++) {
                    sqlDelete =
                        pks.get(index - 1)
                            + "="
                            + "'"
                            + (resultSelect.getMetaData().getColumnType(index) == Types.BIGINT ? String.valueOf(resultSelect.getLong(index)) : resultSelect
                                    .getString(index)) + "' AND ";
                }
                sqlDelete = sqlDelete.substring(0, sqlDelete.lastIndexOf("AND"));
                try {
                    LOGGER.debug(" DELETESQLSTMT DELETE SQL : " + "delete from " + table + " where " + sqlDelete);
                    stmt.executeQuery("delete from " + table + " where " + sqlDelete);
                } catch (SQLException e) {
                    LOGGER.debug(" DELETESQLSTMT ADD CANDIDATE TO SECOND PASS : " + "delete from " + table + " where " + sqlDelete);
                    sqlDeleteTwoPassViolation.add("delete from " + table + " where " + sqlDelete);
                }

            }
            for (int index = sqlDeleteTwoPassViolation.size() - 1; index >= 0; index--) {
                LOGGER.debug(" DELETESQLSTMT SECOND PASS DELETE SQL : " + sqlDeleteTwoPassViolation.get(index));
                stmt.executeQuery(sqlDeleteTwoPassViolation.get(index));
            }
        }
        stmt.close();
        connection.close();
    }

    /**
     * Server hsqldb.
     */
    private static Server server;

    /**
     * Execute before each test class.
     */
    @BeforeClass
    public static void setUpClass() {
        LOGGER.debug("start hsqldb server database path : " + "mem:test;sql.enforce_strict_size=true,shutdown=true");
        server = new Server();
        server.setDatabaseName(0, "test");
        server.setPort(PORT_HSQLDB_SERVER);
        server.setDatabasePath(0, "mem:test;sql.enforce_strict_size=true,shutdown=true");
        server.setErrWriter(null);
        server.setLogWriter(null);
        server.start();
    }

    /**
     * Recuperer une date type factory en fonction du type de la connection de la base.
     * @param cnx la connection a la base.
     * @return type factory adapte.
     * @throws Exception .
     */
    private IDataTypeFactory getDataTypeFactory(Connection cnx) throws Exception {
        final String dbName = cnx.getMetaData().getDatabaseProductName();
        if ("Oracle".equals(dbName)) {
            return new OracleDataTypeFactory();
        }
        if ("MySQL".equals(dbName)) {
            return new MySqlDataTypeFactory();
        }
        if ("HSQL Database Engine".equals(dbName)) {
            return new HsqlDataTypeFactory();
        }
        return new DefaultDataTypeFactory();
    }

    /**
     * {@inheritDoc}
     */
    private IDatabaseConnection getConnection() throws Exception {
        final IDatabaseConnection connection = new DatabaseConnection(dataSource.getConnection());
        final DatabaseConfig config = connection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, getDataTypeFactory(connection.getConnection()));
        return connection;
    }

    /**
     * {@inheritDoc}
     */
    private CompositeDataSet getDataSet() throws Exception {
        final String[] xmlDataSet = getXmlDateSet();
        final ReplacementDataSet[] listDataSet = new ReplacementDataSet[xmlDataSet.length];
        for (int i = 0; i < xmlDataSet.length; i++) {
            final InputStream res = this.getClass().getResourceAsStream("/" + xmlDataSet[i]);
            if (res == null) {
                throw new FileNotFoundException("The dataset '" + xmlDataSet[i] + "' has not been found");
            }
            final FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
            flatXmlDataSetBuilder.setDtdMetadata(false);
            final ReplacementDataSet dataSet = new ReplacementDataSet(flatXmlDataSetBuilder.build(res));
            dataSet.addReplacementObject("null", null);
            listDataSet[i] = dataSet;
        }
        return new CompositeDataSet(listDataSet);
    }

    /**
     * Factory pour la gestion des types SQL pour DBUnit couplé avec HSQLDB.
     * @author Juanito Gonçalves (juanito.goncalves@scub.net)
     */
    private class HsqlDataTypeFactory extends DefaultDataTypeFactory {
        /** {@inheritDoc} */
        public DataType createDataType(int sqlType, String sqlTypeName) throws DataTypeException {
            if (sqlType == Types.BOOLEAN) {
                return DataType.BOOLEAN;
            }
            return super.createDataType(sqlType, sqlTypeName);
        }
    }

    /**
     * Exécute les requêtes SQL du fichier.
     * @param connection la connection à la base de données
     * @throws Exception une exception éventuelle
     */
    private void executeRequetesSql(IDatabaseConnection connection) throws Exception {
        if (getFichierRequetesSql() != null) {
            final StringBuffer requeteSql = new StringBuffer();
            // Lecture du fichier
            final Scanner scanner = new Scanner(this.getClass().getResourceAsStream("/" + getFichierRequetesSql()));
            // On boucle sur chaque ligne
            while (scanner.hasNextLine()) {
                requeteSql.append(scanner.nextLine());
            }
            scanner.close();
            // On joue la requête si elle n'est pas vide
            if (requeteSql.length() > 0) {
                final Statement statement = connection.getConnection().createStatement();
                statement.execute(requeteSql.toString());
                statement.close();
            }
        }
    }

    /**
     * Récupère un fichier SQL permettant de jouer des requêtes SQL après l'ajout du dataset.
     * @return le nom du fichier SQL
     */
    protected String getFichierRequetesSql() {
        return null;
    }
}
