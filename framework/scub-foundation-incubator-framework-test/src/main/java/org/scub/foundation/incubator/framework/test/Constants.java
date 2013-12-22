package org.scub.foundation.incubator.framework.test;

/**
 * Utils constantes for unit test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class Constants {
    /** Constructor. */
    protected Constants() {
    }

    /** message. */
    public static final String WRONG_MESSAGES_COUNT = "The errors count is not the expected one.";

    /** message. */
    public static final String NOT_EQUALS = "The expected value must be equals to the actual.";

    /** message. */
    public static final String NOT_SAME = "The expected must be the same of the actual.";

    /** message. */
    public static final String NULL_MESSAGE = "The object must be null.";

    /** message. */
    public static final String NOT_NULL_MESSAGE = "The object must not be null.";

    /** message. */
    public static final String TRUE_MESSAGE = "The value must be true.";

    /** message. */
    public static final String FALSE_MESSAGE = "The value must be false.";
    
    /** message. */
    public static final String WRONG_MESSAGE = "The exception message is not the expected one.";

    /** message. */
    public static final String WRONG_SIZE = "The list elements number is not the ecpected one.";

    /** message. */
    public static final String MUST_FAIL = "The service would fail.";

    /**
     * Get the error message ""${name}" must not be null" for the given parameter name.
     * @param name the name
     * @return thee message.
     */
    public static String nullError(String name) {
        return "\"" + name + "\"  must not be null";
    }

    /**
     * Get the error message "The "${name}" value is not the expected one." for the given parameter name.
     * @param name the name
     * @return thee message.
     */
    public static String valueError(String name) {
        return "The \"" + name + "\" value is not the expected one.";
    }

    /** id non présent dans le dataset. */
    public static final Long UNEXISTANT_ID = 99999999999L;
}
