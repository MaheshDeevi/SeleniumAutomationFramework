package com.md.listeners;

import com.md.annotations.FrameworkAnnotation;
import com.md.enums.LoggerType;
import com.md.reports.ExtentReport;
import com.md.utils.ELKUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

import static com.md.logs.FrameworkLogger.log;

/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
 * Mostly used to help in extent report generation
 * 
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 * 
 * @since Dec 01, 2023 
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 */
public final class ListenerClass implements ITestListener,ISuiteListener {

	/**
	 * Initialise the reports with the file name
	 * @see com.md.reports.ExtentReport
	 * @see com.md.constants.FrameworkConstants
	 * @see com.md.logs.FrameworkLogger
	 */
	@Override
	public void onStart(ISuite suite) {
			ExtentReport.initReport();
	}

	/**
	 * Terminate the reports
	 * @see com.md.reports.ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {
			ExtentReport.flushReport();
	}

	/**
	 * Starts a test node for each testng test
	 * @see com.md.reports.ExtentReport
	 * @see com.md.annotations.FrameworkAnnotation
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName(),"<b>Description : </b>"+result.getMethod().getDescription()+
				" <br> <b>Browser : </b>"+ExtentReport.addBrowserName(result)+
				" <br> <b>Version : </b>"+ExtentReport.addVersion(result));
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
	}

	/**
	 * Marks the test as pass and logs it in the report and console
	 * @see com.md.logs.FrameworkLogger
	 * @see com.md.utils.ELKUtils
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		String author = Arrays.toString(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		log(LoggerType.PASS, result.getMethod().getMethodName()+ " is passed");
		ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(),"Pass",author,ExtentReport.addBrowserName(result),ExtentReport.addVersion(result));
	}

	/**
	 * Marks the test as fail,append base64 screenshot and logs it in the report and console
	 * @see com.md.logs.FrameworkLogger
	 * @see com.md.utils.ELKUtils
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		String author = Arrays.toString(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		log(LoggerType.FAIL, result.getMethod().getMethodName()+ " is failed.");
		log(LoggerType.FAIL, result.getThrowable().toString());
		ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(),"Fail",author,ExtentReport.addBrowserName(result),ExtentReport.addVersion(result));
	}

	/**
	 * Marks the test as skip and logs it in the report and console
	 * @see com.md.logs.FrameworkLogger
	 * @see com.md.utils.ELKUtils
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		String author = Arrays.toString(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		log(LoggerType.SKIP, result.getMethod().getMethodName()+ " is skipped");
		ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(),"Skip",author,ExtentReport.addBrowserName(result),ExtentReport.addVersion(result));

	}

}
