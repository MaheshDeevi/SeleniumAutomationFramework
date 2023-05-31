package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage {
	
	protected AmazonHamburgerMenuPage() {}
	
	private String linkComputers = "//div[text()='Mobiles, Computers']/parent::a";
	private String linkSubMenu = "//a[text()='%s']";
	
	public AmazonHamburgerMenuPage clickComputer() throws Exception {
		click(By.xpath(linkComputers),WaitStrategy.CLIKCKABLE,"Mobiles and Computers");
		return this;
	}
	
	public AmazonLaptopPage clickOnSubMenuItem(String menutext) throws Exception {
		
		String newXpath = DynamicXpathUtils.getXpath(linkSubMenu, menutext);
		click(By.xpath(newXpath),WaitStrategy.CLIKCKABLE,menutext);
		if(menutext.contains("Laptops")) {
			return new AmazonLaptopPage();
		}
		return null;
		
	}

}
