package org.scub.foundation.incubator.core.interfaces.dto;

import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import org.scub.foundation.framework.base.dto.AbstractDto;
import org.scub.foundation.incubator.core.interfaces.profiles.OvalProfiles;


/**
 * Simple dto that provide an id and a label.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class IdLabelDto extends AbstractDto {

    private static final long serialVersionUID = -2306081099365303257L;

    @NotNull(profiles = {OvalProfiles.ID_LABEL_DTO_ALL_REQUIRED, OvalProfiles.ID_LABEL_DTO_ID_REQUIRED })
    private Long id;

    @NotNull(profiles = {OvalProfiles.ID_LABEL_DTO_ALL_REQUIRED, OvalProfiles.ID_LABEL_DTO_LABEL_REQUIRED })
    @NotBlank(profiles = {OvalProfiles.ID_LABEL_DTO_ALL_REQUIRED, OvalProfiles.ID_LABEL_DTO_LABEL_REQUIRED })
    private String label;

    /**
     * Get the value of id.
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Constructor.
     */
    public IdLabelDto() {
    }

    /**
     * Constructor.
     * @param id l'id
     * @param label le label.
     */
    public IdLabelDto(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    /**
     * Constructor.
     * @param id l'id
     */
    public IdLabelDto(Long id) {
        this.id = id;
    }

    /**
     * Constructor.
     * @param label le label.
     */
    public IdLabelDto(String label) {
        this.label = label;
    }

    /**
     * Set the value of id.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the value of label.
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set the value of label.
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "IdLabelDto [id=" + id + ", label=" + label + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IdLabelDto other = (IdLabelDto) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (label == null) {
            if (other.label != null) {
                return false;
            }
        } else if (!label.equals(other.label)) {
            return false;
        }
        return true;
    }
}
