package com.md.pages;

import static com.md.logs.FrameworkLogger.log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.md.driver.DriverManager;
import com.md.enums.LoggerType;
import com.md.enums.WaitStrategy;
import com.md.factories.ExplicitWaitFactory;

/**
 * The BasePage class serves as the base class for all page classes in the framework,
 * providing common methods and interactions with web elements.
 * 
 * <p>This class is authored by Mahesh Deevi on Dec 23, 2023.</p>
 */
public class BasePage {

	/**
	 * Constructs an instance of the BasePage.
	 * (Note: Use this constructor only if inheritance or internal initialization is required)
	 */
	protected BasePage() {}

	
	/**
	 * Performs a click action on the web element identified by the provided locator.
	 * 
	 * @param by            The By locator strategy to identify the web element.
	 * @param waitStrategy  The wait strategy to be applied before performing the click action.
	 * @param message       The message to log after the click action is performed.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	protected void click(By by, WaitStrategy waitStrategy, String message) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
		log(LoggerType.PASS, message);
	}

	/**
	 * Enters the specified value into the web element identified by the provided locator.
	 * 
	 * @param by            The By locator strategy to identify the web element.
	 * @param value         The value to be entered into the web element.
	 * @param waitStrategy  The wait strategy to be applied before entering the value.
	 * @param message       The message to log after entering the value.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String message) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
		log(LoggerType.PASS, message);
	}

	/**
	 * Performs a click action on the web element identified by the provided locator
	 * using the Actions class for more complex interactions.
	 * 
	 * @param by            The By locator strategy to identify the web element.
	 * @param waitStrategy  The wait strategy to be applied before performing the click action.
	 * @param message       The message to log after the click action is performed.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	protected void clickUsingActions(By by, WaitStrategy waitStrategy, String message) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(element).click().perform();
		log(LoggerType.PASS, message);
	}

	/**
	 * Retrieves the title of the current web page.
	 * 
	 * @return The title of the current web page.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}