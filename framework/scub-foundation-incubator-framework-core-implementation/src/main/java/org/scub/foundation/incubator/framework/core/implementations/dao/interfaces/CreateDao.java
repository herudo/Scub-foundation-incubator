package org.scub.foundation.incubator.framework.core.implementations.dao.interfaces;

import java.util.List;

import org.scub.foundation.framework.core.model.BaseModel;

/**
 * Provide create dao methods.
 * @param <ModelType> the object type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface CreateDao<ModelType extends BaseModel> {

    /**
     * Create an object which extend from IdLabel.
     * @param object the object to create
     */
    void create(ModelType object);

    /**
     * Create a list of objects which extend from IdLabel.
     * @param objects the objects to create
     */
    void createAll(List<ModelType> objects);
}
