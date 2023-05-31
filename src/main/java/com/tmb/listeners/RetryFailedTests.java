package com.tmb.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {
	
	int count = 0;
	int retries =1;

	@Override
	public boolean retry(ITestResult result) {
     //false means no retry
	 //true means retry	
		boolean value = false;
		try {
			if(PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
			value = count<retries;
			count++;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return value;
	}

}
