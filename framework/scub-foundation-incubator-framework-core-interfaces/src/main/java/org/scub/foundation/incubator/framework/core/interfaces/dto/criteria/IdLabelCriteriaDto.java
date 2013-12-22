package org.scub.foundation.incubator.framework.core.interfaces.dto.criteria;

import java.io.Serializable;

import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.StringSearchCriterionDto;

/**
 * Criteria for IdLabel search.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class IdLabelCriteriaDto implements Serializable {

    private static final long serialVersionUID = -9014445268899160212L;

    private StringSearchCriterionDto label;

    /**
     * Constructor.
     */
    public IdLabelCriteriaDto() {
    }

    /**
     * Constructor.
     * @param label the label search criterion.
     */
    public IdLabelCriteriaDto(StringSearchCriterionDto label) {
        this.label = label;
    }

    /**
     * Get the value of label.
     * @return the label
     */
    public StringSearchCriterionDto getLabel() {
        return label;
    }

    /**
     * Set the value of label.
     * @param label the label to set
     */
    public void setLabel(StringSearchCriterionDto label) {
        this.label = label;
    }
}
