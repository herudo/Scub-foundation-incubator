package scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion;

/**
 * Number search criterion for Short.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class ShortSearchCriterionModel extends NumberSearchCriterionModel<Short> {

    private static final long serialVersionUID = -8436740563231579807L;

    /**
     * Constructor.
     */
    public ShortSearchCriterionModel() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public ShortSearchCriterionModel(NumberOperator operator) {
        super(operator);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public ShortSearchCriterionModel(NumberOperator operator, Short value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public ShortSearchCriterionModel(NumberOperator operator, Short value, Short secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }
}
