package scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.operatorButton;

import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * Class to transport Operator button's options.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class OperatorButtonOption {
    private Style iconStyle;

    private String operatorText;

    private String description;

    /** Constructor. */
    public OperatorButtonOption() {
    }

    /**
     * Constructor.
     * @param iconStyle the iconStyle.
     */
    public OperatorButtonOption(Style iconStyle) {
        this.iconStyle = iconStyle;
    }

    /**
     * Constructor.
     * @param iconStyle the iconStyle.
     * @param operatorText the operator text.
     */
    public OperatorButtonOption(Style iconStyle, String operatorText) {
        this.operatorText = operatorText;
        this.iconStyle = iconStyle;
    }

    /**
     * Constructor.
     * @param iconStyle the iconStyle.
     * @param operatorText the operator text.
     * @param description the description to help user if needed.
     */
    public OperatorButtonOption(Style iconStyle, String operatorText, String description) {
        this.operatorText = operatorText;
        this.iconStyle = iconStyle;
        this.description = description;
    }

    /**
     * Get the value of iconStyle.
     * @return the iconStyle
     */
    public Style getIconStyle() {
        return iconStyle;
    }

    /**
     * Set the value of iconStyle.
     * @param iconStyle the iconStyle to set
     */
    public void setIconStyle(Style iconStyle) {
        this.iconStyle = iconStyle;
    }

    /**
     * Get the value of operatorText.
     * @return the operatorText
     */
    public String getOperatorText() {
        return operatorText;
    }

    /**
     * Set the value of operatorText.
     * @param operatorText the operatorText to set
     */
    public void setOperatorText(String operatorText) {
        this.operatorText = operatorText;
    }

    /**
     * Get the value of description.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
