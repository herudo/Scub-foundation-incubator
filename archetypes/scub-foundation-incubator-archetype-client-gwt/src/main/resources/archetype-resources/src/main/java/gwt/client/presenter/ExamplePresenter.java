package ${package}.gwt.client.presenter;

import ${package}.gwt.client.i18n.AppMessages;
import ${package}.gwt.client.service.ExampleServiceGwtAsync;
import ${package}.gwt.shared.ExampleModel;
import org.scub.foundation.framework.gwt.module.client.callback.IntegrityControlAsyncCallback;
import org.scub.foundation.framework.gwt.module.client.mvp.management.alert.AlertEvent;
import org.scub.foundation.framework.gwt.module.client.mvp.management.alert.AlertPresenter.AlertType;
import org.scub.foundation.framework.gwt.module.client.mvp.management.error.ErrorEvent;
import org.scub.foundation.framework.gwt.module.client.mvp.management.loading.LoadingEvent;
import org.scub.foundation.framework.gwt.module.client.mvp.presenter.Presenter;
import org.scub.foundation.framework.gwt.module.client.mvp.view.View;

import ${package}.gwt.client.factory.AppClientFactory;
import ${package}.gwt.client.service.ExampleServiceGwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Exampel Presenter.
 * @author Clément Lavaud (clement.lavaud@scub.net)
 */
public class ExamplePresenter extends Presenter {

    private AppMessages messages = AppClientFactory.getMessages();

    private ExampleView view = AppClientFactory.getExampleView();

    private ExampleServiceGwtAsync exampleService = ExampleServiceGwt.App.getInstance();

    @Override
    public void onBind() {
        view.getBtnCallService().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                fireEventGlobalBus(new LoadingEvent(true));
                exampleService.getExample(new IntegrityControlAsyncCallback<ExampleModel>(view) {
                    @Override
                    public void onFail(Throwable caught) {
                        fireEventGlobalBus(new LoadingEvent(false));
                        fireEventGlobalBus(new ErrorEvent(caught));
                    }
                    @Override
                    public void onSuccess(ExampleModel result) {
                        fireEventGlobalBus(new LoadingEvent(false));
                        fireEventGlobalBus(new AlertEvent(messages.callServiceResult() + " " + result.getProperty(), AlertType.INFO));
                    }
                });
            }
        });
    }

    @Override
    public void onShow(HasWidgets.ForIsWidget container) {
        container.add(view.asWidget());
    }

    @Override
    public void onDetach() {
    }

    /**
     * Interface of the view.
     */
    public interface ExampleView extends View {

        /**
         * Get the ClickHandler of the button call service.
         * @return the ClickHandler.
         */
        HasClickHandlers getBtnCallService();
    }

}
