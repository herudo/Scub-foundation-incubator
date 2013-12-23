package org.scub.foundation.incubator.framework.core.implementations.searchCriterion.query;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.scub.foundation.incubator.framework.core.implementations.searchCriterion.AbstractHibernateSearchCriterion;
import org.scub.foundation.incubator.framework.core.implementations.searchCriterion.HibernateDoubleSearchCriterion;
import org.scub.foundation.incubator.framework.core.implementations.searchCriterion.HibernateFloatSearchCriterion;
import org.scub.foundation.incubator.framework.core.implementations.searchCriterion.HibernateIntegerSearchCriterion;
import org.scub.foundation.incubator.framework.core.implementations.searchCriterion.HibernateLongSearchCriterion;
import org.scub.foundation.incubator.framework.core.implementations.searchCriterion.HibernateStringSearchCriterion;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.DoubleSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.FloatSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.IntegerSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.LongSearchCriterionDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.StringSearchCriterionDto;

/**
 * Helper to create hql query with search criterion.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class HqlQuery {

    /** the logger. */
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private StringBuffer hqlQuery;

    private List<AbstractHibernateSearchCriterion<?, ?, ?>> searchCriterions;

    /**
     * Constructor.
     */
    public HqlQuery() {
        this.hqlQuery = new StringBuffer();
    }

    /**
     * Constructor.
     * @param query the query
     */
    public HqlQuery(StringBuffer query) {
        if (query == null) {
            this.hqlQuery = new StringBuffer();
        } else {
            this.hqlQuery = query;
        }
    }

    /**
     * Constructor.
     * @param query the query
     */
    public HqlQuery(String query) {
        if (query == null) {
            this.hqlQuery = new StringBuffer();
        } else {
            this.hqlQuery = new StringBuffer(query);
        }
    }

    /**
     * Append th given value to the end of the query.
     * @param value the value to add.
     */
    public void append(String value) {
        hqlQuery.append(value);
    }

    /**
     * Set the search criterion given in this HqlQuery to the given query.
     * @param query the hibernate query.
     */
    public void setSearchCriterionParameters(Query query) {
        if (searchCriterions != null) {
            for (AbstractHibernateSearchCriterion<?, ?, ?> searchCriterion : searchCriterions) {
                if (searchCriterion != null) {
                    searchCriterion.setConditionValue(query);
                }
            }
        }
    }

    /**
     * Add a search criterion in where clause.
     * @param searchCriterion the search criterion
     * @param columnName the column name
     * @param parameterName the parameter name.
     */
    public void addSearchCriterion(AbstractHibernateSearchCriterion<?, ?, ?> searchCriterion, String columnName, String parameterName) {
        if (searchCriterion != null) {
            searchCriterion.setHqlParameterName(parameterName);
            searchCriterion.constructHQLCondition(hqlQuery, columnName);
            addSearchCriterion(searchCriterion);
        } else {
            logger.warn("The given search criterion is null.");
        }
    }

    /**
     * Add a search criterion in where clause.
     * @param searchCriterion the search criterion
     */
    public void addSearchCriterion(AbstractHibernateSearchCriterion<?, ?, ?> searchCriterion) {
        if (searchCriterions == null) {
            searchCriterions = new ArrayList<>();
        }
        if (searchCriterion != null) {
            searchCriterions.add(searchCriterion);
        } else {
            logger.warn("The given search criterion is null.");
        }
    }

    /**
     * Add a string search criterion in where clause.
     * @param searchCriterion the string search criterion
     * @param columnName the column name
     * @param parameterName the parameter name.
     */
    public void addSearchCriterion(StringSearchCriterionDto searchCriterion, String columnName, String parameterName) {
        addSearchCriterion(new HibernateStringSearchCriterion(searchCriterion), columnName, parameterName);
    }

    /**
     * Add an integer search criterion in where clause.
     * @param searchCriterion the string search criterion
     * @param columnName the column name
     * @param parameterName the parameter name.
     */
    public void addSearchCriterion(IntegerSearchCriterionDto searchCriterion, String columnName, String parameterName) {
        addSearchCriterion(new HibernateIntegerSearchCriterion(searchCriterion), columnName, parameterName);
    }

    /**
     * Add a double search criterion in where clause.
     * @param searchCriterion the string search criterion
     * @param columnName the column name
     * @param parameterName the parameter name.
     */
    public void addSearchCriterion(DoubleSearchCriterionDto searchCriterion, String columnName, String parameterName) {
        addSearchCriterion(new HibernateDoubleSearchCriterion(searchCriterion), columnName, parameterName);
    }

    /**
     * Add a long search criterion in where clause.
     * @param searchCriterion the string search criterion
     * @param columnName the column name
     * @param parameterName the parameter name.
     */
    public void addSearchCriterion(LongSearchCriterionDto searchCriterion, String columnName, String parameterName) {
        addSearchCriterion(new HibernateLongSearchCriterion(searchCriterion), columnName, parameterName);
    }

    /**
     * Add a float search criterion in where clause.
     * @param searchCriterion the string search criterion
     * @param columnName the column name
     * @param parameterName the parameter name.
     */
    public void addSearchCriterion(FloatSearchCriterionDto searchCriterion, String columnName, String parameterName) {
        addSearchCriterion(new HibernateFloatSearchCriterion(searchCriterion), columnName, parameterName);
    }

    /**
     * Get the value of hqlQuery.
     * @return the hqlQuery
     */
    public StringBuffer getHqlQuery() {
        return hqlQuery;
    }

    /**
     * Set the value of hqlQuery.
     * @param hqlQuery the hqlQuery to set
     */
    public void setHqlQuery(StringBuffer hqlQuery) {
        this.hqlQuery = hqlQuery;
    }
}
