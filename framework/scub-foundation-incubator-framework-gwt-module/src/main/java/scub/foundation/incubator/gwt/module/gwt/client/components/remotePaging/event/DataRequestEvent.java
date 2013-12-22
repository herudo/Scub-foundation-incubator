package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.event;

import java.util.List;

import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingResultsModel;
import org.scub.foundation.framework.gwt.module.shared.pagination.RemotePagingSortModel;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Event launch when the remote pagging table request data.
 * @param <T> the data type.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class DataRequestEvent<T> extends GwtEvent<DataRequestEventHandler> {
    /** The event's type. */
    public static final Type<DataRequestEventHandler> TYPE = new Type<DataRequestEventHandler>();

    private List<RemotePagingSortModel> sorts;

    private AsyncCallback<RemotePagingResultsModel<T>> callback;

    private int firstResult;

    private int maxResult;

    /**
     * Constructor.
     */
    public DataRequestEvent() {
    }

    @Override
    public Type<DataRequestEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DataRequestEventHandler handler) {
        handler.onDataRequest(this);
    }

    /**
     * Get the value of sorts.
     * @return the sorts
     */
    public List<RemotePagingSortModel> getSorts() {
        return sorts;
    }

    /**
     * Set the value of sorts.
     * @param sorts the sorts to set
     */
    public void setSorts(List<RemotePagingSortModel> sorts) {
        this.sorts = sorts;
    }

    /**
     * Get the value of callback.
     * @return the callback
     */
    public AsyncCallback<RemotePagingResultsModel<T>> getCallback() {
        return callback;
    }

    /**
     * Set the value of callback.
     * @param callback the callback to set
     */
    public void setCallback(AsyncCallback<RemotePagingResultsModel<T>> callback) {
        this.callback = callback;
    }

    /**
     * Get the value of firstResult.
     * @return the firstResult
     */
    public int getFirstResult() {
        return firstResult;
    }

    /**
     * Set the value of firstResult.
     * @param firstResult the firstResult to set
     */
    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    /**
     * Get the value of maxResult.
     * @return the maxResult
     */
    public int getMaxResult() {
        return maxResult;
    }

    /**
     * Set the value of maxResult.
     * @param maxResult the maxResult to set
     */
    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }
}
