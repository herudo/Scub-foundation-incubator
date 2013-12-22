package org.scub.foundation.incubator.framework.core.implementations.searchCriterion;

import org.hibernate.Query;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.NumberSearchCriterionDto.NumberOperator;

/**
 * Implementation of the number search crierion for hibernate.
 * @param <NumberType> the number type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class HibernateNumberSearchCriterion<NumberType extends Number> extends
        AbstractHibernateSearchCriterion<NumberSearchCriterionDto<NumberType>, NumberType, NumberSearchCriterionDto.NumberOperator> {

    /**
     * Constructor.
     * @param searchCriterion the search searchCriterion.
     */
    public HibernateNumberSearchCriterion(NumberSearchCriterionDto<NumberType> searchCriterion) {
        super(searchCriterion);
    }

    @Override
    public void constructHQLCondition(StringBuffer hqlQuery, String columnName) {
        if (validateHqlPreConditions(hqlQuery, columnName)) {
            if (searchCriterion != null && searchCriterion.getOperator() != null) {
                String queryPart = getHqlColumnName(columnName);
                queryPart += SPACE;
                // if it's between or not between operator.
                if (searchCriterion.getOperator().equals(NumberOperator.BETWEEN)) {
                    queryPart += constructBetweenQuery(">=", "<=", columnName, AND);
                } else if (searchCriterion.getOperator().equals(NumberOperator.NOT_BETWEEN)) {
                    queryPart += constructBetweenQuery("<=", ">=", columnName, OR);
                } else if (searchCriterion.getOperator().equals(NumberOperator.STRICTLY_BETWEEN)) {
                    queryPart += constructBetweenQuery(">", "<", columnName, AND);
                } else if (searchCriterion.getOperator().equals(NumberOperator.STRICTLY_NOT_BETWEEN)) {
                    queryPart += constructBetweenQuery("<", ">", columnName, OR);
                } else {
                    // all other operators.
                    queryPart += getHqlOperator();

                    // if not null or null operator
                    if (!searchCriterion.getOperator().equals(NumberOperator.IS_NOT_NULL) && !searchCriterion.getOperator().equals(NumberOperator.IS_NULL)) {
                        queryPart += SPACE;
                        queryPart += DOUBLE_POINTS;
                        queryPart += hqlParameterName;
                    }
                }

                if (logger.isDebugEnabled()) {
                    logger.debug("Generated query part : " + queryPart);
                }

                hqlQuery.append(queryPart);
            }
        }
    }

    /**
     * construct the query part for between adn not between operator.
     * @param firstOperator the first operator
     * @param secondOperator the second operator
     * @param columnName the column name.
     * @param glueOperator the operator between two parts.
     * @return the queryp part.
     */
    private String constructBetweenQuery(String firstOperator, String secondOperator, String columnName, String glueOperator) {
        String queryPart = firstOperator;
        queryPart += SPACE;
        queryPart += DOUBLE_POINTS;
        queryPart += hqlParameterName + "minBoundary";

        queryPart += SPACE;
        queryPart += glueOperator;
        queryPart += SPACE;

        queryPart += getHqlColumnName(columnName);
        queryPart += secondOperator;
        queryPart += SPACE;
        queryPart += DOUBLE_POINTS;
        queryPart += hqlParameterName + "maxBoundary";

        return queryPart;
    }

    @Override
    public void setConditionValue(Query query) {
        if (query != null) {
            if (searchCriterion != null && searchCriterion.getOperator() != null) {
                if (!searchCriterion.getOperator().equals(NumberOperator.IS_NOT_NULL) && !searchCriterion.getOperator().equals(NumberOperator.IS_NULL)) {
                    if (searchCriterion.getOperator().equals(NumberOperator.BETWEEN) || searchCriterion.getOperator().equals(NumberOperator.NOT_BETWEEN)
                        || searchCriterion.getOperator().equals(NumberOperator.STRICTLY_BETWEEN)
                        || searchCriterion.getOperator().equals(NumberOperator.STRICTLY_NOT_BETWEEN)) {
                        final NumberType minBoundaryValue = searchCriterion.getValue();
                        final NumberType maxBoundaryValue = searchCriterion.getSecondValue();

                        if (logger.isDebugEnabled()) {
                            logger.debug("Condition value for " + hqlParameterName + "minBoundary : " + minBoundaryValue);
                            logger.debug("Condition value for " + hqlParameterName + "maxBoundary : " + maxBoundaryValue);
                        }

                        setQueryParam(query, hqlParameterName + "minBoundary", minBoundaryValue);
                        setQueryParam(query, hqlParameterName + "maxBoundary", maxBoundaryValue);
                    } else {
                        final NumberType conditionValue = searchCriterion.getValue();

                        if (logger.isDebugEnabled()) {
                            logger.debug("Condition value for " + hqlParameterName + " : " + conditionValue);
                        }

                        setQueryParam(query, hqlParameterName, conditionValue);
                    }
                }
            }
        } else {
            logger.warn("The given hibernate query is empty");
        }
    }

    /**
     * Set a query param.
     * @param query the query to set the param.
     * @param parameterName the parameter name.
     * @param value the value.
     */
    public abstract void setQueryParam(Query query, String parameterName, NumberType value);

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
            case GREATER_THAN_OR_EQUAL:
                operator = ">=";
                break;
            case LESS_THAN_OR_EQUAL:
                operator = "<=";
                break;
            case GREATER_THAN:
                operator = ">";
                break;
            case LESS_THAN:
                operator = "<";
                break;
            case IS_NULL:
                operator = IS_NULL;
                break;
            case IS_NOT_NULL:
                operator = IS_NOT_NULL;
                break;
            case BETWEEN:
                // nothings to do
                break;
            case NOT_BETWEEN:
                // nothings to do
                break;
            case STRICTLY_BETWEEN:
                // nothings to do
                break;
            case STRICTLY_NOT_BETWEEN:
                // nothings to do
                break;
            default:
                logger.fatal("Unknown operator.");
                break;
            }
        }
        return operator;
    }
}
