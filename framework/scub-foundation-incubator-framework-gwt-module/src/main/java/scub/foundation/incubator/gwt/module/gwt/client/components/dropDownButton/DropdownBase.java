package scub.foundation.incubator.gwt.module.gwt.client.components.dropDownButton;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.github.gwtbootstrap.client.ui.base.HasIcon;
import com.github.gwtbootstrap.client.ui.base.UnorderedList;
import com.github.gwtbootstrap.client.ui.constants.Alignment;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off

/**
 * ====> copy of the class in the incubator porject in order to fix the bug in the setCustomIconStyle metho in the IconAnchor class Base class for dropdown
 * widgets.
 * @author Carlos A Becker
 * @author Dominik Mayer
 * @since 2.0.4.0
 */
// @formatter:on
public abstract class DropdownBase extends ComplexWidget implements HasChangeHandlers, HasClickHandlers, HasWidgets, HasText, HasIcon {

    private UnorderedList menu = new UnorderedList();

    /** . **/
    protected IconAnchor trigger;

    private NavLink link;

    private NavLinkClickHandler handler = new NavLinkClickHandler();

    private boolean dropup;

    /**
     * Creates a new widget of the given type.
     * @param type the HTML tag to be used for the widget
     */
    public DropdownBase(String type) {
        super(type);
        createAndAddTrigger();
        menu.setStyleName("dropdown-menu");
        super.add(menu);
    }

    private void createAndAddTrigger() {
        trigger = createTrigger();
        trigger.addStyleName("dropdown-toggle");
        trigger.getElement().setAttribute(Constants.DATA_TOGGLE, "dropdown");
        super.add(trigger);
    }

    /**
     * Sets the text of the dropdown trigger.
     * @param text .
     */
    public void setText(String text) {
        trigger.setText(text);
    }

    /**
     * .
     * @return the text of the dropdown trigger.
     */
    public String getText() {
        return trigger.getText();
    }

    /**
     * Get trigger wiget.
     * @return trigger wiget
     */
    public IconAnchor getTriggerWidget() {
        return trigger;
    }

    /**
     * Get menu unordered list widget.
     * @return menu
     */
    public UnorderedList getMenuWiget() {
        return menu;
    }

    /**
     * Implement this method to create the trigger appropriate for your widget. It has to be an {@link IconAnchor} or a subtype.
     * @return the created trigger
     */
    protected abstract IconAnchor createTrigger();

    /**
     * Set dropup style.
     * @param dropup true:Set Dropup false:Un-set Dropup
     */
    public void setDropup(boolean dropup) {

        this.dropup = dropup;

        if (dropup) {
            addStyleName(Constants.DROPUP);
        } else {
            removeStyleName(Constants.DROPUP);
        }
    }

    /**
     * Is widget dropup?
     * @return true:Dropup false:Dropdown
     */
    public boolean isDropup() {
        return this.dropup;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onLoad() {
        super.onLoad();
        if (trigger != null) {
            configure(trigger.getElement());
        }
    }

    /**
     * Adds a widget to the dropdown menu.
     * @param widget the widget that will be added to the menu
     * @see #addWidget(Widget)
     */
    @Override
    public void add(Widget widget) {
        menu.add(widget);
        if (widget instanceof NavLink) {
            ((NavLink) widget).addClickHandler(handler);
        }
    }

    @Override
    public HandlerRegistration addChangeHandler(ChangeHandler newHandler) {
        return addDomHandler(newHandler, ChangeEvent.getType());
    }

    /**
     * Adds a widget to the the dropdown widget, <b>not</b> to the dropdown menu.
     * <p/>
     * <p/>
     * Use {@link #add(Widget)} if you want to add a widget to the dropdown menu.
     * @param widget the widget to be added.
     */
    protected void addWidget(Widget widget) {
        super.add(widget);
    }

    private native void configure(Element e) /*-{
                                             $wnd.jQuery(e).dropdown();
                                             }-*/;

    /**
     * Pull the dropdown menu to right.
     * @param rightDropdown <code>true</code> pull to right, otherwise to left. Default is <code>false</code>
     */
    public void setRightDropdown(boolean rightDropdown) {
        menu.setStyleName(Alignment.RIGHT.get(), rightDropdown);
    }

    private class NavLinkClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            final IconAnchor iconAnchor = (IconAnchor) event.getSource();
            link = (NavLink) iconAnchor.getParent();
            DomEvent.fireNativeEvent(Document.get().createChangeEvent(), DropdownBase.this);
        }

    }

    /**
     * Method to get the {@link NavLink} that has been clicked most recently.
     * @return Last clicked NavLink or <code>null</code> if none have been clicked.
     */
    public NavLink getLastSelectedNavLink() {
        return link;
    }

    @Override
    public void clear() {
        menu.clear();
    }

    @Override
    public HandlerRegistration addClickHandler(ClickHandler newHandler) {
        return trigger.addClickHandler(newHandler);
    }

    /**
     * Add widget to trigger anchodr.
     * @param w added widget
     */
    @UiChild(tagname = "customTrigger", limit = 1)
    public void addCustomTrigger(Widget w) {
        trigger.insert(w, 0);
    }

}
