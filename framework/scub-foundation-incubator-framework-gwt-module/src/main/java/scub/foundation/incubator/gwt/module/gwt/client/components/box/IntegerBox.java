/**
 * 
 */
package scub.foundation.incubator.gwt.module.gwt.client.components.box;

import scub.foundation.incubator.gwt.module.gwt.client.utils.StringUtils;

/**
 * An integer box accept only integer values.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class IntegerBox extends NumberBox<Integer> {

    /**
     * Create a new integer box.
     */
    public IntegerBox() {
        super("(\\+|-)?(\\d*)");
    }

    @Override
    public Integer convertString(String value) {
        if (StringUtils.isNotEmpty(value)) {
            return Integer.valueOf(value);
        }
        return null;
    }
}
