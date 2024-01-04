package com.md.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.md.constants.FrameworkConstants;
import com.md.driver.DriverManager;
import com.md.enums.WaitStrategy;

/**
 * Explicit wait factory produces different waits before operating on webelement
 * 
 * @since Dec 01, 2023
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 */
public final class ExplicitWaitFactory {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExplicitWaitFactory() {}
	
	/**
	 * 
	 * @author Mahesh Deevi
	 * @since Dec 01, 2023
	 * @param waitstrategy Strategy to be applied to find a webelement {@link com.md.enums.WaitStrategy}
	 * @param by By locator of the webelement
	 * @return webelement Locates and return the webelement
	 */
	public static WebElement performExplicitWait(WaitStrategy waitstrategy,By by) {
		WebElement element = null;
		
		if(waitstrategy == WaitStrategy.CLICKABLE) {
		   element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
			.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitstrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
			.until(ExpectedConditions.presenceOfElementLocated(by));
			
		}
		else if(waitstrategy == WaitStrategy.VISIBILE) {
		  element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
			.until(ExpectedConditions.visibilityOfElementLocated(by));
			
		}
		else if(waitstrategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
