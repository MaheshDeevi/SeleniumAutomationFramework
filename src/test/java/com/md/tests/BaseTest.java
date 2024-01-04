package com.md.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.md.driver.Driver;

/**
 * The BaseTest class serves as the base class for all test classes in the framework,
 * providing setup and teardown methods for test execution.
 * 
 * <p>This class is authored by Mahesh Deevi on 2023-12-22.</p>
 */
public class BaseTest {
	
	/**
	 * Constructs an instance of the BaseTest class.
	 * (Note: Use this constructor only if inheritance or internal initialization is required)
	 */
	protected BaseTest() {}
	
	
	/**
	 * Sets up the test environment before each test method execution.
	 * 
	 * @param data An array of objects containing test data.
	 */
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) {
		Map<String, String> map = (Map<String, String>) data[0];
		System.out.println(map);
		Driver.initDriver(map.get("browser"), map.get("version"));
	}
	
	
	/**
	 * Tears down the test environment after each test method execution.
	 */
	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
	
}