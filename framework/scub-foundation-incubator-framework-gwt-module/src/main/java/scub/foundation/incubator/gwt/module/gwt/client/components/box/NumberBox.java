package scub.foundation.incubator.gwt.module.gwt.client.components.box;

import org.scub.foundation.framework.gwt.module.client.util.composants.regexbox.RegexBox;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasValue;

/**
 * An number box accept only numbers values.
 * @param <Type> the number type.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public abstract class NumberBox<Type extends Number> extends Composite implements HasValue<Type>, HasEnabled {

    /** The number box. */
    protected RegexBox box;

    /**
     * Create a new number box.
     * @param regex the regex for the regexbox. it's used to determine which characters are allowed.
     */
    public NumberBox(String regex) {
        box = new RegexBox(regex);
        box.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                fireEvent();
            }
        });
        initWidget(box);
    }

    private void fireEvent() {
        ValueChangeEvent.fire(this, getValue());
    }

    @Override
    public Type getValue() {
        final String value = box.getText();
        if (value.isEmpty()) {
            return null;
        }
        return convertString(value);
    }

    /**
     * Convert String to the <Type> number value.
     * @param value the string value to convert.
     * @return the converted value.
     */
    public abstract Type convertString(String value);

    @Override
    public void setValue(Type value) {
        setValue(value, false);
    }

    @Override
    public void setValue(Type value, boolean fireEvents) {
        final Type oldValue = getValue();
        box.setValue(value != null ? value.toString() : null);
        final Type newValue = getValue();
        if (fireEvents) {
            ValueChangeEvent.fireIfNotEqual(this, oldValue, newValue);
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Type> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    /**
     * Sets whether this widget is enabled.
     * @param enabled <code>true</code> to enable the widget, <code>false</code> to disable it
     */
    @Override
    public void setEnabled(boolean enabled) {
        box.setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
        return box.isEnabled();
    }
}
