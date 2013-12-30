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
        assertSizeEquals(6, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.DIFFERENTS, getFirstDate())));
    }

    /** test is null. */
    @Test
    public void testIsNull() {
        assertSizeEquals(1, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.IS_NULL)));
    }

    /** test is not null. */
    @Test
    public void testIsNotNull() {
        assertSizeEquals(7, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.IS_NOT_NULL)));
    }

    /** test is greater than or equals. */
    @Test
    public void testGreaterThanOrEquals() {
        assertSizeEquals(3, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.GREATER_THAN_OR_EQUAL, getSecondDate())));
    }

    /** test is greater than. */
    @Test
    public void testGreaterThans() {
        assertSizeEquals(2, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.GREATER_THAN, getSecondDate())));
    }

    /** test is less than or equals. */
    @Test
    public void testLessThanOrEquals() {
        assertSizeEquals(5, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.LESS_THAN_OR_EQUAL, getSecondDate())));
    }

    /** test is less than. */
    @Test
    public void testLessThans() {
        assertSizeEquals(4, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.LESS_THAN, getSecondDate())));
    }

    /** test is between. */
    @Test
    public void testBetween() {
        assertSizeEquals(4, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.BETWEEN, getFirstDate(), getThirdDate())));
    }

    /** test is not between. */
    @Test
    public void testNotBetween() {
        assertSizeEquals(5, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.NOT_BETWEEN, getFirstDate(), getThirdDate())));
    }

    /** test is strictly between. */
    @Test
    public void testStrictlyBetween() {
        assertSizeEquals(2, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.STRICTLY_BETWEEN, getFirstDate(), getThirdDate())));
    }

    /** test is strictly not between. */
    @Test
    public void testStrictlyNotBetween() {
        assertSizeEquals(3, dateValueDao.getDateValues(new DateSearchCriterionDto(DateOperator.STRICTLY_NOT_BETWEEN, getFirstDate(), getThirdDate())));
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
