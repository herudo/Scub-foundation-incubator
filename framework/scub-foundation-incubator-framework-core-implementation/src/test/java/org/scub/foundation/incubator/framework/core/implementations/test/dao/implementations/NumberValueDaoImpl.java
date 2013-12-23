package org.scub.foundation.incubator.framework.core.implementations.test.dao.implementations;

import java.util.List;

import org.hibernate.Query;
import org.scub.foundation.incubator.framework.core.implementations.dao.implementations.HibernateDaoBaseImplementation;
import org.scub.foundation.incubator.framework.core.implementations.searchCriterion.query.HqlQuery;
import org.scub.foundation.incubator.framework.core.implementations.test.dao.interfaces.NumberValueDao;
import org.scub.foundation.incubator.framework.core.implementations.test.model.NumberValue;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DoubleSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.FloatSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.IntegerSearchCriterionDto;

/**
 * Dao Implementation for number query.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class NumberValueDaoImpl extends HibernateDaoBaseImplementation implements NumberValueDao {

    /**
     * create hql query for numberValue.
     * @return the HqlQuery.
     */
    private HqlQuery getHqlQuery() {
        final HqlQuery hqlQuery = new HqlQuery();
        hqlQuery.append("SELECT numberValue ");
        hqlQuery.append("FROM NumberValue numberValue ");
        hqlQuery.append("WHERE ");

        return hqlQuery;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NumberValue> getIntegerValues(IntegerSearchCriterionDto searchCriterion) {
        final HqlQuery hqlQuery = getHqlQuery();
        hqlQuery.addSearchCriterion(searchCriterion, "intValue", "intValue");
        return createQuery(hqlQuery).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NumberValue> getDoubleValues(DoubleSearchCriterionDto searchCriterion) {
        final HqlQuery hqlQuery = getHqlQuery();
        hqlQuery.addSearchCriterion(searchCriterion, "doubleValue", "doubleValue");
        return createQuery(hqlQuery).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NumberValue> getFloatValues(FloatSearchCriterionDto searchCriterion) {
        final HqlQuery hqlQuery = getHqlQuery();
        hqlQuery.addSearchCriterion(searchCriterion, "floatValue", "floatValue");
         Query criteria = createQuery(hqlQuery);
        return createQuery(hqlQuery).list();
    }
}