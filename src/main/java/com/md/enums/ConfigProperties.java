package com.md.enums;

/**
 * Enums to restrict the values used on Property files. Without using enums there can be null pointer exceptions happening
 * because of typos.
 * <p>
 * Whenever a new value is added to property file, corressponding enum should be created here.
 * 
 * Dec 01, 2023
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 * @see com.md.utils.PropertyUtils
 */
public enum ConfigProperties {
	
	URL,
	OVERRIDEREPORT,
	PASSEDSTEPSSCREENSHOTS,
	FAILEDSTEPSSCREENSHOTS,
	SKIPPEDSTEPSSCREENSHOTS,
	ENABLELOGS,
	RETRYFAILEDTESTS,
	RUNMODE,
	SELENIUMGRIDURL,
	SENDRESULTSTOELK,
	ELASTICSEARCHURL

}
