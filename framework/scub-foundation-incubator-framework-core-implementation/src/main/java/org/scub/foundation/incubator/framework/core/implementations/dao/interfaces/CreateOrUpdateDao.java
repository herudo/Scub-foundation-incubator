package org.scub.foundation.incubator.framework.core.implementations.dao.interfaces;

import java.util.List;

import org.scub.foundation.framework.core.model.BaseModel;

/**
 * Provide create or update dao methods.
 * @param <ModelType> the object type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface CreateOrUpdateDao<ModelType extends BaseModel> extends CreateDao<ModelType>, UpdateDao<ModelType> {

    /**
     * Create or update an object which extend from IdLabel.
     * @param object the object to create
     */
    void createOrUpdate(ModelType object);

    /**
     * Create or update a list of objects which extend from IdLabel.
     * @param objects the objects to create
     */
    void createOrUpdateAll(List<ModelType> objects);

}
