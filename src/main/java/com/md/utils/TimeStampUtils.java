package com.md.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The TimeStampUtils class provides utility methods for generating timestamps,
 * particularly formatted for use in the ElasticSearch.
 * 
 * <p>This class is authored by @author mahesh.deevi on Dec 23, 2023.</p>
 */
public final class TimeStampUtils {

    private TimeStampUtils() {
        // Private constructor to prevent instantiation of the utility class.
    }

    /**
     * Creates a timestamp string formatted for ElasticSearch usage.
     *
     * @return A formatted timestamp string in the pattern "yyyy-MM-dd'T'HH:mm:ss.SSSZ".
     * 
     * @since Dec 23, 2023
     * @author Mahesh Deevi
     */
    public static String createTimeStampForELK() {
        // Get the system default time zone
        ZoneId defaultZone = ZoneId.systemDefault();
        
        // Get the current date and time in the default time zone
        ZonedDateTime now = ZonedDateTime.now(defaultZone);
        
        // Define the date-time formatter with the desired pattern
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        
        // Format the current date and time using the formatter
        return now.format(dtf);
    }
}