package org.scub.foundation.incubator.framework.core.implementations.searchCriterion;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.AbstractSearchCriterionDto;

/**
 * Search criterion for hibernate dao utilisation.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 * @param <C> the search criterion dto type.
 * @param <T> the search criterion value type.
 * @param <O> the serarch criterion operator type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractHibernateSearchCriterion<C extends AbstractSearchCriterionDto<T, O>, T, O> extends AbstractSearchCriterion<C, T, O> {

    /** the hql parameter name. */
    protected String hqlParameterName;

    /** the logger. */
    protected Logger logger = Logger.getLogger(AbstractHibernateSearchCriterion.class);

    /** the equals character. */
    protected static final String EQUALS = "=";

    /** the space character. */
    protected static final String SPACE = " ";

    /** the : character. */
    protected static final String DOUBLE_POINTS = ":";

    /** the different operator. */
    protected static final String DIFFERENT = "!=";

    /** the is null operator. */
    protected static final String IS_NULL = "IS NULL";

    /** the is not null operator. */
    protected static final String IS_NOT_NULL = "IS NOT NULL";

    /** the AND operator. */
    protected static final String AND = "AND";

    /** the OR operator. */
    protected static final String OR = "OR";

    /**
     * Constructor.
     * @param searchCriterion the search criterion.
     */
    public AbstractHibernateSearchCriterion(C searchCriterion) {
        super(searchCriterion);
    }

    /**
     * construction the HQL condition (the left part of a WHERE condition with the condition operator).
     * @param hqlQuery the hql query.
     * @param columnName the column name.
     */
    public abstract void constructHQLCondition(StringBuffer hqlQuery, String columnName);

    /**
     * Set the condition value (right part of a WHERE condition).
     * @param query The hibernate query
     */
    public abstract void setConditionValue(Query query);

    /**
     * get the hql columnName.
     * @param columnName the base column name to use.
     * @return the correct columne name
     */
    protected String getHqlColumnName(String columnName) {
        return SPACE + columnName + SPACE;
    }

    /**
     * Process basic validations for a search criterion.
     * @return true if the search crtierion seems to be valide. false otherwise.
     */
    protected boolean validateSearchCriterion() {
        if (searchCriterion != null) {
            if (searchCriterion.getOperator() != null) {
                return true;
            } else {
                logger.warn("The operator of the given search criterion is null.");
            }
        } else {
            logger.warn("The given search criterion is null.");
        }
        return false;
    }

    /**
     * test if the hqlQuery is not null and if he columnName is given.
     * @param hqlQuery the quel query to test
     * @param columnName the column Name to test
     * @return true if ok, false otherwise
     */
    protected boolean validateHqlPreConditions(StringBuffer hqlQuery, String columnName) {
        if (hqlQuery != null) {
            if (StringUtils.isNotBlank(columnName)) {
                if (StringUtils.isNotBlank(hqlParameterName)) {
                    return validateSearchCriterion();
                } else {
                    logger.warn("The given hql parameter name is empty.");
                }
            } else {
                logger.warn("The given column name is empty.");
            }
        } else {
            logger.warn("The given query is null.");
        }
        return false;
    }

    /**
     * Get the value of hqlParameterName.
     * @return the hqlParameterName
     */
    public String getHqlParameterName() {
        return hqlParameterName;
    }

    /**
     * Set the value of hqlParameterName.
     * @param hqlParameterName the hqlParameterName to set
     */
    public void setHqlParameterName(String hqlParameterName) {
        this.hqlParameterName = hqlParameterName;
    }
}
