package scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.handlers;

import scub.foundation.incubator.gwt.module.gwt.client.components.handlers.HasSecondValue;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.AbstractSearchCriterionModel;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.NumberSearchCriterionModel;

/**
 * The handler for the string search criterion components.
 * @param <Type> the value type.
 * @param <SearchCriterionType> the search criterion type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface HasNumberSearchCriterion<Type extends Number, SearchCriterionType extends AbstractSearchCriterionModel<Type, NumberSearchCriterionModel.NumberOperator>>
        extends HasSearchCriterion<SearchCriterionType, NumberSearchCriterionModel.NumberOperator, Type>, HasSecondValue<Type> {

    /**
     * Clear the search criterion.
     */
    void clear();
}
