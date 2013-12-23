package org.scub.foundation.incubator.framework.core.implementations.searchCriterion;

import org.hibernate.Query;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto;

/**
 * Implementation of the float search crierion for hibernate.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class HibernateFloatSearchCriterion extends HibernateNumberSearchCriterion<Float> {

    /**
     * Constructor.
     * @param searchCriterion the search searchCriterion.
     */
    public HibernateFloatSearchCriterion(NumberSearchCriterionDto<Float> searchCriterion) {
        super(searchCriterion);
    }

    @Override
    public void setQueryParam(Query query, String parameterName, Float value) {
        if (query != null) {
            query.setFloat(parameterName, value);
        }
    }
}
