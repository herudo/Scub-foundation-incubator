package org.scub.foundation.incubator.framework.core.implementations.dao.implementations;

import java.io.Serializable;

import org.scub.foundation.framework.core.model.BaseModel;
import org.scub.foundation.incubator.framework.core.implementations.dao.interfaces.GetByIdDao;

/**
 * Implementation Of abstract get by id dao.
 * @param <ModelType> the class type
 * @param <IdType> the id's object type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractGetByIdDaoImplementation<ModelType extends BaseModel, IdType extends Serializable> extends HibernateDaoBaseImplementation
        implements GetByIdDao<ModelType, IdType> {

    @Override
    public ModelType getById(IdType id) {
        return load(id, getClassType());
    }

    /**
     * Provide the Class object for this Dao type.
     * @return the class which correspond to the dao type.
     */
    public abstract Class<ModelType> getClassType();
}
