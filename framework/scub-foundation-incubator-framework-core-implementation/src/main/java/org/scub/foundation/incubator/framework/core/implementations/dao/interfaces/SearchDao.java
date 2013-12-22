package org.scub.foundation.incubator.framework.core.implementations.dao.interfaces;

import java.util.List;

import org.scub.foundation.framework.core.model.BaseModel;

/**
 * Dao for search.
 * @param <ModelType> the model type
 * @param <CriteriaType> the criteria type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface SearchDao<ModelType extends BaseModel, CriteriaType> {

    /**
     * Do a search with the given criteria.
     * @param criteria the paging criteria.
     * @return the results.
     */
    List<ModelType> search(CriteriaType criteria);
}
