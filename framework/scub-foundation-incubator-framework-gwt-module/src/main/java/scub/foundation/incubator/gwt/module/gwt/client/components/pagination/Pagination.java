package scub.foundation.incubator.gwt.module.gwt.client.components.pagination;


import scub.foundation.incubator.gwt.module.gwt.client.components.pagination.event.HasPaginationHandlers;
import scub.foundation.incubator.gwt.module.gwt.client.components.pagination.event.PageChangeEvent;
import scub.foundation.incubator.gwt.module.gwt.client.components.pagination.event.PageChangeHandler;

import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.base.UnorderedList;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Override of Bootstrap Pagination to simplify utilisation.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class Pagination extends DivWidget implements HasPaginationHandlers {

    /** Type of pagination display. */
    public enum Display {
        /** Type of pagination display. */
        ALL, AROUND
    }

    /**
     * Styles for pagination.
     * @author Adrien HAUTOT (adrien.hautot@scub.net)
     */
    public enum PaginationStyle implements Style {
        /** Left. */
        LEFT(""),
        /** centered. */
        CENTERED("pagination-centered"),
        /** right. */
        RIGHT("pagination-right");

        private static final String PAGINATION = "pagination ";

        private String className;

        private PaginationStyle(String className) {
            this.className = PAGINATION + className;
        }

        /**
         * Retrun css class name.
         * @return the className.
         */
        public String get() {
            return className;
        }
    }

    private UnorderedList list;

    private Pager pager;

    private Display display;

    /**
     * Constructor.
     * @param nbElementsPerPage nb elements per page
     */
    public Pagination(int nbElementsPerPage) {
        this(nbElementsPerPage, Display.ALL);
    }

    /**
     * Constructor.
     * @param nbElementsPerPage nb elements per page
     * @param display set the display of pagination
     */
    public Pagination(int nbElementsPerPage, Display display) {
        pager = new Pager(nbElementsPerPage);
        this.display = display;
        list = new UnorderedList();
        setStyle(PaginationStyle.RIGHT);

        super.add(list);
    }

    /**
     * Rebuid Pagination.
     * @param nbElementsTotal the nbElementsTotal to set
     * @param currentPage the currentPage to set
     */
    public void rebuildPagination(int currentPage, int nbElementsTotal) {
        super.remove(list);
        pager.setNbElementsTotal(nbElementsTotal);
        pager.setCurrentPage(currentPage);

        clear();
        if (pager.getPageCount() == 0) {
            return;
        }
        // previous button
        addPreviousPage();
        // build others pages by specific display
        if (display.equals(Display.ALL)) {
            rebuildAllPagination();
        } else if (display.equals(Display.AROUND)) {
            rebuildAroundPagination();
        }
        // next button
        addNextPage();
        super.add(list);
    }

    private void rebuildAroundPagination() {
        // by default, show only one page of each side
        int before = 1;
        int after = 1;
        // if there is less than 4 pages before, show all
        if (!pager.hasPreviousPages(4)) {
            before = pager.getPage();
            while (before > 0 && !pager.hasPreviousPages(before)) {
                before--;
            }
        }
        // if there is less than 4 pages after, show all
        if (!pager.hasNextPages(4)) {
            after = pager.getPageCount() - pager.getPage();
            while (after > 0 && !pager.hasNextPages(after)) {
                after--;
            }
        }

        // show etc if there is more than 3 pages before
        if (pager.hasPreviousPages(4)) {
            // first page
            addPage(0);
            // add ... item
            addEtcItem();
        }
        // add pages around current
        for (int i = pager.getPage() - before; i <= pager.getPage() + after; i++) {
            addPage(i);
        }
        // show etc if there is more than 3 pages after
        if (pager.hasNextPages(4)) {
            // add ... item
            addEtcItem();
            // last page
            addPage(pager.getPageCount() - 1);
        }
    }

    private void rebuildAllPagination() {
        // calculate how much pages before
        int before = pager.getPage();
        while (before > 0 && !pager.hasPreviousPages(before)) {
            before--;
        }
        // calculate how much pages after
        int after = pager.getPageCount() - pager.getPage();
        while (after > 0 && !pager.hasNextPages(after)) {
            after--;
        }
        // display pages
        for (int i = pager.getPage() - before; i <= pager.getPage() + after; i++) {
            addPage(i);
        }
    }

    private void addPage(final int pageIndex) {
        final int displayIndex = pageIndex + 1;
        final NavLink page = new NavLink();
        page.setText(String.valueOf(displayIndex));
        page.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                pager.setPage(pageIndex);
                firePageChangeEvent();
            }
        });
        if (pageIndex == pager.getPage()) {
            page.setActive(true);
        }
        addPage(page);
    }

    private void addPreviousPage() {
        final NavLink prev = new NavLink();
        prev.setText("<");
        if (pager.hasPreviousPage()) {
            prev.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    pager.previousPage();
                    firePageChangeEvent();
                }
            });
        }
        prev.setDisabled(!pager.hasPreviousPage());
        addPage(prev);
    }

    private void addNextPage() {
        final NavLink next = new NavLink();
        next.setText(">");
        if (pager.hasNextPage()) {
            next.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    pager.nextPage();
                    firePageChangeEvent();
                }
            });
        }
        next.setDisabled(!pager.hasNextPage());
        addPage(next);
    }

    private void addEtcItem() {
        final NavLink etc = new NavLink();
        etc.setText("...");
        etc.setDisabled(true);
        addPage(etc);
    }

    /**
     * Change pagination alignement.
     * @param alignment the alignement className. Use {@link PaginationStyle}
     */
    public void setAlignment(String alignment) {
        if (alignment.equalsIgnoreCase("right")) {
            setStyle(PaginationStyle.RIGHT);
        } else if (alignment.equalsIgnoreCase("centered")) {
            setStyle(PaginationStyle.CENTERED);
        } else {
            setStyle(PaginationStyle.LEFT);
        }
    }

    private void addPage(NavLink child) {
        list.add(child);
    }

    @Override
    public void clear() {
        list.clear();
    }

    private void firePageChangeEvent() {
        fireEvent(new PageChangeEvent(pager.getPage()));
    }

    @Override
    public HandlerRegistration addPageChangeHandler(PageChangeHandler handler) {
        return addHandler(handler, PageChangeEvent.TYPE);
    }

    /**
     * Get current page.
     * @return index of current page
     * @see org.scub.foundation.example.gwt.client.framework.pagination.Pager#getPage()
     */
    public int getPage() {
        return pager.getPage();
    }

    /**
     * Get number of elements per page.
     * @return number
     * @see org.scub.foundation.framework.gwt.module.client.util.composants.pagination.Pager#getNbElementsPerPage()
     */
    public int getNbElementsPerPage() {
        return pager.getNbElementsPerPage();
    }
}
