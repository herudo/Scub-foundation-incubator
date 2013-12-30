package org.scub.foundation.incubator.framework.core.implementations.test.dao.implementations;

import java.util.List;

import org.scub.foundation.incubator.framework.core.implementations.dao.implementations.HibernateDaoBaseImplementation;
import org.scub.foundation.incubator.framework.core.implementations.searchCriterion.query.HqlQuery;
import org.scub.foundation.incubator.framework.core.implementations.test.dao.interfaces.DateValueDao;
import org.scub.foundation.incubator.framework.core.implementations.test.model.DateValue;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DateSearchCriterionDto;

/**
 * Implementation of the date value dao.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class DateValueDaoImpl extends HibernateDaoBaseImplementation implements DateValueDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<DateValue> getDateValues(DateSearchCriterionDto searchCriterion) {
        final HqlQuery hqlQuery = new HqlQuery();
        hqlQuery.append("SELECT dateValue ");
        hqlQuery.append("FROM DateValue dateValue ");
        hqlQuery.append("WHERE ");
        hqlQuery.addSearchCriterion(searchCriterion, "value", "value");
        return createQuery(hqlQuery).list();
    }

}
