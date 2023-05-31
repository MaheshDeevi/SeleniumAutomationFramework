package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DecoderUtils;

public final class OrangeHRMLoginPage extends BasePage {
	
	
	
	/*
	 * id
	 * name
	 * classname
	 * linktext
	 * partial link text
	 * css or xpath
	 */
	
	private static final By textbox_username = By.id("txtUsername");
	private static final By textbox_password = By.id("txtPassword");
	private static final By button_login = By.id("btnLogin");
	
	public OrangeHRMLoginPage enterUserName(String username) throws Exception {
		sendKeys(textbox_username,username,WaitStrategy.PRESENCE,"Username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) throws Exception {
		sendKeys(textbox_password,DecoderUtils.getDecoderValue(password),WaitStrategy.PRESENCE,"Password");
		return this;
	}
	
	public OrangeHRMHomePage clickLogin() throws Exception {
		click(button_login,WaitStrategy.CLIKCKABLE,"Login button");
		
		return new OrangeHRMHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
		 
	}

}
