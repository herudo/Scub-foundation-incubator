package org.scub.foundation.incubator.framework.core.implementations.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.scub.foundation.framework.core.model.BaseModel;

/**
 * A type to test date search criterion.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
@Entity
@Table(name = "DATE_VALUE")
public class DateValue extends BaseModel {

    private static final long serialVersionUID = -1122283604803427478L;

    @Column(name = "VALUE")
    private Date value;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return equalsUtil(other);
    }

    /**
     * Get the value of value.
     * @return the value
     */
    public Date getValue() {
        return value;
    }

    /**
     * Set the value of value.
     * @param value the value to set
     */
    public void setValue(Date value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DateValue [value=" + value + "]";
    }
}
