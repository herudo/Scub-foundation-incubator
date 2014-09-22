package scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion;

/**
 * Number search criterion for Integer.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class IntegerSearchCriterionModel extends NumberSearchCriterionModel<Integer> {

    private static final long serialVersionUID = -8436740563231579807L;

    /**
     * Constructor.
     */
    public IntegerSearchCriterionModel() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public IntegerSearchCriterionModel(NumberOperator operator) {
        super(operator);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public IntegerSearchCriterionModel(NumberOperator operator, Integer value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public IntegerSearchCriterionModel(NumberOperator operator, Integer value, Integer secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }
}
