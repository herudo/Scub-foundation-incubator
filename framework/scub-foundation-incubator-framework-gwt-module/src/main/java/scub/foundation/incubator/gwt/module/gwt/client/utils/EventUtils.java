package scub.foundation.incubator.gwt.module.gwt.client.utils;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Provide utils methods for event.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public final class EventUtils implements IsSerializable {

    /** Constructor. */
    private EventUtils() {
    }

    /**
     * test if the value change event's value is not null.
     * @param event the event to test.
     * @return true if the event or event's value is not null, false overise.
     */
    public static boolean isValueNotNull(ValueChangeEvent<?> event) {
        return event != null && event.getValue() != null;
    }

    /**
     * test if the value change event's value is null.
     * @param event the event to test.
     * @return true if the event or event's value is null, false overise.
     */
    public static boolean isValueNull(ValueChangeEvent<?> event) {
        return event == null || event.getValue() == null;
    }
}
