package scub.foundation.incubator.gwt.module.gwt.client.test.service;

import org.scub.foundation.framework.gwt.module.shared.IdLabelModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingCriteriasModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingResultsModel;

import scub.foundation.incubator.gwt.module.gwt.shared.criteria.IdLabelCriteriaModel;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Service asynchrone sur les examples.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
public interface PersonneTypeServiceGwtAsync {

    /**
     * Create or update a personne type.
     * @param PersonneType the personne type to create or update.
     * @param callBack the callback
     */
    void createOrUpdatePersonneType(IdLabelModel PersonneType, AsyncCallback<IdLabelModel> callBack);

    /**
     * Delete a personne type by it's id.
     * @param id the personne type id.
     * @param callBack the callback
     */
    void deletePersonneType(Long id, AsyncCallback<Void> callBack);

    /**
     * Get a personne type by it's id.
     * @param id the personne type id.
     * @param callBack the callback
     */
    void getPersonneTypeById(Long id, AsyncCallback<IdLabelModel> callBack);

    /**
     * Get paging results for given criteria.
     * @param criteria the criteria.
     * @param callBack the callback
     */
    void search(RemotePagingCriteriasModel<IdLabelCriteriaModel> criteria, AsyncCallback<RemotePagingResultsModel<IdLabelModel>> callBack);

}
