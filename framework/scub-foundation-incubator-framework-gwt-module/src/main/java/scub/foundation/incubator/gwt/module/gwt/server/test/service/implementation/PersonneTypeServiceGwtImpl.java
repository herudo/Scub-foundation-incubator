package scub.foundation.incubator.gwt.module.gwt.server.test.service.implementation;

import org.scub.foundation.framework.gwt.module.shared.IdLabelModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingCriteriasModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingResultsModel;
import org.scub.foundation.incubator.framework.core.interfaces.dto.IdLabelDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;

import scub.foundation.incubator.example.core.interfaces.services.interfaces.PersonneTypeService;
import scub.foundation.incubator.gwt.module.gwt.client.test.service.PersonneTypeServiceGwt;
import scub.foundation.incubator.gwt.module.gwt.server.service.implementation.AbstractIdLabelGwtImplementationService;
import scub.foundation.incubator.gwt.module.gwt.shared.criteria.IdLabelCriteriaModel;

/**
 * Implementation of personne type gwt service.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class PersonneTypeServiceGwtImpl extends AbstractIdLabelGwtImplementationService<IdLabelCriteriaDto, IdLabelDto, IdLabelModel>
        implements PersonneTypeServiceGwt {

    private PersonneTypeService personneTypeService;

    @Override
    public IdLabelModel createOrUpdatePersonneType(IdLabelModel personneType) {
        return map(personneTypeService.createOrUpdatePersonneType(map(personneType)));
    }

    @Override
    public void deletePersonneType(Long id) {
        personneTypeService.deletePersonneType(id);
    }

    @Override
    public IdLabelModel getPersonneTypeById(Long id) {
        return map(personneTypeService.getPersonneTypeById(id));
    }

    @Override
    public RemotePagingResultsModel<IdLabelModel> search(RemotePagingCriteriasModel<IdLabelCriteriaModel> criteria) {
        return getPaggingResults(personneTypeService.search(getPaggingCriteria(criteria)));
    }

    /**
     * Set the value of personneTypeService.
     * @param personneTypeService the personneTypeService to set
     */
    public void setPersonneTypeService(PersonneTypeService personneTypeService) {
        this.personneTypeService = personneTypeService;
    }

    @Override
    public Class<IdLabelCriteriaDto> getCriteriaDtoClass() {
        return IdLabelCriteriaDto.class;
    }

    @Override
    public Class<IdLabelDto> getDtoClass() {
        return IdLabelDto.class;
    }

    @Override
    public Class<IdLabelModel> getModelClass() {
        return IdLabelModel.class;
    }
}
