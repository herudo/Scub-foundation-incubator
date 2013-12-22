package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for CellClickedvent.
 * @param <T> the complex type.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public interface CellClickedEventHandler<T> extends EventHandler {
    /**
     * The method to perform when a cell is clicked.
     * @param event the ColumnSortEvent.
     */
    void onCellClicked(CellClickedEvent<T> event);
}
