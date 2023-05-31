package com.tmb.reports;



import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;
import com.tmb.utils.ScreenshotUtils;

public final class ExtentLogger {
	
	private ExtentLogger() {
		
	}
	
	public static void pass(String message) throws Exception {
		
		if(PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
			
			ExtentManager.getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			
		}
		else {
			ExtentManager.getExtentTest().pass(message);
			
		}
	}

	public static void fail(String message) throws Exception {
		
		if(PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {

			ExtentManager.getExtentTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			
		}
		else {
			ExtentManager.getExtentTest().fail(message);

		}
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}
	
	
	
	

}
