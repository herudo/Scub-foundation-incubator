package org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions;

/**
 * Number search criterion for Integer.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class IntegerSearchCriterionDto extends NumberSearchCriterionDto<Integer> {

    private static final long serialVersionUID = -8436740563231579807L;

    /**
     * Constructor.
     */
    public IntegerSearchCriterionDto() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public IntegerSearchCriterionDto(NumberOperator operator, Integer value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public IntegerSearchCriterionDto(NumberOperator operator, Integer value, Integer secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public IntegerSearchCriterionDto(NumberOperator operator) {
        super(operator);
    }

}
