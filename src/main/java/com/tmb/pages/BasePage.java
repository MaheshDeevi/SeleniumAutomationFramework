package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;


public class BasePage {

	protected BasePage() {

	}


	protected static void click(By by,WaitStrategy waitstrategy,String elementname) throws Exception {
		
	WebElement	element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);

	element.click();
	ExtentLogger.pass(elementname+" is clicked");

	}
	
	protected void sendKeys(By by,String value,WaitStrategy waitstrategy,String elementname) throws Exception {
		
		WebElement	element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);

		element.sendKeys(value);
		ExtentLogger.pass(value+" is enetered successfully in "+elementname);

	}
	
	protected String getPageTitle() {
		
		
		return DriverManager.getDriver().getTitle();

	}
	
	
	

}
