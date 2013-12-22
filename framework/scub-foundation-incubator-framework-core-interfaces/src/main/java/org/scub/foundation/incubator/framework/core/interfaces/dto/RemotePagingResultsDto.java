package org.scub.foundation.incubator.framework.core.interfaces.dto;

import java.util.List;

/**
 * Surcharge of the scub foundation remotePagingResultsDto in order to add constructors.
 * @param <DtoType> the dto type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class RemotePagingResultsDto<DtoType> extends org.scub.foundation.framework.base.paging.RemotePagingResultsDto<DtoType> {

    private static final long serialVersionUID = 5871846724061228239L;

    /**
     * Constructor.
     * @param resultsList the results list
     */
    public RemotePagingResultsDto(List<DtoType> resultsList) {
        this(resultsList, 0);
    }

    /**
     * Constructor.
     * @param totalResults the total results number.
     */
    public RemotePagingResultsDto(int totalResults) {
        this(null, totalResults);

    }

    /**
     * Constructor.
     * @param resultsList the results list
     * @param totalResults the total results number.
     */
    public RemotePagingResultsDto(List<DtoType> resultsList, int totalResults) {
        setListResults(resultsList);
        setTotalResults(totalResults);
    }

    @Override
    public String toString() {
        return "RemotePagingResultsDto [getTotalResults()=" + getTotalResults() + ", getListResults()=" + getListResults() + "]";
    }
}
