package org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions;

/**
 * Number search criterion for Double.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class DoubleSearchCriterionDto extends NumberSearchCriterionDto<Double> {

    private static final long serialVersionUID = -8436740563231579807L;

    /**
     * Constructor.
     */
    public DoubleSearchCriterionDto() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public DoubleSearchCriterionDto(NumberOperator operator) {
        super(operator);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public DoubleSearchCriterionDto(NumberOperator operator, Double value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public DoubleSearchCriterionDto(NumberOperator operator, Double value, Double secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }
}
