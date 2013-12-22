package scub.foundation.incubator.gwt.module.gwt.client.components.dropDownButton;

import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconPosition;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;

//@formatter:off
/**
 * ====> copy of the class in the incubator porject in order to fix the bug in the setCustomIconStyle metho in the IconAnchor class Button with a dropdown menu.
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:DropdownButton text="I am the Caption">
 *     <b:NavHeader>Header</b:NavHeader>
 *     <b:NavLink>Link 1</b:NavLink>
 *     <b:NavLink>Link 2</b:NavLink>
 * </b:DropdownButton>
 * }
 * </pre>
 * 
 * </p>
 * @since 2.0.4.0
 * @author Dominik Mayer
 * @see <a href="http://twitter.github.com/bootstrap/components.html#buttonDropdowns">Bootstrap documentation</a>
 * @see Dropdown
 * @see SplitDropdownButton
 */
// @formatter:on
public class DropdownButton extends DropdownBase implements HasEnabled {

    private Button trigger;

    /**
     * Creates a DropdownButton without a caption.
     */
    public DropdownButton() {
        super("div");
        addStyleName("btn-group");
    }

    /**
     * Creates a DropdownButton with the given caption.
     * @param caption the button's caption
     */
    public DropdownButton(String caption) {
        this();
        setText(caption);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IconAnchor createTrigger() {
        trigger = new Button();
        trigger.setCaret(true);
        return trigger;
    }

    /**
     * Sets the button's size.
     * @param size the button's size
     */
    public void setSize(ButtonSize size) {
        trigger.setSize(size);
    }

    /**
     * Sets the button's type.
     * @param type the button's type
     */
    public void setType(ButtonType type) {
        trigger.setType(type);
    }

    /**
     * Sets the button's icon.
     * @param type the icon's type
     */
    public void setIcon(IconType type) {
        trigger.setIcon(type);
    }

    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return trigger.addClickHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconSize(IconSize size) {
        trigger.setIconSize(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCustomIconStyle(String customIconStyle) {
        trigger.setCustomIconStyle(customIconStyle);
    }

    /**
     * add a supplementary custom style.
     * @param customIconStyle the style to add.
     */
    public void addCustomIconStyle(String customIconStyle) {
        trigger.addCustomIconStyle(customIconStyle);
    }

    /**
     * remove a supplementary custom style.
     * @param customIconStyle the style to remove.
     */
    public void removeCustomIconStyle(String customIconStyle) {
        trigger.removeCustomIconStyle(customIconStyle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconPosition(IconPosition position) {
        trigger.setIconPosition(position);
    }

    @Override
    public boolean isEnabled() {
        return trigger.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        trigger.setEnabled(enabled);
    }
}
