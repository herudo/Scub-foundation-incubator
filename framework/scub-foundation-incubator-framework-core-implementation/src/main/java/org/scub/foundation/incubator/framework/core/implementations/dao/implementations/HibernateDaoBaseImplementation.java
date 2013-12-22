package org.scub.foundation.incubator.framework.core.implementations.dao.implementations;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.util.Version;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.scub.foundation.framework.base.paging.RemotePagingDto;
import org.scub.foundation.framework.base.paging.RemotePagingSortDto;
import org.scub.foundation.framework.core.lucene.SfDefaultLuceneAnalyser;
import org.scub.foundation.incubator.framework.core.implementations.searchCriterion.query.HqlQuery;

/**
 * Dao implementation for hibernate.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class HibernateDaoBaseImplementation {
    /** the session factory. */
    protected SessionFactory sessionFactory;

    /**
     * Get the current hibernate session.
     * @return la Session hibernate.
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Create a new criteria.
     * @param persistentClass The persistant class for the criteria.
     * @return the criteria.
     */
    protected final Criteria createCriteria(Class<?> persistentClass) {
        return getSession().createCriteria(persistentClass);
    }

    /**
     * Create a new criteria.
     * @param persistentClass The persistant class for the criteria.
     * @param paging the paging dto.
     * @return the criteria.
     */
    protected final Criteria createCriteria(Class<?> persistentClass, RemotePagingDto paging) {
        final Criteria crit = getSession().createCriteria(persistentClass);
        if (paging != null) {
            crit.setFirstResult(paging.getFirstResult()).setMaxResults(paging.getMaxResult());
            for (RemotePagingSortDto sort : paging.getListeSorts()) {
                crit.addOrder(sort.isAscending() ? Order.asc(sort.getSortField()) : Order.desc(sort.getSortField()));
            }
        }
        return crit;
    }

    /**
     * Create a new criteria.
     * @param persistentClass The persistant class for the criteria.
     * @param alias The alias criteria
     * @return the criteria.
     */
    protected final Criteria createCriteria(Class<?> persistentClass, String alias) {
        return getSession().createCriteria(persistentClass, alias);
    }

    /**
     * Create a new query from hql.
     * @param hql the query
     * @return the hibernate query
     */
    protected final Query createQuery(String hql) {
        return getSession().createQuery(hql);
    }

    /**
     * Create a new query from hql.
     * @param hql the query
     * @param paging the paging dto.
     * @return the hibernate query
     */
    protected final Query createQuery(String hql, RemotePagingDto paging) {
        final StringBuffer sqlBuffer = new StringBuffer(hql);
        if (paging != null) {
            if (!paging.getListeSorts().isEmpty()) {
                sqlBuffer.append(" ORDER BY ");
                for (int index = 0; index < paging.getListeSorts().size(); index++) {
                    final RemotePagingSortDto sort = paging.getListeSorts().get(index);
                    sqlBuffer.append(sort.getSortField()).append(sort.isAscending() ? " ASC " : " DESC ");
                    if (index != (paging.getListeSorts().size() - 1)) {
                        sqlBuffer.append(",");
                    }
                }
            }
        }

        final Query query = getSession().createQuery(sqlBuffer.toString());
        if (paging != null) {
            query.setFirstResult(paging.getFirstResult());
            query.setMaxResults(paging.getMaxResult());
        }
        return query;
    }

    /**
     * Create a new query from HqlQuery.
     * @param hqlQuery the query
     * @return the hibernate query
     */
    protected final Query createQuery(HqlQuery hqlQuery) {
        if (hqlQuery != null) {
            return createQuery(hqlQuery, null);
        } else {
            return null;
        }
    }

    /**
     * Create a new query from HqlQuery.
     * @param hqlQuery the query
     * @param paging the paging dto.
     * @return the hibernate query
     */
    protected final Query createQuery(HqlQuery hqlQuery, RemotePagingDto paging) {
        if (hqlQuery != null) {
            final Query query = createQuery(hqlQuery.getHqlQuery().toString(), paging);
            hqlQuery.setSearchCriterionParameters(query);
            return query;
        }
        return null;
    }

    /**
     * Create a sql query from the sql string.
     * @param sql the sql string query.
     * @return the hibernate sql query
     */
    protected final SQLQuery createSqlQuery(String sql) {
        return getSession().createSQLQuery(sql);
    }

    /**
     * Create a sql query from the sql string.
     * @param sql the sql string query.
     * @param paging the paging dto.
     * @return the hibernate sql query
     */
    protected final SQLQuery createSqlQuery(String sql, RemotePagingDto paging) {

        final StringBuffer sqlBuffer = new StringBuffer(sql);
        if (paging != null) {
            if (!paging.getListeSorts().isEmpty()) {
                sqlBuffer.append(" ORDER BY ");
                for (int index = 0; index < paging.getListeSorts().size(); index++) {
                    final RemotePagingSortDto sort = paging.getListeSorts().get(index);
                    sqlBuffer.append(sort.getSortField()).append(sort.isAscending() ? " ASC " : " DESC ");
                    if (index != (paging.getListeSorts().size() - 1)) {
                        sqlBuffer.append(",");
                    }
                }
            }
        }

        final SQLQuery query = getSession().createSQLQuery(sqlBuffer.toString());
        if (paging != null) {
            query.setFirstResult(paging.getFirstResult());
            query.setMaxResults(paging.getMaxResult());
        }
        return query;
    }

    /**
     * Get all instance for the specified persistant class.
     * @param persistentClass The persistant class.
     * @return the instances.
     */
    protected final List<?> loadAll(Class<?> persistentClass) {
        final Criteria criteria = getSession().createCriteria(persistentClass);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    /**
     * save an hibernate pojo.
     * @param pojo the object to persist.
     */
    protected final void save(Object pojo) {
        getSession().persist(pojo);
    }

    /**
     * update an hibernate pojo.
     * @param pojo the object to update.
     */
    protected final void update(Object pojo) {
        getSession().update(pojo);
    }

    /**
     * save or update an hibernate pojo.
     * @param pojo the object to save or update.
     */
    protected final void saveOrUpdate(Object pojo) {
        getSession().saveOrUpdate(pojo);
    }

    /**
     * delete an hibernate pojo.
     * @param pojo the object to delete.
     */
    protected final void delete(Object pojo) {
        getSession().delete(pojo);
    }

    /**
     * delete a list of hibernate pojos.
     * @param array the objects to delete.
     */
    protected void deleteAll(Collection<?> array) {
        for (Object object : array) {
            getSession().delete(object);
        }
    }

    /**
     * Get an object of the persistant class corresponding to the given id.
     * @param id the object id.
     * @param persistentClass The persistant class.
     * @param <E> the return type.
     * @return the object or null if the id is null or not object is correspondig.
     */
    @SuppressWarnings("unchecked")
    protected final <E>E load(final Serializable id, final Class<?> persistentClass) {
        if (id != null) {
            return (E) getSession().get(persistentClass, id);
        } else {
            return null;
        }
    }

    /**
     * Get a full text session.
     * @return the session.
     */
    public synchronized FullTextSession getFullTextSession() {
        return Search.getFullTextSession(getSession());
    }

    /**
     * Create a full text query from the given lucene query.
     * @param luceneQuery the lucene query
     * @param persistentClass The persistant class.
     * @return an hibernate query.
     */
    protected final FullTextQuery createFullTextQuery(org.apache.lucene.search.Query luceneQuery, Class<?> persistentClass) {
        return getFullTextSession().createFullTextQuery(luceneQuery, persistentClass);
    }

    /**
     * get the default analyser.
     * @deprecated use instead getAnalyser(Class entities).
     * @return the default analyser
     */
    @Deprecated
    protected Analyzer getDefaultAnalysers() {
        return new SfDefaultLuceneAnalyser();
    }

    /**
     * get the default analyser.
     * @param persistentClass The persistant class.
     * @return the default analyser
     */
    protected Analyzer getAnalyser(Class<?> persistentClass) {
        return getFullTextSession().getSearchFactory().getAnalyzer(persistentClass);
    }

    /**
     * Get the lucene version.
     * @return get the lucene version.
     */
    protected Version getMatchingVersion() {
        return Version.LUCENE_24;
    }

    /**
     * Get the query parser for an IN CLAUSE.
     * @param field the field
     * @param values the values
     * @return the query
     */
    protected org.apache.lucene.search.Query getInQuery(String field, List<String> values) {
        final BooleanQuery booleanQuery = new BooleanQuery();
        for (String value : values) {
            booleanQuery.add(new TermQuery(new Term(field, value)), BooleanClause.Occur.SHOULD);
        }
        return booleanQuery;
    }

    /**
     * Set the session factory.
     * @param sessionFactory the sessionFactory to set.
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
