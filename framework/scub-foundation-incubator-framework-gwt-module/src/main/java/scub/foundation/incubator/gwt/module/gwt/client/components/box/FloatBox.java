package scub.foundation.incubator.gwt.module.gwt.client.components.box;

import scub.foundation.incubator.gwt.module.gwt.client.utils.StringUtils;

/**
 * A float box which accept only float values.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class FloatBox extends RealNumberBox<Float> {

    @Override
    public Float convertString(String value) {
        if (StringUtils.isNotEmpty(value)) {
            return Float.valueOf(value);
        }
        return null;
    }
}
