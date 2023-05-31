package com.tmb.exceptions;

/**
 * Jan 11, 2022
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 * @param browser
 */
@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends RuntimeException {
	
	public BrowserInvocationFailedException(String message) {
		super(message);
		
	}
	
	public BrowserInvocationFailedException(String message,Throwable cause) {
		super(message,cause);
		
	}

}
