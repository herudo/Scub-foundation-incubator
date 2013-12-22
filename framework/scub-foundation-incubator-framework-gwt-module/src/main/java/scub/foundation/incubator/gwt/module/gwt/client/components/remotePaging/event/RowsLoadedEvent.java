package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Event launch when all rows are loaded in remote paging table.
 * @param <T> the data type.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class RowsLoadedEvent<T> extends GwtEvent<RowsLoadedEventHandler> {
    /** The event's type. */
    public static final Type<RowsLoadedEventHandler> TYPE = new Type<RowsLoadedEventHandler>();

    private List<T> rowsHandlers;

    /**
     * Constructor.
     * @param rowsHandlers the rows handlers.
     */
    public RowsLoadedEvent(List<T> rowsHandlers) {
        this.rowsHandlers = rowsHandlers;
    }

    @Override
    public Type<RowsLoadedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RowsLoadedEventHandler handler) {
        handler.onRowsLoaded(this);
    }

    /**
     * Get the value of rowsHandlers.
     * @return the rowsHandlers
     */
    public List<T> getRowsHandlers() {
        return rowsHandlers;
    }

    /**
     * Set the value of rowsHandlers.
     * @param rowsHandlers the rowsHandlers to set
     */
    public void setRowsHandlers(List<T> rowsHandlers) {
        this.rowsHandlers = rowsHandlers;
    }
}
