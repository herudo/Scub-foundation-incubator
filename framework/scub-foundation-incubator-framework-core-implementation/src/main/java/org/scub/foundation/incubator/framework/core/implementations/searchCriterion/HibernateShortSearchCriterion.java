package org.scub.foundation.incubator.framework.core.implementations.searchCriterion;

import org.hibernate.Query;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto;

/**
 * Implementation of the short search crierion for hibernate.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class HibernateShortSearchCriterion extends HibernateNumberSearchCriterion<Short> {

    /**
     * Constructor.
     * @param searchCriterion the search searchCriterion.
     */
    public HibernateShortSearchCriterion(NumberSearchCriterionDto<Short> searchCriterion) {
        super(searchCriterion);
    }

    @Override
    public void setQueryParam(Query query, String parameterName, Short value) {
        if (query != null) {
            query.setShort(parameterName, value);
        }
    }
}
