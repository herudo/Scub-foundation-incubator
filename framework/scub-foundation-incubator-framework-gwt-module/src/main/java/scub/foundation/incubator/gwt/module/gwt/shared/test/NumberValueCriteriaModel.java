package scub.foundation.incubator.gwt.module.gwt.shared.test;

import java.io.Serializable;

import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.DoubleSearchCriterionModel;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.FloatSearchCriterionModel;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.IntegerSearchCriterionModel;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.LongSearchCriterionModel;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.ShortSearchCriterionModel;

/**
 * Criteria for NumberValue service.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class NumberValueCriteriaModel implements Serializable {

    private static final long serialVersionUID = 1304447894681861846L;

    private DoubleSearchCriterionModel doubleSearchCriterion;

    private FloatSearchCriterionModel floatSearchCriterion;

    private IntegerSearchCriterionModel integerSearchCriterion;

    private ShortSearchCriterionModel shortSearchCriterion;

    private LongSearchCriterionModel logSearchCriterion;

    /**
     * Get the value of doubleSearchCriterion.
     * @return the doubleSearchCriterion
     */
    public DoubleSearchCriterionModel getDoubleSearchCriterion() {
        return doubleSearchCriterion;
    }

    /**
     * Set the value of doubleSearchCriterion.
     * @param doubleSearchCriterion the doubleSearchCriterion to set
     */
    public void setDoubleSearchCriterion(DoubleSearchCriterionModel doubleSearchCriterion) {
        this.doubleSearchCriterion = doubleSearchCriterion;
    }

    /**
     * Get the value of floatSearchCriterion.
     * @return the floatSearchCriterion
     */
    public FloatSearchCriterionModel getFloatSearchCriterion() {
        return floatSearchCriterion;
    }

    /**
     * Set the value of floatSearchCriterion.
     * @param floatSearchCriterion the floatSearchCriterion to set
     */
    public void setFloatSearchCriterion(FloatSearchCriterionModel floatSearchCriterion) {
        this.floatSearchCriterion = floatSearchCriterion;
    }

    /**
     * Get the value of integerSearchCriterion.
     * @return the integerSearchCriterion
     */
    public IntegerSearchCriterionModel getIntegerSearchCriterion() {
        return integerSearchCriterion;
    }

    /**
     * Set the value of integerSearchCriterion.
     * @param integerSearchCriterion the integerSearchCriterion to set
     */
    public void setIntegerSearchCriterion(IntegerSearchCriterionModel integerSearchCriterion) {
        this.integerSearchCriterion = integerSearchCriterion;
    }

    /**
     * Get the value of shortSearchCriterion.
     * @return the shortSearchCriterion
     */
    public ShortSearchCriterionModel getShortSearchCriterion() {
        return shortSearchCriterion;
    }

    /**
     * Set the value of shortSearchCriterion.
     * @param shortSearchCriterion the shortSearchCriterion to set
     */
    public void setShortSearchCriterion(ShortSearchCriterionModel shortSearchCriterion) {
        this.shortSearchCriterion = shortSearchCriterion;
    }

    /**
     * Get the value of logSearchCriterion.
     * @return the logSearchCriterion
     */
    public LongSearchCriterionModel getLogSearchCriterion() {
        return logSearchCriterion;
    }

    /**
     * Set the value of logSearchCriterion.
     * @param logSearchCriterion the logSearchCriterion to set
     */
    public void setLogSearchCriterion(LongSearchCriterionModel logSearchCriterion) {
        this.logSearchCriterion = logSearchCriterion;
    }

    @Override
    public String toString() {
        return "NumberValueCriteriaModel [doubleSearchCriterion=" + doubleSearchCriterion + ", floatSearchCriterion=" + floatSearchCriterion
            + ", integerSearchCriterion=" + integerSearchCriterion + ", shortSearchCriterion=" + shortSearchCriterion + ", logSearchCriterion="
            + logSearchCriterion + "]";
    }
}
