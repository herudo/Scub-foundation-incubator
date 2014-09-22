package scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion;

import scub.foundation.incubator.gwt.module.gwt.client.components.box.IntegerBox;
import scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.handlers.HasIntegerSearchCriterion;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.IntegerSearchCriterionModel;

/**
 * Integer search criterion box.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class IntegerSearchCriterionBox extends NumberSearchCriterionBox<Integer, IntegerSearchCriterionModel> implements HasIntegerSearchCriterion {

    public IntegerSearchCriterionBox() {
        super();
    }

    @SuppressWarnings("unchecked")
    @Override
    public IntegerBox getBox() {
        return new IntegerBox();
    }

    @SuppressWarnings("unchecked")
    @Override
    public IntegerBox getSecondBox() {
        return new IntegerBox();
    }

    @Override
    public IntegerSearchCriterionModel createSearchCriterionInstance() {
        return new IntegerSearchCriterionModel();
    }

}
