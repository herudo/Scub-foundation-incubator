package org.scub.foundation.incubator.framework.base.utils;

import java.util.List;

/**
 * Provide utils methods for list.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public final class ListUtils {

    /** Constructor. */
    private ListUtils() {
    }

    /**
     * test if the list is null or empty.
     * @param list the list to test.
     * @return true if the list is null or empty, false overise.
     */
    public static boolean isEmpty(List<?> list) {
        return CollectionUtils.isEmpty(list);
    }

    /**
     * test if the list is not null and not empty.
     * @param list the list to test.
     * @return false if the list is null or empty, true overise.
     */
    public static boolean isNotEmpty(List<?> list) {
        return CollectionUtils.isNotEmpty(list);
    }
}
