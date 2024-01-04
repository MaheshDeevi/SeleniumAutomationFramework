package com.md.utils;

/**
 * Constructs a dynamic xpath at run time.
 * 
 * @since Dec 03, 2023
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 */
public final class DynamicXpathUtils {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DynamicXpathUtils() {}
	
	/**
	 * Receives a wildcard string, replace the wildcard with the value and return to the caller
	 * @author Mahesh Deevi
	 * @since Dec 03, 2023
	 * @param xpath Xpath with wildcard string
	 * @param value value to be replaced in place of wildcard
	 * @return dynamic xpath string
	 * 
	 */
	public static String getXpath(String xpath, String value) {
		
		return String.format(xpath, value);
		
	}

}

