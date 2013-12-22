package scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion;

import scub.foundation.incubator.gwt.module.gwt.client.components.button.SimpleHtmlButton;
import scub.foundation.incubator.gwt.module.gwt.client.components.handlers.HasCalculatedWidth;
import scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.handlers.HasStringSearchCriterion;
import scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.operatorButton.StringOperatorButton;
import scub.foundation.incubator.gwt.module.gwt.client.factory.AppClientFactory;
import scub.foundation.incubator.gwt.module.gwt.client.i18n.AppMessages;
import scub.foundation.incubator.gwt.module.gwt.client.utils.EventUtils;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.StringSearchCriterionModel;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.StringSearchCriterionModel.StringOperator;

import com.github.gwtbootstrap.client.ui.InputAddOn;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.Tooltip;
import com.github.gwtbootstrap.client.ui.base.PlaceholderHelper;
import com.github.gwtbootstrap.client.ui.constants.Placement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasEnabled;

/**
 * A search criterion box for String.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class StringSearchCriterionBox extends Composite implements HasStringSearchCriterion, HasEnabled, HasCalculatedWidth {

    private StringOperator defaultOperator = StringOperator.CONTAINS;

    private boolean defaultCaseSensitive = true;

    private boolean caseSensitive = defaultCaseSensitive;

    private TextBox textBox;

    private SimpleHtmlButton caseSensitiveButton;

    private Tooltip caseSensitiveTooltip;

    private StringOperatorButton operatorButton;

    private HandlerManager handlerManager;

    /**
     * Constructor.
     */
    public StringSearchCriterionBox() {
        handlerManager = new HandlerManager(this);
        textBox = new TextBox();
        caseSensitiveTooltip = new Tooltip("");
        caseSensitiveTooltip.setPlacement(Placement.TOP);

        // button to choose case sensitive value
        caseSensitiveButton = new SimpleHtmlButton();
        caseSensitiveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                setCaseSensitive(!caseSensitive);
            }
        });
        caseSensitiveTooltip.add(caseSensitiveButton);
        setCaseSensitive(caseSensitive);

        // operator button
        operatorButton = new StringOperatorButton(defaultOperator);
        operatorButton.addValueChangeHandler(new ValueChangeHandler<StringSearchCriterionModel.StringOperator>() {
            @Override
            public void onValueChange(ValueChangeEvent<StringOperator> event) {
                if (EventUtils.isValueNotNull(event)) {
                    switch (event.getValue()) {
                    case IS_NULL:
                        setEnabled(false, true);
                        break;
                    case IS_NOT_NULL:
                        setEnabled(false, true);
                        break;
                    default:
                        setEnabled(true, true);
                        break;
                    }
                }
            }
        });

        // all element in one widget.
        final InputAddOn addOn = new InputAddOn();
        addOn.add(operatorButton);
        addOn.add(textBox);
        addOn.add(caseSensitiveTooltip);
        addOn.addStyleName("input-append input-prepend");

        initWidget(addOn);
        addStyleName(AppClientFactory.getResources().css().searchCriterion());
        caseSensitiveTooltip.reconfigure();
    }

    @Override
    public StringSearchCriterionModel getSearchCriterion() {
        final StringSearchCriterionModel searchCriterion = new StringSearchCriterionModel(operatorButton.getValue(), getValue());
        searchCriterion.setCaseSensitive(caseSensitive);
        return searchCriterion;
    }

    @Override
    public void setSearchCriterion(StringSearchCriterionModel value) {
        if (value != null) {
            setOperator(value.getOperator());
            setCaseSensitive(value.isCaseSensitive());
            setValue(value.getValue());
        } else {
            setOperator(null);
            setCaseSensitive(defaultCaseSensitive);
            setValue(null);
        }
    }

    @Override
    public void setOperator(StringOperator newOperator) {
        StringOperator operator = defaultOperator;
        if (newOperator != null) {
            operator = newOperator;
        }
        operatorButton.setValue(operator);
    }

    @Override
    public StringOperator getOperator() {
        return operatorButton.getValue();
    }

    @Override
    public void clear() {
        setValue(null);
    }

    @Override
    public String getValue() {
        return textBox.getValue();
    }

    @Override
    public void setValue(String value) {
        textBox.setValue(value);
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        textBox.setValue(value, fireEvents);
    }

    /**
     * Get the value of caseSensitive.
     * @return the caseSensitive
     */
    @Override
    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    /**
     * Set the value of caseSensitive.
     * @param caseSensitive the caseSensitive to set
     */
    @Override
    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = Boolean.valueOf(caseSensitive);
        if (caseSensitive) {
            caseSensitiveButton.setHTML(new HTML("A &ne; a"));
        } else {
            caseSensitiveButton.setText("A = a");
        }
        setCaseSensitivetooltipText();
        caseSensitiveTooltip.show();
    }

    /**
     * set the case sensitive tooltip text for the current case sensitive value.
     */
    private void setCaseSensitivetooltipText() {
        final AppMessages messages = AppClientFactory.getMessages();
        if (caseSensitive) {
            caseSensitiveTooltip.setText(messages.caseSensitiveDescription());
        } else {
            caseSensitiveTooltip.setText(messages.caseInsensitiveDescription());
        }
        caseSensitiveTooltip.hide();
        caseSensitiveTooltip.reconfigure();

    }

    @Override
    public boolean isEnabled() {
        return operatorButton.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        setEnabled(enabled, false);
    }

    /**
     * Set widget enabled.
     * @param enabled enabled or not.
     * @param partial partial (text + case sensitive) or not (all)
     */
    private void setEnabled(boolean enabled, boolean partial) {
        textBox.setEnabled(enabled);
        caseSensitiveButton.setEnabled(enabled);
        if (!partial) {
            operatorButton.setEnabled(enabled);
        }
        if (enabled) {
            setCaseSensitivetooltipText();
        } else {
            caseSensitiveTooltip.setText("");
            caseSensitiveTooltip.reconfigure();
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
        return textBox.addValueChangeHandler(handler);
    }

    @Override
    public HandlerRegistration addOperatorChangeHandler(ValueChangeHandler<StringOperator> handler) {
        return handlerManager.addHandler(ValueChangeEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addCaseSensitiveChangeHandler(ValueChangeHandler<Boolean> handler) {
        return handlerManager.addHandler(ValueChangeEvent.getType(), handler);
    }

    /**
     * Get the value of defaultOperator.
     * @return the defaultOperator
     */
    public StringOperator getDefaultOperator() {
        return defaultOperator;
    }

    @Override
    public void setCalculatedWidth(Width calculatedWidth) {
        switch (calculatedWidth) {
        case CENT_PERCENT:
            textBox.getElement().getStyle().setWidth(0, Unit.PX);
            final int containerWidth = getElement().getClientWidth();
            int width = containerWidth;

            if (operatorButton.isVisible()) {
                final int operatorButtonWidth = 72;
                width -= operatorButtonWidth;
            }
            width -= caseSensitiveButton.getElement().getClientWidth();

            // margin
            final int margin = 30;
            width -= margin;
            textBox.getElement().getStyle().setWidth(width, Unit.PX);
            break;

        default:
            break;
        }
    }

    /**
     * Set the value of defaultOperator.
     * @param defaultOperator the defaultOperator to set
     */
    public void setDefaultOperator(StringOperator defaultOperator) {
        this.defaultOperator = defaultOperator;
    }

    /**
     * Get the value of defaultCaseSensitive.
     * @return the defaultCaseSensitive
     */
    public boolean isDefaultCaseSensitive() {
        return defaultCaseSensitive;
    }

    /**
     * Set the value of defaultCaseSensitive.
     * @param defaultCaseSensitive the defaultCaseSensitive to set
     */
    public void setDefaultCaseSensitive(boolean defaultCaseSensitive) {
        this.defaultCaseSensitive = defaultCaseSensitive;
    }

    @Override
    public void setOperatorVisible(boolean visible) {
        operatorButton.setVisible(visible);
    }

    @Override
    public void setCaseSensitiveOptionvisible(boolean visible) {
        caseSensitiveButton.setVisible(visible);
    }

    /**
     * Set the place holder.
     * @param placeHolder the place holder to set.
     */
    public void setPlaceHolder(String placeHolder) {
        final PlaceholderHelper placeHolderHelper = new PlaceholderHelper();
        placeHolderHelper.setPlaceholer(textBox.getElement(), placeHolder);
    }
}
