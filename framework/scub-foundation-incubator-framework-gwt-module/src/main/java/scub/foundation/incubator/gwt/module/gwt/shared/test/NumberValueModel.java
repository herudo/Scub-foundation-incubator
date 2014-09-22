package scub.foundation.incubator.gwt.module.gwt.shared.test;

import java.io.Serializable;

/**
 * Dto for number value service.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class NumberValueModel implements Serializable {

    private static final long serialVersionUID = 1784512010464L;

    private Integer intValue;

    private Double doubleValue;

    private Float floatValue;

    private Long longValue;

    private Short shortValue;

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

    @Override
    public String toString() {
        return "NumberValueDto [intValue=" + intValue + ", doubleValue=" + doubleValue + ", floatValue=" + floatValue + ", longValue=" + longValue
            + ", shortValue=" + shortValue + "]";
    }
}
