package org.scub.foundation.incubator.framework.core.implementations.dao.implementations;

import java.util.List;

import org.scub.foundation.framework.core.model.BaseModel;
import org.scub.foundation.incubator.framework.core.implementations.dao.interfaces.DeleteDao;

/**
 * Implementation Of abstract update dao.
 * @param <ModelType> the class type
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class DeleteDaoImplementation<ModelType extends BaseModel> extends HibernateDaoBaseImplementation implements DeleteDao<ModelType> {

    @Override
    public void delete(ModelType object) {
        super.delete(object);
    }

    @Override
    public void deleteAll(List<ModelType> objects) {
        super.deleteAll(objects);
    }

}
