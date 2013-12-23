package org.scub.foundation.incubator.framework.core.implementations.test;

import org.junit.Test;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DoubleSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto.NumberOperator;

/**
 * Double search criterion test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class DoubleSearchCriterionTest extends NumberSearchCriterion {

    private static final Double DOUBLE_1_5 = 1.5d;

    private static final Double DOUBLE_3_5 = 3.5d;

    private static final Double DOUBLE_6_5 = 6.5d;

    /** test equals. */
    @Test
    public void testEquals() {
        assertSizeEquals(1, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.EQUALS, DOUBLE_1_5)));
    }

    /** test differents. */
    @Test
    public void testDifferents() {
        assertSizeEquals(6, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.DIFFERENTS, DOUBLE_1_5)));
    }

    /** test is null. */
    @Test
    public void testIsNull() {
        assertSizeEquals(1, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.IS_NULL)));
    }

    /** test is not null. */
    @Test
    public void testIsNotNull() {
        assertSizeEquals(7, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.IS_NOT_NULL)));
    }

    /** test is greater than or equals. */
    @Test
    public void testGreaterThanOrEquals() {
        assertSizeEquals(4, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.GREATER_THAN_OR_EQUAL, DOUBLE_3_5)));
    }

    /** test is greater than. */
    @Test
    public void testGreaterThans() {
        assertSizeEquals(3, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.GREATER_THAN, DOUBLE_3_5)));
    }

    /** test is less than or equals. */
    @Test
    public void testLessThanOrEquals() {
        assertSizeEquals(4, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.LESS_THAN_OR_EQUAL, DOUBLE_3_5)));
    }

    /** test is less than. */
    @Test
    public void testLessThans() {
        assertSizeEquals(3, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.LESS_THAN, DOUBLE_3_5)));
    }

    /** test is between. */
    @Test
    public void testBetween() {
        assertSizeEquals(5, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.BETWEEN, DOUBLE_1_5, DOUBLE_6_5)));
    }

    /** test is not between. */
    @Test
    public void testNotBetween() {
        assertSizeEquals(4, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.NOT_BETWEEN, DOUBLE_1_5, DOUBLE_6_5)));
    }

    /** test is strictly between. */
    @Test
    public void testStrictlyBetween() {
        assertSizeEquals(3, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.STRICTLY_BETWEEN, DOUBLE_1_5, DOUBLE_6_5)));
    }

    /** test is strictly not between. */
    @Test
    public void testStrictlyNotBetween() {
        assertSizeEquals(2, numberValueDao.getDoubleValues(new DoubleSearchCriterionDto(NumberOperator.STRICTLY_NOT_BETWEEN, DOUBLE_1_5, DOUBLE_6_5)));
    }
}
