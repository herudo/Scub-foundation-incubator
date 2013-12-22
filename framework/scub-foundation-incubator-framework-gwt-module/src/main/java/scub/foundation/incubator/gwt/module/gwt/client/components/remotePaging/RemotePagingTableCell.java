package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging;

import com.google.gwt.user.client.ui.Widget;

/**
 * Object that represent a cell for the {@link RemotePagingTable}.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class RemotePagingTableCell {

    private boolean clickable;

    private Widget content;

    /**
     * Constructor. cells default clickable.
     * @param widget the cell content.
     */
    public RemotePagingTableCell(Widget widget) {
        this(true, widget);
    }

    /**
     * Constructor.
     * @param clickable true if the row is clickable, false overwise.
     * @param widget the cell content.
     */
    public RemotePagingTableCell(boolean clickable, Widget widget) {
        this.clickable = clickable;
        this.content = widget;
    }

    /**
     * Get the value of clickable.
     * @return the clickable
     */
    public boolean isClickable() {
        return clickable;
    }

    /**
     * Set the value of clickable.
     * @param clickable the clickable to set
     */
    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    /**
     * Get the value of content.
     * @return the content
     */
    public Widget getContent() {
        return content;
    }

    /**
     * Set the value of content.
     * @param content the content to set
     */
    public void setContent(Widget content) {
        this.content = content;
    }
}
