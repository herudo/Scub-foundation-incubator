package org.scub.foundation.incubator.framework.core.implementations.dao.interfaces;

import java.util.List;

import org.scub.foundation.framework.base.paging.RemotePagingCriteriasDto;
import org.scub.foundation.framework.core.model.BaseModel;

/**
 * Dao for paging search.
 * @param <ModelType> the model type
 * @param <CriteriaType> the criteria type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface PagingSearchDao<ModelType extends BaseModel, CriteriaType> extends SearchDao<ModelType, CriteriaType> {

    /**
     * Do a search with the given criteria.
     * @param criteria the paging criteria.
     * @return the results.
     */
    List<ModelType> search(RemotePagingCriteriasDto<CriteriaType> criteria);

    /**
     * Get the total results for the given criteria.
     * @param criteria the criteria.
     * @return the total results number.
     */
    int getTotalResults(CriteriaType criteria);
}
