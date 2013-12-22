package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for RowsLoadedEvent.
 * @param <T> the complex type.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public interface RowsLoadedEventHandler<T> extends EventHandler {
    /**
     * The method to perform when all rows are loaded.
     * @param rowsLoadedEvent the ColumnSortEvent.
     */
    void onRowsLoaded(RowsLoadedEvent<T> rowsLoadedEvent);
}
