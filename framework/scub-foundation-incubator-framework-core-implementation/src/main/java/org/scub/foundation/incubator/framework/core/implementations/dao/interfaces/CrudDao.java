package org.scub.foundation.incubator.framework.core.implementations.dao.interfaces;

import java.io.Serializable;

import org.scub.foundation.framework.core.model.BaseModel;

/**
 * Provide all classics methods for dao.
 * @param <ModelType> the object type.
 * @param <IdType> the object id type.
 * @param <CriteriaType> the criteria type fore search dao.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface CrudDao<ModelType extends BaseModel, IdType extends Serializable, CriteriaType> extends GetByIdDao<ModelType, IdType>,
        CreateOrUpdateDao<ModelType>, DeleteDao<ModelType>, PagingSearchDao<ModelType, CriteriaType> {

}
