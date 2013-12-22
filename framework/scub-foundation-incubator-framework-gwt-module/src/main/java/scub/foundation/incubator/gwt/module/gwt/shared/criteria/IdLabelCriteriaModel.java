package scub.foundation.incubator.gwt.module.gwt.shared.criteria;

import java.io.Serializable;

import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.StringSearchCriterionModel;

/**
 * Criteria for idLabel.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class IdLabelCriteriaModel implements Serializable {

    private static final long serialVersionUID = 4192620647640509472L;

    private StringSearchCriterionModel label;

    /**
     * Get the value of label.
     * @return the label
     */
    public StringSearchCriterionModel getLabel() {
        return label;
    }

    /**
     * Set the value of label.
     * @param label the label to set
     */
    public void setLabel(StringSearchCriterionModel label) {
        this.label = label;
    }

}
