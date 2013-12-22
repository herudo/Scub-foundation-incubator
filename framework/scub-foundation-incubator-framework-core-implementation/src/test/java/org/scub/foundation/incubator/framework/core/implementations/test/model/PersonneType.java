package org.scub.foundation.incubator.framework.core.implementations.test.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.scub.foundation.incubator.framework.core.implementations.model.IdLabelModel;

/**
 * A type personne type that extends IdLabelModel.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
@Entity
@Table(name = "PERSONNE_TYPE")
public class PersonneType extends IdLabelModel {

    private static final long serialVersionUID = -1122283604803427478L;

}
