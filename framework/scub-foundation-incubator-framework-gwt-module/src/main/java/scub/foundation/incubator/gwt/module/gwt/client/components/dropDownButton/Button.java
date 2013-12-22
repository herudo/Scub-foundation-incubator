package scub.foundation.incubator.gwt.module.gwt.client.components.dropDownButton;

import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.DragEndEvent;
import com.google.gwt.event.dom.client.DragEndHandler;
import com.google.gwt.event.dom.client.DragEnterEvent;
import com.google.gwt.event.dom.client.DragEnterHandler;
import com.google.gwt.event.dom.client.DragEvent;
import com.google.gwt.event.dom.client.DragHandler;
import com.google.gwt.event.dom.client.DragLeaveEvent;
import com.google.gwt.event.dom.client.DragLeaveHandler;
import com.google.gwt.event.dom.client.DragOverEvent;
import com.google.gwt.event.dom.client.DragOverHandler;
import com.google.gwt.event.dom.client.DragStartEvent;
import com.google.gwt.event.dom.client.DragStartHandler;
import com.google.gwt.event.dom.client.DropEvent;
import com.google.gwt.event.dom.client.DropHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.GestureChangeEvent;
import com.google.gwt.event.dom.client.GestureChangeHandler;
import com.google.gwt.event.dom.client.GestureEndEvent;
import com.google.gwt.event.dom.client.GestureEndHandler;
import com.google.gwt.event.dom.client.GestureStartEvent;
import com.google.gwt.event.dom.client.GestureStartHandler;
import com.google.gwt.event.dom.client.HasAllDragAndDropHandlers;
import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.event.dom.client.HasAllGestureHandlers;
import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.HasAllTouchHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasDoubleClickHandlers;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.dom.client.TouchCancelEvent;
import com.google.gwt.event.dom.client.TouchCancelHandler;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;

//@formatter:off
/**
 * ====> copy of the class in the incubator porject in order to fix the bug in the setCustomIconStyle metho in the IconAnchor class
 * 
 * Button with optional icon.
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code <b:Button icon="TRASH" type="ERROR" toggle="true" loadingText="I'm loading..." completeText="Oh hoh, I completed the action!">Delete</b:Button>}
 * </pre>
 * 
 * All arguments are optional.
 * </p>
 * @since 2.0.4.0
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#buttons">Bootstrap documentation</a>
 * @see ButtonGroup
 * @see ButtonToolbar
 * @see DropdownButton
 * @see SplitDropdownButton
 * @see NavbarButton
 */
