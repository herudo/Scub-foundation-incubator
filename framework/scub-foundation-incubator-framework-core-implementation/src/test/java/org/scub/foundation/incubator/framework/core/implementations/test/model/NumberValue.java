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

    @Column(name = "DOUBLE_VALUE")
    private Double doubleValue;

    @Column(name = "FLOAT_VALUE")
    private Float floatValue;

    @Column(name = "LONG_VALUE")
    private Long longValue;

    @Column(name = "SHORT_VALUE")
    private Short shortValue;

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

    /**
     * Get the value of doubleValue.
     * @return the doubleValue
     */
    public Double getDoubleValue() {
        return doubleValue;
    }

    /**
     * Set the value of doubleValue.
     * @param doubleValue the doubleValue to set
     */
    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    /**
     * Get the value of floatValue.
     * @return the floatValue
     */
    public Float getFloatValue() {
        return floatValue;
    }

    /**
     * Set the value of floatValue.
     * @param floatValue the floatValue to set
     */
    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }

    /**
     * Get the value of longValue.
     * @return the longValue
     */
    public Long getLongValue() {
        return longValue;
    }

    /**
     * Set the value of longValue.
     * @param longValue the longValue to set
     */
    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }
    /**
     * Get the value of shortValue.
     * @return the shortValue
     */
    public Short getShortValue() {
        return shortValue;
    }

    /**
     * Set the value of shortValue.
     * @param shortValue the shortValue to set
     */
    public void setShortValue(Short shortValue) {
        this.shortValue = shortValue;
    }
}
