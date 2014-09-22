package scub.foundation.incubator.gwt.module.gwt.client.components.handlers;

/**
 * Extends {@link TakesSecondValue} to allow the second value to be pulled back out, and to throw
 * {@link com.google.gwt.event.logical.shared.SecondValueChangeEvent SecondValueChangeEvent} events.
 * <p>
 * An object that implements this interface should be a user input widget, where the user and programmer can both set and get the object's second value. It is
 * intended to provide a unified interface to widgets with "atomic" second values, like Strings and Dates.
 * @param <T> the type of second value
 */
public interface HasSecondValue<T> extends HasSecondValueChangeHandlers<T> {

    /**
     * Gets this object's second value.
     * @return the object's second value
     */
    T getSecondValue();

    /**
     * Sets this object's second value without firing any events. This should be identical to calling setSecondValue(second value, false).
     * <p>
     * It is acceptable to fail assertions or throw (documented) unchecked exceptions in response to bad second values.
     * <p>
     * Widgets must accept null as a valid second value. By convention, setting a widget to null clears second value, calling getSecondValue() on a cleared
     * widget returns null. Widgets that can not be cleared (e.g. {@link CheckBox}) must find another valid meaning for null input.
     * @param value the object's new second value
     */
    void setSecondValue(T value);

    /**
     * Sets this object's second value. Fires {@link com.google.gwt.event.logical.shared.SecondValueChangeEvent} when fireEvents is true and the new second
     * value does not equal the existing second value.
     * <p>
     * It is acceptable to fail assertions or throw (documented) unchecked exceptions in response to bad second values.
     * @param value the object's new second value
     * @param fireEvents fire events if true and second value is new
     */
    void setSecondValue(T value, boolean fireEvents);
}
