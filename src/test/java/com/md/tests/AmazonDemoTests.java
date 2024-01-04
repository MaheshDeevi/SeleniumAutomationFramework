package com.md.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.md.annotations.FrameworkAnnotation;
import com.md.enums.CategoryType;
import com.md.pages.AmazonHomePage;

/**
 * The AmazonDemoTests class contains test methods related to Amazon functionality.
 * 
 * <p>This class is authored by Mahesh Deevi on Dec 23, 2023.</p>
 */
public final class AmazonDemoTests extends BaseTest {
	
	// Private constructor to prevent instantiation of the class
	private AmazonDemoTests() {}
	
	
	
	/**
	 * Test method for Amazon functionality.
	 * 
	 * @param data A map containing test data.
	 * 
	 * @since Dec 23, 2023
	 * @author Mahesh Deevi
	 */
	@FrameworkAnnotation(author = {"Mahesh"}, category = {CategoryType.REGRESSION, CategoryType.SMOKE})
	@Test
	public void amazonTest(Map<String, String> data) {
		String title = new AmazonHomePage().clickHamburger()
				                           .clickMainMenu(data.get("mainmenu"))
				                           .clickOnSubMenuItem(data.get("submenu"))
				                           .getTitle();

		Assertions.assertThat(title)
		          .isNotBlank();
	}
}