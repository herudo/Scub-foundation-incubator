package scub.foundation.incubator.example.core.implementations.dao.implementations;

import org.scub.foundation.incubator.framework.core.implementations.dao.implementations.AbstractIdLabelDaoImplementation;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;

import scub.foundation.incubator.example.core.implementations.dao.interfaces.PersonneTypeDao;
import scub.foundation.incubator.example.core.implementations.model.PersonneType;

/**
 * Dao implementation for personne type.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class PersonneTypeDaoImplementation extends AbstractIdLabelDaoImplementation<PersonneType, IdLabelCriteriaDto> implements PersonneTypeDao {

    @Override
    public Class<PersonneType> getClassType() {
        return PersonneType.class;
    }

}

