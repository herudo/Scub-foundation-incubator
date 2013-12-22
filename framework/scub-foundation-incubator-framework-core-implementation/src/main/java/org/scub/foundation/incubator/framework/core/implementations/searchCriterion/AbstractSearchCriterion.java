package org.scub.foundation.incubator.framework.core.implementations.searchCriterion;

import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.AbstractSearchCriterionDto;

/**
 * Search criterion for dao utilisation.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 * @param <C> the search criterion dto type.
 * @param <T> the search criterion value type.
 * @param <O> the serarch criterion operator type.
 */
public abstract class AbstractSearchCriterion<C extends AbstractSearchCriterionDto<T, O>, T, O> {

    /** the serach criterion. */
    protected C searchCriterion;

    /**
     * Constructor.
     * @param searchCriterion the searchCriterion
     */
    public AbstractSearchCriterion(C searchCriterion) {
        this.searchCriterion = searchCriterion;
    }

    /**
     * Get the value of searchCriterion.
     * @return the searchCriterion
     */
    public C getSearchCriterion() {
        return searchCriterion;
    }

    /**
     * Set the value of searchCriterion.
     * @param searchCriterion the searchCriterion to set
     */
    public void setSearchCriterion(C searchCriterion) {
        this.searchCriterion = searchCriterion;
    }
}
