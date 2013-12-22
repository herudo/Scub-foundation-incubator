package org.scub.foundation.incubator.framework.base.utils;

import java.util.Collection;

/**
 * Provide utils methods for collections.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public final class CollectionUtils {

    /** Constructor. */
    private CollectionUtils() {
    }

    /**
     * test if the collection is null or empty.
     * @param collection the collection to test.
     * @return true if the collection is null or empty, false overise.
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * test if the collection is not null and not empty.
     * @param collection the collection to test.
     * @return false if the collection is null or empty, true overise.
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }
}
