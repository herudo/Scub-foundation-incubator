package org.scub.foundation.incubator.framework.core.implementations.searchCriterion;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Query;
import org.scub.foundation.incubator.framework.base.utils.DateUtils;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DateSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DateSearchCriterionDto.DateOperator;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DateSearchCriterionValueDto;

/**
 * Implementation of the date search crierion for hibernate.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class HibernateDateSearchCriterion extends
        AbstractHibernateSearchCriterion<DateSearchCriterionDto, DateSearchCriterionValueDto, DateSearchCriterionDto.DateOperator> {

    private static final String GREATER_THAN = ">";

    private static final String LOWER_THAN = "<";

    private static final String GREATER_THAN_OR_EQUAL = ">=";

    private static final String LOWER_THAN_OR_EQUAL = "<=";

    /**
     * Constructor.
     * @param searchCriterion the search searchCriterion.
     */
    public HibernateDateSearchCriterion(DateSearchCriterionDto searchCriterion) {
        super(searchCriterion);
    }

    @Override
    public void constructHQLCondition(StringBuffer hqlQuery, String columnName) {
        if (validateHqlPreConditions(hqlQuery, columnName)) {
            if (searchCriterion != null && searchCriterion.getOperator() != null) {
                String queryPart = getHqlColumnName(columnName);
                queryPart += SPACE;

                // set the first operator.
                if (searchCriterion.getValue() != null && searchCriterion.getValue().getValue() != null) {
                    switch (searchCriterion.getOperator()) {
                    case BETWEEN:
                        queryPart += constructBetweenQuery(GREATER_THAN_OR_EQUAL, LOWER_THAN_OR_EQUAL, columnName, AND);
                        break;
                    case NOT_BETWEEN:
                        queryPart += constructBetweenQuery(LOWER_THAN_OR_EQUAL, GREATER_THAN_OR_EQUAL, columnName, OR);
                        break;
                    case STRICTLY_BETWEEN:
                        queryPart += constructBetweenQuery(GREATER_THAN, LOWER_THAN, columnName, AND);
                        break;
                    case STRICTLY_NOT_BETWEEN:
                        queryPart += constructBetweenQuery(LOWER_THAN, GREATER_THAN, columnName, OR);
                        break;
                    case IS_NULL:
                        queryPart += getHqlOperator();
                        break;
                    case IS_NOT_NULL:
                        queryPart += getHqlOperator();
                        break;
                    case EQUALS:
                        if (searchCriterion.getValue().isIgnoreTime()) {
                            queryPart += constructBetweenQuery(GREATER_THAN_OR_EQUAL, LOWER_THAN_OR_EQUAL, columnName, AND);
                        } else {
                            queryPart += constructNormalQuery();
                        }
                        break;
                    case GREATER_THAN:
                        queryPart += constructNormalQuery();
                        break;
                    case GREATER_THAN_OR_EQUAL:
                        queryPart += constructNormalQuery();
                        break;
                    case LESS_THAN:
                        queryPart += constructNormalQuery();
                        break;
                    case LESS_THAN_OR_EQUAL:
                        queryPart += constructNormalQuery();
                        break;
                    case DIFFERENTS:
                        if (searchCriterion.getValue().isIgnoreTime()) {
                            queryPart += constructBetweenQuery(LOWER_THAN_OR_EQUAL, GREATER_THAN_OR_EQUAL, columnName, OR);
                        } else {
                            queryPart += constructNormalQuery();
                        }
                        break;

                    default:
                        break;

                    }
                } else {
                    if (!searchCriterion.getOperator().equals(DateOperator.IS_NULL) && !searchCriterion.getOperator().equals(DateOperator.IS_NOT_NULL)) {
                        logger.info("The value is null, use the is null operator instead of the given.");
                        queryPart += IS_NULL;
                    } else {
                        queryPart += getHqlOperator();
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
     * Construct query part for normal query.
     * @return the query part.
     */
    private String constructNormalQuery() {
        String queryPart = getHqlOperator();
        queryPart += SPACE;
        queryPart += DOUBLE_POINTS;
        queryPart += hqlParameterName;

        return queryPart;
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
        queryPart += getMinBoundary();

        queryPart += SPACE;
        queryPart += glueOperator;
        queryPart += SPACE;

        queryPart += getHqlColumnName(columnName);
        queryPart += secondOperator;
        queryPart += SPACE;
        queryPart += DOUBLE_POINTS;
        queryPart += getMaxBoundary();

        return queryPart;
    }

    @Override
    public void setConditionValue(Query query) {
        if (query != null) {
            if (searchCriterion != null && searchCriterion.getOperator() != null) {
                if (!searchCriterion.getOperator().equals(DateOperator.IS_NOT_NULL) && !searchCriterion.getOperator().equals(DateOperator.IS_NULL)) {
                    if (searchCriterion.getValue() != null && searchCriterion.getValue().getValue() != null) {
                        switch (searchCriterion.getOperator()) {
                        case EQUALS:
                            if (searchCriterion.getValue().isIgnoreTime()) {
                                final Calendar minBoundaryValue = DateUtils.getBeginningOfTheDay(searchCriterion.getValue().getValue());
                                final Calendar maxBoundaryValue = DateUtils.getEndOfTheDay(searchCriterion.getValue().getValue());
                                setBetweenCondition(query, hqlParameterName, minBoundaryValue, maxBoundaryValue);
                            } else {
                                setUniqueCondition(query, hqlParameterName, searchCriterion.getValue().getValue());
                            }
                            break;
                        case BETWEEN:
                            setBetweenCondition(BoundaryType.BEGINNING, BoundaryType.END, query);
                            break;
                        case NOT_BETWEEN:
                            setBetweenCondition(BoundaryType.BEGINNING, BoundaryType.END, query);
                            break;
                        case STRICTLY_BETWEEN:
                            setBetweenCondition(BoundaryType.END, BoundaryType.BEGINNING, query);
                            break;
                        case STRICTLY_NOT_BETWEEN:
                            setBetweenCondition(BoundaryType.BEGINNING, BoundaryType.END, query);
                            break;
                        case DIFFERENTS:
                            if (searchCriterion.getValue().isIgnoreTime()) {
                                final Calendar minBoundaryValue = DateUtils.getBeginningOfTheDay(searchCriterion.getValue().getValue());
                                final Calendar maxBoundaryValue = DateUtils.getEndOfTheDay(searchCriterion.getValue().getValue());
                                setBetweenCondition(query, hqlParameterName, minBoundaryValue, maxBoundaryValue);
                            } else {
                                setUniqueCondition(query, hqlParameterName, searchCriterion.getValue().getValue());
                            }
                            break;
                        case LESS_THAN:
                            if (searchCriterion.getValue().isIgnoreTime()) {
                                setUniqueCondition(query, hqlParameterName, DateUtils.getBeginningOfTheDay(searchCriterion.getValue().getValue()));
                            } else {
                                setUniqueCondition(query, hqlParameterName, searchCriterion.getValue().getValue());
                            }
                            break;
                        case LESS_THAN_OR_EQUAL:
                            if (searchCriterion.getValue().isIgnoreTime()) {
                                setUniqueCondition(query, hqlParameterName, DateUtils.getEndOfTheDay(searchCriterion.getValue().getValue()));
                            } else {
                                setUniqueCondition(query, hqlParameterName, searchCriterion.getValue().getValue());
                            }
                            break;
                        case GREATER_THAN:
                            if (searchCriterion.getValue().isIgnoreTime()) {
                                setUniqueCondition(query, hqlParameterName, DateUtils.getEndOfTheDay(searchCriterion.getValue().getValue()));
                            } else {
                                setUniqueCondition(query, hqlParameterName, searchCriterion.getValue().getValue());
                            }
                            break;
                        case GREATER_THAN_OR_EQUAL:
                            if (searchCriterion.getValue().isIgnoreTime()) {
                                setUniqueCondition(query, hqlParameterName, DateUtils.getBeginningOfTheDay(searchCriterion.getValue().getValue()));
                            } else {
                                setUniqueCondition(query, hqlParameterName, searchCriterion.getValue().getValue());
                            }
                            break;
                        default:
                            break;
                        }

                    }
                }
            }
        } else {
            logger.warn("The given hibernate query is empty");
        }
    }

    private void setBetweenCondition(BoundaryType minBoundary, BoundaryType maxBoundary, Query query) {
        Calendar firstValue = Calendar.getInstance();
        firstValue.clear();
        firstValue.setTime(searchCriterion.getValue().getValue());
        if (searchCriterion.getValue().isIgnoreTime() && minBoundary != null) {
            if (minBoundary.equals(BoundaryType.BEGINNING)) {
                firstValue = DateUtils.getBeginningOfTheDay(searchCriterion.getValue().getValue());
            } else if (minBoundary.equals(BoundaryType.END)) {
                firstValue = DateUtils.getEndOfTheDay(searchCriterion.getValue().getValue());
            }
        }
        setUniqueCondition(query, getMinBoundary(), firstValue);

        if (searchCriterion.getSecondValue() != null && searchCriterion.getSecondValue().getValue() != null) {
            Calendar secondValue = Calendar.getInstance();
            secondValue.clear();
            secondValue.setTime(searchCriterion.getSecondValue().getValue());
            if (searchCriterion.getSecondValue().isIgnoreTime() && maxBoundary != null) {
                if (maxBoundary.equals(BoundaryType.BEGINNING)) {
                    secondValue = DateUtils.getBeginningOfTheDay(searchCriterion.getSecondValue().getValue());
                } else if (maxBoundary.equals(BoundaryType.END)) {
                    secondValue = DateUtils.getEndOfTheDay(searchCriterion.getSecondValue().getValue());
                }
            }

            setUniqueCondition(query, getMaxBoundary(), secondValue);
        } else {
            logger.error("The second value is not set.");
        }

    }

    private String getMaxBoundary() {
        return hqlParameterName + "MaxBoundary";
    }

    private String getMinBoundary() {
        return hqlParameterName + "MinBoundary";
    }

    private void setUniqueCondition(Query query, String parameterName, Date value) {
        if (logger.isDebugEnabled()) {
            logger.debug("Condition value for " + parameterName + " : " + value);
        }

        setQueryParam(query, parameterName, value);
    }

    private void setUniqueCondition(Query query, String parameterName, Calendar value) {
        if (value != null) {
            setUniqueCondition(query, parameterName, value.getTime());
        }
    }

    private void setBetweenCondition(Query query, String parameterName, Date minBoundaryValue, Date maxBoundaryValue) {
        if (logger.isDebugEnabled()) {
            logger.debug("Condition value for " + parameterName + "MinBoundary : " + minBoundaryValue);
            logger.debug("Condition value for " + parameterName + "MaxBoundary : " + maxBoundaryValue);
        }

        setQueryParam(query, parameterName + "MinBoundary", minBoundaryValue);
        setQueryParam(query, parameterName + "MaxBoundary", maxBoundaryValue);
    }

    private void setBetweenCondition(Query query, String parameterName, Calendar minBoundaryValue, Calendar maxBoundaryValue) {
        if (minBoundaryValue != null && maxBoundaryValue != null) {
            setBetweenCondition(query, parameterName, minBoundaryValue.getTime(), maxBoundaryValue.getTime());
        }
    }

    /**
     * Set a query param.
     * @param query the query to set the param.
     * @param parameterName the parameter name.
     * @param value the value.
     */
    public void setQueryParam(Query query, String parameterName, Date value) {
        if (query != null && value != null) {
            query.setDate(parameterName, value);
        }
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
            case GREATER_THAN_OR_EQUAL:
                operator = GREATER_THAN_OR_EQUAL;
                break;
            case LESS_THAN_OR_EQUAL:
                operator = LOWER_THAN_OR_EQUAL;
                break;
            case GREATER_THAN:
                operator = GREATER_THAN;
                break;
            case LESS_THAN:
                operator = LOWER_THAN;
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

    private enum BoundaryType {
        /** beginning of the day. */
        BEGINNING,
        /** end of the day. */
        END
    }
}
