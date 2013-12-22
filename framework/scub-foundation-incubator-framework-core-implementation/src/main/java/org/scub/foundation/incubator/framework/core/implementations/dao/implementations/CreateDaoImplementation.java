package org.scub.foundation.incubator.framework.core.implementations.dao.implementations;

import java.util.List;

import org.scub.foundation.framework.core.model.BaseModel;
import org.scub.foundation.incubator.framework.base.utils.ListUtils;
import org.scub.foundation.incubator.framework.core.implementations.dao.interfaces.CreateDao;

/**
 * Implementation of create dao.
 * @param <ModelType> the class type
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class CreateDaoImplementation<ModelType extends BaseModel> extends HibernateDaoBaseImplementation implements CreateDao<ModelType> {

    @Override
    public void create(ModelType object) {
        save(object);
    }

    @Override
    public void createAll(List<ModelType> objects) {
        if (ListUtils.isNotEmpty(objects)) {
            for (ModelType object : objects) {
                create(object);
            }
        }
    }

}
