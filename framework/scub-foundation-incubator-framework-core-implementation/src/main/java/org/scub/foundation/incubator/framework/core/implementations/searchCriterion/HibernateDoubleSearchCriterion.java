package org.scub.foundation.incubator.framework.core.implementations.searchCriterion;

import org.hibernate.Query;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto;

/**
 * Implementation of the double search crierion for hibernate.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class HibernateDoubleSearchCriterion extends HibernateNumberSearchCriterion<Double> {

    /**
     * Constructor.
     * @param searchCriterion the search searchCriterion.
     */
    public HibernateDoubleSearchCriterion(NumberSearchCriterionDto<Double> searchCriterion) {
        super(searchCriterion);
    }

    @Override
    public void setQueryParam(Query query, String parameterName, Double value) {
        if (query != null) {
            query.setDouble(parameterName, value);
        }
    }
}
