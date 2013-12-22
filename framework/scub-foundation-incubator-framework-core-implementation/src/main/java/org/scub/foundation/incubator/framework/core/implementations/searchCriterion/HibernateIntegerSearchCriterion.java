package org.scub.foundation.incubator.framework.core.implementations.searchCriterion;

import org.hibernate.Query;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto;

/**
 * Implementation of the integer search crierion for hibernate.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class HibernateIntegerSearchCriterion extends HibernateNumberSearchCriterion<Integer> {

    /**
     * Constructor.
     * @param searchCriterion the search searchCriterion.
     */
    public HibernateIntegerSearchCriterion(NumberSearchCriterionDto<Integer> searchCriterion) {
        super(searchCriterion);
    }

    @Override
    public void setQueryParam(Query query, String parameterName, Integer value) {
        if (query != null) {
            query.setInteger(parameterName, value);
        }
    }
}
