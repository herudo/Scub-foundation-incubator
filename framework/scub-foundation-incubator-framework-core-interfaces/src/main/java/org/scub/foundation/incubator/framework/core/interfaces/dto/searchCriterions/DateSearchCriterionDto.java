package org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions;

import java.util.Calendar;
import java.util.Date;

/**
 * Search criterion for date.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class DateSearchCriterionDto extends AbstractSearchCriterionDto<DateSearchCriterionValueDto, DateSearchCriterionDto.DateOperator> {

    private static final long serialVersionUID = -5366680907856030388L;

    private DateSearchCriterionValueDto secondValue;

    /**
     * Constructor.
     */
    public DateSearchCriterionDto() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public DateSearchCriterionDto(DateOperator operator) {
        super(operator);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public DateSearchCriterionDto(DateOperator operator, DateSearchCriterionValueDto value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public DateSearchCriterionDto(DateOperator operator, DateSearchCriterionValueDto value, DateSearchCriterionValueDto secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public DateSearchCriterionDto(DateOperator operator, Date value) {
        super(operator, new DateSearchCriterionValueDto(value));
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public DateSearchCriterionDto(DateOperator operator, Date value, Date secondValue) {
        super(operator, new DateSearchCriterionValueDto(value));
        setSecondValue(new DateSearchCriterionValueDto(secondValue));
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public DateSearchCriterionDto(DateOperator operator, Calendar value) {
        super(operator, new DateSearchCriterionValueDto(value));
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public DateSearchCriterionDto(DateOperator operator, Calendar value, Calendar secondValue) {
        super(operator, new DateSearchCriterionValueDto(value));
        setSecondValue(new DateSearchCriterionValueDto(secondValue));
    }

    /**
     * Get the value of secondValue.
     * @return the secondValue
     */
    public DateSearchCriterionValueDto getSecondValue() {
        return secondValue;
    }

    /**
     * Set the value of secondValue.
     * @param secondValue the secondValue to set
     */
    public void setSecondValue(DateSearchCriterionValueDto secondValue) {
        this.secondValue = secondValue;
    }

    /**
     * The operators list for date search cirterion.
     * @author Adrien HAUTOT (contact@adrienhautot.fr)
     */
    public enum DateOperator {
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
}
