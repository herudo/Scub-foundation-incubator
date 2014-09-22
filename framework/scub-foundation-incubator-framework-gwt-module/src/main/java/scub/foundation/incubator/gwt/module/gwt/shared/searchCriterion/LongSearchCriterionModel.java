package scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion;

/**
 * Number search criterion for Long.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class LongSearchCriterionModel extends NumberSearchCriterionModel<Long> {

    private static final long serialVersionUID = -8436740563231579807L;

    /**
     * Constructor.
     */
    public LongSearchCriterionModel() {
        super();
    }

    /**
     * Constructor.
     * @param operator the operator
     */
    public LongSearchCriterionModel(NumberOperator operator) {
        super(operator);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public LongSearchCriterionModel(NumberOperator operator, Long value) {
        super(operator, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param secondValue the second value
     */
    public LongSearchCriterionModel(NumberOperator operator, Long value, Long secondValue) {
        super(operator, value);
        setSecondValue(secondValue);
    }
}
