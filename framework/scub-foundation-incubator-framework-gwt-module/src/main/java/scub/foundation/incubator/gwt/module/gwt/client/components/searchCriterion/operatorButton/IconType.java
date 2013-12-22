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
    /** different. */
    ENDS_WITH("ends-width"),
    /** different. */
    NOT_STARTS_WITH("not-starts-with"),
    /** different. */
    NOT_ENDS_WITH("not-ends-with"),
    /** different. */
    CONTAINS("contains"),
    /** different. */
    NOT_CONTAINS("not-contains"),
    /** different. */
    IS_NULL("is-null"),
    /** different. */
    IS_NOT_NULL("is-not-null");

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
