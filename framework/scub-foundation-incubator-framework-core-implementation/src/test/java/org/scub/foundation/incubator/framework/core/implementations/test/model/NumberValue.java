package org.scub.foundation.incubator.framework.core.implementations.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.scub.foundation.framework.core.model.BaseModel;

/**
 * A type to test number search criterion.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
@Entity
@Table(name = "NUMBER_VALUE")
public class NumberValue extends BaseModel {

    private static final long serialVersionUID = -1122283604803427478L;

    @Column(name = "INT_VALUE")
    private Integer intValue;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return equalsUtil(other);
    }

    /**
     * Get the value of intValue.
     * @return the intValue
     */
    public Integer getIntValue() {
        return intValue;
    }

    /**
     * Set the value of intValue.
     * @param intValue the intValue to set
     */
    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

}
