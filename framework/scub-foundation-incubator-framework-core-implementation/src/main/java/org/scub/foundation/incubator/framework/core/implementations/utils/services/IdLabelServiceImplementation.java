package org.scub.foundation.incubator.framework.core.implementations.utils.services;

import org.scub.foundation.incubator.framework.core.implementations.dao.interfaces.CrudDao;
import org.scub.foundation.incubator.framework.core.implementations.dao.interfaces.IdLabelDao;
import org.scub.foundation.incubator.framework.core.implementations.model.IdLabelModel;
import org.scub.foundation.incubator.framework.core.implementations.utils.ErrorMessages;
import org.scub.foundation.incubator.framework.core.interfaces.dto.IdLabelDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;

/**
 * Utils methods for idLabel services.
 * @param <ModelType> the model type.
 * @param <DtoType> the dto type.
 * @param <CriteriaType> the criteria type for search.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class IdLabelServiceImplementation<ModelType extends IdLabelModel, DtoType extends IdLabelDto, CriteriaType extends IdLabelCriteriaDto> extends
        CrudServiceImplementation<ModelType, DtoType, CriteriaType> {

    /**
     * Create or update a <ModelType> object.
     * @param dto the dto for created the model.
     * @param ovalProfiles the oval profiles for integrity controls.
     * @return the created object as <DtoType>.
     */
    @Override
    protected DtoType createOrUpdate(DtoType dto, String[] ovalProfiles) {
        validateDto(dto, ovalProfiles);

        ModelType model = getNewModelInstance();

        if (dto.getId() != null) { // get the object to update
            model = getIdLabelDao().getById(dto.getId());
            businessValidator.assertNotNull(getErrorMessages().objectNotFound(), model);
        }

        mapDtoToModel(dto, model);

        if (dto.getId() == null) { // enregistrement si c'est une création.
            getIdLabelDao().create(model);
        }

        return mapperDozerBean.map(model, getDtoClass());
    }

    @Override
    public <T extends CrudDao<ModelType, Long, CriteriaType>>T getCrudDao() {
        return getIdLabelDao();
    }

    /**
     * Get the error message object.
     * @return the errorMessage.
     */
    public abstract ErrorMessages getErrorMessages();

    /**
     * Get a new <ModelType> instance.
     * @return a <ModelType> instance.
     */
    public abstract ModelType getNewModelInstance();

    /**
     * Get the Class for the <ModelType>.
     * @return Class<ModelType> instance.
     */
    public abstract Class<DtoType> getDtoClass();

    /**
     * Get the dao for the <ModelType>.
     * @param <T> the dao type.
     * @return a dao.
     */
    public abstract <T extends IdLabelDao<ModelType, CriteriaType>>T getIdLabelDao();
}
