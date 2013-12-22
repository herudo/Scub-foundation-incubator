package scub.foundation.incubator.gwt.module.gwt.client.utils;

import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Provide utils methods for map.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public final class MapUtils implements IsSerializable {

    /** Constructor. */
    private MapUtils() {
    }

    /**
     * test if the map is null or empty.
     * @param map the map to test.
     * @return true if the map is null or empty, false overise.
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * test if the map is not null and not empty.
     * @param map the map to test.
     * @return false if the map is null or empty, true overise.
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return map != null && !map.isEmpty();
    }
}
