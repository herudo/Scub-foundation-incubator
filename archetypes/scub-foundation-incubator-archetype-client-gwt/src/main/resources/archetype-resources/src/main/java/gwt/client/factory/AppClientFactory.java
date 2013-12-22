package ${package}.gwt.client.factory;

import ${package}.gwt.client.bundle.ExampleProjectResources;
import ${package}.gwt.client.controller.AppController;
import ${package}.gwt.client.controller.AppLayout;
import ${package}.gwt.client.i18n.AppMessages;
import ${package}.gwt.client.layout.AppLayoutImpl;
import ${package}.gwt.client.presenter.ExamplePresenter.ExampleView;
import ${package}.gwt.client.view.ExampleViewImpl;

import com.google.gwt.core.client.GWT;

/**
 * Client Factory.
 * @author Clément Lavaud (clement.lavaud@scub.net)
 */
public final class AppClientFactory {

    private static AppController appController;

    private static AppLayout layout;

    private static AppMessages messages;

    private static ExampleProjectResources resources;

    private AppClientFactory() {
    }

    /**
     * Create and get an instance of appController.
     * @return the controller
     */
    public static AppController getAppController() {
        if (appController == null) {
            appController = GWT.create(AppController.class);
        }
        return appController;
    }

    /**
     * Create and get an instance of layout.
     * @return the layout
     */
    public static AppLayout getLayout() {
        if (layout == null) {
            layout = GWT.create(AppLayoutImpl.class);
        }
        return layout;
    }

    /**
     * Create and get an instance of messages.
     * @return the messages
     */
    public static AppMessages getMessages() {
        if (messages == null) {
            messages = GWT.create(AppMessages.class);
        }
        return messages;
    }

    /**
     * Create and get an instance of resources.
     * @return the resources
     */
    public static ExampleProjectResources getResources() {
        if (resources == null) {
            resources = GWT.create(ExampleProjectResources.class);
        }
        return resources;
    }

    /**
     * Create a new instance of ExampleView.
     * @return the ExampleView
     */
    public static ExampleView getExampleView() {
        return new ExampleViewImpl();
    }
}
