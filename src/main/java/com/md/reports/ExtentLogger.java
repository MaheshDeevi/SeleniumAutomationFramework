/**
 * The {@code ExtentLogger} class provides static methods to log pass, fail, and skip messages
 * in Extent Reports along with optional screenshots based on configuration properties.
 * This class cannot be instantiated, and all its methods are static.
 *
 * @author Mahesh Deevi
 * @version 1.0
 * @since 2023-12-03
 */
package com.md.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.md.enums.ConfigProperties;
import com.md.utils.PropertyUtils;
import com.md.utils.ScreenshotUtils;

/**
 * The {@code ExtentLogger} class provides static methods to log pass, fail, and skip messages
 * in Extent Reports along with optional screenshots based on configuration properties.
 * This class cannot be instantiated, and all its methods are static.
 */
public final class ExtentLogger {

    // Private constructor to prevent instantiation of the class
    private ExtentLogger() {}

    /**
     * Logs a pass message in Extent Reports. Optionally includes a screenshot based on configuration.
     *
     * @param message The pass message to be logged.
     */
    public static void pass(String message) {
        if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            ExtentManager.getExtentTest().pass(message);
        }
    }

    /**
     * Logs a fail message in Extent Reports. Optionally includes a screenshot based on configuration.
     *
     * @param message The fail message to be logged.
     */
    public static void fail(String message) {
        if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            ExtentManager.getExtentTest().fail(message);
        }
    }

    /**
     * Logs a skip message in Extent Reports. Optionally includes a screenshot based on configuration.
     *
     * @param message The skip message to be logged.
     */
    public static void skip(String message) {
        if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            ExtentManager.getExtentTest().skip(message);
        }
    }
}