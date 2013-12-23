package org.scub.foundation.incubator.framework.core.implementations.dao.implementations;

import java.util.List;

import org.scub.foundation.incubator.framework.core.interfaces.dto.RemotePagingCriteriasDto;
import org.scub.foundation.incubator.framework.core.implementations.dao.interfaces.IdLabelDao;
import org.scub.foundation.incubator.framework.core.implementations.model.IdLabelModel;
import org.scub.foundation.incubator.framework.core.implementations.searchCriterion.query.HqlQuery;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;
import org.scub.foundation.incubator.framework.core.interfaces.dto.searchCriterions.StringSearchCriterionDto;

/**
 * Implementation of the AbstracIdLabeDao.
 * @param <ModelType> the type of this dao.
 * @param <CriteriaType> the criteria type for search.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractIdLabelDaoImplementation<ModelType extends IdLabelModel, CriteriaType extends IdLabelCriteriaDto> extends
        AbstractCrudDaoImplementation<ModelType, Long, CriteriaType> implements IdLabelDao<ModelType, CriteriaType> {

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelType> getByLabel(StringSearchCriterionDto filter) {
        final HqlQuery hqlQuery = new HqlQuery();
        hqlQuery.append("SELECT idLabel ");
        hqlQuery.append("FROM " + getClassType().getSimpleName() + " idLabel ");
        if (filter != null) {
            hqlQuery.append("WHERE ");
            hqlQuery.addSearchCriterion(filter, "label", "label");
        }

        return createQuery(hqlQuery).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelType> search(RemotePagingCriteriasDto<CriteriaType> paggingCriteria) {
        CriteriaType criteria = null;
        if (paggingCriteria != null) {
            criteria = paggingCriteria.getCriterias();
        }
        return createQuery(getQuery(criteria, "SELECT idLabel "), paggingCriteria).list();
    }

    @Override
    public int getTotalResults(CriteriaType criteria) {
        return ((Long) createQuery(getQuery(criteria, "SELECT count(*) ")).uniqueResult()).intValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelType> search(CriteriaType criteria) {
        return createQuery(getQuery(criteria, "SELECT idLabel ")).list();
    }

    /**
     * Create an hql query for the given criteria and start string.
     * @param criteria the criteria
     * @param start the query string to start.
     * @return the hql query.
     */
    private HqlQuery getQuery(CriteriaType criteria, String start) {
        final HqlQuery hqlQuery = new HqlQuery();
        hqlQuery.append(start);
        hqlQuery.append("FROM " + getClassType().getSimpleName() + " idLabel ");
        if (criteria != null && criteria.getLabel() != null) {
            hqlQuery.append("WHERE ");
            hqlQuery.addSearchCriterion(criteria.getLabel(), "label", "label");
        }
        return hqlQuery;
    }
}
