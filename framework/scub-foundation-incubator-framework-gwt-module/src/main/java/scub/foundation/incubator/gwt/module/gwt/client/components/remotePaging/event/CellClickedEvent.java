package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Event launch when a click occurs on a remote paging table clickable cell.
 * @param <T> the data type.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class CellClickedEvent<T> extends GwtEvent<CellClickedEventHandler> {
    /** The event's type. */
    public static final Type<CellClickedEventHandler> TYPE = new Type<CellClickedEventHandler>();

    private T rowData;

    private int rowNumber;
    /**
     * Constructor.
     * @param rowData the row data.
     * @param rowNumber the row number
     */
    public CellClickedEvent(T rowData, int rowNumber) {
        this.rowData = rowData;
        this.rowNumber = rowNumber;
    }

    @Override
    public Type<CellClickedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CellClickedEventHandler handler) {
        handler.onCellClicked(this);
    }

    /**
     * Get the value of rowData.
     * @return the rowData
     */
    public T getRowData() {
        return rowData;
    }

    /**
     * Set the value of rowData.
     * @param rowData the rowData to set
     */
    public void setRowData(T rowData) {
        this.rowData = rowData;
    }

    /**
     * Get the value of rowNumber.
     * @return the rowNumber
     */
    public int getRowNumber() {
        return rowNumber;
    }

    /**
     * Set the value of rowNumber.
     * @param rowNumber the rowNumber to set
     */
    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }
}
