package org.scub.foundation.incubator.framework.base.utils.mapper;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.RootLogger;
import org.dozer.CustomConverter;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Util class for create mapper dozer bean.
 * @author Goumard Stephane (stephane.goumard@scub.net)
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public final class MapperDozerFactoryBean extends AbstractFactoryBean<MapperDozerBean> {
    private List<String> mappingFiles;

    private List<CustomConverter> customConverters;

    private MapperDozerBean singletonInstance;

    private Logger logger = RootLogger.getLogger(MapperDozerFactoryBean.class);

    /**
     * {@inheritDoc}
     */
    public Class<MapperDozerBean> getObjectType() {
        return MapperDozerBean.class;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isSingleton() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    protected MapperDozerBean createInstance() throws Exception {
        if (singletonInstance == null) {
            logger.info("Create new MapperDozerBean");
            if (mappingFiles != null) {
                for (String fileMapping : mappingFiles) {
                    logger.debug("Add new config file : " + fileMapping);
                }
            } else {
                logger.info("No mapping file found.");
            }
            if (customConverters != null) {
                for (CustomConverter custom : customConverters) {
                    if (custom != null) {
                        logger.debug("Add custom converter : " + custom.getClass().getCanonicalName());
                    }
                }
            } else {
                logger.debug("No custom converter given.");
            }
            singletonInstance = new MapperDozerBean(mappingFiles, customConverters);
        }
        return singletonInstance;
    }

    /**
     * Set the mappingFiles value.
     * @param mappingFiles the mappingFiles to set
     */
    public void setMappingFiles(List<String> mappingFiles) {
        this.mappingFiles = mappingFiles;
    }

    /**
     * Set the customConverters value.
     * @param customConverters the customConverters to set
     */
    public void setCustomConverters(List<CustomConverter> customConverters) {
        this.customConverters = customConverters;
    }

}
