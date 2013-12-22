package scub.foundation.incubator.gwt.module.gwt.client.utils;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Provide utils methods for list.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public final class ListUtils implements IsSerializable {

    /** Constructor. */
    private ListUtils() {
    }

    /**
     * test if the list is null or empty.
     * @param list the list to test.
     * @return true if the list is null or empty, false overise.
     */
    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    /**
     * test if the list is not null and not empty.
     * @param list the list to test.
     * @return false if the list is null or empty, true overise.
     */
    public static boolean isNotEmpty(List<?> list) {
        return list != null && !list.isEmpty();
    }
}
