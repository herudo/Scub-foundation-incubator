package scub.foundation.incubator.gwt.module.gwt.client.factory;

import scub.foundation.incubator.gwt.module.gwt.client.bundle.ScubFoundationIncubatorResources;
import scub.foundation.incubator.gwt.module.gwt.client.controller.AppController;
import scub.foundation.incubator.gwt.module.gwt.client.controller.AppLayout;
import scub.foundation.incubator.gwt.module.gwt.client.i18n.AppMessages;
import scub.foundation.incubator.gwt.module.gwt.client.layout.AppLayoutImpl;
import scub.foundation.incubator.gwt.module.gwt.client.test.service.PersonneTypeServiceGwt;
import scub.foundation.incubator.gwt.module.gwt.client.test.service.PersonneTypeServiceGwtAsync;

import com.google.gwt.core.client.GWT;

/**
 * Client Factory.
 * @author Clément Lavaud (clement.lavaud@scub.net)
 */
public final class AppClientFactory {

    private static AppController appController;

    private static AppLayout layout;

    private static AppMessages messages;

    private static ScubFoundationIncubatorResources resources;

    private static PersonneTypeServiceGwtAsync personneTypeService;

    private AppClientFactory() {
    }

    /**
     * Create and get an instance of personneTypeService.
     * @return the personneTypeService.
     */
    public static PersonneTypeServiceGwtAsync getPersonneTypeService() {
        if (personneTypeService == null) {
            personneTypeService = GWT.create(PersonneTypeServiceGwt.class);
        }
        return personneTypeService;
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
    public static ScubFoundationIncubatorResources getResources() {
        if (resources == null) {
            resources = GWT.create(ScubFoundationIncubatorResources.class);
        }
        return resources;
    }
}
