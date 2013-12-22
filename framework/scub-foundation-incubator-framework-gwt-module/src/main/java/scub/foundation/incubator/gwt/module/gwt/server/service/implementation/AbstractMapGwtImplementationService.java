package scub.foundation.incubator.gwt.module.gwt.server.service.implementation;

import java.io.Serializable;
import java.util.List;

import org.scub.foundation.framework.base.paging.RemotePagingCriteriasDto;
import org.scub.foundation.framework.base.paging.RemotePagingResultsDto;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingCriteriasModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingResultsModel;

/**
 * Abstract class to provide utilities methods for gwt implementation service.
 * @param <CriteriaDtoType> the criteria dto type.
 * @param <DtoType> the dto type.
 * @param <ModelType> the model dto type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractMapGwtImplementationService<CriteriaDtoType extends Serializable, DtoType extends Serializable, ModelType extends Serializable>
        extends AbstractGwtImplementationService {

    /**
     * Map a remote pagging criteria model into a remote pagging criteria dto.
     * @param pagging the pagging model to map.
     * @return the remote pagging dto.
     */
    protected RemotePagingCriteriasDto<CriteriaDtoType> getPaggingCriteria(RemotePagingCriteriasModel<?> pagging) {
        if (pagging != null) {
            final CriteriaDtoType criteria = mapperDozerBean.map(pagging.getCriterias(), getCriteriaDtoClass());
            return new RemotePagingCriteriasDto<CriteriaDtoType>(criteria, pagging.getFirstResult(), pagging.getMaxResult());
        }
        return null;
    }

    /**
     * Map a remote pagging results dto into a remote paging results model.
     * @param pagging the remote pagging results dto to map.
     * @return the remote pagging results model
     */
    protected RemotePagingResultsModel<ModelType> getPaggingResults(RemotePagingResultsDto<DtoType> pagging) {
        if (pagging != null) {
            final List<ModelType> results = mapperDozerBean.map(pagging.getListResults(), getModelClass());
            return new scub.foundation.incubator.gwt.module.gwt.shared.RemotePagingResultsModel<ModelType>(results, pagging.getTotalResults());
        }
        return null;
    }

    /**
     * Map a model into a dto.
     * @param model the model to map.
     * @return the dto.
     */
    protected DtoType mapDto(ModelType model) {
        return mapperDozerBean.map(model, getDtoClass());
    }

    /**
     * Map a dto into a model.
     * @param dto the dto to map.
     * @return the model.
     */
    protected ModelType mapModel(DtoType dto) {
        return mapperDozerBean.map(dto, getModelClass());
    }
    /**
     * Map a models list into a dtos list.
     * @param models the models list to map.
     * @return the dtos list.
     */
    protected List<DtoType> mapDtos(List<ModelType> models) {
        return mapperDozerBean.map(models, getDtoClass());
    }

    /**
     * Map a dtos list into a models list.
     * @param dtos the dtos list to map.
     * @return the models list.
     */
    protected List<ModelType> mapModels(List<DtoType> dtos) {
        return mapperDozerBean.map(dtos, getModelClass());
    }

    /**
     * Get the criteria dto class.
     * @return the class.
     */
    public abstract Class<CriteriaDtoType> getCriteriaDtoClass();

    /**
     * Get the dto class.
     * @return the class.
     */
    public abstract Class<DtoType> getDtoClass();

    /**
     * Get the model class.
     * @return the class.
     */
    public abstract Class<ModelType> getModelClass();
}
