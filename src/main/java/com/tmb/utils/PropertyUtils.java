package com.tmb.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.PropertyFileException;

public final class PropertyUtils {

	private PropertyUtils() {

	}

	private static final Properties prop = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<>();

	//eager initialization
	static {
		
		try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigpath())) {
			
			prop.load(file);

			for(Map.Entry<Object,Object> entry:prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());

			}
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0); // terminates the program gracefully
		}
		
	}

	public static String getValue(ConfigProperties key) {

		String propVal = CONFIGMAP.get(key.name().toLowerCase());	
		
		if(Objects.isNull(key) || Objects.isNull(propVal) ) {
			throw new PropertyFileException("Property name "+key+" or Property Value "+propVal+" not found in config file. Please check");
		}
		return propVal;

	}


	/********Additional notes:
	 * ===============
	 * Properties file acts as Hashtable
	 * Hashtable is slow and thread safe
	 * conver hashtable to hashmap
	 * *******************/

}
