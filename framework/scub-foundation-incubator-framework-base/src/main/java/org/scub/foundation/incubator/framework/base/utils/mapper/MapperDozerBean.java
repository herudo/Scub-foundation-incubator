package org.scub.foundation.incubator.framework.base.utils.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.scub.foundation.incubator.framework.base.utils.ListUtils;

/**
 * Implementation of a mapper dozer bean.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public final class MapperDozerBean {
    /**
     * Mapper dozer.
     */
    private DozerBeanMapper mapperIf;

    /**
     * Constructor.
     * @param mappingFiles the mapping files list.
     * @param customConverters the custom converter list.
     */
    public MapperDozerBean(final List<String> mappingFiles, final List<CustomConverter> customConverters) {
        mapperIf = new DozerBeanMapper();
        mapperIf.setMappingFiles(mappingFiles);
        if (ListUtils.isNotEmpty(customConverters)) {
            mapperIf.setCustomConverters(customConverters);
        }
    }

    /**
     * Map the source object into an object of clazz.
     * @param source the source object.
     * @param clazz the class type.
     * @param <SourceType> the source type.
     * @param <DestinationType> the destination type.
     * @return the clazz type mapt object.
     */
    public <DestinationType, SourceType>DestinationType map(SourceType source, Class<DestinationType> clazz) {
        if (source != null) {
            return (DestinationType) mapperIf.map(source, clazz);
        } else {
            return null;
        }
    }

    /**
     * Map the source object into the destination object.
     * @param source the source object.
     * @param destination the destination object
     * @param <DestinationType> the destination and returned type.
     * @return the mapped destination object.
     */
    public <DestinationType>DestinationType map(Object source, DestinationType destination) {
        if (source != null) {
            mapperIf.map(source, destination);
            return destination;
        } else {
            return null;
        }
    }

    /**
     * Map the source objects into the destination object.
     * @param sources the source objects.
     * @param clazz the class type.
     * @param <SourceType> the source type.
     * @param <DestinationType> the destination and returned type.
     * @return the mapped destination objects.
     */
    public <DestinationType, SourceType>List<DestinationType> map(Collection<SourceType> sources, Class<DestinationType> clazz) {
        List<DestinationType> returnedList = null;
        if (sources != null) {
            returnedList = new ArrayList<DestinationType>();
            if (!sources.isEmpty()) {
                for (SourceType source : sources) {
                    returnedList.add(map(source, clazz));
                }
            }
        }
        return returnedList;
    }

    /**
     * Map the source objects into the destination object.
     * @param sources the source objects.
     * @param clazz the class type.
     * @param <SourceType> the source type.
     * @param <DestinationType> the destination and returned type.
     * @return the mapped destination objects.
     */
    public <DestinationType, SourceType>List<DestinationType> map(SourceType[] sources, Class<DestinationType> clazz) {
        List<DestinationType> returnedList = null;
        if (sources != null) {
            returnedList = new ArrayList<DestinationType>();
            if (sources.length > 0) {
                for (int index = 0; index < sources.length; index++) {
                    returnedList.add(map(sources[index], clazz));
                }
            }
        }
        return returnedList;
    }
}
