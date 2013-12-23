package org.scub.foundation.incubator.framework.core.implementations.test;

import org.junit.Test;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.FloatSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto.NumberOperator;

/**
 * Float search criterion test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class FloatSearchCriterionTest extends NumberSearchCriterion {

    private static final Float FLOAT_1_7 = 1.7f;

    private static final Float FLOAT_3_7 = 3.7f;

    private static final Float FLOAT_6_7 = 6.7f;

    /** test is null. */
    @Test
    public void testIsNull() {
        assertSizeEquals(1, numberValueDao.getFloatValues(new FloatSearchCriterionDto(NumberOperator.IS_NULL)));
    }

    /** test is not null. */
    @Test
    public void testIsNotNull() {
        assertSizeEquals(7, numberValueDao.getFloatValues(new FloatSearchCriterionDto(NumberOperator.IS_NOT_NULL)));
    }

    /** test is greater than. */
    @Test
    public void testGreaterThans() {
        assertSizeEquals(3, numberValueDao.getFloatValues(new FloatSearchCriterionDto(NumberOperator.GREATER_THAN, FLOAT_3_7)));
    }

    /** test is less than or equals. */
    @Test
    public void testLessThanOrEquals() {
        assertSizeEquals(4, numberValueDao.getFloatValues(new FloatSearchCriterionDto(NumberOperator.LESS_THAN_OR_EQUAL, FLOAT_3_7)));
    }

    /** test is not between. */
    @Test
    public void testNotBetween() {
        assertSizeEquals(4, numberValueDao.getFloatValues(new FloatSearchCriterionDto(NumberOperator.NOT_BETWEEN, FLOAT_1_7, FLOAT_6_7)));
    }

    /** test is strictly between. */
    @Test
    public void testStrictlyBetween() {
        assertSizeEquals(3, numberValueDao.getFloatValues(new FloatSearchCriterionDto(NumberOperator.STRICTLY_BETWEEN, FLOAT_1_7, FLOAT_6_7)));
    }
}
