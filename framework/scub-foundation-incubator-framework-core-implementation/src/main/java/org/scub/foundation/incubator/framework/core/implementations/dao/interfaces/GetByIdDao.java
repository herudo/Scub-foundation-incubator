package org.scub.foundation.incubator.framework.core.implementations.dao.interfaces;

import java.io.Serializable;

import org.scub.foundation.framework.core.model.BaseModel;

/**
 * Provide the getById dao method.
 * @param <ModelType> the object type.
 * @param <IdType> the object id type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface GetByIdDao<ModelType extends BaseModel, IdType extends Serializable> {
    /**
     * Get an object that extend.
     * @param id l'id à ércupérer
     * @return l'objet ou null si non trouvé.
     */
    ModelType getById(IdType id);
}
