package com.md.pages;

import org.openqa.selenium.By;

import com.md.enums.WaitStrategy;

/**
 * The AmazonHomePage class represents the main page of the Amazon application,
 * providing methods to interact with elements on the home page.
 * 
 * <p>This class is authored by Mahesh Deevi on Dec 23, 2023.</p>
 */
public final class AmazonHomePage extends BasePage {
	
	/**
	 * Locator for the hamburger menu link on the Amazon home page.
	 */
	private final By linkHamburger = By.id("nav-hamburger-menu");
	
	
	/**
	 * Clicks on the hamburger menu link to open the Amazon Hamburger Menu page.
	 * 
	 * @return An instance of AmazonHamburgerMenuPage representing the opened Hamburger Menu page.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	public AmazonHamburgerMenuPage clickHamburger() {
		click(linkHamburger, WaitStrategy.CLICKABLE, "Hamburger is clicked");
		return new AmazonHamburgerMenuPage();
	}
}