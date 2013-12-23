package org.scub.foundation.incubator.framework.core.implementations.searchCriterion;

import org.hibernate.Query;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto;

/**
 * Implementation of the long search crierion for hibernate.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class HibernateLongSearchCriterion extends HibernateNumberSearchCriterion<Long> {

    /**
     * Constructor.
     * @param searchCriterion the search searchCriterion.
     */
    public HibernateLongSearchCriterion(NumberSearchCriterionDto<Long> searchCriterion) {
        super(searchCriterion);
    }

    @Override
    public void setQueryParam(Query query, String parameterName, Long value) {
        if (query != null) {
            query.setLong(parameterName, value);
        }
    }
}
