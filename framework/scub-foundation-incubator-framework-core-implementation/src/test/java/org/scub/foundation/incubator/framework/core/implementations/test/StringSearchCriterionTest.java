package org.scub.foundation.incubator.framework.core.implementations.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.scub.foundation.incubator.framework.core.implementations.test.services.interfaces.PersonneTypeService;
import org.scub.foundation.incubator.framework.core.interfaces.dto.RemotePagingCriteriasDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.StringSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.StringSearchCriterionDto.StringOperator;
import org.scub.foundation.incubator.framework.test.abstractCase.AbstractDbunitBaseTestCase;

/**
 * test IdLabelService.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class StringSearchCriterionTest extends AbstractDbunitBaseTestCase {

    private PersonneTypeService personneTypeService;

    private static final String PERSONNALITY_1 = "Personnality";

    private static final String PERSONNALITY_2 = "personnality";

    private static final String ONNA = "onna";

    private static final String PER_1 = "per";

    private static final String LITY_1 = "lity";

    private static final String PER_2 = "Per";

    private static final String PERSON = "person";

    private static final String PER_3 = "pEr";

    private static final String PER_4 = "PeR";

    private static final String Y = "y";

    private static final String LITY_2 = "LiTy";

    /** init. */
    @Before
    public void init() {
        personneTypeService = (PersonneTypeService) getBeanSpring("personneTypeService");
    }

    @Override
    public String[] getXmlDateSet() {
        return new String[] {"datasets/StringSearchCriterion.dataset.xml"};
    }

    @Override
    public List<String> getContextFiles() {
        final List<String> contextFiles = new ArrayList<String>();
        contextFiles.add("testContext.xml");
        contextFiles.add("attributesMappingContext.xml");
        return contextFiles;
    }

    /** test equals case sensitive. */
    @Test
    public void testEqualsCaseSensitive() {
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PERSONNALITY_1)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PERSONNALITY_2)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, ONNA)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PER_1)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, LITY_1)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PER_2)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PERSON)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PER_3)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PER_4)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, Y)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, LITY_2)).getListResults());
    }

    /** test equals case insensitive. */
    @Test
    public void testEqualsCaseInsensitive() {
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PERSONNALITY_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PERSONNALITY_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, ONNA, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PER_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, LITY_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PER_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PERSON, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PER_3, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, PER_4, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, Y, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.EQUALS, LITY_2, false)).getListResults());
    }

    /** test equals case sensitive. */
    @Test
    public void testContainsCaseSensitive() {
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PERSONNALITY_1)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PERSONNALITY_2)).getListResults());
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, ONNA)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PER_1)).getListResults());
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, LITY_1)).getListResults());
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PER_2)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PERSON)).getListResults());
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PER_3)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PER_4)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, Y)).getListResults());
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, LITY_2)).getListResults());
    }

    /** test equals case insensitive. */
    @Test
    public void testContainsCaseInsensitive() {
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PERSONNALITY_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PERSONNALITY_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, ONNA, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PER_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, LITY_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PER_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PERSON, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PER_3, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, PER_4, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, Y, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.CONTAINS, LITY_2, false)).getListResults());
    }

    /** test starts with case sensitive. */
    @Test
    public void testStartsWithCaseSensitive() {
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PERSONNALITY_1)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PERSONNALITY_2)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, ONNA)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PER_1)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, LITY_1)).getListResults());
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PER_2)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PERSON)).getListResults());
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PER_3)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PER_4)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, Y)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, LITY_2)).getListResults());
    }

    /** test starts with case insensitive. */
    @Test
    public void testStartsWithCaseInsensitive() {
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PERSONNALITY_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PERSONNALITY_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, ONNA, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PER_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, LITY_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PER_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PERSON, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PER_3, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, PER_4, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, Y, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.STARTS_WITH, LITY_2, false)).getListResults());
    }

    /** test ends with case sensitive. */
    @Test
    public void testEndsWithCaseSensitive() {
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PERSONNALITY_1)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PERSONNALITY_2)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, ONNA)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PER_1)).getListResults());
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, LITY_1)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PER_2)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PERSON)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PER_3)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PER_4)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, Y)).getListResults());
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, LITY_2)).getListResults());
    }

    /** test ends with case insensitive. */
    @Test
    public void testEndsWithCaseInsensitive() {
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PERSONNALITY_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PERSONNALITY_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, ONNA, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PER_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, LITY_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PER_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PERSON, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PER_3, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, PER_4, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, Y, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.ENDS_WITH, LITY_2, false)).getListResults());
    }

    /** test differents case sensitive. */
    @Test
    public void testDifferentsCaseSensitive() {
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PERSONNALITY_1)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PERSONNALITY_2)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, ONNA)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PER_1)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, LITY_1)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PER_2)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PERSON)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PER_3)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PER_4)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, Y)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, LITY_2)).getListResults());
    }

    /** test differents case insensitive. */
    @Test
    public void testDifferentsCaseInsensitive() {
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PERSONNALITY_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PERSONNALITY_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, ONNA, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PER_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, LITY_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PER_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PERSON, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PER_3, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, PER_4, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, Y, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.DIFFERENTS, LITY_2, false)).getListResults());
    }

    /** test not starts with case sensitive. */
    @Test
    public void testNotStartsWithCaseSensitive() {
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PERSONNALITY_1)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PERSONNALITY_2)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, ONNA)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PER_1)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, LITY_1)).getListResults());
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PER_2)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PERSON)).getListResults());
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PER_3)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PER_4)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, Y)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, LITY_2)).getListResults());
    }

    /** test not starts with case insensitive. */
    @Test
    public void testNotStartsWithCaseInsensitive() {
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PERSONNALITY_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PERSONNALITY_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, ONNA, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PER_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, LITY_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PER_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PERSON, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PER_3, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, PER_4, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, Y, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_STARTS_WITH, LITY_2, false)).getListResults());
    }

    /** test not ends with case sensitive. */
    @Test
    public void testNotEndsWithCaseSensitive() {
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PERSONNALITY_1)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PERSONNALITY_2)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, ONNA)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PER_1)).getListResults());
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, LITY_1)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PER_2)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PERSON)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PER_3)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PER_4)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, Y)).getListResults());
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, LITY_2)).getListResults());
    }

    /** test not ends with case insensitive. */
    @Test
    public void testNotEndsWithCaseInsensitive() {
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PERSONNALITY_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PERSONNALITY_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, ONNA, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PER_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, LITY_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PER_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PERSON, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PER_3, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, PER_4, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, Y, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_ENDS_WITH, LITY_2, false)).getListResults());
    }

    /** test not contains with case sensitive. */
    @Test
    public void testNotContainsWithCaseSensitive() {
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PERSONNALITY_1)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PERSONNALITY_2)).getListResults());
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, ONNA)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PER_1)).getListResults());
        assertSizeEquals(1, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, LITY_1)).getListResults());
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PER_2)).getListResults());
        assertSizeEquals(2, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PERSON)).getListResults());
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PER_3)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PER_4)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, Y)).getListResults());
        assertSizeEquals(3, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, LITY_2)).getListResults());
    }

    /** test not contains with case insensitive. */
    @Test
    public void testNotContainsWithCaseInsensitive() {
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PERSONNALITY_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PERSONNALITY_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, ONNA, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PER_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, LITY_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PER_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PERSON, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PER_3, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, PER_4, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, Y, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, LITY_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.NOT_CONTAINS, "truc", false)).getListResults());
    }

    /** test is null with case sensitive. */
    @Test
    public void testIsNullCaseSensitive() {
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PERSONNALITY_1)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PERSONNALITY_2)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, ONNA)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PER_1)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, LITY_1)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PER_2)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PERSON)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PER_3)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PER_4)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, Y)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, LITY_2)).getListResults());
    }

    /** test is null with case insensitive. */
    @Test
    public void testIsNullCaseInsensitive() {
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PERSONNALITY_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PERSONNALITY_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, ONNA, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PER_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, LITY_1, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PER_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PERSON, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PER_3, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, PER_4, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, Y, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, LITY_2, false)).getListResults());
        assertSizeEquals(0, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NULL, "truc", false)).getListResults());
    }

    /** test is not null with case sensitive. */
    @Test
    public void testIsNotNullCaseSensitive() {
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PERSONNALITY_1)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PERSONNALITY_2)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, ONNA)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PER_1)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, LITY_1)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PER_2)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PERSON)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PER_3)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PER_4)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, Y)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, LITY_2)).getListResults());
    }

    /** test is not null with case insensitive. */
    @Test
    public void testIsNotNullCaseInsensitive() {
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PERSONNALITY_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PERSONNALITY_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, ONNA, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PER_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, LITY_1, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PER_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PERSON, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PER_3, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, PER_4, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, Y, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, LITY_2, false)).getListResults());
        assertSizeEquals(4, personneTypeService.search(getRemotePagingCriteria(StringOperator.IS_NOT_NULL, "truc", false)).getListResults());
    }

    /**
     * Create paging criteria to reduce test code.
     * @param operator the operator
     * @param value the value
     * @return the criteria
     */
    private RemotePagingCriteriasDto<IdLabelCriteriaDto> getRemotePagingCriteria(StringOperator operator, String value, boolean caseSensitive) {
        final RemotePagingCriteriasDto<IdLabelCriteriaDto> remoteCriteria = new RemotePagingCriteriasDto<IdLabelCriteriaDto>();
        remoteCriteria.setCriterias(new IdLabelCriteriaDto(new StringSearchCriterionDto(operator, value, caseSensitive)));
        return remoteCriteria;
    }

    /**
     * Create paging criteria to reduce test code.
     * @param operator the operator
     * @param value the value
     * @param caseSensitive the case sensitive value
     * @return the criteria
     */

    private RemotePagingCriteriasDto<IdLabelCriteriaDto> getRemotePagingCriteria(StringOperator operator, String value) {
        return getRemotePagingCriteria(operator, value, true);
    }
}
