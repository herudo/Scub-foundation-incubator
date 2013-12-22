package scub.foundation.incubator.gwt.module.gwt.client.controller;

import org.scub.foundation.framework.gwt.module.client.mvp.view.View;
import org.scub.foundation.framework.gwt.module.client.util.composants.tabpanel.event.HasTabPanelHandlers;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Interface for the view.
 */
public interface AppLayout extends View {

    /**
     * Get a tab content by its token.
     * @param token a tab's token.
     * @return the tab's content.
     */
    HasWidgets.ForIsWidget getTabContent(String token);

    /**
     * Get the unique container.
     * @return the container.
     */
    HasWidgets.ForIsWidget getUniqueContainer();

    /**
     * Get handlers for tab panel.
     * @return handlers interface
     */
    HasTabPanelHandlers getTabPanelHandlers();
}
