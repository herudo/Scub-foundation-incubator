package scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Value for the date search criterion.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class DateSearchCriterionValueModel implements Serializable {

    private static final long serialVersionUID = 2100975620056933936L;

    private Date value;

    /** used to make search whith hours or not. */
    private boolean ignoreTime = false;

    /**
     * Constructor.
     * @param value the value
     */
    public DateSearchCriterionValueModel(Date value) {
        this(value, false);
    }

    /**
     * Constructor.
     * @param value the value
     * @param ignoreTime search with hours or not.
     */
    public DateSearchCriterionValueModel(Date value, boolean ignoreTime) {
        super();
        this.value = value;
        this.ignoreTime = ignoreTime;
    }

    /**
     * Constructor.
     * @param value the value
     */
    public DateSearchCriterionValueModel(Calendar value) {
        super();
        if (value != null) {
            this.value = value.getTime();
        }
    }

    /**
     * Constructor.
     * @param value the value
     * @param ignoreTime search with hours or not.
     */
    public DateSearchCriterionValueModel(Calendar value, boolean ignoreTime) {
        super();
        if (value != null) {
            this.value = value.getTime();
        }
        this.ignoreTime = ignoreTime;
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
     * Get the value of ignoreTime.
     * @return the ignoreTime
     */
    public boolean isIgnoreTime() {
        return ignoreTime;
    }

    /**
     * Set the value of ignoreTime.
     * @param ignoreTime the ignoreTime to set
     */
    public void setIgnoreTime(boolean ignoreTime) {
        this.ignoreTime = ignoreTime;
    }

    @Override
    public String toString() {
        return "DateSearchCriterionValueDto [value=" + value + ", ignoreTime=" + ignoreTime + "]";
    }
}
