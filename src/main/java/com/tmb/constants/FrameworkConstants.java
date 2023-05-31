package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
	private static final String CHROMEDRIVERPATH = "./src/test/resources/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = "./src/test/resources/executables/geckodriver.exe";
	private static final String CONFIGPATH = "./src/test/resources/config/config.properties";
	private static final int EXPLICITWAIT  = 10;
	private static final String EXCELPATH  = "./src/test/resources/excel/testdata.xlsx";
	
	
	public static String getExcelpath() {
		return EXCELPATH;
	}

	private static final String EXTENTREPORTFOLDERPATH  = System.getProperty("user.dir")+"/test-results/";
	private static  String EXTENTREPORTFILEPATH  = "";

	

	public static String getExtentreportfilepath() {
		if(EXTENTREPORTFILEPATH.isEmpty()) {
			EXTENTREPORTFILEPATH = createReportPath();
			System.out.println(EXTENTREPORTFILEPATH);
		}
		return EXTENTREPORTFILEPATH;
	}
	
	private static String createReportPath() {
		if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORT).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"index.html";
		}
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigpath() {
		return CONFIGPATH;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	
	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}

}
