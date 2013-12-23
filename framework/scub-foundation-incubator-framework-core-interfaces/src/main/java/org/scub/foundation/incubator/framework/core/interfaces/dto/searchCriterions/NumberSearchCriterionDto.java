package org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions;

import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto.NumberOperator;

/**
 * Abstract search criterion for number.
 * @param <NumberType> the number type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class NumberSearchCriterionDto<NumberType extends Number> extends AbstractSearchCriterionDto<NumberType, NumberOperator> {

    private static final long serialVersionUID = 6698835772004689781L;

    private NumberType secondValue;

    /**
     * Constructor.
     */
    public NumberSearchCriterionDto() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public NumberSearchCriterionDto(NumberOperator operator, NumberType value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public NumberSearchCriterionDto(NumberOperator operator) {
        super(operator);
    }

    /**
     * Operator for numbers.
     * @author Adrien HAUTOT (contact@adrienhautot.fr)
     */
    public enum NumberOperator {
        /** search for value stricktly equals. */
        EQUALS,
        /** search for value differents. */
        DIFFERENTS,
        /** search for null value. */
        IS_NULL,
        /** search for a not null value. */
        IS_NOT_NULL,
        /** search for a value greater than or equal. */
        GREATER_THAN_OR_EQUAL,
        /** search for a value less than or equal. */
        LESS_THAN_OR_EQUAL,
        /** search for a value strictly greater than. */
        GREATER_THAN,
        /** search for a value strictly less than. */
        LESS_THAN,
        /** search for a value that is between the value and the other. */
        BETWEEN,
        /** search for a value that is not between the value and the other. */
        NOT_BETWEEN,
        /** search for a value that is strictly between the value and the other. */
        STRICTLY_BETWEEN,
        /** search for a value that is strictly not between the value and the other. */
        STRICTLY_NOT_BETWEEN
    }

    /**
     * Get the value of secondValue.
     * @return the secondValue
     */
    public NumberType getSecondValue() {
        return secondValue;
    }

    /**
     * Set the value of secondValue.
     * @param secondValue the secondValue to set
     */
    public void setSecondValue(NumberType secondValue) {
        this.secondValue = secondValue;
    }
}
