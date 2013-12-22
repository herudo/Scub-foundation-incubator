package scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion;

/**
 * A search crtierion for string searchs.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class StringSearchCriterionModel extends AbstractSearchCriterionModel<String, StringSearchCriterionModel.StringOperator> {

    private static final long serialVersionUID = 7450337063916477787L;
    private boolean caseSensitive;

    /**
     * Constructor.
     */
    public StringSearchCriterionModel() {
        this(StringOperator.CONTAINS, "");
    }

    /**
     * Constructor with default operator StringOperator.CONTAINS.
     * @param value the value
     */
    public StringSearchCriterionModel(String value) {
        this(StringOperator.CONTAINS, value);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     */
    public StringSearchCriterionModel(StringOperator operator, String value) {
        this(operator, value, true);
    }

    /**
     * Constructor.
     * @param operator the operator
     * @param value the value
     * @param caseSensitive the case sensitive value.
     */
    public StringSearchCriterionModel(StringOperator operator, String value, boolean caseSensitive) {
        this.operator = operator;
        this.value = value;
        this.caseSensitive = caseSensitive;
    }

    /**
     * The operators list for string search cirterion.
     * @author Adrien HAUTOT (contact@adrienhautot.fr)
     */
    public enum StringOperator {
        /** search for value stricktly equals. */
        EQUALS, //
        /** search for value differents. */
        DIFFERENTS, //
        /** search for value that starts with. */
        STARTS_WITH, //
        /** search for value that ends with. */
        ENDS_WITH, //
        /** search for value that not starts with. */
        NOT_STARTS_WITH, //
        /** search for value that not ends with. */
        NOT_ENDS_WITH, //
        /** search for value that contains. */
        CONTAINS, //
        /** search for value that not contains. */
        NOT_CONTAINS, //
        /** search for null value. */
        IS_NULL,
        /** search for a not null value. */
        IS_NOT_NULL
    }

    /**
     * Get the value of caseSensitive.
     * @return the caseSensitive
     */
    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    /**
     * Set the value of caseSensitive.
     * @param caseSensitive the caseSensitive to set
     */
    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }
}
