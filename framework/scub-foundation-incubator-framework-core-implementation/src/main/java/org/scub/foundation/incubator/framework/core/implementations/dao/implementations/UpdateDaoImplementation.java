package org.scub.foundation.incubator.framework.core.implementations.dao.implementations;

import java.util.List;

import org.scub.foundation.framework.core.model.BaseModel;
import org.scub.foundation.incubator.framework.base.utils.ListUtils;
import org.scub.foundation.incubator.framework.core.implementations.dao.interfaces.UpdateDao;

/**
 * Implementation Of abstract update dao.
 * @param <ModelType> the class type
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class UpdateDaoImplementation<ModelType extends BaseModel> extends HibernateDaoBaseImplementation implements UpdateDao<ModelType> {

    @Override
    public void update(ModelType object) {
        super.update(object);
    }

    @Override
    public void updateAll(List<ModelType> objects) {
        if (ListUtils.isNotEmpty(objects)) {
            for (ModelType object : objects) {
                update(object);
            }
        }
    }

}
