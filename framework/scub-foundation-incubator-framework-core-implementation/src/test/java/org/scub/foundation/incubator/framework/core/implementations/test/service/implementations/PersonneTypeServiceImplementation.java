package org.scub.foundation.incubator.framework.core.implementations.test.service.implementations;

import org.scub.foundation.incubator.framework.core.implementations.test.dao.interfaces.PersonneTypeDao;
import org.scub.foundation.incubator.framework.core.implementations.test.model.PersonneType;
import org.scub.foundation.incubator.framework.core.implementations.test.services.interfaces.PersonneTypeService;
import org.scub.foundation.incubator.framework.core.implementations.test.utils.ErrorMessages;
import org.scub.foundation.incubator.framework.core.implementations.utils.services.IdLabelServiceImplementation;
import org.scub.foundation.incubator.framework.core.interfaces.dto.IdLabelDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.RemotePagingCriteriasDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.RemotePagingResultsDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;
import org.scub.foundation.incubator.framework.core.interfaces.profiles.OvalProfiles;

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
        return super.search(criteria);
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
