package org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions;

/**
 * Number search criterion for Long.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class LongSearchCriterionDto extends NumberSearchCriterionDto<Long> {

    private static final long serialVersionUID = -8436740563231579807L;

    /**
     * Constructor.
     */
    public LongSearchCriterionDto() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public LongSearchCriterionDto(NumberOperator operator) {
        super(operator);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public LongSearchCriterionDto(NumberOperator operator, Long value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public LongSearchCriterionDto(NumberOperator operator, Long value, Long secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }
}
