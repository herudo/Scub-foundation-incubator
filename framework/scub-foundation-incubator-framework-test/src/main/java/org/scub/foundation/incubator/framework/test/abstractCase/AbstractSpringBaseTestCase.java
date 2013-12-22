package org.scub.foundation.incubator.framework.test.abstractCase;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractSpringBaseTestCase extends AbstractBaseTestCase {

    /**
     * Recuperer l'identifiant du provider manager pour l'authentification. Vous pouvez redefinir cette methode dans chaque test pour utiliser un nom de bean
     * different.
     * @return identifiant du bean valeur par defaut "authenticationProvider"
     */
    protected String getAuthenticationProviderManagerBeanId() {
        return "authenticationManager";
    }

    /**
     * Création du contexte sécurisé.
     * @param username le nom d'utilisateur
     * @param password le mot de passe
     */
    protected final void createSecureContext(final String username, final String password) {
        destroySecurityContext();
        final ProviderManager providerManager = (ProviderManager) this.getBeanSpring(getAuthenticationProviderManagerBeanId());
        final Authentication auth = providerManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    /** Détruit le contexte de sécurité. */
    private void destroySecurityContext() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    /**
     * Recuperer un Bean Spring dans le Contexte.
     * @param beanId identifiant du bean.
     * @return une instance du bean demandé.
     */
    protected final Object getBeanSpring(final String beanId) {
        return getApplicationContext().getBean(beanId);
    }

    /** {@inheritDoc} */
    @After
    public void tearDownBaseTestCase() throws Exception {
        destroySecurityContext();
    }

    private ApplicationContext applicationContext;

    /**
     * Recuperer un Bean Spring dans le Contexte.
     * @param beanId identifiant du bean.
     * @return une instance du bean demandé.
     */
    protected final ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            final List<String> contextFiles = getContextFiles();
            applicationContext = new ClassPathXmlApplicationContext(contextFiles.toArray(new String[contextFiles.size()]));
        }
        return applicationContext;
    }

    /**
     * Recuperer une liste de fichiers suplémentaire de contexte spring. Vous pouvez redefinir cette methode dans chaque test pour une liste de fichiers de
     * configuration supplémentaire.
     * @return un tableau avec le nom de chaque fichier disponible dans le classPath de l'application.
     */
    public List<String> getContextFiles() {
        final List<String> contextFiles = new ArrayList<String>();
        contextFiles.add("applicationContext.xml");
        contextFiles.add("securiteServiceContext.xml");
        contextFiles.add("securiteServiceSpecContext.xml");
        contextFiles.add("rmiServiceImporterMockContext.xml");
        return contextFiles;
    }
}
