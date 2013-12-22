package scub.foundation.incubator.example.core.interfaces.services.interfaces;

import org.scub.foundation.framework.base.paging.RemotePagingCriteriasDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.IdLabelDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.RemotePagingResultsDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;

/**
 * Interface of a service to test the IdLabelService.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface PersonneTypeService {

    /**
     * Create or update a personne type.
     * @param PersonneType the personne type to create or update.
     * @return the created or updated personne type.
     */
    IdLabelDto createOrUpdatePersonneType(IdLabelDto PersonneType);

    /**
     * Delete a personne type by it's id.
     * @param id the personne type id.
     */
    void deletePersonneType(Long id);

    /**
     * Get a personne type by it's id.
     * @param id the personne type id.
     * @return the personne type.
     */
    IdLabelDto getPersonneTypeById(Long id);

    /**
     * Get paging results for given criteria.
     * @param criteria the criteria.
     * @return the paging results.
     */
    RemotePagingResultsDto<IdLabelDto> search(RemotePagingCriteriasDto<IdLabelCriteriaDto> criteria);
}
