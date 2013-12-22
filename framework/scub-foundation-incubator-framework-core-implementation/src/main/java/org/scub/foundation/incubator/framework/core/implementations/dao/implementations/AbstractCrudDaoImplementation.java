package org.scub.foundation.incubator.framework.core.implementations.dao.implementations;

import java.io.Serializable;
import java.util.List;

import org.scub.foundation.framework.core.model.BaseModel;
import org.scub.foundation.incubator.framework.core.implementations.dao.interfaces.CrudDao;

/**
 * Implementation Of abstract crud dao.
 * @param <ModelType> the class type
 * @param <IdType> the id's object type.
 * @param <CriteriaType> the criteria type fore search dao.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractCrudDaoImplementation<ModelType extends BaseModel, IdType extends Serializable, CriteriaType> extends
        AbstractGetByIdDaoImplementation<ModelType, IdType> implements CrudDao<ModelType, IdType, CriteriaType> {

    private CreateOrUpdateDaoImplementation<ModelType> createorUpdateDao;

    private DeleteDaoImplementation<ModelType> deleteDao;

    @Override
    public void create(ModelType object) {
        getCreateorUpdateDaoInstance().create(object);
    }

    @Override
    public void delete(ModelType object) {
        getDeleteDaoInstance().delete(object);
    }

    @Override
    public void update(ModelType object) {
        getCreateorUpdateDaoInstance().update(object);
    }

    @Override
    public void createOrUpdate(ModelType object) {
        getCreateorUpdateDaoInstance().createOrUpdate(object);
    }

    @Override
    public void createAll(List<ModelType> objects) {
        getCreateorUpdateDaoInstance().createAll(objects);
    }

    @Override
    public void deleteAll(List<ModelType> objects) {
        getDeleteDaoInstance().deleteAll(objects);
    }

    @Override
    public void updateAll(List<ModelType> objects) {
        getCreateorUpdateDaoInstance().updateAll(objects);
    }

    @Override
    public void createOrUpdateAll(List<ModelType> objects) {
        getCreateorUpdateDaoInstance().createOrUpdateAll(objects);
    }

    /**
     * get create or update dao instance.
     * @return the create or update dao.
     */
    protected CreateOrUpdateDaoImplementation<ModelType> getCreateorUpdateDaoInstance() {
        if (createorUpdateDao == null) {
            createorUpdateDao = new CreateOrUpdateDaoImplementation<ModelType>();
            createorUpdateDao.setSessionFactory(sessionFactory);
        }

        return createorUpdateDao;
    }

    /**
     * get delete dao instance.
     * @return the delete dao.
     */
    protected DeleteDaoImplementation<ModelType> getDeleteDaoInstance() {
        if (deleteDao == null) {
            deleteDao = new DeleteDaoImplementation<ModelType>();
            deleteDao.setSessionFactory(sessionFactory);
        }

        return deleteDao;
    }
}
