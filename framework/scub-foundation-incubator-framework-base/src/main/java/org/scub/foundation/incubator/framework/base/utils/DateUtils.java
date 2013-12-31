package org.scub.foundation.incubator.framework.base.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Utilities methods for date management.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public final class DateUtils {

    /**
     * Constructor.
     */
    private DateUtils() {
    }

    /**
     * Get a calendar corresponding to the day of the given date whithout hour, minute, second or millisecond.
     * @param date the date to get the beginning of the day.
     * @return the date whitout time.
     */
    public static Calendar getBeginningOfTheDay(Date date) {
        if (date != null) {
            final Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.setTime(date);
            calendar.clear(Calendar.HOUR_OF_DAY);
            calendar.clear(Calendar.MINUTE);
            calendar.clear(Calendar.SECOND);
            calendar.clear(Calendar.MILLISECOND);

            return calendar;
        }

        return null;
    }

    /**
     * Get a calendar corresponding to the day of the given date whithout hour, minute, second or millisecond.
     * @param date the date to get the beginning of the day.
     * @return the date whitout time.
     */
    public static Calendar getBeginningOfTheDay(Calendar date) {
        if (date != null) {
            return getBeginningOfTheDay(date.getTime());
        }

        return null;
    }

    /**
     * Get a calendar corresponding to the day of the given date with time equals to 11:59:59.999 (23:59:59.999).
     * @param date the date to get the end of the day.
     * @return the date whitout time.
     */
    public static Calendar getEndOfTheDay(Date date) {
        if (date != null) {
            final int hours = 23;
            final int minutes = 59;
            final int seconds = 59;
            final int milliSeconds = 999;

            final Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, hours);
            calendar.set(Calendar.MINUTE, minutes);
            calendar.set(Calendar.SECOND, seconds);
            calendar.set(Calendar.MILLISECOND, milliSeconds);

            return calendar;
        }

        return null;
    }

    /**
     * Get a calendar corresponding to the day of the given date with time equals to 11:59:59.999 (23:59:59.999).
     * @param date the date to get the end of the day.
     * @return the date whitout time.
     */
    public static Calendar getEndOfTheDay(Calendar date) {
        if (date != null) {
            return getEndOfTheDay(date.getTime());
        }

        return null;
    }

}
