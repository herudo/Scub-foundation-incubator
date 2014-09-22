package scub.foundation.incubator.gwt.module.gwt.client.components.box;

import scub.foundation.incubator.gwt.module.gwt.client.utils.StringUtils;

/**
 * A Double box which accept only Double values.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class DoubleBox extends RealNumberBox<Double> {

    @Override
    public Double convertString(String value) {
        if (StringUtils.isNotEmpty(value)) {
            return Double.valueOf(value);
        }
        return null;
    }
}
