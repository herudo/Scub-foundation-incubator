package org.scub.foundation.incubator.framework.core.implementations.test;

import org.junit.Test;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.IntegerSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto.NumberOperator;

/**
 * Integer search criterion test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class IntegerSearchCriterionTest extends NumberSearchCriterion {

    /** test equals. */
    @Test
    public void testEquals() {
        assertSizeEquals(1, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.EQUALS, 1)));
    }

    /** test differents. */
    @Test
    public void testDifferents() {
        assertSizeEquals(6, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.DIFFERENTS, 1)));
    }

    /** test is null. */
    @Test
    public void testIsNull() {
        assertSizeEquals(1, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.IS_NULL)));
    }

    /** test is not null. */
    @Test
    public void testIsNotNull() {
        assertSizeEquals(7, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.IS_NOT_NULL)));
    }

    /** test is greater than or equals. */
    @Test
    public void testGreaterThanOrEquals() {
        assertSizeEquals(4, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.GREATER_THAN_OR_EQUAL, 3)));
    }

    /** test is greater than. */
    @Test
    public void testGreaterThans() {
        assertSizeEquals(3, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.GREATER_THAN, 3)));
    }

    /** test is less than or equals. */
    @Test
    public void testLessThanOrEquals() {
        assertSizeEquals(4, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.LESS_THAN_OR_EQUAL, 3)));
    }

    /** test is less than. */
    @Test
    public void testLessThans() {
        assertSizeEquals(3, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.LESS_THAN, 3)));
    }

    /** test is between. */
    @Test
    public void testBetween() {
        assertSizeEquals(5, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.BETWEEN, 1, 6)));
    }

    /** test is not between. */
    @Test
    public void testNotBetween() {
        assertSizeEquals(4, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.NOT_BETWEEN, 1, 6)));
    }

    /** test is strictly between. */
    @Test
    public void testStrictlyBetween() {
        assertSizeEquals(3, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.STRICTLY_BETWEEN, 1, 6)));
    }

    /** test is strictly not between. */
    @Test
    public void testStrictlyNotBetween() {
        assertSizeEquals(2, numberValueDao.getIntegerValues(new IntegerSearchCriterionDto(NumberOperator.STRICTLY_NOT_BETWEEN, 1, 6)));
    }
}
