package org.scub.foundation.incubator.framework.core.implementations.test;

import org.junit.Test;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.ShortSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto.NumberOperator;

/**
 * Short search criterion test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class ShortSearchCriterionTest extends NumberSearchCriterion {

    private static final Short SHORT_1 = 1;

    private static final Short SHORT_3 = 3;

    private static final Short SHORT_6 = 6;

    /** test equals. */
    @Test
    public void testEquals() {
        assertSizeEquals(1, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.EQUALS, SHORT_1)));
    }

    /** test differents. */
    @Test
    public void testDifferents() {
        assertSizeEquals(6, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.DIFFERENTS, SHORT_1)));
    }

    /** test is null. */
    @Test
    public void testIsNull() {
        assertSizeEquals(1, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.IS_NULL)));
    }

    /** test is not null. */
    @Test
    public void testIsNotNull() {
        assertSizeEquals(7, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.IS_NOT_NULL)));
    }

    /** test is greater than or equals. */
    @Test
    public void testGreaterThanOrEquals() {
        assertSizeEquals(4, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.GREATER_THAN_OR_EQUAL, SHORT_3)));
    }

    /** test is greater than. */
    @Test
    public void testGreaterThans() {
        assertSizeEquals(3, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.GREATER_THAN, SHORT_3)));
    }

    /** test is less than or equals. */
    @Test
    public void testLessThanOrEquals() {
        assertSizeEquals(4, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.LESS_THAN_OR_EQUAL, SHORT_3)));
    }

    /** test is less than. */
    @Test
    public void testLessThans() {
        assertSizeEquals(3, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.LESS_THAN, SHORT_3)));
    }

    /** test is between. */
    @Test
    public void testBetween() {
        assertSizeEquals(5, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.BETWEEN, SHORT_1, SHORT_6)));
    }

    /** test is not between. */
    @Test
    public void testNotBetween() {
        assertSizeEquals(4, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.NOT_BETWEEN, SHORT_1, SHORT_6)));
    }

    /** test is strictly between. */
    @Test
    public void testStrictlyBetween() {
        assertSizeEquals(3, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.STRICTLY_BETWEEN, SHORT_1, SHORT_6)));
    }

    /** test is strictly not between. */
    @Test
    public void testStrictlyNotBetween() {
        assertSizeEquals(2, numberValueDao.getShortValues(new ShortSearchCriterionDto(NumberOperator.STRICTLY_NOT_BETWEEN, SHORT_1, SHORT_6)));
    }
}
