package scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.operatorButton;

import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * Icon for search operator.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public enum IconType implements Style {

    /** equals. */
    EQUALS("equals"),
    /** different. */
    DIFFERENT("different"),
    /** starts with. */
    STARTS_WITH("starts-with"),
    /** ends width. */
    ENDS_WITH("ends-width"),
    /** not starts with. */
    NOT_STARTS_WITH("not-starts-with"),
    /** not ends with. */
    NOT_ENDS_WITH("not-ends-with"),
    /** contains. */
    CONTAINS("contains"),
    /** not contains. */
    NOT_CONTAINS("not-contains"),
    /** is null. */
    IS_NULL("is-null"),
    /** is not null. */
    IS_NOT_NULL("is-not-null"),
    /** greater than or equal. */
    GREATER_THAN_OR_EQUAL("greater-than-or-equal"),
    /** less than or equal. */
    LESS_THAN_OR_EQUAL("less-than-or-equal"),
    /** less than. */
    LESS_THAN("less-than"),
    /** greather than. */
    GREATER_THAN("greather-than"),
    /** between. */
    BETWEEN("between"),
    /** not between. */
    NOT_BETWEEN("not-between"),
    /** strictly between. */
    STRICTLY_BETWEEN("strictly-between"),
    /** strictly not between. */
    STRICTLY_NOT_BETWEEN("strictly-not-between");

    private static final String PREFIX = "icon-incubator-";

    private String className;

    private IconType(String className) {
        this.className = className;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String get() {
        return PREFIX + className;
    }
}
