/**
 * FrameworkLogger class provides logging functionalities for different logger types.
 * Supported logger types include PASS, FAIL, and SKIP, with corresponding actions for each type.
 * This class uses ExtentLogger for logging PASS, FAIL, and SKIP events, and also logs messages to
 * the SLF4J logger for INFO, ERROR, and WARN events.
 *
 * @author Mahesh Deevi
 * @since 2023-12-30
 */
package com.md.logs;

import com.md.enums.LoggerType;
import com.md.reports.ExtentLogger;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

/**
 * The FrameworkLogger class is a utility class for logging framework-specific events.
 * It supports logging events such as PASS, FAIL, SKIP, INFO, ERROR, and WARN.
 */
@Slf4j
public final class FrameworkLogger {

    private FrameworkLogger() {}

    // Consumers for different log actions
    private static final Consumer<String> PASS = ExtentLogger::pass;
    private static final Consumer<String> FAIL = ExtentLogger::fail;
    private static final Consumer<String> SKIP = ExtentLogger::skip;
    private static final Consumer<String> INFOCONSOLE = log::info;
    private static final Consumer<String> ERRORCONSOLE = log::error;
    private static final Consumer<String> WARNCONSOLE = log::warn;

    /**
     * Logs the given message based on the provided LoggerType.
     *
     * @param status   The LoggerType indicating the type of logging action (PASS, FAIL, SKIP).
     * @param message  The message to be logged.
     */
    public static void log(LoggerType status, String message) {
        if (status == LoggerType.PASS) {
            PASS.andThen(INFOCONSOLE).accept(message);
        } else if (status == LoggerType.FAIL) {
            FAIL.andThen(ERRORCONSOLE).accept(message);
        } else if (status == LoggerType.SKIP) {
            SKIP.andThen(WARNCONSOLE).accept(message);
        }
    }
    
}