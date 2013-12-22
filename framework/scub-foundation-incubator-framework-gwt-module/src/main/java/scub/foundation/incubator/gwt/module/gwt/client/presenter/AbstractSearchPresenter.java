package scub.foundation.incubator.gwt.module.gwt.client.presenter;

import java.util.logging.Logger;

import org.scub.foundation.framework.gwt.module.client.mvp.presenter.Presenter;
import org.scub.foundation.framework.gwt.module.client.mvp.view.View;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingCriteriasModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingResultsModel;

import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.HasRemotePagingTableHandlers;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.CellClickedEvent;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.CellClickedEventHandler;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.DataRequestEvent;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event.DataRequestEventHandler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets.ForIsWidget;

/**
 * Presenter for commons search page functionalities.
 * @param <ResultType> the type of result in the results list.
 * @param <RowHandlerType> the returned type for RemotePagingTableRow, used to attach handler to widget displayed in the row. Use Void if you don't need to
 *            attach something.
 * @param <CriteriaType> the type remote pagging criterias.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractSearchPresenter<ResultType, RowHandlerType, CriteriaType> extends Presenter {

    private static Logger logger = Logger.getLogger("AbstractSearchPresenter");

    /** the search view. */
    protected SearchView<ResultType, RowHandlerType> view;

    /**
     * Constructor.
     * @param view the search view.
     * @param <ViewType> the view type.
     */
    public <ViewType extends SearchView<ResultType, RowHandlerType>> AbstractSearchPresenter(ViewType view) {
        this.view = view;
    }

    @Override
    public void onBind() {
        if (view != null) {
            view.getSearchClick().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    view.getRemotePagingTableHandlers().requestData();
                }
            });

            view.getClearClick().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    view.clearSearch();
                }
            });

            view.getRemotePagingTableHandlers().addCellClickedHandler(new CellClickedEventHandler<ResultType>() {
                @Override
                public void onCellClicked(CellClickedEvent<ResultType> event) {
                    if (event != null) {
                        openEntity(event.getRowData());
                    }
                }
            });

            view.getRemotePagingTableHandlers().addDataRequestHandler(new DataRequestEventHandler<ResultType>() {
                @Override
                public void onDataRequest(DataRequestEvent<ResultType> event) {
                    doSearch(getRemotePagingCriterias(event, getCriteria()), event.getCallback());
                }
            });

            view.getKeyPress().addKeyPressHandler(new KeyPressHandler() {
                @Override
                public void onKeyPress(KeyPressEvent event) {
                    if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
                        view.getRemotePagingTableHandlers().requestData();
                    }
                }
            });
        } else {
            logger.severe("The search view must not be null");
        }
    }

    /**
     * Get the remote paging criterias.
     * @param event the data request event.
     * @param criterias the search criterias
     * @return the remote paging criteria.
     */
    protected RemotePagingCriteriasModel<CriteriaType> getRemotePagingCriterias(DataRequestEvent<ResultType> event, CriteriaType criterias) {
        final RemotePagingCriteriasModel<CriteriaType> remotePaggingCriterias = new RemotePagingCriteriasModel<CriteriaType>();
        remotePaggingCriterias.setCriterias(criterias);
        remotePaggingCriterias.setFirstResult(event.getFirstResult());
        remotePaggingCriterias.setMaxResult(event.getMaxResult());
        remotePaggingCriterias.setListeSorts(event.getSorts());

        return remotePaggingCriterias;
    }

    @Override
    public void onShow(ForIsWidget container) {
        if (container != null) {
            if (view != null) {
                container.add(view.asWidget());
                view.getRemotePagingTableHandlers().requestData();
            } else {
                logger.severe("The search view must not be null");
            }
        } else {
            logger.warning("The given container for search view is null");
        }
    }

    /**
     * open the given entity.
     * @param value the entity to open.
     */
    public abstract void openEntity(ResultType value);

    /**
     * Get the search criterias.
     * @return the search criteria.
     */
    public abstract CriteriaType getCriteria();

    /**
     * Call the search service whit the given callback.
     * @param criterias the criterias.
     * @param callback the callback to use.
     */
    public abstract void doSearch(RemotePagingCriteriasModel<CriteriaType> criterias, AsyncCallback<RemotePagingResultsModel<ResultType>> callback);

    /**
     * View interface for commons search page functionalities.
     * @param <ResultType> the type of result in the results list.
     * @author Adrien HAUTOT (contact@adrienhautot.fr)
     */
    public interface SearchView<ResultType, RowHandlerType> extends View {
        /**
         * Get search click handler.
         * @return le ClickHandler.
         */
        HasClickHandlers getSearchClick();

        /**
         * get clear click handler.
         * @return le ClickHandler.
         */
        HasClickHandlers getClearClick();

        /**
         * clear all search fields.
         */
        void clearSearch();

        /**
         * get the display results handlers..
         * @return la RemotePagingTable.
         */
        HasRemotePagingTableHandlers<ResultType, RowHandlerType> getRemotePagingTableHandlers();

        /**
         * Get key press on all search fields.
         * @return le key press handler
         */
        HasKeyPressHandlers getKeyPress();
    }
}
