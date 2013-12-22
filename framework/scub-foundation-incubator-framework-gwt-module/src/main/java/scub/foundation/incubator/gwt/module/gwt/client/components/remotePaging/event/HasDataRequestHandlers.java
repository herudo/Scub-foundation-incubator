package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Has handler for DataRequestEvent.
 * @param <T> the complex type.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public interface HasDataRequestHandlers<T> extends HasHandlers {

    /**
     * Add an handler for data request event.
     * @param handler the handler.
     * @return the handler registration.
     */
    HandlerRegistration addDataRequestHandler(DataRequestEventHandler<T> handler);
}
