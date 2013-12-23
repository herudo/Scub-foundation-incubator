package org.scub.foundation.incubator.framework.core.implementations.test;

import org.junit.Test;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.LongSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto.NumberOperator;

/**
 * Long search criterion test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class LongSearchCriterionTest extends NumberSearchCriterion {

    private static final Long LONG_1 = 1l;

    private static final Long LONG_3 = 3l;

    private static final Long LONG_6 = 6l;

    /** test equals. */
    @Test
    public void testEquals() {
        assertSizeEquals(1, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.EQUALS, LONG_1)));
    }

    /** test differents. */
    @Test
    public void testDifferents() {
        assertSizeEquals(6, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.DIFFERENTS, LONG_1)));
    }

    /** test is null. */
    @Test
    public void testIsNull() {
        assertSizeEquals(1, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.IS_NULL)));
    }

    /** test is not null. */
    @Test
    public void testIsNotNull() {
        assertSizeEquals(7, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.IS_NOT_NULL)));
    }

    /** test is greater than or equals. */
    @Test
    public void testGreaterThanOrEquals() {
        assertSizeEquals(4, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.GREATER_THAN_OR_EQUAL, LONG_3)));
    }

    /** test is greater than. */
    @Test
    public void testGreaterThans() {
        assertSizeEquals(3, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.GREATER_THAN, LONG_3)));
    }

    /** test is less than or equals. */
    @Test
    public void testLessThanOrEquals() {
        assertSizeEquals(4, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.LESS_THAN_OR_EQUAL, LONG_3)));
    }

    /** test is less than. */
    @Test
    public void testLessThans() {
        assertSizeEquals(3, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.LESS_THAN, LONG_3)));
    }

    /** test is between. */
    @Test
    public void testBetween() {
        assertSizeEquals(5, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.BETWEEN, LONG_1, LONG_6)));
    }

    /** test is not between. */
    @Test
    public void testNotBetween() {
        assertSizeEquals(4, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.NOT_BETWEEN, LONG_1, LONG_6)));
    }

    /** test is strictly between. */
    @Test
    public void testStrictlyBetween() {
        assertSizeEquals(3, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.STRICTLY_BETWEEN, LONG_1, LONG_6)));
    }

    /** test is strictly not between. */
    @Test
    public void testStrictlyNotBetween() {
        assertSizeEquals(2, numberValueDao.getLongValues(new LongSearchCriterionDto(NumberOperator.STRICTLY_NOT_BETWEEN, LONG_1, LONG_6)));
    }
}
