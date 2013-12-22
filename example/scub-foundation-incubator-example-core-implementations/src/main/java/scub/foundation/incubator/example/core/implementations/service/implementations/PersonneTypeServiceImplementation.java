package scub.foundation.incubator.example.core.implementations.service.implementations;

import org.scub.foundation.framework.base.paging.RemotePagingCriteriasDto;
import org.scub.foundation.incubator.framework.core.implementations.utils.services.IdLabelServiceImplementation;
import org.scub.foundation.incubator.framework.core.interfaces.dto.IdLabelDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.RemotePagingResultsDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;
import org.scub.foundation.incubator.framework.core.interfaces.profiles.OvalProfiles;

import scub.foundation.incubator.example.core.implementations.dao.interfaces.PersonneTypeDao;
import scub.foundation.incubator.example.core.implementations.model.PersonneType;
import scub.foundation.incubator.example.core.implementations.utils.ErrorMessages;
import scub.foundation.incubator.example.core.interfaces.services.interfaces.PersonneTypeService;

/**
 * Implementation of an IdLabelService to test it.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class PersonneTypeServiceImplementation extends IdLabelServiceImplementation<PersonneType, IdLabelDto, IdLabelCriteriaDto> implements
        PersonneTypeService {

    private ErrorMessages errorMessages;

    private PersonneTypeDao personneTypeDao;

    @Override
    public IdLabelDto createOrUpdatePersonneType(IdLabelDto PersonneType) {
        return createOrUpdate(PersonneType, new String[] {OvalProfiles.ID_LABEL_DTO_LABEL_REQUIRED});
    }

    @Override
    public void deletePersonneType(Long id) {
        delete(id);
    }

    @Override
    public IdLabelDto getPersonneTypeById(Long id) {
        return getById(id);
    }

    @Override
    public ErrorMessages getErrorMessages() {
        return errorMessages;
    }

    @Override
    public PersonneType getNewModelInstance() {
        return new PersonneType();
    }

    @Override
    public RemotePagingResultsDto<IdLabelDto> search(RemotePagingCriteriasDto<IdLabelCriteriaDto> criteria) {
        RemotePagingResultsDto<IdLabelDto> results = super.search(criteria);;
        System.out.println(results);
        return results;
    }

    /**
     * Set the value of errorMessages.
     * @param errorMessages the errorMessages to set
     */
    public void setErrorMessages(ErrorMessages errorMessages) {
        this.errorMessages = errorMessages;
    }

    /**
     * Set the value of personneTypeDao.
     * @param personneTypeDao the personneTypeDao to set
     */
    public void setPersonneTypeDao(PersonneTypeDao personneTypeDao) {
        this.personneTypeDao = personneTypeDao;
    }

    @Override
    public Class<IdLabelDto> getDtoClass() {
        return IdLabelDto.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PersonneTypeDao getIdLabelDao() {
        return personneTypeDao;
    }
}
