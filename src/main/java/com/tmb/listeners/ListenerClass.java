package com.tmb.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;

public class ListenerClass implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReports();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ISuite suite) {

		try {
			ExtentReport.flushReports();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
      
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		try {
			ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			ExtentLogger.fail(result.getMethod().getMethodName()+" is failed");
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
           /*
            * Not required
            */
		
	}

	@Override
	public void onStart(ITestContext context) {
		 /*
         * Not required
         */
		
	}

	@Override
	public void onFinish(ITestContext context) {
		 /*
         * Not required
         */
		
	}

}
