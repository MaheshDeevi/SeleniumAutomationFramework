package com.md.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.md.annotations.FrameworkAnnotation;
import com.md.enums.CategoryType;
import com.md.pages.OrangeHRMLoginPage;
import com.md.utils.DecoderUtils;

public final class OrangeHRMTests extends BaseTest {
	
	private OrangeHRMTests() {}
	
	@FrameworkAnnotation(author= {"Mahesh","Harish"},category= {CategoryType.REGRESSION,CategoryType.SMOKE})
	@Test
	public void loginLogoutTest(Map<String,String> data) {
		
		String title = new OrangeHRMLoginPage()
				       .enterUsername(data.get("username")).enterPassword(DecoderUtils.getDecoderValue(data.get("password"))).clickLogin()
		               .clickUserProfile().clickLogout().getTitle();
		
		Assertions.assertThat(title)
		          .isEqualToIgnoringCase("OrangeHRM");
		
	}

	@FrameworkAnnotation(author= {"Mahesh"},category= {CategoryType.REGRESSION,CategoryType.SMOKE})
	@Test
	public void newTest(Map<String,String> data) {
		
		String title = new OrangeHRMLoginPage()
				       .enterUsername(data.get("username")).enterPassword(DecoderUtils.getDecoderValue(data.get("password"))).clickLogin()
		               .clickUserProfile().clickLogout().getTitle();
		
		Assertions.assertThat(title)
		          .isEqualToIgnoringCase("OrangeHRM");
		
	}

}
