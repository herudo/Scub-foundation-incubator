package org.scub.foundation.incubator.framework.core.implementations.dao.interfaces;

import java.util.List;

import org.scub.foundation.framework.core.model.BaseModel;

/**
 * Provide update dao methods.
 * @param <ModelType> the object type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface UpdateDao<ModelType extends BaseModel> {

    /**
     * update an object which extend from IdLabel.
     * @param object the object to create
     */
    void update(ModelType object);

    /**
     * Update a list of objects which extend from IdLabel.
     * @param objects the objects to create
     */
    void updateAll(List<ModelType> objects);
}
