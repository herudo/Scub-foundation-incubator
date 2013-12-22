package scub.foundation.incubator.gwt.module.gwt.shared;

import java.util.List;

/**
 * Surcharge of scub foundation remote paging results model.
 * @param <ModelType> the model type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class RemotePagingResultsModel<ModelType> extends org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingResultsModel<ModelType> {

    private static final long serialVersionUID = -5616058229516760472L;

    /**
     * Constructor.
     * @param resultsList the results list.
     * @param totalResults the total results.
     */
    public RemotePagingResultsModel(List<ModelType> resultsList, int totalResults) {
        super();
        setListResults(resultsList);
        setTotalResults(totalResults);
    }

    /**
     * Constructor.
     */
    public RemotePagingResultsModel() {
        super();
    }
}
