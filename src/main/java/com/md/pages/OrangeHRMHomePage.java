package com.md.pages;

import org.openqa.selenium.By;

import com.md.enums.WaitStrategy;

/**
 * The OrangeHRMHomePage class represents the home page of the OrangeHRM application,
 * providing methods to interact with elements specific to this page.
 * 
 * <p>This class is authored by Mahesh Deevi on Dec 23, 2023.</p>
 */
public final class OrangeHRMHomePage extends BasePage {
	
	// Locators for OrangeHRMHomePage initialized here
	private final By dropdownUserprofile = By.className("oxd-userdropdown-tab");
	private final By linkLogout = By.linkText("Logout");
	
	
	/**
	 * Clicks on the user profile dropdown to open the associated menu.
	 * 
	 * @return An instance of OrangeHRMHomePage after clicking the user profile icon.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	public OrangeHRMHomePage clickUserProfile() {
		click(dropdownUserprofile, WaitStrategy.CLICKABLE, "UserProfile icon is clicked");
		return this;
	}
	
	
	/**
	 * Clicks on the "Logout" link to log out from the OrangeHRM application.
	 * 
	 * @return An instance of OrangeHRMLoginPage after clicking the Logout button.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	public OrangeHRMLoginPage clickLogout() {
		click(linkLogout, WaitStrategy.CLICKABLE, "Logout button is clicked");
		return new OrangeHRMLoginPage();
	}
}