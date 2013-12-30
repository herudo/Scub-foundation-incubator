package org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Value for the date search criterion.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class DateSearchCriterionValueDto implements Serializable {

    private static final long serialVersionUID = 2100975620056933936L;

    private Date value;

    /** used to make search whith hours or not. */
    private boolean ignoreHours = false;

    /**
     * Constructor.
     * @param value the value
     */
    public DateSearchCriterionValueDto(Date value) {
        this(value, false);
    }

    /**
     * Constructor.
     * @param value the value
     * @param ignoreHours search with hours or not.
     */
    public DateSearchCriterionValueDto(Date value, boolean ignoreHours) {
        super();
        this.value = value;
        this.ignoreHours = ignoreHours;
    }

    /**
     * Constructor.
     * @param value the value
     */
    public DateSearchCriterionValueDto(Calendar value) {
        super();
        if (value != null) {
            this.value = value.getTime();
        }
    }

    /**
     * Constructor.
     * @param value the value
     * @param ignoreHours search with hours or not.
     */
    public DateSearchCriterionValueDto(Calendar value, boolean ignoreHours) {
        super();
        if (value != null) {
            this.value = value.getTime();
        }
        this.ignoreHours = ignoreHours;
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

    /**
     * Get the value of ignoreHours.
     * @return the ignoreHours
     */
    public boolean isIgnoreHours() {
        return ignoreHours;
    }

    /**
     * Set the value of ignoreHours.
     * @param ignoreHours the ignoreHours to set
     */
    public void setIgnoreHours(boolean ignoreHours) {
        this.ignoreHours = ignoreHours;
    }

    @Override
    public String toString() {
        return "DateSearchCriterionValueDto [value=" + value + ", ignoreHours=" + ignoreHours + "]";
    }
}
