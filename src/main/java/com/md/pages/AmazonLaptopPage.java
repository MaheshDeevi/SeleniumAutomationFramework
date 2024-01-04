package com.md.pages;

/**
 * The AmazonLaptopPage class represents a page in the Amazon application
 * specifically related to laptops.
 * 
 * <p>This class is authored by Mahesh Deevi on Dec 23, 2023.</p>
 */
public final class AmazonLaptopPage extends BasePage {
	
	/**
	 * Constructs an instance of the AmazonLaptopPage.
	 * (Note: Use this constructor only if inheritance or internal initialization is required)
	 */
	protected AmazonLaptopPage() {}
	
	
	/**
	 * Retrieves the title of the Amazon Laptop page.
	 * 
	 * @return The title of the Amazon Laptop page.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	public String getTitle() {
		return getPageTitle();
	}
}