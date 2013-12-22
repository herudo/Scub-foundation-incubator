package ${package}.gwt.client.service;

import ${package}.gwt.shared.ExampleModel;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Service asynchrone sur les examples.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
public interface ExampleServiceGwtAsync {

    /**
     * Recuperer un exemple.
     * @param callBack le callback
     */
    void getExample(AsyncCallback < ExampleModel > callBack);

}