// @formatter:on
public class Button extends IconAnchor implements HasClickHandlers, HasDoubleClickHandlers, HasEnabled, HasType<ButtonType>, HasAllDragAndDropHandlers,
        HasAllFocusHandlers, HasAllGestureHandlers, HasAllKeyHandlers, HasAllMouseHandlers, HasAllTouchHandlers {

    private final LoadingStateBehavior state = new LoadingStateBehavior();

    private ButtonType type;

    private ButtonSize size;

    /**
     * Creates an empty Button.
     */
    public Button() {
        super();
        addStyleName(Constants.BTN);
    }

    /**
     * Creates an Button with ClickHandler.
     * @param handler Butotn ClickHandler
     */
    public Button(ClickHandler handler) {
        this();
        addClickHandler(handler);

    }

    /**
     * Creates a Button with the given caption.
     * @param caption the caption of the Button
     */
    public Button(String caption) {
        this();
        setText(caption);
    }

    /**
     * Create Button with click handler.
     * @param caption the caption of the Button
     * @param handler Button Click Handler
     */
    public Button(String caption, ClickHandler handler) {
        this(caption);
        addClickHandler(handler);
    }

    /**
     * Creates a Button with the given caption and icon.
     * @param caption the caption of the Button
     * @param icon the Icon on the caption's left
     */
    public Button(String caption, IconType icon) {
        this(caption);
        setIcon(icon);
    }

    /**
     * Creates a Button with the given caption and icon and ClickHandler.
     * @param caption the caption of the Button
     * @param icon the Icon on the caption's left
     * @param handler the ClickHandler of the Button.
     */
    public Button(String caption, IconType icon, ClickHandler handler) {
        this(caption, icon);
        addClickHandler(handler);
    }

    /**
     * Sets the type of the Button.
     * <p>
     * Different types give the button a different look.
     * @param type the type of the Button.
     */
    public void setType(ButtonType type) {
        this.type = type;
        StyleHelper.changeStyle(this, type, ButtonType.class);
    }

    /**
     * Sets the size of the Button.
     * @param size the size of the Button.
     */
    public void setSize(ButtonSize size) {
        this.size = size;
        StyleHelper.changeStyle(this, size, ButtonSize.class);
    }

    /**
     * Whether the Button is enabled or disabled.
     * <p>
     * A disabled widget cannot be used.
     * @return <code>false</code> if the Button is disabled.
     */
    public boolean isEnabled() {
        return !getStyleName().contains(Constants.DISABLED);
    }

    /**
     * Sets whether the Button is enabled or disabled.
     * <p>
     * A disabled widget cannot be used.
     * @param enabled <code>false</code> if the Button should be disabled. Default: <code>true</code>
     */
    public void setEnabled(boolean enabled) {
        if (enabled) {
            removeStyleName(Constants.DISABLED);
        } else {
            addStyleName(Constants.DISABLED);
        }
    }

    /**
     * Enable ou disable the data-toggle behavior.
     * @param toggle <code>true</code> will enable this behavior. <code>false</code> will disable it or do nothing if it never was enabled.
     */
    public void setToggle(boolean toggle) {
        if (toggle) {
            getElement().setAttribute(Constants.DATA_TOGGLE, "button");
        } else {
            getElement().removeAttribute(Constants.DATA_TOGGLE);
        }
    }

    /**
     * Verify if the property "toggle" is set.
     * @return true: if the data-toggle is equal 'button' false: otherwise
     */
    public boolean isToggle() {
        return getElement().getAttribute(Constants.DATA_TOGGLE).equals("button");
    }

    /**
     * Verify if the button is toggled.
     * @return true: if yes (it will contain the "active" styleclass false: otherwise.
     */
    public boolean isToggled() {
        return getStyleName().toLowerCase().contains("active");
    }

    /**
     * Set a Loading Text to show when some action are in work with this button.
     * @see LoadingStateBehavior
     * @param text .
     */
    public void setLoadingText(String text) {
        if (text == null || text.trim().isEmpty()) {
            getElement().removeAttribute(Constants.DATA_LOADING_TEXT);
            return;
        }

        getElement().setAttribute(Constants.DATA_LOADING_TEXT, text);
    }

    /**
     * Set a Loading Text to show when some action are completed with this button.
     * @see LoadingStateBehavior
     * @param text .
     */
    public void setCompleteText(String text) {
        if (text == null || text.trim().isEmpty()) {
            getElement().removeAttribute(Constants.DATA_COMPLETE_TEXT);
            return;
        }

        getElement().setAttribute(Constants.DATA_COMPLETE_TEXT, text);
    }

    /**
     * A simple DSL to change the button state to loading, complete, or reset it.
     * @return .
     */
    public LoadingStateBehavior state() {
        return state;
    }

    /**
     * A simple class to encapsulate the button state managing from the user.
     * @author Carlos Alexandro Becker
     */
    public class LoadingStateBehavior {

        /**
         * put the button in the loading state.
         */
        public void loading() {
            setLoadingBehavior("loading");
        }

        /**
         * reset the button state.
         */
        public void reset() {
            setLoadingBehavior("reset");
        }

        /**
         * put the button in the completed state.
         */
        public void complete() {
            setLoadingBehavior("complete");
        }

        private void setLoadingBehavior(String behavior) {
            setLoadingBehavior(getElement(), behavior);
        }

        private native void setLoadingBehavior(Element e, String behavior) /*-{
                                                                           $wnd.jQuery(e).button(behavior);
                                                                           }-*/;
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addDoubleClickHandler(DoubleClickHandler handler) {
        return addDomHandler(handler, DoubleClickEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addDragEndHandler(DragEndHandler handler) {
        return addDomHandler(handler, DragEndEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addDragEnterHandler(DragEnterHandler handler) {
        return addDomHandler(handler, DragEnterEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addDragLeaveHandler(DragLeaveHandler handler) {
        return addDomHandler(handler, DragLeaveEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addDragHandler(DragHandler handler) {
        return addDomHandler(handler, DragEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addDragOverHandler(DragOverHandler handler) {
        return addDomHandler(handler, DragOverEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addDragStartHandler(DragStartHandler handler) {
        return addDomHandler(handler, DragStartEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addDropHandler(DropHandler handler) {
        return addDomHandler(handler, DropEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addFocusHandler(FocusHandler handler) {
        return addDomHandler(handler, FocusEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addBlurHandler(BlurHandler handler) {
        return addDomHandler(handler, BlurEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addGestureStartHandler(GestureStartHandler handler) {
        return addDomHandler(handler, GestureStartEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addGestureChangeHandler(GestureChangeHandler handler) {
        return addDomHandler(handler, GestureChangeEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addGestureEndHandler(GestureEndHandler handler) {
        return addDomHandler(handler, GestureEndEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
        return addDomHandler(handler, KeyUpEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
        return addDomHandler(handler, KeyDownEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
        return addDomHandler(handler, KeyPressEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
        return addDomHandler(handler, MouseDownEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
        return addDomHandler(handler, MouseUpEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
        return addDomHandler(handler, MouseOutEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
        return addDomHandler(handler, MouseOverEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
        return addDomHandler(handler, MouseMoveEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
        return addDomHandler(handler, MouseWheelEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addTouchStartHandler(TouchStartHandler handler) {
        return addDomHandler(handler, TouchStartEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addTouchMoveHandler(TouchMoveHandler handler) {
        return addDomHandler(handler, TouchMoveEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addTouchEndHandler(TouchEndHandler handler) {
        return addDomHandler(handler, TouchEndEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    public HandlerRegistration addTouchCancelHandler(TouchCancelHandler handler) {
        return addDomHandler(handler, TouchCancelEvent.getType());
    }

    /**
     * Get Button Type.
     * @return Current Button Type
     */
    public ButtonType getType() {
        return type;
    }

    /**
     * Get Button Size.
     * @return Current Button Size
     */
    public ButtonSize getSize() {
        return size;
    }

    /**
     * Set element as a Block Level Button.
     * @param block true:Block Level false:Default
     */
    public void setBlock(boolean block) {
        setStyleName(Constants.BTN_BLOCK, block);
    }
}
