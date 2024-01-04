package com.md.utils;

import java.util.Base64;

/**
 * Helps to decode the base64 encoded string.
 * 
 * @since Dec 03, 2023 
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 */
public final class DecoderUtils {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DecoderUtils() {}
	
	/**
	 * Accepts and base64 string,decode and return to the caller
	 * 
	 * @author Mahesh Deevi
	 * @since Dec 03, 2023
	 * @param encodedString Base64 encoded string
	 * @return String Decoded base64 string
	 */
	public static String getDecoderValue(String encodedString) {
		
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
		
	}

}