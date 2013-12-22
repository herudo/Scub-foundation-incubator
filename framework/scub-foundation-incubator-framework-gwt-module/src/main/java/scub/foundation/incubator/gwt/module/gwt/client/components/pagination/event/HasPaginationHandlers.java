package scub.foundation.incubator.gwt.module.gwt.client.components.pagination.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A widget that implements this interface provides registration for {@link Pagination} handlers instances.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
public interface HasPaginationHandlers extends HasHandlers {
    /**
     * Adds a {@link PageChangeEvent} handler.
     * @param handler the handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addPageChangeHandler(PageChangeHandler handler);
}
