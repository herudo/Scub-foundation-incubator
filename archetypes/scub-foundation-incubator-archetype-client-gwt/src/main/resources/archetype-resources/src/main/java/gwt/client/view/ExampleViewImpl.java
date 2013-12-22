package ${package}.gwt.client.view;

import ${package}.gwt.client.presenter.ExamplePresenter.ExampleView;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Implementation of ExampleView.
 * @author Clément Lavaud (clement.lavaud@scub.net)
 */
public class ExampleViewImpl extends Composite implements ExampleView {

    private Binder binder = GWT.create(Binder.class);

    /** The call service's button. */
    @UiField
    Button btnCallService;

    /**
     * Default constructor.
     */
    public ExampleViewImpl() {
        super();
        initWidget(binder.createAndBindUi(this));
        btnCallService.ensureDebugId("debugIdBtnCallService");
    }

    /**
     * An interface required by the UiBinder.
     */
    public interface Binder extends UiBinder<Widget, ExampleViewImpl> {
    }

    @Override
    public Widget asWidget() {
        return this;
    }

    @Override
    public HasClickHandlers getBtnCallService() {
        return btnCallService;
    }

    @Override
    public Widget getPrincipalContainer() {
        return getWidget();
    }

}
