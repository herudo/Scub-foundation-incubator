package scub.foundation.incubator.gwt.module.gwt.client.components.pagination;

/**
 * Pager to help in page management.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
public class Pager {

    private int currentPage;

    /** Default value if not set. */
    private int nbElementsPerPage = 10;

    private int nbElementsTotal;

    /**
     * Constructor.
     * @param nbElementsPerPage nb elements per page
     */
    protected Pager(int nbElementsPerPage) {
        this.nbElementsPerPage = nbElementsPerPage;
    }

    /**
     * Set the value of nbElementsTotal.
     * @param nbElementsTotal the nbElementsTotal to set
     */
    public void setNbElementsTotal(int nbElementsTotal) {
        this.nbElementsTotal = nbElementsTotal;
    }

    /**
     * Set the value of currentPage.
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Get the number of pages.
     * @return page count
     */
    public int getPageCount() {
        return (int) Math.ceil((double) nbElementsTotal / (double) nbElementsPerPage);
    }

    /**
     * Check if exist previous page.
     * @return boolean
     */
    public boolean hasPreviousPage() {
        return hasPreviousPages(1);
    }

    /**
     * Check if exist a specific previous page.
     * @param page difference of page
     * @return boolean
     */
    public boolean hasPreviousPages(int page) {
        return (currentPage - page) >= 0;
    }

    /**
     * Check if exist next page.
     * @return boolean
     */
    public boolean hasNextPage() {
        return hasNextPages(1);
    }

    /**
     * Check if exist a specific next page.
     * @param page difference of page
     * @return boolean
     */
    public boolean hasNextPages(int page) {
        return (currentPage + page) < getPageCount();
    }

    /**
     * Get the current page.
     * @return index
     */
    public int getPage() {
        return currentPage;
    }

    /**
     * Set current page to previous page.
     */
    public void previousPage() {
        if (hasPreviousPage()) {
            currentPage--;
        }
    }

    /**
     * Set current page to next page.
     */
    public void nextPage() {
        if (hasNextPage()) {
            currentPage++;
        }
    }

    /**
     * Set a specific page.
     * @param page page to set
     */
    public void setPage(int page) {
        if (page >= 0 && page <= getPageCount() - 1) {
            currentPage = page;
        }
    }

    /**
     * Get the value of nbElementsPerPage.
     * @return the nbElementsPerPage
     */
    public int getNbElementsPerPage() {
        return nbElementsPerPage;
    }
}
