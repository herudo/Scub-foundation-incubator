package ${package}.gwt.shared;

import java.io.Serializable;

/**
 * An example object.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
public final class ExampleModel implements Serializable {

    /** Serial Version UID. */
    private static final long serialVersionUID = 5023994221954367795L;

    /** Text of the message. */
    private String property;

    /**
     * Return the value of property.
     * @return property
     */
    public String getProperty() {
        return property;
    }

    /**
     * Modify the value of property.
     * @param property the property to set
     */
    public void setProperty(String property) {
        this.property = property;
    }

}