package org.scub.foundation.incubator.framework.core.implementations.dao.implementations;

import java.util.List;

import org.scub.foundation.framework.core.model.BaseModel;
import org.scub.foundation.incubator.framework.base.utils.ListUtils;
import org.scub.foundation.incubator.framework.core.implementations.dao.interfaces.CreateOrUpdateDao;

/**
 * Implementation Of abstract create or update dao.
 * @param <ModelType> the class type
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class CreateOrUpdateDaoImplementation<ModelType extends BaseModel> extends HibernateDaoBaseImplementation implements CreateOrUpdateDao<ModelType> {

    private CreateDaoImplementation<ModelType> createDao;

    private UpdateDaoImplementation<ModelType> updateDao;

    @Override
    public void create(ModelType object) {
        getCreateDaoInstance().create(object);
    }

    @Override
    public void createAll(List<ModelType> objects) {
        getCreateDaoInstance().createAll(objects);
    }

    @Override
    public void update(ModelType object) {
        getUdpateDaoInstance().update(object);
    }

    @Override
    public void updateAll(List<ModelType> objects) {
        getUdpateDaoInstance().updateAll(objects);
    }

    @Override
    public void createOrUpdate(ModelType object) {
        super.saveOrUpdate(object);
    }

    @Override
    public void createOrUpdateAll(List<ModelType> objects) {
        if (ListUtils.isNotEmpty(objects)) {
            for (ModelType object : objects) {
                createOrUpdate(object);
            }
        }
    }

    /**
     * get update dao instance.
     * @return the update dao.
     */
    protected UpdateDaoImplementation<ModelType> getUdpateDaoInstance() {
        if (updateDao == null) {
            updateDao = new UpdateDaoImplementation<ModelType>();
            updateDao.setSessionFactory(sessionFactory);
        }

        return updateDao;
    }

    /**
     * get create dao instance.
     * @return the create dao.
     */
    protected CreateDaoImplementation<ModelType> getCreateDaoInstance() {
        if (createDao == null) {
            createDao = new CreateDaoImplementation<ModelType>();
            createDao.setSessionFactory(sessionFactory);
        }

        return createDao;
    }

}
