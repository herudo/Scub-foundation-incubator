package scub.foundation.incubator.gwt.module.gwt.client.components.dropDownButton;

import com.github.gwtbootstrap.client.ui.base.HasIcon;
import com.github.gwtbootstrap.client.ui.base.ListItem;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.IconPosition;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * ====> copy of the class in the incubator porject in order to fix the bug in the setCustomIconStyle metho in the IconAnchor class A Container for Widgets in a
 * Nav context (Navbar, NavList, ...). Example:<br>
 * <br>
 * {@code <b:NavWidget text="Inbox"><b:Badge /></b:NavWidget>}
 * @since 2.0.4.0
 * @author Dominik Mayer
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation (Navbar)</a>
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navs">Bootstrap documentation (Navs)</a>
 * @see NavList
 * @see WellNavList
 * @see Dropdown
 * @see Navbar
 * @see ResponsiveNavbar
 */
// @formatter:on
public class NavWidget extends ListItem implements HasClickHandlers, HasIcon {

    private final IconAnchor anchor = new IconAnchor();

    /** . */
    public NavWidget() {
        super.add(anchor);
    }

    /**
     * .
     * @param w .
     */
    public NavWidget(Widget w) {
        this();
        add(w);
    }

    /**
     * .
     * @param href .
     */
    public void setHref(String href) {
        anchor.setHref(href);
    }

    /**
     * .
     * @param targetHistoryToken .
     */
    public void setTargetHistoryToken(String targetHistoryToken) {
        anchor.setTargetHistoryToken(targetHistoryToken);
    }

    /**
     * .
     * @param text .
     */
    public void setText(String text) {
        anchor.setText(text);
    }

    /**
     * .
     * @return .
     */
    public String getText() {
        return anchor.getText();
    }

    /**
     * .
     * @param type .
     */
    public void setIcon(IconType type) {
        anchor.setIcon(type);
    }

    @Override
    public void setIconSize(IconSize size) {
        anchor.setIconSize(size);
    }

    /**
     * .
     * @param active .
     */
    public void setActive(boolean active) {

        if (active) {
            addStyleName(Constants.ACTIVE);
        } else {
            removeStyleName(Constants.ACTIVE);
        }
    }

    /**
     * .
     * @return .
     */
    public boolean isActive() {
        return this.getStyleName().contains(Constants.ACTIVE);
    }

    /**
     *  .
     * @param disabled .
     */
    public void setDisabled(boolean disabled) {

        if (disabled) {
            addStyleName(Constants.DISABLED);
        } else {
            removeStyleName(Constants.DISABLED);
        }

        anchor.setEnabled(!disabled);
    }

    /**
     * .
     * @return .
     */
    public boolean isDisabled() {
        return !anchor.isEnabled();
    }

    /**
     * .
     * @return .
     */
    public IconAnchor getAnchor() {
        return anchor;
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return anchor.addDomHandler(handler, ClickEvent.getType());
    }

    /**
     * . Add widget to inner anchor {@inheritDoc} .
     */
    @Override
    public void add(Widget w) {
        anchor.add(w);
    }

    /**
     * Add widget to this widget .
     * @param w .
     */
    @UiChild(tagname = "widget")
    public void addWidget(Widget w) {
        super.add(w);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        anchor.clear();
    }

    /**
     * Set anchor target attribute.
     * @param target target name
     */
    public void setTarget(String target) {
        anchor.setTarget(target);
    }

    /**
     * Get anchor target attribute.
     * @return target name
     */
    public String getTarget() {
        return anchor.getTarget();
    }

    /**
     * Set anchor name .
     * @param name anchor name
     */
    public void setName(String name) {
        anchor.setName(name);
    }

    /**
     * Get anchor name .
     * @return anchor name
     */
    public String getName() {
        return anchor.getName();
    }

    @Override
    public void setCustomIconStyle(String customIconStyle) {
        anchor.setCustomIconStyle(customIconStyle);
    }

    @Override
    public void setIconPosition(IconPosition position) {
        anchor.setIconPosition(position);
    }
}
