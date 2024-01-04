package com.md.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.md.utils.DataProviderUtils;

/**
 * Implements {@link org.testng.IAnnotationTransformer} to leverage certain functionality like updating the annotations of test
 * methods at runtime.
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 * 
 * @since Dec 01, 2023 
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 * @see com.md.utils.DataProviderUtils
 */
public class AnnotationTransformer implements IAnnotationTransformer {

	/**
	 * Helps in setting the dataprovider, dataprovider class and retry analyser annotation to all the test methods
	 * at run time. 
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setDataProviderClass(DataProviderUtils.class);
		annotation.setDataProvider("getData");
		annotation.setRetryAnalyzer(RetryFailedTests.class);
		
	}

}
