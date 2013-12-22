package scub.foundation.incubator.gwt.module.gwt.server.service.implementation;

import org.scub.foundation.framework.gwt.module.shared.IdLabelModel;
import org.scub.foundation.incubator.framework.core.interfaces.dto.IdLabelDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;

/**
 * Abstract class to provide utilities methods for id label gwt service.
 * @param <CriteriaDtoType> the criteria dto type.
 * @param <DtoType> the dto type.
 * @param <ModelType> the model dto type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractIdLabelGwtImplementationService<CriteriaDtoType extends IdLabelCriteriaDto, DtoType extends IdLabelDto, ModelType extends IdLabelModel>
        extends AbstractMapGwtImplementationService<CriteriaDtoType, DtoType, ModelType> {

    /**
     * Map a model into a dto.
     * @param model the model to map.
     * @return the dto.
     */
    protected DtoType map(ModelType model) {
        return mapDto(model);
    }

    /**
     * Map a dto into a model.
     * @param dto the dto to map.
     * @return the model.
     */
    protected ModelType map(DtoType dto) {
        return mapModel(dto);
    }

}
