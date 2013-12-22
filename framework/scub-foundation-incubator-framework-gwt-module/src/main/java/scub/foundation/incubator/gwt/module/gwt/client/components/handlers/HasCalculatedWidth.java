package scub.foundation.incubator.gwt.module.gwt.client.components.handlers;

/**
 * interface for component which have calculated width.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public interface HasCalculatedWidth {

    /**
     * Posibillities for calculated width.
     * @author Adrien HAUTOT (contact@adrienhautot.fr)
     */
    public enum Width {
        /** 100%. */
        CENT_PERCENT
    }

    /**
     * The width.
     * @param width the width.
     */
    void setCalculatedWidth(Width width);
}
