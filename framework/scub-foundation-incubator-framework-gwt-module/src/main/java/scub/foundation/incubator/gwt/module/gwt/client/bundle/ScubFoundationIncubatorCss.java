package scub.foundation.incubator.gwt.module.gwt.client.bundle;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.Shared;

/**
 * Interface for the used css.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
@Shared
public interface ScubFoundationIncubatorCss extends CssResource {

    /* =========================== global styles ========================== */

    /**
     * style width = 100%.
     * @return the style.
     */
    String width100Percent();

    /**
     * Utility to remove outline border.
     * @return the style.
     */
    String outlineNone();

    /**
     * Utility to align center.
     * @return the style.
     */
    String alignCenter();

    /**
     * Utility to set margin = 10px.
     * @return the style.
     */
    String margin10();

    /* =========================== search criterion styles ========================== */

    /**
     * The style for search criterion.
     * @return the style.
     */
    String searchCriterion();

    /**
     * The style for search criterion operator button.
     * @return the style.
     */
    String operatorButton();

    /* =========================== remote pagging table ========================== */

    /**
     * remote paging table principal table.
     * @return the style.
     */
    @ClassName("remote-paging-table")
    String remotePagingTable();

    /**
     * remote paging table loading panel.
     * @return the style.
     */
    String remotePagingLoadingPanel();

    /**
     * remote paging table: style for clickable cells.
     * @return the style.
     */
    String clickable();

    /**
     * remote paging table: container for pagination.
     * @return the style.
     */
    String paginationContainer();
}
