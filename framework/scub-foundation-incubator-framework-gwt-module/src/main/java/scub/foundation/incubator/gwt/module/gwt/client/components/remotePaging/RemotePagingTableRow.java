package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging;

import java.util.ArrayList;
import java.util.List;

/**
 * This object represent a remote pagging row.
 * @param <T> the possible return type. Used {@link Void} if don't need. Whene the row are loaded, the remotePagingTable fire a RowsLoadedEvent that contains
 *            the list of <T>, one for each row added in remotePagingTable. This <T> Objects are created in the rowRenderer method. Use this param to atach some
 *            handlers to widgets displayed in the row such as ClickHandlers on a Button.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class RemotePagingTableRow<T> {

    private T handler;

    private List<RemotePagingTableCell> cells;

    /**
     * Constructor.
     */
    public RemotePagingTableRow() {
        this(null, new ArrayList<RemotePagingTableCell>());
    }

    /**
     * Constructor.
     * @param handler the handler used for this row. use Void if you don't need to attach handlers.
     */
    public RemotePagingTableRow(T handler) {
        this(handler, new ArrayList<RemotePagingTableCell>());
    }

    /**
     * Constructor.
     * @param cells the cells list.
     */
    public RemotePagingTableRow(List<RemotePagingTableCell> cells) {
        this(null, cells);
    }

    /**
     * Constructor.
     * @param handler the handler used for this row. use Void if you don't need to attach handlers.
     * @param cells the cells list.
     */
    public RemotePagingTableRow(T handler, List<RemotePagingTableCell> cells) {
        this.handler = handler;
        this.cells = cells;
    }

    /**
     * Get the value of handler.
     * @return the handler
     */
    public T getHandler() {
        return handler;
    }

    /**
     * Set the value of handler.
     * @param handler the handler to set
     */
    public void setHandler(T handler) {
        this.handler = handler;
    }

    /**
     * Get the value of cells.
     * @return the cells
     */
    public List<RemotePagingTableCell> getCells() {
        return cells;
    }

    /**
     * Set the value of cells.
     * @param cells the cells to set
     */
    public void setCells(List<RemotePagingTableCell> cells) {
        this.cells = cells;
    }

    /**
     * Add a cell to the row.
     * @param cell the cell to add.
     */
    public void addCell(RemotePagingTableCell cell) {
        cells.add(cell);
    }
}
