package org.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest {
	
	private OrangeHRMTests() {
		
	}
	
	
	@Test
	public static void loginLogout(Map<String,String> map) throws Exception  {
		
		
		
	String title=	new OrangeHRMLoginPage().enterUserName(map.get("username")).enterPassword(map.get("password")).clickLogin()
		                                    .clickWelcomeLink().clickLogout()
		                                    .getTitle();
	
	Assertions.assertThat(title)
	          .isEqualTo("OrangeHRM");
		
		
	}
	
	@Test
	public static void loginTest(Map<String,String> map) throws Exception {
		
		
		
	String title=	new OrangeHRMLoginPage().enterUserName(map.get("username")).enterPassword(map.get("password")).clickLogin()
		                                    .clickWelcomeLink().clickLogout()
		                                    .getTitle();
	
	Assertions.assertThat(title)
	          .isEqualTo("OrangeHRM");
		
		
	}
	
	

}
