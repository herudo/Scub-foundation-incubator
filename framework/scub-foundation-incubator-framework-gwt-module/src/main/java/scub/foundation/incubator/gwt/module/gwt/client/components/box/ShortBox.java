/**
 * 
 */
package scub.foundation.incubator.gwt.module.gwt.client.components.box;

import scub.foundation.incubator.gwt.module.gwt.client.utils.StringUtils;

/**
 * An Short box accept only Short values.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class ShortBox extends NumberBox<Short> {

    /**
     * Create a new integer box.
     */
    public ShortBox() {
        super("(\\+|-)?(\\d*)");
    }

    @Override
    public Short convertString(String value) {
        if (StringUtils.isNotEmpty(value)) {
            return Short.valueOf(value);
        }
        return null;
    }
}
