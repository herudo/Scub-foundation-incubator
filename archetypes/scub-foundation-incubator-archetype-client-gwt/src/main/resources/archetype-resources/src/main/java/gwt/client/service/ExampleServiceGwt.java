package ${package}.gwt.client.service;

import ${package}.gwt.shared.ExampleModel;
import org.scub.foundation.framework.gwt.module.client.exception.GwtRunTimeExceptionGwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Service pour les examples.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
@RemoteServiceRelativePath("handler/exampleService")
public interface ExampleServiceGwt extends RemoteService {

    /**
     * Class statique permettant de recuperer une instance du service asynchrone.
     */
    public static final class App {
        private static ExampleServiceGwtAsync app = null;

        /**
         * Constructeur prive.
         */
        private App() {}

        /**
         * Recupere l'instance du service.
         * @return le service.
         */
        public static synchronized ExampleServiceGwtAsync getInstance() {
            if (app == null) {
                app = (ExampleServiceGwtAsync) GWT.create(ExampleServiceGwt.class);
            }
            return app;
        }
    }

    /**
     * Recuperer un exemple.
     * @return l'exemple
     * @throws GwtRunTimeExceptionGwt l'erreur Gwt
     */
    ExampleModel getExample() throws GwtRunTimeExceptionGwt;

}