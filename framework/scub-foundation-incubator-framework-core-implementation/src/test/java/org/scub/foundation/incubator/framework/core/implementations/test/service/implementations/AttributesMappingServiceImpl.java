package org.scub.foundation.incubator.framework.core.implementations.test.service.implementations;

import org.scub.foundation.incubator.framework.core.implementations.test.services.interfaces.AttributesMappingService;

/**
 * Service to provide attribute keys.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class AttributesMappingServiceImpl implements AttributesMappingService {

    /* IdLabelDto */
    private String idLabelDtoId;

    private String idLabelDtoLabel;

    /**
     * Get the value of idLabelDtoId.
     * @return the idLabelDtoId
     */
    public String getIdLabelDtoId() {
        return idLabelDtoId;
    }

    /**
     * Set the value of idLabelDtoId.
     * @param idLabelDtoId the idLabelDtoId to set
     */
    public void setIdLabelDtoId(String idLabelDtoId) {
        this.idLabelDtoId = idLabelDtoId;
    }

    /**
     * Get the value of idLabelDtoLabel.
     * @return the idLabelDtoLabel
     */
    public String getIdLabelDtoLabel() {
        return idLabelDtoLabel;
    }

    /**
     * Set the value of idLabelDtoLabel.
     * @param idLabelDtoLabel the idLabelDtoLabel to set
     */
    public void setIdLabelDtoLabel(String idLabelDtoLabel) {
        this.idLabelDtoLabel = idLabelDtoLabel;
    }
}
