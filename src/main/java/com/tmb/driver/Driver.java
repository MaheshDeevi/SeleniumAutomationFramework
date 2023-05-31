package com.tmb.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.BrowserInvocationFailedException;
import com.tmb.factories.DriverFactory;
import com.tmb.utils.PropertyUtils;


public final class Driver {

	private Driver() {

	}

	// replace // with \ then it will work in all machines
		//ctrl+shift+O to import automatically 

	public static void initDriver(String browser) {
		
		if(Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Browser Invocation Failed. Please check the capabilities of browser");
			}
			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
			DriverManager.getDriver().manage().window().maximize();
				
			}
			
	}
	

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

	
}
