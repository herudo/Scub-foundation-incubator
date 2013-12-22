package org.scub.foundation.incubator.framework.core.implementations.utils.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.scub.foundation.framework.base.dto.AbstractDto;
import org.scub.foundation.framework.core.model.BaseModel;
import org.scub.foundation.incubator.framework.core.implementations.dao.interfaces.CrudDao;
import org.scub.foundation.incubator.framework.core.implementations.utils.ErrorMessages;
import org.scub.foundation.incubator.framework.core.interfaces.dto.RemotePagingCriteriasDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.RemotePagingResultsDto;

/**
 * Utils methods for crud services.
 * @param <ModelType> the model type.
 * @param <DtoType> the dto type.
 * @param <CriteriaType> the criteria type for search.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class CrudServiceImplementation<ModelType extends BaseModel, DtoType extends AbstractDto, CriteriaType extends Serializable> extends
        CommonsServiceImpl {

    /**
     * Create or update a <ModelType> object.
     * @param dto the dto for created the model.
     * @param ovalProfiles the oval profiles for integrity controls.
     * @return the created object as <DtoType>.
     */
    protected abstract DtoType createOrUpdate(DtoType dto, String[] ovalProfiles);

    /**
     * Validate the given dto for the given ovalProfiles.
     * @param dto the dto to validate.
     * @param ovalProfiles the oval profiles.
     */
    protected void validateDto(DtoType dto, String[] ovalProfiles) {
        integrityValidator.validateDto(dto, ovalProfiles);
    }

    /**
     * Map the dto into the model. this method could be override to manage spefics mappings like model links.
     * @param dto the dto.
     * @param model the model.
     */
    protected void mapDtoToModel(DtoType dto, ModelType model) {
        mapperDozerBean.map(dto, model);
    }

    /**
     * Map the model into a dto. this method could be override to manage spefics mappings.
     * @param model the model.
     * @return the dto
     */
    protected DtoType mapModelToDto(ModelType model) {
        return mapperDozerBean.map(model, getDtoClass());
    }

    /**
     * Map a model list into a dto list. this method could be override to manage spefics mappings.
     * @param models the model list.
     * @return the dto
     */
    protected List<DtoType> mapModelsToDtos(List<ModelType> models) {
        List<DtoType> dtos = null;
        if (models != null) {
            dtos = new ArrayList<DtoType>();
            if (!models.isEmpty()) {
                for (ModelType model : models) {
                    dtos.add(mapModelToDto(model));
                }
            }
        }
        return dtos;
    }

    /***
     * Delete a <ModelType> entity corresponding to the given id.
     * @param id the id of the entity to delete.
     */
    protected void delete(Long id) {
        technicalValidator.assertNotNull(getErrorMessages().idNull(), id);
        final ModelType model = getCrudDao().getById(id);
        businessValidator.assertNotNull(getErrorMessages().objectNotFound(), model);
        getCrudDao().delete(model);
    }

    /**
     * Get a <ModelType> object by it's id.
     * @param id the id.
     * @return the <ModelType>
     */
    protected DtoType getById(Long id) {
        technicalValidator.assertNotNull(getErrorMessages().idNull(), id);
        final ModelType model = getCrudDao().getById(id);
        businessValidator.assertNotNull(getErrorMessages().objectNotFound(), model);
        return mapModelToDto(model);
    }

    /**
     * Search for <ModelType> with the specified criteria.
     * @param criteria the criteria.
     * @return the paging results.
     */
    protected RemotePagingResultsDto<DtoType> search(RemotePagingCriteriasDto<CriteriaType> criteria) {
        technicalValidator.assertNotNull(getErrorMessages().searchCriteriaNull(), criteria);
        return new RemotePagingResultsDto<DtoType>(mapModelsToDtos(getCrudDao().search(criteria)), getCrudDao().getTotalResults(criteria.getCriterias()));
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
    public abstract <T extends CrudDao<ModelType, Long, CriteriaType>>T getCrudDao();

}
