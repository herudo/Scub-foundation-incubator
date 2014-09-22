package scub.foundation.incubator.gwt.module.gwt.client.components.box;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.i18n.client.NumberFormat;

/**
 * Utility class for real numbers boxes.
 * @param <Type> the real number type (Double or Float)
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class RealNumberBox<Type extends Number> extends NumberBox<Type> {

    private int precision;

    private static final int DEFAULT_PRECISION = 2;

    private NumberFormat numFormat;

    /**
     * Create a new integer box.
     */
    public RealNumberBox() {
        this(DEFAULT_PRECISION);
    }

    /**
     * Create a new integer box with the given precision.
     * @param precision number of digit after the point.
     */
    public RealNumberBox(int precision) {
        this(precision, null);
    }

    /**
     * Create a new integer box with the given precision.
     * @param precision number of digit after the point.
     * @param value the float box value.
     */
    public RealNumberBox(int precision, Type value) {
        super("(\\+|-)?(\\d*)(\\.|,)?(\\d{0," + precision + "})");
        this.precision = precision;

        String format = "#0.";
        for (int i = 0; i < precision; i++) {
            format += "0";
        }
        numFormat = NumberFormat.getFormat(format);

        box.addBlurHandler(new BlurHandler() {

            @Override
            public void onBlur(BlurEvent event) {
                box.setValue(format(getValue()));
            }
        });

        setValue(value);
    }

    /**
     * Format the value for the textbox.
     * @param value the vlaue to format.
     * @return the string formated value
     */
    private String format(Type value) {
        return value != null ? numFormat.format(value).toString() : "";
    }

    /**
     * Get the value of precision.
     * @return the precision
     */
    public int getPrecision() {
        return precision;
    }
}
