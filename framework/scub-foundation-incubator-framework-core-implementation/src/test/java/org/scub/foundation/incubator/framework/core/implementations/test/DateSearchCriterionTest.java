package org.scub.foundation.incubator.framework.core.implementations.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.scub.foundation.incubator.framework.core.implementations.test.dao.interfaces.DateValueDao;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DateSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DateSearchCriterionDto.DateOperator;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DateSearchCriterionValueDto;
import org.scub.foundation.incubator.framework.test.abstractCase.AbstractDbunitBaseTestCase;

/**
 * Date search criterion test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class DateSearchCriterionTest extends AbstractDbunitBaseTestCase {

    /** Dao for date value. */
    protected DateValueDao dateValueDao;

    /** init. */
    @Before
    public void init() {
        dateValueDao = (DateValueDao) getBeanSpring("dateValueDao");
    }

    @Override
    public String[] getXmlDateSet() {
        return new String[] {"datasets/DateSearchCriterion.dataset.xml"};
    }

    @Override
    public List<String> getContextFiles() {
        final List<String> contextFiles = new ArrayList<String>();
        contextFiles.add("testContext.xml");
        contextFiles.add("attributesMappingContext.xml");
        return contextFiles;
    }

    /** test equals. */
    @Test
    public void testEquals() {
        assertSizeEquals(1, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.EQUALS, getFirstDate())));
    }

    /** test differents. */
    @Test
    public void testDifferents() {
        assertSizeEquals(9, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.DIFFERENTS, getFirstDate())));
    }

    /** test is null. */
    @Test
    public void testIsNull() {
        assertSizeEquals(1, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.IS_NULL)));
    }

    /** test is not null. */
    @Test
    public void testIsNotNull() {
        assertSizeEquals(10, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.IS_NOT_NULL)));
    }

    /** test is greater than or equals. */
    @Test
    public void testGreaterThanOrEquals() {
        assertSizeEquals(4, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.GREATER_THAN_OR_EQUAL, getSecondDate())));
    }

    /** test is greater than. */
    @Test
    public void testGreaterThans() {
        assertSizeEquals(3, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.GREATER_THAN, getSecondDate())));
    }

    /** test is less than or equals. */
    @Test
    public void testLessThanOrEquals() {
        assertSizeEquals(7, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.LESS_THAN_OR_EQUAL, getSecondDate())));
    }

    /** test is less than. */
    @Test
    public void testLessThans() {
        assertSizeEquals(6, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.LESS_THAN, getSecondDate())));
    }

    /** test is between. */
    @Test
    public void testBetween() {
        assertSizeEquals(6, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.BETWEEN, getFirstDate(), getThirdDate())));
    }

    /** test is not between. */
    @Test
    public void testNotBetween() {
        assertSizeEquals(6, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.NOT_BETWEEN, getFirstDate(), getThirdDate())));
    }

    /** test is strictly between. */
    @Test
    public void testStrictlyBetween() {
        assertSizeEquals(4, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.STRICTLY_BETWEEN, getFirstDate(), getThirdDate())));
    }

    /** test is strictly not between. */
    @Test
    public void testStrictlyNotBetween() {
        assertSizeEquals(3, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.STRICTLY_NOT_BETWEEN, getFirstDate(), getThirdDate())));
    }

    /** test equals ignore time. */
    @Test
    public void testEqualsIgnoreTime() {
        assertSizeEquals(2, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.EQUALS, getFirstDate(), null)));
    }

    /** test differents ignore time. */
    @Test
    public void testDifferentsIgnoreTime() {
        assertSizeEquals(8, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.DIFFERENTS, getFirstDate(), null)));
    }

    /** test is null ignore time. */
    @Test
    public void testIsNullIgnoreTime() {
        assertSizeEquals(1, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.IS_NULL, null, null)));
    }

    /** test is not null ignore time. */
    @Test
    public void testIsNotNullIgnoreTime() {
        assertSizeEquals(10, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.IS_NOT_NULL, null, null)));
    }

    /** test is greater than or equals ignore time. */
    @Test
    public void testGreaterThanOrEqualsIgnoreTime() {
        assertSizeEquals(4, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.GREATER_THAN_OR_EQUAL, getSecondDate(), null)));
    }

    /** test is greater than ignore time. */
    @Test
    public void testGreaterThansIgnoreTime() {
        assertSizeEquals(3, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.GREATER_THAN, getSecondDate(), null)));
    }

    /** test is less than or equals ignore time. */
    @Test
    public void testLessThanOrEqualsIgnoreTime() {
        assertSizeEquals(7, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.LESS_THAN_OR_EQUAL, getSecondDate(), null)));
    }

    /** test is less than ignore time. */
    @Test
    public void testLessThansIgnoreTime() {
        assertSizeEquals(6, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.LESS_THAN, getSecondDate(), null)));
    }

    /** test is between ignore time. */
    @Test
    public void testBetweenIgnoreTime() {
        assertSizeEquals(7, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.BETWEEN, getFirstDate(), getThirdDate())));
    }

    /** test is not between ignore time. */
    @Test
    public void testNotBetweenIgnoreTime() {
        assertSizeEquals(4, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.NOT_BETWEEN, getFirstDate(), getThirdDate())));
    }

    /** test is strictly between ignore time. */
    @Test
    public void testStrictlyBetweenIgnoreTime() {
        assertSizeEquals(3, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.STRICTLY_BETWEEN, getFirstDate(), getThirdDate())));
    }

    /** test is strictly not between ignore time. */
    @Test
    public void testStrictlyNotBetweenIgnoreTime() {
        assertSizeEquals(3, dateValueDao.getDateValues(getCriterionIgnoreTime(DateOperator.STRICTLY_NOT_BETWEEN, getFirstDate(), getThirdDate())));
    }

    /**
     * get a search criterion for ignore time tests.
     * @param operator the operator.
     * @param firstDate the first date
     * @param secondDate the second date.
     * @return the search criterion
     */
    private DateSearchCriterionDto getCriterionIgnoreTime(DateOperator operator, Date firstDate, Date secondDate) {
        final DateSearchCriterionDto searchCriterion = new DateSearchCriterionDto(operator);
        if (firstDate != null) {
            searchCriterion.setValue(new DateSearchCriterionValueDto(firstDate, true));
        }
        if (firstDate != null) {
            searchCriterion.setSecondValue(new DateSearchCriterionValueDto(secondDate, true));
        }

        return searchCriterion;
    }

    private Date getFirstDate() {
        final Calendar date = Calendar.getInstance();
        date.clear();

        final int year = 2013;
        final int month = 9;
        final int day = 3;
        final int hour = 10;
        final int minute = 30;
        final int second = 50;

        date.set(year, month, day, hour, minute, second);
        return date.getTime();
    }

    private Date getSecondDate() {
        final Calendar date = Calendar.getInstance();
        date.clear();

        final int year = 2014;
        final int month = 0;
        final int day = 20;
        final int hour = 17;
        final int minute = 45;
        final int second = 3;

        date.set(year, month, day, hour, minute, second);
        return date.getTime();
    }

    private Date getThirdDate() {
        final Calendar date = Calendar.getInstance();
        date.clear();

        final int year = 2014;
        final int month = 6;
        final int day = 31;
        final int hour = 0;
        final int minute = 0;
        final int second = 59;

        date.set(year, month, day, hour, minute, second);
        return date.getTime();
    }
}
