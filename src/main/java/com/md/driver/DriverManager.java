package com.md.driver;

import org.openqa.selenium.WebDriver;

/**
 * DriverManager class helps to achieve thread safety for the {@link org.openqa.selenium.WebDriver} instance.
 * 
 * @since Dec 01, 2023 
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 * @see Driver
 */
public final class DriverManager {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverManager() {}
	
	private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();
	
	/**
	 * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
	 * 
	 * @author Mahesh Deevi
	 * @since Dec 01, 2023
	 * @return {@link org.openqa.selenium.WebDriver} instance.
	 */
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	/**
	 * Set the WebDriver instance to thread local variable
	 * 
	 * @author Mahesh Deevi
	 * @since Dec 01, 2023
	 * @param driverref {@link org.openqa.selenium.WebDriver} instance that needs to saved from Thread safety issues.
	 */
	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);
	}
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * @author Mahesh Deevi
	 * @since Dec 01, 2023
	 */
	public static void unload() {
		dr.remove();
	}

}
