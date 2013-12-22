package org.scub.foundation.incubator.framework.core.implementations.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.IdentifierLoadAccess;
import org.junit.Before;
import org.junit.Test;
import org.scub.foundation.framework.base.exception.BusinessException;
import org.scub.foundation.framework.base.exception.IntegrityControlException;
import org.scub.foundation.framework.base.exception.TechnicalException;
import org.scub.foundation.incubator.framework.core.implementations.test.services.interfaces.AttributesMappingService;
import org.scub.foundation.incubator.framework.core.implementations.test.services.interfaces.PersonneTypeService;
import org.scub.foundation.incubator.framework.core.implementations.utils.ErrorMessages;
import org.scub.foundation.incubator.framework.core.interfaces.dto.IdLabelDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.RemotePagingCriteriasDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.RemotePagingResultsDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.StringSearchCriterionDto;
import org.scub.foundation.incubator.framework.test.Constants;
import org.scub.foundation.incubator.framework.test.abstractCase.AbstractDbunitBaseTestCase;

/**
 * Test of the id labe service utils class.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class IdLabelServiceTest extends AbstractDbunitBaseTestCase {

    private PersonneTypeService personneTypeService;

    private ErrorMessages errorMessages;

    private AttributesMappingService attributesMappingService;

    /** init. */
    @Before
    public void init() {
        personneTypeService = (PersonneTypeService) getBeanSpring("personneTypeService");
        errorMessages = (ErrorMessages) getBeanSpring("errorMessages");
        attributesMappingService = (AttributesMappingService) getBeanSpring("attributesMappingService");
    }

    /**
     * Recuperer une liste de fichiers suplémentaire de contexte spring. Vous pouvez redefinir cette methode dans chaque test pour une liste de fichiers de
     * configuration supplémentaire.
     * @return un tableau avec le nom de chaque fichier disponible dans le classPath de l'application.
     */
    @Override
    public List<String> getContextFiles() {
        final List<String> contextFiles = new ArrayList<String>();
        contextFiles.add("testContext.xml");
        contextFiles.add("attributesMappingContext.xml");
        return contextFiles;
    }

    @Override
    public String[] getXmlDateSet() {
        return new String[] {"datasets/IdLabelService.dataset.xml"};
    }

    /** test create or update. */
    @Test
    public void testCreateOrUpdatePersonneType() {
        try {
            personneTypeService.createOrUpdatePersonneType(null);
            fail(Constants.MUST_FAIL);
        } catch (TechnicalException e) {
            assertFailMessage(e, errorMessages.validatedObjectNull());
        }

        // test integrity controls.
        try {
            personneTypeService.createOrUpdatePersonneType(new IdLabelDto());
            fail(Constants.MUST_FAIL);
        } catch (IntegrityControlException e) {
            assertErrorCountEquals(e.getReport(), 1);
            assertHasMessage(e.getReport(), attributesMappingService.getIdLabelDtoLabel(), errorMessages.idLabelDtolabelRequired());
        }

        // test not found.
        final IdLabelDto personneType = new IdLabelDto();
        personneType.setId(Constants.UNEXISTANT_ID);
        personneType.setLabel("test error");

        try {
            personneTypeService.createOrUpdatePersonneType(personneType);
            fail(Constants.MUST_FAIL);
        } catch (BusinessException e) {
            assertFailMessage(e, errorMessages.objectNotFound());
        }

        // ######################## test create
        personneType.setId(null);

        // test personne type count before
        assertPagingResultsIsCorrect(personneTypeService.search(new RemotePagingCriteriasDto<IdLabelCriteriaDto>(new IdLabelCriteriaDto())), 3, 3);

        final IdLabelDto createdPersonneType = personneTypeService.createOrUpdatePersonneType(personneType);

        // test personne type count after
        assertPagingResultsIsCorrect(personneTypeService.search(new RemotePagingCriteriasDto<IdLabelCriteriaDto>(new IdLabelCriteriaDto())), 4, 4);

        // test fields
        personneType.setId(4L);
        assertReflectionEquals(personneType, createdPersonneType);

        // # test modification
        personneType.setId(4L);
        personneType.setLabel("Modification");

        // test personne type count before
        assertPagingResultsIsCorrect(personneTypeService.search(new RemotePagingCriteriasDto<IdLabelCriteriaDto>(new IdLabelCriteriaDto())), 4, 4);

        final IdLabelDto updatedPersonneType = personneTypeService.createOrUpdatePersonneType(personneType);

        // test personne type count after
        assertPagingResultsIsCorrect(personneTypeService.search(new RemotePagingCriteriasDto<IdLabelCriteriaDto>(new IdLabelCriteriaDto())), 4, 4);

        // test fields
        assertReflectionEquals(personneType, updatedPersonneType);
    }

    /** test getPersonneType. */
    @Test
    public void testGetPersonneType() {
        final RemotePagingCriteriasDto<IdLabelCriteriaDto> remoteCriteria = new RemotePagingCriteriasDto<IdLabelCriteriaDto>();
        remoteCriteria.setCriterias(new IdLabelCriteriaDto());
        assertPagingResultsIsCorrect(personneTypeService.search(remoteCriteria), 3, 3);

        assertPagingResultsIsCorrect(personneTypeService.search(remoteCriteria), 3, 3);

        remoteCriteria.setCriterias(new IdLabelCriteriaDto(new StringSearchCriterionDto("No")));
        assertPagingResultsIsCorrect(personneTypeService.search(remoteCriteria), 1, 1);

        remoteCriteria.setCriterias(new IdLabelCriteriaDto(new StringSearchCriterionDto("o")));
        assertPagingResultsIsCorrect(personneTypeService.search(remoteCriteria), 2, 2);

        remoteCriteria.setCriterias(new IdLabelCriteriaDto(new StringSearchCriterionDto("Normal")));
        final RemotePagingResultsDto<IdLabelDto> results = personneTypeService.search(remoteCriteria);

        final List<IdLabelDto> personneTypes = results.getListResults();
        assertSizeEquals(1, personneTypes);

        final IdLabelDto normalPersonne = personneTypes.get(0);
        assertNotNull(Constants.nullError("Ther personne type"), normalPersonne);
        assertEquals(Constants.valueError("personneType.id"), 1L, normalPersonne.getId());
        assertEquals(Constants.valueError("personneType.label"), "Normal", normalPersonne.getLabel());
    }

    /** test deletePersonneType. */
    @Test
    public void testDeletePersonneType() {
        try {
            personneTypeService.deletePersonneType(null);
            fail(Constants.MUST_FAIL);
        } catch (TechnicalException e) {
            assertFailMessage(e, errorMessages.idNull());
        }

        // unexistant personne type
        try {
            personneTypeService.deletePersonneType(Constants.UNEXISTANT_ID);
            fail(Constants.MUST_FAIL);
        } catch (BusinessException e) {
            assertFailMessage(e, errorMessages.objectNotFound());
        }
        final RemotePagingCriteriasDto<IdLabelCriteriaDto> remoteCriteria = new RemotePagingCriteriasDto<IdLabelCriteriaDto>(new IdLabelCriteriaDto());

        assertPagingResultsIsCorrect(personneTypeService.search(remoteCriteria), 3, 3); // test count before
        personneTypeService.deletePersonneType(1L);
        assertPagingResultsIsCorrect(personneTypeService.search(remoteCriteria), 2, 2); // test count after

        // unexistant personne type
        try {
            personneTypeService.deletePersonneType(1L);
            fail(Constants.MUST_FAIL);
        } catch (BusinessException e) {
            assertFailMessage(e, errorMessages.objectNotFound());
        }
    }

    /** test getPersonneTypeById. */
    @Test
    public void testGetPersonneTypeById() {
        try {
            personneTypeService.getPersonneTypeById(null);
            fail(Constants.MUST_FAIL);
        } catch (TechnicalException e) {
            assertFailMessage(e, errorMessages.idNull());
        }

        // unexistant personne type
        try {
            personneTypeService.getPersonneTypeById(Constants.UNEXISTANT_ID);
            fail(Constants.MUST_FAIL);
        } catch (BusinessException e) {
            assertFailMessage(e, errorMessages.objectNotFound());
        }

        final IdLabelDto normalPersonne = personneTypeService.getPersonneTypeById(1L);
        final IdLabelDto expectedPersonne = new IdLabelDto(1L, "Normal");

        assertReflectionEquals(expectedPersonne, normalPersonne);
    }
}
