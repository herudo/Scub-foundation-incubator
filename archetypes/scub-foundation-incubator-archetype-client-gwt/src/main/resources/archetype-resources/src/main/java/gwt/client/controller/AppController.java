package ${package}.gwt.client.controller;

import ${package}.gwt.client.bundle.ExampleProjectResources;
import ${package}.gwt.client.i18n.AppMessages;
import ${package}.gwt.client.presenter.ExamplePresenter;

import org.scub.foundation.framework.gwt.module.client.factory.ClientFactory;
import org.scub.foundation.framework.gwt.module.client.mvp.controller.Controller;
import org.scub.foundation.framework.gwt.module.client.mvp.management.alert.AlertPresenter;
import org.scub.foundation.framework.gwt.module.client.mvp.management.confirm.ConfirmPresenter;
import org.scub.foundation.framework.gwt.module.client.mvp.management.error.ErrorPresenter;
import org.scub.foundation.framework.gwt.module.client.mvp.management.loading.LoadingPresenter;
import org.scub.foundation.framework.gwt.module.client.mvp.view.View;
import org.scub.foundation.framework.gwt.module.client.util.TokenUtil;
import org.scub.foundation.framework.gwt.module.client.util.composants.tabpanel.event.SelectTabEvent;
import org.scub.foundation.framework.gwt.module.client.util.composants.tabpanel.event.SelectTabHandler;

import ${package}.gwt.client.controller.AppLayout;
import ${package}.gwt.client.factory.AppClientFactory;

import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Application controller.
 * @author Anthony Guillemette (anthony.guillemette@scub.net) - SCUB
 */
public class AppController extends Controller implements ValueChangeHandler<String> {

    private AppLayout layout = AppClientFactory.getLayout();

    private ExamplePresenter examplePresenter = GWT.create(ExamplePresenter.class);

    private LoadingPresenter loadingPresenter = ClientFactory.getLoadingPresenter();

    private ErrorPresenter errorPresenter = ClientFactory.getErrorPresenter();

    private ConfirmPresenter confirmPresenter = ClientFactory.getConfirmPresenter();

    private AlertPresenter alertPresenter = ClientFactory.getAlertPresenter();

    private AppMessages messages = AppClientFactory.getMessages();

    private ExampleProjectResources resources = AppClientFactory.getResources();

    /**
     * Default constructor.
     */
    public AppController() {
        super();
        // add search engine tab by default
        layout.getTabPanelHandlers().addTab(getDefaultToken(), messages.defaultTab(), false, IconType.SEARCH);
    }

    @Override
    public void onDetach() {
    }

    @Override
    public View getLayout() {
        return layout;
    }

    @Override
    public void onBind() {
        layout.getTabPanelHandlers().addSelectTabHandler(new SelectTabHandler() {
            @Override
            public void onTabSelected(SelectTabEvent event) {
                History.newItem(event.getToken());
            }
        });
    }

    @Override
    public void onShow(HasWidgets.ForIsWidget container) {
        addChildPresenter(loadingPresenter);
        addChildPresenter(errorPresenter);
        addChildPresenter(confirmPresenter);
        addChildPresenter(alertPresenter);

        errorPresenter.showPresenter(null);
        loadingPresenter.showPresenter(null);
        confirmPresenter.showPresenter(null);
        alertPresenter.showPresenter(null);

        StyleInjector.inject(resources.css().getText());
        super.onShow(container);
    }

    @Override
    public String getDefaultToken() {
        return "default";
    }

    @Override
    public void onTokenChange(final String token) {
        final String page = TokenUtil.getPage(token);
        if (page.equals("default")) {
            if (examplePresenter == null) {
                addChildPresenter(examplePresenter);
                examplePresenter.showPresenter(layout.getTabContent(token));
            }
        }
        layout.getTabPanelHandlers().selectTab(token);
    }
}
