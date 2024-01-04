package com.md.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.md.enums.ConfigProperties;
import com.md.utils.PropertyUtils;

public final class DriverFactory {

	private DriverFactory() {
	}
	
	private static final String REMOTE = "remote";
	
	public static WebDriver getDriver(String browser, String version) throws MalformedURLException {
		WebDriver driver = null;
		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
		if (browser.equalsIgnoreCase("chrome")) {
			if (runmode.equalsIgnoreCase(REMOTE)) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(browser);
				cap.setVersion(version);
				driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
			} else {
				driver = new ChromeDriver();
			}

		} else if (browser.equalsIgnoreCase("firefox")) {

			if (runmode.equalsIgnoreCase(REMOTE)) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(browser);
				cap.setVersion(version);
				driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
			} else {
				driver = new FirefoxDriver();
			}
		} else if (browser.equalsIgnoreCase("MicrosoftEdge")) {

			if (runmode.equalsIgnoreCase(REMOTE)) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(browser);
				cap.setVersion(version);
				driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
			} else {
				driver = new EdgeDriver();
			}
		}
		return driver;
	}
}
