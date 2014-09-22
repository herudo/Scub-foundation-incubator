package scub.foundation.incubator.gwt.module.gwt.client.test;

import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingCriteriasModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingResultsModel;

import scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.handlers.HasIntegerSearchCriterion;
import scub.foundation.incubator.gwt.module.gwt.client.presenter.AbstractSearchPresenter;
import scub.foundation.incubator.gwt.module.gwt.shared.test.NumberValueCriteriaModel;
import scub.foundation.incubator.gwt.module.gwt.shared.test.NumberValueModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class NumberSearchPresenter extends AbstractSearchPresenter<NumberValueModel, Void, NumberValueCriteriaModel> {

    private NumberValueSearchView view;

    /**
     * Constructor.
     * @param view the view.
     */
    public NumberSearchPresenter(NumberValueSearchView view) {
        super(view);
        this.view = view;
    }

    @Override
    public void openEntity(NumberValueModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public NumberValueCriteriaModel getCriteria() {
        final NumberValueCriteriaModel criteria = new NumberValueCriteriaModel();
        criteria.setIntegerSearchCriterion(view.getIntegerSearchCriterion().getSearchCriterion());
        return null;
    }

    @Override
    public void doSearch(RemotePagingCriteriasModel<NumberValueCriteriaModel> criterias, AsyncCallback<RemotePagingResultsModel<NumberValueModel>> callback) {
        // TODO
        GWT.log(">>>>>>" + criterias.getCriterias());
    }

    @Override
    public void onDetach() {

    }

    public interface NumberValueSearchView extends SearchView<NumberValueModel, Void> {

        HasIntegerSearchCriterion getIntegerSearchCriterion();
    }
}
