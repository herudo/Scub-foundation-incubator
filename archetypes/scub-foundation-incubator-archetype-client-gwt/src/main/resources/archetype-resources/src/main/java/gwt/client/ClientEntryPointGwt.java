package ${package}.gwt.client;

import ${package}.gwt.client.controller.AppController;

import ${package}.gwt.client.factory.AppClientFactory;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Application entry point.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
public final class ClientEntryPointGwt implements EntryPoint {

    /**
     * {@inheritDoc}
     */
    public void onModuleLoad() {
        AppClientFactory.getAppController().showPresenter(RootLayoutPanel.get());
    }
}