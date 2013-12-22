package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging;

import java.util.ArrayList;
import java.util.List;

import org.scub.foundation.framework.gwt.module.client.exception.TechnicalExceptionGwt;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingResultsModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingSortModel;

import scub.foundation.incubator.gwt.module.gwt.client.bundle.ScubFoundationIncubatorResources;
import scub.foundation.incubator.gwt.module.gwt.client.components.pagination.Pagination;
import scub.foundation.incubator.gwt.module.gwt.client.components.pagination.Pagination.Display;
import scub.foundation.incubator.gwt.module.gwt.client.components.pagination.event.PageChangeEvent;
import scub.foundation.incubator.gwt.module.gwt.client.components.pagination.event.PageChangeHandler;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.CellClickedEvent;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.CellClickedEventHandler;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.DataRequestEvent;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.DataRequestEventHandler;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.RowsLoadedEvent;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.RowsLoadedEventHandler;
import scub.foundation.incubator.gwt.module.gwt.client.factory.AppClientFactory;

import com.github.gwtbootstrap.client.ui.base.InlineLabel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Remote paging table.
 * @param <T> type of data
 * @param <R> the returned type for RemotePagingTableRow, used to attach handler to widget displayed in the row. Use Void if you don't need to attach something.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public abstract class RemotePagingTable<T, R> extends Composite implements IsWidget, HasRemotePagingTableHandlers<T, R> {

    /** Data table. */
    private FlexTable dataTable;

    private HorizontalPanel loadingPanel;

    private List<T> data;

    /** Pagination. */
    private Pagination pagination;

    private VerticalPanel container;

    private List<RemotePagingSortModel> sorts;

    private InlineLabel noResult;

    private InlineLabel resultsNumber;

    private List<Widget> headersWidget;

    private List<RemotePagingTableHeader> headers;

    private Integer pageSize;

    /** Messages. */
    private Messages messages = GWT.create(Messages.class);

    private static ScubFoundationIncubatorResources resources = AppClientFactory.getResources();

    /** The messages used in this table. */
    public interface Messages extends com.google.gwt.i18n.client.Messages {
        /**
         * Return noResults.
         * @return noResults
         */
        String noResult();

        /**
         * return result.
         * @return result.
         */
        String result();

        /**
         * Return Results.
         * @return results
         */
        String results();
    }

    /**
     * Constructor.
     * @param pageSize nb elements per page
     */
    public RemotePagingTable(int pageSize) {
        this(pageSize, Display.ALL);
    }

    /**
     * Constructor.
     * @param pageSize nb elements per page
     * @param display display of pagination
     */
    public RemotePagingTable(int pageSize, Display display) {
        pagination = new Pagination(pageSize, display);
        pagination.setVisible(false);
        final int marginRight = 18;
        pagination.getElement().getStyle().setMarginRight(marginRight, Unit.PX);
        this.pageSize = pageSize;

        headersWidget = new ArrayList<Widget>();
        headers = new ArrayList<RemotePagingTableHeader>();
        sorts = new ArrayList<RemotePagingSortModel>();
        data = new ArrayList<T>();

        dataTable = new FlexTable();
        dataTable.setVisible(false);
        dataTable.setWidth("100%");
        dataTable.addStyleName(" table-condensed table-bordered table-striped ");

        noResult = new InlineLabel(messages.noResult());
        noResult.getElement().getStyle().setProperty("display", "block");
        resultsNumber = new InlineLabel();
        resultsNumber.setVisible(false);
        resultsNumber.getElement().getStyle().setMarginRight(10, Unit.PX);

        loadingPanel = new HorizontalPanel();
        loadingPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        loadingPanel.addStyleName(AppClientFactory.getResources().css().remotePagingLoadingPanel());
        loadingPanel.add(new Image(resources.remotePagingLoader()));
        showLoadingPanel(false);

        final HorizontalPanel paginationContainer = new HorizontalPanel();
        paginationContainer.addStyleName(AppClientFactory.getResources().css().paginationContainer());
        paginationContainer.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        paginationContainer.add(resultsNumber);
        paginationContainer.add(pagination);

        container = new VerticalPanel();
        container.addStyleName("table-bordered " + AppClientFactory.getResources().css().remotePagingTable());
        container.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        container.add(loadingPanel);
        container.add(dataTable);
        container.add(paginationContainer);
        container.add(noResult);

        pagination.addPageChangeHandler(new PageChangeHandler() {
            @Override
            public void onPageChange(PageChangeEvent event) {
                requestData(event.getPage());
            }
        });

        initWidget(container);
    }

    /**
     * Creat the header line.
     */
    public void refreshHeader() {
        if (headersWidget.size() > 0) { // if there ise some headers widgets, we add it.
            for (int i = 0; i < headersWidget.size(); i++) {
                dataTable.setWidget(0, i, headersWidget.get(i));
                dataTable.getFlexCellFormatter().setStyleName(0, i, "cellTableHeader");
            }
        }
        // if there is header (for column sorts).
        if (headers.size() > 0) {
            for (final RemotePagingTableHeader header : headers) {
                if (!header.isClickedEventAttached()) {
                    if (header.getAscending() != null) {
                        sorts.clear(); // only one column sort at a same time
                        sorts.add(new RemotePagingSortModel(header.getColumnName(), header.getAscending()));
                    }
                    // when an header is clicked, we launch the data request
                    header.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                            sorts.clear(); // only one column sort at a same time
                            sorts.add(new RemotePagingSortModel(header.getColumnName(), header.getAscending()));
                            requestData();
                            // refresh all headers (for the sort icon)
                            for (RemotePagingTableHeader headerToRefresh : headers) {
                                if (!header.equals(headerToRefresh)) { // if it's not the clicked header, we set the ascending to null.
                                    headerToRefresh.setAscending(null);
                                }
                            }
                        }
                    });
                    // in order to don't attach a new time header click.
                    header.setClickedEventAttached(true);
                }
            }
        }
    }

    /**
     * Fire a DataRequestEvent with the informations provided by the remotePagingTable.
     */
    @Override
    public void requestData() {
        requestData(0);
    }

    /**
     * Fire a DataRequestEvent with the informations provided by the remotePagingTable.
     * @param pageNumber the page number.
     * @param firstResult the first result number.
     */
    private void requestData(final int pageNumber) {
        // create the DataRequestEvent
        final int firstResult = pageNumber * pagination.getNbElementsPerPage();
        final DataRequestEvent<T> event = new DataRequestEvent<T>();
        event.setSorts(sorts);
        event.setFirstResult(firstResult);
        event.setMaxResult(firstResult + pagination.getNbElementsPerPage());

        // create the callback
        event.setCallback(new AsyncCallback<RemotePagingResultsModel<T>>() {

            @Override
            public void onFailure(Throwable caught) {
                showLoadingPanel(false);
                new TechnicalExceptionGwt(caught);
            }

            @Override
            public void onSuccess(RemotePagingResultsModel<T> results) {
                // clear all widget and lists.
                dataTable.clear();
                dataTable.removeAllRows();
                data.clear();
                refreshHeader();
                int rowNumber = dataTable.getRowCount();

                // list for the rowsLoadedEvent
                final List<R> rowsHandlers = new ArrayList<R>();
                if (results != null && results.getListResults().size() > 0) {
                    // there are result so hide the noResult message and show data and pagination.
                    noResult.setVisible(false);
                    dataTable.setVisible(true);
                    data = results.getListResults();

                    // foreach results.
                    for (T result : results.getListResults()) {
                        // get the row render.
                        final RemotePagingTableRow<R> row = rowRender(result, rowNumber - 1);
                        if (row != null) {
                            final List<RemotePagingTableCell> cells = row.getCells();
                            // add handler to the list if it's not null and not Void instance.
                            if (row.getHandler() != null && !(row.getHandler() instanceof Void)) {
                                rowsHandlers.add(row.getHandler());
                            }
                            if (cells != null) {
                                // foreach cells
                                for (int colNumber = 0; colNumber < cells.size(); colNumber++) {
                                    if (cells.get(colNumber).isClickable()) { // if the cell is clickable
                                        final Cell cell = new Cell(cells.get(colNumber).getContent());
                                        final int finalRowNumber = rowNumber - 1;
                                        // fire cell click event on cell click.
                                        cell.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                fireEvent(new CellClickedEvent<T>(data.get(finalRowNumber), finalRowNumber));
                                            }
                                        });
                                        cell.addStyleName(AppClientFactory.getResources().css().clickable());
                                        dataTable.setWidget(rowNumber, colNumber, cell);
                                    } else {
                                        dataTable.setWidget(rowNumber, colNumber, cells.get(colNumber).getContent());
                                    }
                                }
                            }
                            rowNumber++;
                        }
                        // set the results label text.
                        resultsNumber.setVisible(true);
                        resultsNumber.setText(results.getTotalResults() + " ");
                        if (results.getListResults().size() > 1) {
                            resultsNumber.setText(resultsNumber.getText() + messages.results());
                        } else {
                            resultsNumber.setText(resultsNumber.getText() + messages.result());
                        }
                        // refresh pagination
                        if (results.getTotalResults() <= pageSize) {
                            pagination.setVisible(false);
                        } else {
                            pagination.setVisible(true);
                            pagination.rebuildPagination(pageNumber, results.getTotalResults());
                        }
                    }
                } else {
                    // no results, hide data and pagination and show the noResults label.
                    noResult.setText(messages.noResult());
                    noResult.setVisible(true);
                    dataTable.setVisible(false);
                    pagination.setVisible(false);
                    resultsNumber.setVisible(false);
                }
                // all the row are loaded, fire a row loaded event.
                fireEvent(new RowsLoadedEvent<R>(rowsHandlers));
                showLoadingPanel(false);
            }
        });
        showLoadingPanel(true);
        fireEvent(event);
    }

    /**
     * Define how to display the complex type <T>.
     * @param rowData the complex type to display
     * @param rowNumber the row number in the displayed page
     * @return the row informations.
     */
    public abstract RemotePagingTableRow<R> rowRender(T rowData, int rowNumber);

    @Override
    public Widget asWidget() {
        return container;
    }

    /**
     * Define visible.
     * @param visible visible
     */
    public void setVisible(boolean visible) {
        container.setVisible(visible);
    }

    /**
     * Get the value of dataTable.
     * @return the dataTable
     */
    public FlexTable getDataTable() {
        return dataTable;
    }

    /**
     * Add a widget as header. In order to add a widget with sortable column fonction, us addHeader(Widget, Header) method.
     * @param header the widget to add as header.
     */
    public void addHeader(Widget header) {
        headersWidget.add(header);
    }

    /**
     * Add a new header definition. The widget is display and the header is used to refresh visual interface. Use this methode to add complew widget as header.
     * For example, a vertical panel with a picture and an header for sortable column. The header has to be put in the widget if you want it to be visible. In
     * order to add a widget without sortable column fonction, us addHeader(Widget) method.
     * @param widget the widget to add as header.
     * @param header the header to used.
     */
    public void addHeader(Widget widget, RemotePagingTableHeader header) {
        headersWidget.add(widget);
        headers.add(header);
    }

    /**
     * Add a RemotePagingTableHeader for sortable column. RemotePagingTableHeader is used to indicate sortable columns.
     * @param header the header to add.
     */
    public void addHeader(RemotePagingTableHeader header) {
        headersWidget.add(header);
        headers.add(header);
    }

    /**
     * Show/hide the loading panel.
     * @param show true to show the panel, false to hide.
     */
    public void showLoadingPanel(boolean show) {
        if (show) {
             loadingPanel.setHeight(container.getElement().getClientHeight() + "px");
            final int width = container.getElement().getClientWidth();
            final int loaderWidth = 66;
            if (width > loaderWidth) {
                loadingPanel.setWidth(container.getElement().getClientWidth() + "px");
            } else {
                loadingPanel.setWidth("100%");
            }
        }
        loadingPanel.setVisible(show);
    }

    @Override
    public T getRowData(int rowNumber) {
        if (data != null && data.size() >= rowNumber) {
            return data.get(rowNumber);
        }
        return null;
    }

    @Override
    public HandlerRegistration addCellClickedHandler(CellClickedEventHandler<T> handler) {
        return addHandler(handler, CellClickedEvent.TYPE);
    }

    @Override
    public HandlerRegistration addDataRequestHandler(DataRequestEventHandler<T> handler) {
        return addHandler(handler, DataRequestEvent.TYPE);
    }

    @Override
    public HandlerRegistration addRowsLoadedHandler(RowsLoadedEventHandler<R> handler) {
        return addHandler(handler, RowsLoadedEvent.TYPE);
    }

    /**
     * A widget for clickable Cells.
     * @author Adrien HAUTOT (adrien.hautot@scub.net)
     */
    private class Cell extends FocusPanel {

        /**
         * Constructor.
         * @param widget the cell content.
         */
        public Cell(Widget widget) {
            super();

            getElement().getStyle().setProperty("outline", "none");
            setHeight("100%");

            add(widget);
        }
    }

    /**
     * Set the value of messages.
     * @param messages the messages to set
     */
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

}
