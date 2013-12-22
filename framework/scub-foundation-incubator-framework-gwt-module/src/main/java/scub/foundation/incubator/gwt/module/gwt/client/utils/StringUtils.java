package scub.foundation.incubator.gwt.module.gwt.client.utils;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Provide utils methods for string.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public final class StringUtils implements IsSerializable {

    /** Constructor. */
    private StringUtils() {
    }

    /**
     * test if the string is null or empty.
     * @param string the string to test.
     * @return true if the string is null or empty, false overise.
     */
    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    /**
     * test if the string is not null and not empty.
     * @param string the string to test.
     * @return false if the string is null or empty, true overise.
     */
    public static boolean isNotEmpty(String string) {
        return string != null && !string.isEmpty();
    }
}
