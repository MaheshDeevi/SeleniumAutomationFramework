package com.md.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.md.constants.FrameworkConstants;
import com.md.enums.ConfigProperties;
import com.md.exceptions.PropertyFileUsageException;

/**
 * Read the property file and store it in a HashMap for faster processing.
 * Users can prefer to use json instead of property file based on their requirement.
 * 
 * @since Dec 03, 2023
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 */
public final class PropertyUtils {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private PropertyUtils() {}
	
	
	private static Properties property = new Properties();
	
	/**
	 *  Underlying data structure of properties file is HashTable.
	 *  HashTable is slower, thread-safe and synchronized.
	 *  HashMap is faster, non-thread safe and non-synchronized.
	 *  Convert HashTable to HashMap
	 */
	private static final Map<String,String> CONFIGMAP = new HashMap<>();
	
	// Eager Initialization
	static {
		
		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
			 property.load(fis);
			 property.forEach((key,value)->CONFIGMAP.put(key.toString(), value.toString().trim()));
		}
		catch(IOException e) {
		    e.printStackTrace();
		    System.exit(0); //graceful termination
		}
		
		
	}
	
	/**
	 * Receives the {@link com.md.enums.ConfigProperties},converts to lowercase , return the corresponding value
	 * for the key from the HashMap
	 * @author Mahesh Deevi
	 * @since Dec 03, 2023
	 * @param key To be fetched from property file
	 * @return corresponding value for the requested key if found else {@link PropertyFileUsageException}
	 */
	public static String get(ConfigProperties key) {
		 
		 if(Objects.isNull(CONFIGMAP.get(key.toString().toLowerCase())) || Objects.isNull(key.toString().toLowerCase())) {
			 throw new PropertyFileUsageException("Property name "+key+" is not found.Please check config.properties file");
		 }
		 
		 return CONFIGMAP.get(key.toString().toLowerCase());
		 
	 }

}
