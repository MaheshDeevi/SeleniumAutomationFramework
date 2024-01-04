package com.md.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.md.enums.ConfigProperties;
import com.md.exceptions.BrowserInvocationFailedException;
import com.md.factories.DriverFactory;
import com.md.utils.PropertyUtils;

/**
 * 
 * Driver class is responsible for invoking and closing the browsers.
 * 
 * <p>
 * It is also responsible for 
 * setting the driver variable to DriverManager which handles the thread safety for the 
 * webdriver instance.
 * 
 * @since Dec 1, 2023 
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see com.md.tests.BaseTest
 */
public final class Driver {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private Driver() {}

	

	/**
	 * Gets the browser value and initialise the browser based on that
	 * 
	 * @author Mahesh Deevi
	 * @since Dec 01, 2023
	 * @param browser Value will be passed from {@link com.md.tests.BaseTest}. User can set this browser values from Test Data sheet.
	 * @param version Value will be passed from {@link com.md.tests.BaseTest}. User can set this browser versions from Test Data sheet.
	 * 
	 */
	public static void initDriver(String browser,String version) {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser, version));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Browser Invocation Failed.Please check the capabilities of browser");
			}
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}

	}

	/**
	 * Terminates the browser instance.
	 * Sets the threadlocal to default value, i.e null.
	 * @author Mahesh Deevi
	 * @since Dec 01, 2023
	 */
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		
	}

}
