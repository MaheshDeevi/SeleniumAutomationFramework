package com.md.constants;

import com.md.enums.ConfigProperties;
import com.md.utils.PropertyUtils;

/**
 * Framework Constants holds all the constant values used within the framework. If some value needs to be changed
 * or modified often, then it should be stored in the property files
 * 
 * <p>Nov 30, 2023 
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 * @see com.md.utils.PropertyUtils
 */
public final class FrameworkConstants {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameworkConstants() {}

	private static final String USERDIRPATH = System.getProperty("user.dir");

	private static final String CHROMEDRIVERPATH = USERDIRPATH+"/src/test/resources/executables/chromedriver.exe";
	private static final String EDGEDRIVERPATH = USERDIRPATH+"/src/test/resources/executables/msedgedriver.exe";
	private static final String CONFIGFILEPATH   = USERDIRPATH+"/src/test/resources/config/config.properties";
	private static final String LOG4JCONFIGFILEPATH   = USERDIRPATH+"/src/test/resources/config/log4j.properties";
	private static final String EXCELFILEPATH    = USERDIRPATH+"/src/test/resources/testdata/TestData.xlsx";
	private static final int    EXPLICITWAITTIME     = 10;
	private static final String EXTENTREPORTFOLDERPATH = USERDIRPATH+"/test-results/";
	private static String extentReportFilePath = "";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String DATASHEET = "DATA";
	
	/**
	 * Retrieves the sheet name for the Run Manager from the configuration.
	 *
	 * @return The sheet name for the Run Manager.
	 */
	public static String getRunManagerSheet() {
	    return RUNMANAGERSHEET;
	}

	/**
	 * Retrieves the sheet name for the data from the configuration.
	 *
	 * @return The sheet name for the data.
	 */
	public static String getDataSheet() {
	    return DATASHEET;
	}

	/**
	 * Retrieves the file path for the Excel workbook from the configuration.
	 *
	 * @return The file path for the Excel workbook.
	 */
	public static String getExcelFilePath() {
	    return EXCELFILEPATH;
	}

	/**
	 * Retrieves the explicit wait time from the configuration.
	 *
	 * @return The explicit wait time in seconds.
	 */
	public static int getExplicitWaitTime() {
	    return EXPLICITWAITTIME;
	}

	/**
	 * Retrieves the file path for the configuration file.
	 *
	 * @return The file path for the configuration file.
	 */
	public static String getConfigFilePath() {
	    return CONFIGFILEPATH;
	}

	/**
	 * Retrieves the file path for the ChromeDriver executable.
	 *
	 * @return The file path for the ChromeDriver executable.
	 */
	public static String getChromeDriverPath() {
	    return CHROMEDRIVERPATH;
	}

	/**
	 * Retrieves the file path for the EdgeDriver executable.
	 *
	 * @return The file path for the EdgeDriver executable.
	 */
	public static String getEdgeDriverPath() {
	    return EDGEDRIVERPATH;
	}

	/**
	 * Retrieves the file path for the Log4j configuration file.
	 *
	 * @return The file path for the Log4j configuration file.
	 */
	public static String getLog4jconfigfilepath() {
	    return LOG4JCONFIGFILEPATH;
	}


	/**
	 * 
	 * @author Mahesh Deevi
	 * <p>Nov 30, 2023
	 * @return Extent Report path where the index.html file will be generated.
	 */
	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}


	/**
	 * 
	 * @author Mahesh Deevi
	 * <p>Jan 21, 2021
	 * @return  If Override reports value in the 
	 * property file is no,then the timestamp will be appended
	 */
	private static String createReportPath() {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORT).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+"index_"+new java.util.Date().toString().replace(':', '.')+".html";  
		}
		else {
			return EXTENTREPORTFOLDERPATH+"index.html";
		}

	}


	

}
