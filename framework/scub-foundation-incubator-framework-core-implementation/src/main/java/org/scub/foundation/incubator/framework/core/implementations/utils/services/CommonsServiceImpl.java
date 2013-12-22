package org.scub.foundation.incubator.framework.core.implementations.utils.services;

import org.scub.foundation.framework.base.mapping.util.MapperDozerBean;
import org.scub.foundation.framework.core.oval.validator.BusinessValidator;
import org.scub.foundation.incubator.framework.core.implementations.utils.IntegrityValidator;
import org.scub.foundation.incubator.framework.core.implementations.utils.TechnicalValidator;

/**
 * Commons attributes for services.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class CommonsServiceImpl {

    /** validator. */
    protected BusinessValidator businessValidator;

    /** validator. */
    protected IntegrityValidator integrityValidator;

    /** validator. */
    protected TechnicalValidator technicalValidator;

    /** mapperDozerBean. */
    protected MapperDozerBean mapperDozerBean;

    /**
     * Set the value of businessValidator.
     * @param businessValidator the businessValidator to set
     */
    public void setBusinessValidator(BusinessValidator businessValidator) {
        this.businessValidator = businessValidator;
    }

    /**
     * Set the value of integrityValidator.
     * @param integrityValidator the integrityValidator to set
     */
    public void setIntegrityValidator(IntegrityValidator integrityValidator) {
        this.integrityValidator = integrityValidator;
    }

    /**
     * Set the value of technicalValidator.
     * @param technicalValidator the technicalValidator to set
     */
    public void setTechnicalValidator(TechnicalValidator technicalValidator) {
        this.technicalValidator = technicalValidator;
    }

    /**
     * Set the value of mapperDozerBean.
     * @param mapperDozerBean the mapperDozerBean to set
     */
    public void setMapperDozerBean(MapperDozerBean mapperDozerBean) {
        this.mapperDozerBean = mapperDozerBean;
    }
}
