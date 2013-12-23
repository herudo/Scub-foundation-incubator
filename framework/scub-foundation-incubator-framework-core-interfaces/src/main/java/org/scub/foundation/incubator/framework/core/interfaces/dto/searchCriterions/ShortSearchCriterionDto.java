package org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions;

/**
 * Number search criterion for Short.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class ShortSearchCriterionDto extends NumberSearchCriterionDto<Short> {

    private static final long serialVersionUID = -8436740563231579807L;

    /**
     * Constructor.
     */
    public ShortSearchCriterionDto() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public ShortSearchCriterionDto(NumberOperator operator) {
        super(operator);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public ShortSearchCriterionDto(NumberOperator operator, Short value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public ShortSearchCriterionDto(NumberOperator operator, Short value, Short secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }
}
