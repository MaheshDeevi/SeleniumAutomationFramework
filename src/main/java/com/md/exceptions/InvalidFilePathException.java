package com.md.exceptions;

/**
 * Runtime Exception occurs when the path given for any of the files is incorrect.
 * @since Dec 01, 2023 
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
public class InvalidFilePathException extends FrameworkException {

	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public InvalidFilePathException(String message) {
		super(message);
		
	}
	
	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public InvalidFilePathException(String message,Throwable cause) {
		super(message,cause);
		
	}

}
