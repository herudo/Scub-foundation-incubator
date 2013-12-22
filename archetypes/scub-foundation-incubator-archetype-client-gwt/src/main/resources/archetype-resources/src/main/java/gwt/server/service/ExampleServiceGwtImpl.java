package ${package}.gwt.server.service;

import ${package}.gwt.client.service.ExampleServiceGwt;
import ${package}.gwt.shared.ExampleModel;

/**
 * Implementation du service sur les examples.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
public final class ExampleServiceGwtImpl implements ExampleServiceGwt {

    /**
     * {@inheritDoc}
     */
    public ExampleModel getExample() {
        final ExampleModel exemple = new ExampleModel();
        exemple.setProperty("Value");
        return exemple;
    }

}