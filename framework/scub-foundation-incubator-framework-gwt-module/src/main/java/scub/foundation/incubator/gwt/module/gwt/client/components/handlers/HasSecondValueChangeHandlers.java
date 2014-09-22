package scub.foundation.incubator.gwt.module.gwt.client.components.handlers;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A widget that implements this interface is a public source of {@link ValueChangeEvent} events.
 * @param <T> the value about to be changed
 */
public interface HasSecondValueChangeHandlers<T> extends HasHandlers {
    /**
     * Adds a {@link ValueChangeEvent} handler.
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addSecondValueChangeHandler(ValueChangeHandler<T> handler);
}
