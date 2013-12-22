package org.scub.foundation.incubator.framework.core.implementations.searchCriterion;

import org.hibernate.Query;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.StringSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.StringSearchCriterionDto.StringOperator;

/**
 * Implementation of th string search crierion for hibernate.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class HibernateStringSearchCriterion
    extends AbstractHibernateSearchCriterion<StringSearchCriterionDto, String, StringSearchCriterionDto.StringOperator> {

    /** the like operator. */
    private static final String LIKE = "LIKE";

    /** the "not" word. */
    private static final String NOT = "NOT";

    /** the "%" character. */
    private static final String PERCENT = "%";

    /**
     * Constructor.
     * @param searchCriterion the search searchCriterion.
     */
    public HibernateStringSearchCriterion(StringSearchCriterionDto searchCriterion) {
        super(searchCriterion);
    }

    @Override
    public void constructHQLCondition(StringBuffer hqlQuery, String columnName) {
        if (validateHqlPreConditions(hqlQuery, columnName)) {
            String queryPart = getHqlColumnName(columnName);
            queryPart += SPACE;
            queryPart += getHqlOperator();
            if (searchCriterion != null && !searchCriterion.getOperator().equals(StringOperator.IS_NOT_NULL)
                && !searchCriterion.getOperator().equals(StringOperator.IS_NULL)) {
                queryPart += SPACE;
                queryPart += DOUBLE_POINTS;
                queryPart += hqlParameterName;
            }

            if (logger.isDebugEnabled()) {
                logger.debug("Generated query part : " + queryPart);
            }

            hqlQuery.append(queryPart);
        }
    }

    @Override
    public void setConditionValue(Query query) {
        if (query != null) {
            if (searchCriterion != null) {
                String conditionValue = null;
                if (!searchCriterion.getOperator().equals(StringOperator.IS_NOT_NULL) && !searchCriterion.getOperator().equals(StringOperator.IS_NULL)) {
                    conditionValue = getCaseSensitiveValue();
                }

                switch (searchCriterion.getOperator()) {
                case STARTS_WITH:
                    conditionValue = conditionValue + PERCENT;
                    break;
                case ENDS_WITH:
                    conditionValue = PERCENT + conditionValue;
                    break;
                case CONTAINS:
                    conditionValue = PERCENT + conditionValue + PERCENT;
                    break;
                case NOT_ENDS_WITH:
                    conditionValue = PERCENT + conditionValue;
                    break;
                case NOT_STARTS_WITH:
                    conditionValue = conditionValue + PERCENT;
                    break;
                case NOT_CONTAINS:
                    conditionValue = PERCENT + conditionValue + PERCENT;
                    break;
                default:
                    logger.fatal("Unknown operator.");
                    break;
                }
                if (logger.isDebugEnabled()) {
                    logger.debug("Condition value for " + hqlParameterName + " : " + conditionValue);
                }

                if (conditionValue != null) {
                    query.setString(hqlParameterName, conditionValue);
                }
            }
        } else {
            logger.warn("The given hibernate query is empty");
        }
    }

    /**
     * get the hql columnName (add a lower if the search is case insensitive).
     * @param columnName the base column name to use.
     * @return the correct columne name
     */
    private String getHqlColumnName(String columnName) {
        if (searchCriterion != null) {
            if (!searchCriterion.getOperator().equals(StringOperator.IS_NULL) && !searchCriterion.getOperator().equals(StringOperator.IS_NOT_NULL)) {
                if (!searchCriterion.isCaseSensitive()) {
                    return " lower(" + columnName + ") ";
                }
            }
        }
        return SPACE + columnName + SPACE;
    }

    /**
     * Get the operator for the hql condition.
     * @return the operator.
     */
    private String getHqlOperator() {
        // determine the operator
        String operator = null;
        if (searchCriterion != null) {
            switch (searchCriterion.getOperator()) {
            case EQUALS:
                operator = EQUALS;
                break;
            case DIFFERENTS:
                operator = DIFFERENT;
                break;
            case STARTS_WITH:
                operator = LIKE;
                break;
            case ENDS_WITH:
                operator = LIKE;
                break;
            case CONTAINS:
                operator = LIKE;
                break;
            case NOT_ENDS_WITH:
                operator = NOT + SPACE + LIKE;
                break;
            case NOT_STARTS_WITH:
                operator = NOT + SPACE + LIKE;
                break;
            case NOT_CONTAINS:
                operator = NOT + SPACE + LIKE;
                break;
            case IS_NULL:
                operator = IS_NULL;
                break;
            case IS_NOT_NULL:
                operator = IS_NOT_NULL;
                break;
            default:
                logger.fatal("Unknown operator.");
                break;
            }
        }
        return operator;
    }

    /**
     * Get the correct value for the search according to the case sensitive specification in search criterion.
     * @return the correct value.
     */
    private String getCaseSensitiveValue() {
        if (searchCriterion != null) {
            if (searchCriterion.isCaseSensitive()) {
                return searchCriterion.getValue();
            } else {
                if (searchCriterion.getValue() != null) {
                    return searchCriterion.getValue().toLowerCase();
                } else {
                    logger.warn("The search criterion value is null.");
                }
            }
        }
        return null;
    }
}
