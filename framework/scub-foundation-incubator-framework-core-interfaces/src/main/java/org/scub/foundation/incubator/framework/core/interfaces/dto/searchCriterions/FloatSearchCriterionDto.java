package org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions;

/**
 * Number search criterion for Float.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class FloatSearchCriterionDto extends NumberSearchCriterionDto<Float> {

    private static final long serialVersionUID = -8436740563231579807L;

    /**
     * Constructor.
     */
    public FloatSearchCriterionDto() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public FloatSearchCriterionDto(NumberOperator operator) {
        super(operator);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public FloatSearchCriterionDto(NumberOperator operator, Float value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public FloatSearchCriterionDto(NumberOperator operator, Float value, Float secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }
}
