package com.md.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.md.constants.FrameworkConstants;
import com.md.enums.CategoryType;

/**
 * Perform initialisation and termination of {@link com.aventstack.extentreports.ExtentReports}
 * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to ThreadLocal 
 * variable for providing thread safety.
 * 
 * @since Dec 03, 2023 
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 * @see com.md.listeners.ListenerClass
 * @see com.md.annotations.FrameworkAnnotation
 */
public final class ExtentReport {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentReport() {}

	private static ExtentReports extent;

	/**
	 * Set the initial configuration for the Extent Reports and decides the report generation path.
	 * @since Dec 03, 2023 
	 * @author Mahesh Deevi
	 */
	public static void initReport() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Automation");
			spark.config().setReportName("OrangeHRM");
		}
	}

	/**
	 * Flushing the reports ensures extent logs are reflected properly. 
	 * Opens the report in the default desktop browser.
	 * Sets the ThreadLocal variable to default value
	 * @since Dec 03, 2023 
	 * @author Mahesh Deevi
	 */
	public static void flushReport() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety
	 * @author Mahesh Deevi
	 * @since Dec 03, 2023
	 * @param testCaseName Test Name that needs to be reflected in the report
	 * @param testDescription Test Description that needs to be reflected in the report
	 */
	public static void createTest(String testCaseName, String testDescription) {

		ExtentManager.setExtentTest(extent.createTest(testCaseName, testDescription));
	}

	/**
	 * Logs the authors details in the authors view in the extent report.
	 * Gives an clear idea of Authors Vs Percentage success metrics
	 * @author Mahesh Deevi
	 * @since Dec 03, 2023
	 * @param authors Authors who created a particular test case
	 */
	public static void addAuthors(String[] authors) {

		for (String author : authors) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}

	}

	/**
	 * Adds the category a particular test case belongs to.
	 * Gives an clear idea of Group Vs Percentage success metrics.
	 * @author Mahesh Deevi
	 * @since Dec 03, 2023
	 * @param categories category a particular test case belongs to.
	 */
	public static void addCategories(CategoryType[] categories) {

		for (CategoryType category : categories) {
			ExtentManager.getExtentTest().assignCategory(category.toString());
		}

	}
	
	/**
	 * Retrieves the browser name from the parameters of an {@code ITestResult}.
	 * @author Mahesh Deevi
	 * @since Dec 10, 2023
	 * @param result The {@code ITestResult} containing information about the test execution.
	 * @return The name of the browser extracted from the parameters.
	 */
	@SuppressWarnings("unchecked")
	public static String addBrowserName(ITestResult result) {
	    // Retrieve the parameters from the test result
	    Object[] data = result.getParameters();

	    // Assuming that the first parameter is a Map<String, String> containing browser information
	    Map<String, String> map = (Map<String, String>) data[0];

	    // Extract and return the browser name from the map
	    return map.get("browser");
	}
	
	/**
	 * Retrieves the version information from the parameters of an {@code ITestResult}.
	 * @author Mahesh Deevi
	 * @since Dec 10, 2023
	 * @param result The {@code ITestResult} containing information about the test execution.
	 * @return The version information extracted from the parameters.
	 */
	@SuppressWarnings("unchecked")
	public static String addVersion(ITestResult result) {
	    // Retrieve the parameters from the test result
	    Object[] data = result.getParameters();

	    // Assuming that the first parameter is a Map<String, String> containing browser information
	    Map<String, String> map = (Map<String, String>) data[0];

	    // Extract and return the browser name from the map
	    return map.get("version");
	}


}
