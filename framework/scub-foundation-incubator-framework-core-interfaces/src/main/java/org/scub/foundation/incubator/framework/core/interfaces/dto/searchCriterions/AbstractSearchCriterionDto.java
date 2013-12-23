package org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions;

import java.io.Serializable;

/**
 * Based class for search criterion. A search criterion is a set of property that represent a criterion for a search. it's give for example a value and an
 * operator for the search.
 * @param <O> the operator enum type
 * @param <T> the value type
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractSearchCriterionDto<T, O> implements Serializable {

    private static final long serialVersionUID = -604237118194859912L;

    /** The operator. */
    protected O operator;

    /** The value. */
    protected T value;

    /**
     * Constructor.
     */
    public AbstractSearchCriterionDto() {
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public AbstractSearchCriterionDto(O operator, T value) {
        this.operator = operator;
        this.value = value;
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public AbstractSearchCriterionDto(O operator) {
        this.operator = operator;
    }

    /**
     * Get the value of operator.
     * @return the operator
     */
    public O getOperator() {
        return operator;
    }

    /**
     * Set the value of operator.
     * @param operator the operator to set
     */
    public void setOperator(O operator) {
        this.operator = operator;
    }

    /**
     * Get the value of value.
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * Set the value of value.
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [operator=" + operator + ", value=" + value + "]";
    }
}
