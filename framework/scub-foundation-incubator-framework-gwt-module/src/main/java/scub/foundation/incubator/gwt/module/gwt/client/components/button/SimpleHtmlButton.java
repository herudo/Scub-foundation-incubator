package scub.foundation.incubator.gwt.module.gwt.client.components.button;

import com.github.gwtbootstrap.client.ui.base.InlineLabel;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.DirectionalTextHelper;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasEnabled;

/**
 * A simple button class that can have html text.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class SimpleHtmlButton extends InlineLabel implements HasEnabled {
    private DirectionalTextHelper directionalTextHelper;

    /** constructor. */
    public SimpleHtmlButton() {
        addStyleName(Constants.BTN);
        directionalTextHelper = new DirectionalTextHelper(getElement(), false);
    }

    /**
     * create a button with the given html text.
     * @param html the html text
     */
    public SimpleHtmlButton(HTML html) {
        this();
        setHTML(html);
    }

    /**
     * create a button with the given html text and click handler.
     * @param html the html text
     * @param clickHandler the click handler.
     */
    public SimpleHtmlButton(HTML html, ClickHandler clickHandler) {
        this(html);
        addClickHandler(clickHandler);
    }

    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        HandlerRegistration handlerRegistration = null;
        if (handler != null) {
            handlerRegistration = addDomHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (isEnabled()) {
                        handler.onClick(event);
                    }
                }
            }, ClickEvent.getType());
        }
        return handlerRegistration;
    }

    /**
     * The text.
     * @param html the html text.
     */
    public void setHTML(HTML html) {
        if (html != null) {
            directionalTextHelper.setTextOrHtml(html.getHTML(), true);
        } else {
            setText(null);
        }
        updateHorizontalAlignment();
    }

    @Override
    public boolean isEnabled() {
        return !getStyleName().contains(Constants.DISABLED);
    }

    @Override
    public void setEnabled(boolean enabled) {
        if (enabled) {
            removeStyleName(Constants.DISABLED);
        } else {
            addStyleName(Constants.DISABLED);
        }
    }

}
