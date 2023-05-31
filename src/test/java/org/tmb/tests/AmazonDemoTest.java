package org.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.AmazonHomePage;

public final class AmazonDemoTest extends BaseTest {
	
	private AmazonDemoTest() {
		
	}
	
	@FrameworkAnnotation(author = { "Mahesh Deevi" }, category = { CategoryType.REGRESSION,CategoryType.SANITY })
	@Test
	public static void amazonTest(Map<String,String> data) throws Exception {
		String title = new AmazonHomePage().clickHamburger().clickComputer().clickOnSubMenuItem(data.get("submenu")).getTitle();
		
		Assertions.assertThat(title)
		.isNotBlank();
	}

}
