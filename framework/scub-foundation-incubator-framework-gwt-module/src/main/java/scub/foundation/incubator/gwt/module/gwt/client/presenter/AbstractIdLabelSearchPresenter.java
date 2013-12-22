package scub.foundation.incubator.gwt.module.gwt.client.presenter;

import org.scub.foundation.framework.gwt.module.shared.IdLabelModel;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HasWidgets.ForIsWidget;

import scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.handlers.HasStringSearchCriterion;
import scub.foundation.incubator.gwt.module.gwt.shared.criteria.IdLabelCriteriaModel;

/**
 * Implementation of search presenter for idLabel.
 * @param <ResultType> the type of result in the results list.
 * @param <RowHandlerType> the returned type for RemotePagingTableRow, used to attach handler to widget displayed in the row. Use Void if you don't need to
 *            attach something.
 * @param <CriteriaType> the type remote pagging criterias.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractIdLabelSearchPresenter<ResultType extends IdLabelModel, RowHandlerType, CriteriaType extends IdLabelCriteriaModel> extends
        AbstractSearchPresenter<ResultType, RowHandlerType, CriteriaType> {

    /** the id label search view. */
    protected IdLabelSearchView<ResultType, RowHandlerType> view;

    /**
     * Constructor.
     * @param view the id label search view.
     * @param <ViewType> the view type.
     */
    public <ViewType extends IdLabelSearchView<ResultType, RowHandlerType>> AbstractIdLabelSearchPresenter(ViewType view) {
        super(view);
        this.view = view;
    }

    @Override
    public CriteriaType getCriteria() {
        final CriteriaType criteria = getIdLabelCriteria();

        if (criteria != null) {
            criteria.setLabel(view.getLabel().getSearchCriterion());
        }
        return criteria;
    }

    @Override
    public void onShow(ForIsWidget container) {
        super.onShow(container);
        new Timer() {

            @Override
            public void run() {
                view.resize();
            }
        }.schedule(10);
    }

    /**
     * Get an instance of the id label criteria.
     * @return the criteria.
     */
    public abstract CriteriaType getIdLabelCriteria();

    /**
     * The IdLabel search view interface.
     * @author Adrien HAUTOT (contact@adrienhautot.fr)
     * @param <ResultType> the type of result in the results list.
     * @param <RowHandlerType> the returned type for RemotePagingTableRow, used to attach handler to widget displayed in the row. Use Void if you don't need to
     *            attach something.
     */
    public interface IdLabelSearchView<ResultType, RowHandlerType> extends SearchView<ResultType, RowHandlerType> {

        /**
         * Get the label search criterion.
         * @return the handler on the search criterion.
         */
        HasStringSearchCriterion getLabel();

        /**
         * Force to calculate sizes.
         */
        void resize();
    }

}
