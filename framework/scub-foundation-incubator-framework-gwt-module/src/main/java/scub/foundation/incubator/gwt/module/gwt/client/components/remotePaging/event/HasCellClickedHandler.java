package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

/**
 * allow to add handler for Cell clicked event.
 * @param <T> type of data
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public interface HasCellClickedHandler<T> extends HasHandlers {

    /**
     * Add a cell clicked handler.
     * @param handler the handler to add.
     * @return the handler registration.
     */
    HandlerRegistration addCellClickedHandler(CellClickedEventHandler<T> handler);
}
