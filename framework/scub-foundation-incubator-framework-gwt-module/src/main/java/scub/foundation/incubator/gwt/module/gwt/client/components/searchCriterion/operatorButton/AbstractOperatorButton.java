package scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.operatorButton;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import scub.foundation.incubator.gwt.module.gwt.client.components.dropDownButton.DropdownButton;
import scub.foundation.incubator.gwt.module.gwt.client.factory.AppClientFactory;
import scub.foundation.incubator.gwt.module.gwt.client.utils.ListUtils;
import scub.foundation.incubator.gwt.module.gwt.client.utils.MapUtils;
import scub.foundation.incubator.gwt.module.gwt.client.utils.StringUtils;

import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Tooltip;
import com.github.gwtbootstrap.client.ui.constants.Placement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Base class for operator button.
 * @param <OperatorType> the operator type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractOperatorButton<OperatorType> extends Composite implements HasValue<OperatorType>, HasEnabled {

    private static Logger logger = Logger.getLogger("AbstractOperatorButton");

    private List<OperatorType> possibleOperators;

    private Map<OperatorType, OperatorButtonOption> options;

    private OperatorType value;

    private DropdownButton dropdownButton;

    private Tooltip tooltip;

    /**
     * Constructor.
     */
    public AbstractOperatorButton() {
        super();
        tooltip = new Tooltip("");
        tooltip.setPlacement(Placement.TOP);

        dropdownButton = new DropdownButton();
        tooltip.add(dropdownButton);

        tooltip.reconfigure();
        options = initOptions();

        final SimplePanel panel = new SimplePanel();
        panel.add(tooltip);
        panel.addStyleName(AppClientFactory.getResources().css().operatorButton());
        initWidget(panel);
    }

    /**
     * init the icon and text linked to the operator in the map key.
     * @return the operator button's options.
     */
    abstract Map<OperatorType, OperatorButtonOption> initOptions();

    /**
     * Get the value of possibleOperators.
     * @return the possibleOperators
     */
    public List<OperatorType> getPossibleOperators() {
        return possibleOperators;
    }

    /**
     * Set the value of possibleOperators.
     * @param possibleOperators the possibleOperators to set
     */
    public void setPossibleOperators(List<OperatorType> possibleOperators) {
        this.possibleOperators = possibleOperators;

        // init the dropdown.
        setValue(null);
        dropdownButton.clear();
        if (ListUtils.isNotEmpty(possibleOperators)) {
            if (MapUtils.isNotEmpty(options)) {
                for (OperatorType operatorType : possibleOperators) {
                    if (operatorType != null && options.containsKey(operatorType)) {
                        addOperatorOption(options.get(operatorType), operatorType);
                    } else {
                        logger.warning("The operator is null or is not found in the options map.");
                    }
                }
            } else {
                logger.severe("The options map is empty.");
            }
        }
    }

    /**
     * Add the given operator button option to the drop down.
     * @param option the option to add.
     * @param operatorValue the operator type value
     */
    public void addOperatorOption(final OperatorButtonOption option, final OperatorType operatorValue) {
        if (option != null) {
            if (StringUtils.isNotEmpty(option.getOperatorText()) && option.getIconStyle() != null) {
                final NavLink operatorOption = new NavLink();
                if (StringUtils.isNotEmpty(option.getOperatorText())) {
                    operatorOption.setText(option.getOperatorText());
                }
                if (option.getIconStyle() != null) {
                    operatorOption.setCustomIconStyle(option.getIconStyle().get());
                }

                operatorOption.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        setValue(operatorValue);
                    }
                });

                if (StringUtils.isNotEmpty(option.getDescription())) {
                    final Tooltip tooltip = new Tooltip();
                    tooltip.setWidget(operatorOption);
                    tooltip.setText(option.getDescription());
                    tooltip.setPlacement(Placement.RIGHT);
                    tooltip.reconfigure();
                    dropdownButton.add(tooltip);
                } else {
                    dropdownButton.add(operatorOption);
                }
            } else {
                logger.warning("The operator text and the style are null. Option is ignored.");
            }
        } else {
            logger.warning("The given option in the options map is null. Option is ignored.");
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<OperatorType> handler) {
        return dropdownButton.addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public OperatorType getValue() {
        return value;
    }

    @Override
    public void setValue(OperatorType value) {
        setValue(value, true);
    }

    @Override
    public void setValue(OperatorType newValue, boolean fireEvents) {
        final OperatorType oldValue = getValue();
        this.value = newValue;

        // set correct icon style
        dropdownButton.setCustomIconStyle(null);
        if (value != null && MapUtils.isNotEmpty(options) && options.containsKey(value)) {
            final OperatorButtonOption option = options.get(value);
            if (option.getIconStyle() != null) {
                dropdownButton.setCustomIconStyle(option.getIconStyle().get());
            }
            setTooltipText();
        }

        if (fireEvents) {
            ValueChangeEvent.fireIfNotEqual(this, oldValue, value);
        }
    }

    /**
     * Set the tooltip text for the current value.
     */
    private void setTooltipText() {
        if (value != null && MapUtils.isNotEmpty(options) && options.containsKey(value)) {
            final OperatorButtonOption option = options.get(value);

            if (StringUtils.isNotEmpty(option.getDescription()) || StringUtils.isNotEmpty(option.getOperatorText())) {
                String tooltipText = "";
                if (StringUtils.isNotEmpty(option.getOperatorText())) {
                    tooltipText = option.getOperatorText();
                }
                if (StringUtils.isNotEmpty(option.getDescription())) {
                    if (StringUtils.isNotEmpty(tooltipText)) {
                        tooltipText += " : ";
                    }
                    tooltipText += option.getDescription();
                }
                tooltip.setText(tooltipText);
                tooltip.hide();
                tooltip.reconfigure();
            }
        }
    }

    @Override
    public boolean isEnabled() {
        return dropdownButton.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        dropdownButton.setEnabled(enabled);
        if (enabled) {
            tooltip.setText("");
            tooltip.hide();
            tooltip.reconfigure();
        } else {
            setTooltipText();
        }
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        dropdownButton.fireEvent(event);
    }

    /**
     * Get the value of dropdownButton.
     * @return the dropdownButton
     */
    public DropdownButton getDropdownButton() {
        return dropdownButton;
    }
}
