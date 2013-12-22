package org.scub.foundation.incubator.framework.core.interfaces.dto;

/**
 * Surcharge of the RemotePagingCriteriasDto in ordre to add constructor.
 * @param <Type> the criteria type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class RemotePagingCriteriasDto<Type> extends org.scub.foundation.framework.base.paging.RemotePagingCriteriasDto<Type> {

    private static final long serialVersionUID = -8720895641201360654L;

    /**
     * constructor.
     */
    public RemotePagingCriteriasDto() {
        super(null, 0, Integer.MAX_VALUE);
    }

    /**
     * constructor.
     * @param criterias the criteria.
     */
    public RemotePagingCriteriasDto(Type criterias) {
        super(criterias, 0, Integer.MAX_VALUE);
    }

    /**
     * constructor.
     * @param criterias the criteria.
     * @param firstResult the first result index.
     */
    public RemotePagingCriteriasDto(Type criterias, int firstResult) {
        super(criterias, firstResult, Integer.MAX_VALUE);
    }

    /**
     * constructor.
     * @param firstResult the first result index.
     * @param maxResult the max results number.
     */
    public RemotePagingCriteriasDto(int firstResult, int maxResult) {
        super(null, firstResult, maxResult);
    }

}
