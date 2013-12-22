package scub.foundation.incubator.gwt.module.gwt.client.test.service;

import org.scub.foundation.framework.gwt.module.client.exception.GwtRunTimeExceptionGwt;
import org.scub.foundation.framework.gwt.module.shared.IdLabelModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingCriteriasModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingResultsModel;

import scub.foundation.incubator.gwt.module.gwt.shared.criteria.IdLabelCriteriaModel;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Synchrone interface for personne type service.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
@RemoteServiceRelativePath("handler/personneTypeService")
public interface PersonneTypeServiceGwt extends RemoteService {

    /**
     * Create or update a personne type.
     * @param PersonneType the personne type to create or update.
     * @return the created or updated personne type.
     */
    IdLabelModel createOrUpdatePersonneType(IdLabelModel PersonneType) throws GwtRunTimeExceptionGwt;

    /**
     * Delete a personne type by it's id.
     * @param id the personne type id.
     */
    void deletePersonneType(Long id) throws GwtRunTimeExceptionGwt;

    /**
     * Get a personne type by it's id.
     * @param id the personne type id.
     * @return the personne type.
     */
    IdLabelModel getPersonneTypeById(Long id) throws GwtRunTimeExceptionGwt;

    /**
     * Get paging results for given criteria.
     * @param criteria the criteria.
     * @return the paging results.
     */
    RemotePagingResultsModel<IdLabelModel> search(RemotePagingCriteriasModel<IdLabelCriteriaModel> criteria) throws GwtRunTimeExceptionGwt;

}
