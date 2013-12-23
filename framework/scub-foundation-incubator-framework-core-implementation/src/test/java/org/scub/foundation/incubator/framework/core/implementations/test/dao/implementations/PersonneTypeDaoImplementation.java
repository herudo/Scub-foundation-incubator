package org.scub.foundation.incubator.framework.core.implementations.test.dao.implementations;

import org.scub.foundation.incubator.framework.core.implementations.dao.implementations.AbstractIdLabelDaoImplementation;
import org.scub.foundation.incubator.framework.core.implementations.test.dao.interfaces.PersonneTypeDao;
import org.scub.foundation.incubator.framework.core.implementations.test.model.PersonneType;
import org.scub.foundation.incubator.framework.core.interfaces.dto.criteria.IdLabelCriteriaDto;


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

