package scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion;

/**
 * Number search criterion for Double.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class DoubleSearchCriterionModel extends NumberSearchCriterionModel<Double> {

    private static final long serialVersionUID = -8436740563231579807L;

    /**
     * Constructor.
     */
    public DoubleSearchCriterionModel() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public DoubleSearchCriterionModel(NumberOperator operator) {
        super(operator);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public DoubleSearchCriterionModel(NumberOperator operator, Double value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public DoubleSearchCriterionModel(NumberOperator operator, Double value, Double secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }
}
