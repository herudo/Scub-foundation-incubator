package scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.handlers;

import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.StringSearchCriterionModel;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * The handler for the string search criterion components.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface HasStringSearchCriterion extends HasSearchCriterion<StringSearchCriterionModel, StringSearchCriterionModel.StringOperator, String> {

    /**
     * Clear the search criterion.
     */
    void clear();

    /**
     * Get the value of caseSensitive.
     * @return the caseSensitive
     */
    boolean isCaseSensitive();

    /**
     * Set the value of caseSensitive.
     * @param caseSensitive the caseSensitive to set
     */
    void setCaseSensitive(boolean caseSensitive);

    /**
     * Adds a {@link ValueChangeEvent} handler.
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addCaseSensitiveChangeHandler(ValueChangeHandler<Boolean> handler);

    /**
     * Get the value of defaultCaseSensitive.
     * @return the defaultCaseSensitive
     */
    boolean isDefaultCaseSensitive();

    /**
     * Set the value of defaultCaseSensitive.
     * @param defaultCaseSensitive the defaultCaseSensitive to set
     */
    void setDefaultCaseSensitive(boolean defaultCaseSensitive);

    /**
     * Show/Hide the case sensitive option.
     * @param visible true = visible, false = hidden.
     */
    void setCaseSensitiveOptionvisible(boolean visible);
}
