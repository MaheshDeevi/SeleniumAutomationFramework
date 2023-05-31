package com.tmb.utils;

import java.util.Base64;

public final class DecoderUtils {
	
	private DecoderUtils() {}
	
	public static String getDecoderValue(String encodedString) {
		
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
		
		
	}

}
