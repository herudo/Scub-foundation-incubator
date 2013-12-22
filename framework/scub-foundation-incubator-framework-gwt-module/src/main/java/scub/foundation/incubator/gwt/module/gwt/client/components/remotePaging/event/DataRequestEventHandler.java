package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for DataRequestEvent.
 * @param <T> the complex type.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public interface DataRequestEventHandler<T> extends EventHandler {
    /**
     * The method to perform when data request occured in remote table.
     * @param event the ColumnSortEvent.
     */
    void onDataRequest(DataRequestEvent<T> event);
}
