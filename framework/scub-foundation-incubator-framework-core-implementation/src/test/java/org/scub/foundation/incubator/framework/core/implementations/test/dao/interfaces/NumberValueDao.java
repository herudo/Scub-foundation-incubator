package org.scub.foundation.incubator.framework.core.implementations.test.dao.interfaces;

import java.util.List;

import org.scub.foundation.incubator.framework.core.implementations.test.model.NumberValue;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.IntegerSearchCriterionDto;

/**
 * Dao interface to get a list of number values.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface NumberValueDao {

    /**
     * get a list of number values filtered by the given numberSearchCriterion.
     * @param searchCriterion the search criterion.
     * @return the value list.
     */
    List<NumberValue> getIntegerValues(IntegerSearchCriterionDto searchCriterion);
}
