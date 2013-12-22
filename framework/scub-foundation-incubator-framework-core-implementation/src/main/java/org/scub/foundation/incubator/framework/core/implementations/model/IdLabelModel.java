package org.scub.foundation.incubator.framework.core.implementations.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.scub.foundation.framework.core.model.BaseModel;

/**
 * Model for simple type with an id and a label..
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
@MappedSuperclass
public abstract class IdLabelModel extends BaseModel {

    private static final long serialVersionUID = 2604938081437115192L;

    @Column(nullable = false)
    private String label;

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
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        return equalsUtil(other);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [label=" + label + ", id=" + getId() + "]";
    }
}
