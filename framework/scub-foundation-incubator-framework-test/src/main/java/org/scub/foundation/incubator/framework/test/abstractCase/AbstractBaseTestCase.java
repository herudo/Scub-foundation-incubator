package org.scub.foundation.incubator.framework.test.abstractCase;

import java.util.List;

import junit.framework.TestCase;

import org.scub.foundation.framework.base.dto.report.ReportDto;
import org.scub.foundation.framework.base.exception.CoreRunTimeException;
import org.scub.foundation.framework.base.paging.RemotePagingResultsDto;
import org.scub.foundation.incubator.framework.test.Constants;
import org.unitils.reflectionassert.ReflectionAssert;

/**
 * Abstract class that provides assert methods.
 * @author sgoumard
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class AbstractBaseTestCase {

    /**
     * Test the exception message is correct
     * @param e the exception
     * @param message the message.
     */
    protected void assertFailMessage(CoreRunTimeException e, String message) {
        assertFailMessage(Constants.WRONG_MESSAGE, e, message);
    }

    /**
     * Test the exception message is correct
     * @param message the message.
     * @param e the exception
     * @param exceptionmessage the exception message.
     */
    protected void assertFailMessage(String message, CoreRunTimeException e, String exceptionmessage) {
        assertEquals(message, exceptionmessage, e.getMessage());
    }

    /**
     * Test if the list has the correcte size.
     * @param expected the expected size
     * @param list the list to test
     */
    protected void assertSizeEquals(int expected, List<?> list) {
        assertSizeEquals("The list must not be null.", Constants.WRONG_SIZE, expected, list);
    }

    /**
     * Test if the list has the correcte size.
     * @param notNullMessage the message if the list is null.
     * @param message the message.
     * @param expected the expected size
     * @param list the list to test
     */
    protected void assertSizeEquals(String notNullMessage, String message, int expected, List<?> list) {
        assertNotNull(notNullMessage, list);
        assertEquals(message, expected, list.size());
    }

    /**
     * test the herarchy of the two objects.
     * @param expected expected object
     * @param actual real object
     */
    protected void assertReflectionEquals(Object expected, Object actual) {
        ReflectionAssert.assertReflectionEquals(expected, actual);
    }

    /**
     * Test if the two objects are equals.
     * @param message the message.
     * @param expected expected object
     * @param actual real object
     */
    protected void assertEquals(String message, Object expected, Object actual) {
        TestCase.assertEquals(message, expected, actual);
    }

    /**
     * Test if the two objects are equals.
     * @param expected expected object
     * @param actual real object
     */
    protected void assertEquals(Object expected, Object actual) {
        assertEquals(Constants.NOT_EQUALS, expected, actual);
    }

    /**
     * Test if the two objects are same.
     * @param message the message.
     * @param expected expected object
     * @param actual real object
     */
    protected void assertNotSame(String message, Object expected, Object actual) {
        TestCase.assertNotSame(message, expected, actual);
    }

    /**
     * Test if the two objects are same.
     * @param expected expected object
     * @param actual real object
     */
    protected void assertNotSame(Object expected, Object actual) {
        assertNotSame(Constants.NOT_SAME, expected, actual);
    }

    /**
     * Test if the given object is null.
     * @param message the message.
     * @param object object to test.
     */
    protected void assertNull(String message, Object object) {
        TestCase.assertNull(message, object);
    }

    /**
     * Test if the given object is null.
     * @param object object to test.
     */
    protected void assertNull(Object object) {
        assertNull(Constants.NULL_MESSAGE, object);
    }

    /**
     * Test if the given object is not null.
     * @param message the message.
     * @param object object to test.
     */
    protected void assertNotNull(String message, Object object) {
        TestCase.assertNotNull(message, object);
    }

    /**
     * Test if the given object is not null.
     * @param object object to test.
     */
    protected void assertNotNull(Object object) {
        TestCase.assertNotNull(Constants.NOT_NULL_MESSAGE, object);
    }

    /**
     * Test if the given boolean is true.
     * @param message the message.
     * @param bool boolean to test.
     */
    protected void assertTrue(String message, boolean bool) {
        TestCase.assertTrue(message, bool);
    }

    /**
     * Test if the given boolean is true.
     * @param bool boolean to test.
     */
    protected void assertTrue(boolean bool) {
        assertTrue(Constants.TRUE_MESSAGE, bool);
    }

    /**
     * Test if the given boolean is false.
     * @param message the message.
     * @param bool boolean to test.
     */
    protected void assertFalse(String message, boolean bool) {
        TestCase.assertFalse(message, bool);
    }

    /**
     * Test if the given boolean is false.
     * @param bool boolean to test.
     */
    protected void assertFalse(boolean bool) {
        assertFalse(Constants.FALSE_MESSAGE, bool);
    }

    /**
     * Test the error count into report.
     * @param report the report to test.
     * @param errorCount the error count.
     */
    protected void assertErrorCountEquals(ReportDto report, int errorCount) {
        assertErrorCountEquals(Constants.WRONG_MESSAGES_COUNT, report, errorCount);
    }

    /**
     * Test the error count into report.
     * @param errorMessage the error message
     * @param report the report to test.
     * @param errorCount the error count.
     */
    protected void assertErrorCountEquals(String errorMessage, ReportDto report, int errorCount) {
        if (errorCount != report.getErrorCount()) {
            String error = errorMessage + " Expected: <" + errorCount + "> but was <" + report.getErrorCount() + ">";
            error += "\n Report details : \n" + report;
            fail(error);
        }
    }

    /**
     * Test the error count for the given attribute into report.
     * @param report the report to test.
     * @param attribute the attribute to test
     * @param errorCount the error count
     */
    protected void assertErrorCountEquals(ReportDto report, String attribute, int errorCount) {
        assertErrorCountEquals(Constants.WRONG_MESSAGES_COUNT, report, attribute, errorCount);
    }

    /**
     * Test the error count for the given attribute into report.
     * @param errorMessage the error message
     * @param report the report to test.
     * @param attribute the attribute to test
     * @param errorCount the error count
     */
    protected void assertErrorCountEquals(String errorMessage, ReportDto report, String attribute, int errorCount) {
        if (errorCount != report.getErrorCount(attribute)) {
            String error = errorMessage + " Expected: <" + errorCount + "> but was <" + report.getErrorCount() + ">";
            error += "\n Report details : \n" + report;
            fail(error);
        }
    }

    /**
     * Test if the given attribute has the given message into report.
     * @param report the report to test
     * @param attribute the atrtibute to test
     * @param message the message to find.
     */
    protected void assertHasMessage(ReportDto report, String attribute, String message) {
        String error = "The attribute \"" + attribute + "\" don't have the given message : " + message;
        error += "\n Report details : \n" + report;
        assertHasMessage(error, report, attribute, message);
    }

    /**
     * Test if the given attribute has the given message into report.
     * @param errorMessage the error message
     * @param report the report to test
     * @param attribute the atrtibute to test
     * @param message the message to find.
     */
    protected void assertHasMessage(String errorMessage, ReportDto report, String attribute, String message) {
        assertTrue(errorMessage, report.hasErrorMessage(attribute, message));
    }

    /**
     * Test if the given RemotePagingResults has the correct values.
     * @param remotePagingResults the RemotePagingResults to test.
     * @param expectedTotalResult the total results value.
     * @param expectedResultSize the results number in the list.
     */
    protected void assertPagingResultsIsCorrect(RemotePagingResultsDto<?> remotePagingResults, int expectedTotalResult, int expectedResultSize) {
        assertNotNull("The remotePagingResults must not be null.", remotePagingResults);
        assertSizeEquals("The remotePagingResults results list must not be null.", "The remotePagingResults results list has not the expected size.",
            expectedResultSize, remotePagingResults.getListResults());
        assertEquals("The remotePagingResults total result is not the expected one.", expectedTotalResult, remotePagingResults.getTotalResults());
    }

    /**
     * Erreur lors d'un traitement.
     * @param message le message à afficher.
     */
    protected void fail(final String message) {
        TestCase.fail(message);
    }
}
