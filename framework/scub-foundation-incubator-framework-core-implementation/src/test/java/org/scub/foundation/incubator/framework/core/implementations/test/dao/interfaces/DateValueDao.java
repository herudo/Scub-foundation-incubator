package org.scub.foundation.incubator.framework.core.implementations.test.dao.interfaces;

import java.util.List;

import org.scub.foundation.incubator.framework.core.implementations.test.model.DateValue;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DateSearchCriterionDto;

/**
 * Dao interface to get a list of date values.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface DateValueDao {

    /**
     * get a list of number values filtered by the given DateSearchCriterionDto.
     * @param searchCriterion the search criterion.
     * @return the value list.
     */
    List<DateValue> getDateValues(DateSearchCriterionDto searchCriterion);
}
