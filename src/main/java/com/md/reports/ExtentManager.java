package com.md.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager class helps to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.
 * 
 * @since Dec 03, 2023
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 */
public final class ExtentManager {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager() {}
	
	private static final ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 * @author Mahesh Deevi
	 * @since Dec 03, 2023
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */ 
	static ExtentTest getExtentTest() {
		return extTest.get();
	}

	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 * @author Mahesh Deevi
	 * @since Dec 03, 2023
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.
	 */
	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}

	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * @author Mahesh Deevi
	 * @since Dec 03, 2023
	 */ 
	static void unload() {
		extTest.remove();
	}

}
