package com.md.pages;

import org.openqa.selenium.By;

import com.md.enums.WaitStrategy;
import com.md.utils.DynamicXpathUtils;

/**
 * The AmazonHamburgerSubMenuPage class represents a page in the Amazon application
 * that interacts with the hamburger menu and its sub-menu items.
 * 
 * <p>This class is authored by Mahesh Deevi on Dec 23, 2023.</p>
 */
public final class AmazonHamburgerSubMenuPage extends BasePage {
	
	/**
	 * Constructs an instance of the AmazonHamburgerSubMenuPage.
	 * (Note: Use this constructor only if inheritance or internal initialization is required)
	 */
	protected AmazonHamburgerSubMenuPage() {}
	
	/**
	 * XPath pattern for sub-menu links.
	 */
	private String linkSubMenu = "//a[text()='%s']";
	
	/**
	 * Clicks on a sub-menu item in the Amazon hamburger menu.
	 * 
	 * @param submenuText The text of the sub-menu item to be clicked.
	 * @return An instance of AmazonLaptopPage if the clicked item is "Laptops"; otherwise, null.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	public AmazonLaptopPage clickOnSubMenuItem(String submenuText) {
		// Generate dynamic XPath based on the provided submenu text
		String newXpath = DynamicXpathUtils.getXpath(linkSubMenu, submenuText);
		
		// Click on the sub-menu item using the defined wait strategy
		clickUsingActions(By.xpath(newXpath), WaitStrategy.CLICKABLE, submenuText + " is clicked");
		
		// Return AmazonLaptopPage instance if submenuText contains "Laptops"
		if (submenuText.contains("Laptops")) {
			return new AmazonLaptopPage();
		}
		
		// Return null for other sub-menu items
		return null;
	}
}