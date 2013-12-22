package scub.foundation.incubator.gwt.module.gwt.client.components.pagination.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Event when asking for change page in remote table.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class PageChangeEvent extends GwtEvent<PageChangeHandler> {
    /** The event's type. */
    public static final Type<PageChangeHandler> TYPE = new Type<PageChangeHandler>();

    private int page;

    /**
     * Constructor.
     * @param page page to show
     */
    public PageChangeEvent(int page) {
        this.page = page;
    }

    @Override
    public Type<PageChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PageChangeHandler handler) {
        handler.onPageChange(this);
    }

    /**
     * Get the value of page.
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * Set the value of page.
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }
}
