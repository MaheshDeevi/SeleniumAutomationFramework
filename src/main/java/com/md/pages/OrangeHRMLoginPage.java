package com.md.pages;

import org.openqa.selenium.By;

import com.md.enums.WaitStrategy;

/**
 * The OrangeHRMLoginPage class represents the login page of the OrangeHRM application,
 * providing methods to interact with login-related elements.
 * 
 * <p>This class is authored by Mahesh Deevi on Dec 23, 2023.</p>
 */
public final class OrangeHRMLoginPage extends BasePage {

	// Locators for OrangeHRMLoginPage initialized here
	private final By textboxUsername = By.xpath("//input[@name='username']");
	private final By textboxPassword = By.name("password");
	private final By buttonLogin = By.xpath("//button[text()=' Login ']");

	
	/**
	 * Enters the specified username into the username textbox on the OrangeHRM login page.
	 * 
	 * @param username The username to be entered.
	 * @return An instance of OrangeHRMLoginPage after entering the username.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	public OrangeHRMLoginPage enterUsername(String username) {
		sendKeys(textboxUsername, username, WaitStrategy.VISIBILE, username + " is entered in username textbox");
		return this;
	}

	
	/**
	 * Enters the specified password into the password textbox on the OrangeHRM login page.
	 * 
	 * @param password The password to be entered.
	 * @return An instance of OrangeHRMLoginPage after entering the password.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, password, WaitStrategy.VISIBILE, password + " is entered in password textbox");
		return this;
	}

	
	/**
	 * Clicks the login button on the OrangeHRM login page.
	 * 
	 * @return An instance of OrangeHRMHomePage after clicking the login button.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	public OrangeHRMHomePage clickLogin() {
		click(buttonLogin, WaitStrategy.CLICKABLE, "Login button is clicked");
		return new OrangeHRMHomePage();
	}

	
	/**
	 * Retrieves the title of the current web page.
	 * 
	 * @return The title of the current web page.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	public String getTitle() {
		return getPageTitle();
	}
}