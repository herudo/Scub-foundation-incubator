package scub.foundation.incubator.gwt.module.gwt.client.components.dropDownButton;

import scub.foundation.incubator.gwt.module.gwt.client.utils.StringUtils;

import com.github.gwtbootstrap.client.ui.Icon;
import com.github.gwtbootstrap.client.ui.base.Caret;
import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.github.gwtbootstrap.client.ui.base.HasHref;
import com.github.gwtbootstrap.client.ui.base.HasIcon;
import com.github.gwtbootstrap.client.ui.base.TextNode;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.IconPosition;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.impl.FocusImpl;

/**
 * ====> copy of the class in the incubator porject in order to fix the bug in the setCustomIconStyle metho in the IconAnchor class
 * 
 * An Anchor with optional image and caret.
 * <p>
 * </p>
 * <p>
 * <h3>UiBinder Usage:</h3> {@code <b:IconAnchor icon="plane" href="www.twitter.com">Some Text</b:IconAnchor>}
 * </p>
 * <p>
 * Here we add a second Icon:
 * 
 * <pre>
 * {@code <b:IconAnchor icon="STAR" text="There is a widget so the text goes here">
 *     <b:Icon type="STAR" />
 * </b:IconAnchor>}
 * </pre>
 * 
 * All parameter are optional. All setters can be used as parameters.
 * </p>
 * @since 2.0.4.0
 * @author Dominik Mayer
 * @author ohashi keisuke
 */
public class IconAnchor extends ComplexWidget implements HasText, HasIcon, HasHref, HasClickHandlers, HasEnabled, Focusable, HasName {

    private static final FocusImpl IMPL = FocusImpl.getFocusImplForWidget();

    private String currentCustomIconStyle;

    private Icon icon = new Icon();

    private TextNode text = new TextNode();

    private Caret caret = new Caret();

    /**
     * Creates the widget and sets the {@code href} property to {@code javascript:;} in order to avoid problems when clicking on it.
     */
    public IconAnchor() {
        super("a");
        super.add(icon);
        super.add(text);
        setEmptyHref();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconPosition(IconPosition position) {

        icon.removeFromParent();
        text.removeFromParent();

        if (IconPosition.RIGHT == position) {
            this.insert(text, 0);
            this.add(icon);
            return;

        } else if (IconPosition.LEFT == position) {
            this.insert(icon, 0);
            this.insert(text, 1);
            return;
        }

    }

    /**
     * {@inheritDoc}
     */
    public void setIcon(IconType type) {
        if (type != null) {
            this.icon.setType(type);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconSize(IconSize size) {
        icon.setIconSize(size);
    }

    /**
     * {@inheritDoc}
     */
    public void setText(String text) {

        this.text.setText(" " + text + " ");
    }

    /**
     * {@inheritDoc}
     */
    public String getText() {
        return text.getText();
    }

    /**
     * {@inheritDoc}
     */
    public void setHref(String href) {
        getElement().setAttribute("href", href);
    }

    /**
     * {@inheritDoc}
     */
    public String getHref() {
        return getElement().getAttribute("href");
    }

    /**
     * Shows or hides the caret.
     * @param visible <code>true</code> if the caret should be shown.
     */
    public void setCaret(boolean visible) {
        if (visible) {
            super.add(caret);
        } else {
            super.remove(caret);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void setTargetHistoryToken(String targetHistoryToken) {
        setHref("#" + targetHistoryToken);
    }

    /**
     * {@inheritDoc}
     */
    public String getTargetHistoryToken() {
        final String[] hrefs = getHref().split("#");
        return hrefs[1];
    }

    /**
     * Sets the <code>href</code>property of this element to "javascript:;" in order to get another cursor (hand).
     */
    public void setEmptyHref() {
        setHref(Constants.EMPTY_HREF);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return !DOM.getElementPropertyBoolean(getElement(), "disabled");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnabled(boolean enabled) {
        DOM.setElementPropertyBoolean(getElement(), "disabled", !enabled);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBrowserEvent(Event event) {
        switch (DOM.eventGetType(event)) {
        case Event.ONCLICK:
            if (isEnabled()) {
                super.onBrowserEvent(event);
            }
            break;
        default:
            super.onBrowserEvent(event);
            break;
        }

    }

    @Override
    public int getTabIndex() {
        return IMPL.getTabIndex(getElement());
    }

    @Override
    public void setAccessKey(char key) {
        DOM.setElementProperty(getElement(), "accessKey", "" + key);
    }

    @Override
    public void setFocus(boolean focused) {
        if (focused) {
            IMPL.focus(getElement());
        } else {
            IMPL.blur(getElement());
        }
    }

    @Override
    public void setTabIndex(int index) {
        IMPL.setTabIndex(getElement(), index);
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        // Accessibility: setting tab index to be 0 by default, ensuring element
        // appears in tab sequence. We must ensure that the element doesn't already
        // have a tabIndex set. This is not a problem for normal widgets, but when
        // a widget is used to wrap an existing static element, it can already have
        // a tabIndex.
        final int tabIndex = getTabIndex();
        if (-1 == tabIndex) {
            setTabIndex(0);
        }
    }

    /**
     * Set active style name.
     * @param active <code>true</code> : set active <code>false</code> : unset active
     */
    public void setActive(boolean active) {
        setStyleName(Constants.ACTIVE, active);
    }

    /**
     * Has the active css style name?
     * @return <code>true</code>: has <code>false</code> : none.
     */
    public boolean isActive() {
        return getStyleName().contains(Constants.ACTIVE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(String name) {
        getAnchorElement().setName(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return getAnchorElement().getName();
    }

    /**
     * Set target attribute.
     * @param target target name
     */
    public void setTarget(String target) {
        getAnchorElement().setTarget(target);
    }

    /**
     * Get target attribute value.
     * @return target attribute value
     */
    public String getTarget() {
        return getAnchorElement().getTarget();
    }

    /**
     * .
     * @return .
     **/
    protected AnchorElement getAnchorElement() {
        return AnchorElement.as(getElement());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCustomIconStyle(String customIconStyle) {
        if (StringUtils.isNotEmpty(currentCustomIconStyle)) {
            icon.removeStyleName(currentCustomIconStyle);
        }
        currentCustomIconStyle = customIconStyle;
        if (StringUtils.isNotEmpty(customIconStyle)) {
            icon.addStyleName(customIconStyle);
        }
    }

    /**
     * add a supplementary custom style.
     * @param customIconStyle the style to add.
     */
    public void addCustomIconStyle(String customIconStyle) {
        icon.addStyleName(customIconStyle);
    }

    /**
     * remove a supplementary custom style.
     * @param customIconStyle the style to remove.
     */
    public void removeCustomIconStyle(String customIconStyle) {
        icon.removeStyleName(customIconStyle);
    }
}
