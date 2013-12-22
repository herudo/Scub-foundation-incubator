package scub.foundation.incubator.gwt.module.gwt.server.service.implementation;

import org.scub.foundation.incubator.framework.base.utils.mapper.MapperDozerBean;

/**
 * Abstract class to provide utilities methods for gwt implementation service.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractGwtImplementationService {

    /** mapper dozer bean. */
    protected MapperDozerBean mapperDozerBean;

    /**
     * Set the value of mapperDozerBean.
     * @param mapperDozerBean the mapperDozerBean to set
     */
    public void setMapperDozerBean(MapperDozerBean mapperDozerBean) {
        this.mapperDozerBean = mapperDozerBean;
    }

}
