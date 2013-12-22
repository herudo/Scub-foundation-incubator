package scub.foundation.incubator.gwt.module.gwt.client.test;

import org.scub.foundation.framework.gwt.module.shared.IdLabelModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingCriteriasModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingResultsModel;

import scub.foundation.incubator.gwt.module.gwt.client.factory.AppClientFactory;
import scub.foundation.incubator.gwt.module.gwt.client.presenter.AbstractIdLabelSearchPresenter;
import scub.foundation.incubator.gwt.module.gwt.client.presenter.AbstractIdLabelSearchPresenter.IdLabelSearchView;
import scub.foundation.incubator.gwt.module.gwt.shared.criteria.IdLabelCriteriaModel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class PersonneTypeSearchPresenter extends AbstractIdLabelSearchPresenter<IdLabelModel, Void, IdLabelCriteriaModel> {

    private PersonneTypeSearchView view;

    private boolean operatorVisible = true;

    /**
     * Constructor.
     * @param view
     */
    public PersonneTypeSearchPresenter(PersonneTypeSearchView view) {
        super(view);
        this.view = view;
    }

    @Override
    public void onBind() {
        super.onBind();
        view.getOptionsClick().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                view.getLabel().setOperatorVisible(!operatorVisible);
                view.getLabel().setCaseSensitiveOptionvisible(!operatorVisible);
                operatorVisible = !operatorVisible;
                view.resize();
            }
        });
    }

    @Override
    public void openEntity(IdLabelModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void doSearch(RemotePagingCriteriasModel<IdLabelCriteriaModel> criterias, AsyncCallback<RemotePagingResultsModel<IdLabelModel>> callback) {
        AppClientFactory.getPersonneTypeService().search(criterias, callback);
    }

    @Override
    public void onDetach() {

    }

    @Override
    public IdLabelCriteriaModel getIdLabelCriteria() {
        return new IdLabelCriteriaModel();
    }

    public interface PersonneTypeSearchView extends IdLabelSearchView<IdLabelModel, Void> {
        HasClickHandlers getOptionsClick();
    }
}
