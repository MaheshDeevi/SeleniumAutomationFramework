package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {
		
	}
	
private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
	
	protected static ExtentTest getExtentTest() {
		return extTest.get();
	}
	
	protected static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}
	
	protected static void unload() {
		extTest.remove();
	}


}
