package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging;

import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.HasCellClickedHandler;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.HasDataRequestHandlers;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.HasRowsLoadedHandler;

/**
 * A widget that implements this interface provides registration for {@link RemotePagingTable} handlers instances.
 * @param <T> type of data
 * @param <R> the returned type for rowLoadedEvent.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public interface HasRemotePagingTableHandlers<T, R> extends HasDataRequestHandlers<T>, HasCellClickedHandler<T>, HasRowsLoadedHandler<R> {

    /**
     * Fire a DataRequestEvent with the informations provided by the remotePagingTable.
     */
    void requestData();

    /**
     * Get the row data for the given rowNumber.
     * @param rowNumber the row number.
     * @return the row data.
     */
    T getRowData(int rowNumber);
}
