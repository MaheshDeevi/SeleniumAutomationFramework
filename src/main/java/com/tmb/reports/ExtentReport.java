package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.CategoryType;

public final class ExtentReport {
	
	private ExtentReport() {
		
	}
	
	private static ExtentReports extent;
	
	
	public static void initReports() {
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportfilepath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("TMB Report");
		spark.config().setReportName("Youtube Training");
		}
	}
	
	public static void flushReports() throws IOException {
		if(Objects.nonNull(extent)) {
		extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportfilepath()).toURI());
		
	}
	
	public static void createTest(String testcasename) {
		ExtentTest test = extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
		
	}
	
	public static void addAuthors(String[] authors) {
		for(String temp : authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}
	
	public static void addCategories(CategoryType[] categoryTypes) {
		for(CategoryType temp : categoryTypes) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}

}
