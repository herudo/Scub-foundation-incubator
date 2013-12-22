package org.scub.foundation.incubator.framework.base.utils;

import java.util.Set;

/**
 * Provide utils methods for set.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public final class SetUtils {

    /** Constructor. */
    private SetUtils() {
    }

    /**
     * test if the set is null or empty.
     * @param set the set to test.
     * @return true if the set is null or empty, false overise.
     */
    public static boolean isEmpty(Set<?> set) {
        return CollectionUtils.isEmpty(set);
    }

    /**
     * test if the set is not null and not empty.
     * @param set the set to test.
     * @return false if the set is null or empty, true overise.
     */
    public static boolean isNotEmpty(Set<?> set) {
        return CollectionUtils.isNotEmpty(set);
    }
}
