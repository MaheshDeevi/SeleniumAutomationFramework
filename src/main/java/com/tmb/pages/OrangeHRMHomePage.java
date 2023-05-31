package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage {
	
	private static final By linktxt_welcome = By.xpath("//*[@id=\"welcome\"]");
	private static final By linktxt_logout = By.linkText("Logout");
	
	public OrangeHRMHomePage clickWelcomeLink() throws Exception {
		click(linktxt_welcome,WaitStrategy.CLIKCKABLE,"Welcome Link");
		
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() throws Exception {
		//Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		click(linktxt_logout,WaitStrategy.CLIKCKABLE,"Logout button");
		
		return new OrangeHRMLoginPage();
	}

}
