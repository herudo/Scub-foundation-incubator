package scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.handlers;

import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.StringSearchCriterionModel.StringOperator;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * Handler for components which have search criterion.
 * @param <SearchCriterionType> the search criterion type.
 * @param <SearchCriterionOperatorType> the search criterion operator type.
 * @param <SearchCriterionValueType> the search criterion value type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface HasSearchCriterion<SearchCriterionType, SearchCriterionOperatorType, SearchCriterionValueType> extends HasValue<SearchCriterionValueType> {

    /**
     * Get the search criterion.
     * @return the search criterion.
     */
    SearchCriterionType getSearchCriterion();

    /**
     * set the search criterion.
     * @param value the search criterion.
     */
    void setSearchCriterion(SearchCriterionType value);

    /**
     * Set the operator for the search criterion component.
     * @param operator the operator.
     */
    void setOperator(SearchCriterionOperatorType operator);

    /**
     * Get the current search criterion operator.
     * @return the search criterion operator.
     */
    SearchCriterionOperatorType getOperator();

    /**
     * Adds a {@link ValueChangeEvent} handler.
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addOperatorChangeHandler(ValueChangeHandler<SearchCriterionOperatorType> handler);

    /**
     * Get the value of defaultOperator.
     * @return the defaultOperator
     */
    StringOperator getDefaultOperator();

    /**
     * Set the value of defaultOperator.
     * @param defaultOperator the defaultOperator to set
     */
    void setDefaultOperator(StringOperator defaultOperator);

    /**
     * show/hide the operator.
     * @param visible true = visible, false = hidden.
     */
    void setOperatorVisible(boolean visible);
}
