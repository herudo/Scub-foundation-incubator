package org.scub.foundation.incubator.framework.core.implementations.dao.interfaces;

import java.util.List;

import org.scub.foundation.framework.core.model.BaseModel;

/**
 * Provide delete dao methods.
 * @param <ModelType> the object type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface DeleteDao<ModelType extends BaseModel> {

    /**
     * delete an object which extend from IdLabel.
     * @param object the object to delete
     */
    void delete(ModelType object);

    /**
     * Supprime une liste d'objets du type <T> héritant de BaseModel.
     * @param objects les objets à supprimer.
     */
    void deleteAll(List<ModelType> objects);
}
