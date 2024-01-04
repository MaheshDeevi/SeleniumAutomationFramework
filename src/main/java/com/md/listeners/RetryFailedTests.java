package com.md.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.md.enums.ConfigProperties;
import com.md.utils.PropertyUtils;

/**
 * Implements {@link IRetryAnalyzer}.<p>
 * Helps in rerunning the failed tests.<p>
 * @since Dec 01, 2023
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 */
public class RetryFailedTests implements IRetryAnalyzer {
	
	int count = 0;
	int retries =1;

	/**
	 * Return true when needs to be retried and false otherwise.
	 * Maximum will retry for one time.
	 * Retry will happen if user desires to and set the value in the property file
	 */
	@Override
	public boolean retry(ITestResult result) {
     //false means no retry
	 //true means retry	
		boolean value = false;
		try {
			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			value = count<retries;
			count++;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return value;
	}

}

