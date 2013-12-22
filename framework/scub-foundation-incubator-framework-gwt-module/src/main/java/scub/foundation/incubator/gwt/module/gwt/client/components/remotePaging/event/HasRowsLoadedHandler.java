package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

/**
 * allow to add handler for rows loaded event.
 * @param <R> type of handler
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public interface HasRowsLoadedHandler<R> extends HasHandlers {

    /**
     * Add a row loaded handler.
     * @param handler the handler to add.
     * @return the handler registration.
     */
    HandlerRegistration addRowsLoadedHandler(RowsLoadedEventHandler<R> handler);
}
