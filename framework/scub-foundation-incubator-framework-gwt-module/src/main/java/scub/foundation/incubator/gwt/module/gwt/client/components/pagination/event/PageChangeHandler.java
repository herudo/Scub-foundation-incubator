package scub.foundation.incubator.gwt.module.gwt.client.components.pagination.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for PageChangeEvent.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
public interface PageChangeHandler extends EventHandler {
    /**
     * The method to perform when ask for changing page in remote table.
     * @param event the PageChangeEvent.
     */
    void onPageChange(PageChangeEvent event);
}
