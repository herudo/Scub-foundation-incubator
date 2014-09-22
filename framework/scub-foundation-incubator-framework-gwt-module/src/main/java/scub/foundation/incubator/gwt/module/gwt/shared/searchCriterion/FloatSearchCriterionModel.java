package scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion;

/**
 * Number search criterion for Float.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class FloatSearchCriterionModel extends NumberSearchCriterionModel<Float> {

    private static final long serialVersionUID = -8436740563231579807L;

    /**
     * Constructor.
     */
    public FloatSearchCriterionModel() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public FloatSearchCriterionModel(NumberOperator operator) {
        super(operator);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public FloatSearchCriterionModel(NumberOperator operator, Float value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public FloatSearchCriterionModel(NumberOperator operator, Float value, Float secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }
}
