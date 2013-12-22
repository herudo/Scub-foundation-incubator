package org.scub.foundation.incubator.framework.core.implementations.dao.interfaces;

import java.util.List;

import org.scub.foundation.incubator.framework.core.implementations.model.IdLabelModel;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.StringSearchCriterionDto;

/**
 * Dao for model base on IdLabelModel.
 * @param <ModelType> the object type.
 * @param <CriteriaType> the criteria type fore search dao.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface IdLabelDao<ModelType extends IdLabelModel, CriteriaType extends IdLabelCriteriaDto> extends CrudDao<ModelType, Long, CriteriaType> {
    /**
     * Get a list of objects which extend from IdLabel filterd on the label.
     * @param filter the filter
     * @return the object's list.
     */
    List<ModelType> getByLabel(StringSearchCriterionDto filter);
}
