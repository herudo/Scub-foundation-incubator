package org.scub.foundation.incubator.framework.core.implementations.test.dao.interfaces;

import java.util.List;

import org.scub.foundation.incubator.framework.core.implementations.test.model.NumberValue;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DoubleSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.FloatSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.IntegerSearchCriterionDto;

/**
 * Dao interface to get a list of number values.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface NumberValueDao {

    /**
     * get a list of number values filtered by the given IntegerSearchCriterionDto.
     * @param searchCriterion the search criterion.
     * @return the value list.
     */
    List<NumberValue> getIntegerValues(IntegerSearchCriterionDto searchCriterion);

    /**
     * get a list of number values filtered by the given DoubleSearchCriterionDto.
     * @param searchCriterion the search criterion.
     * @return the value list.
     */
    List<NumberValue> getDoubleValues(DoubleSearchCriterionDto searchCriterion);

    /**
     * get a list of number values filtered by the given FloatSearchCriterionDto.
     * @param searchCriterion the search criterion.
     * @return the value list.
     */
    List<NumberValue> getFloatValues(FloatSearchCriterionDto searchCriterion);
}
