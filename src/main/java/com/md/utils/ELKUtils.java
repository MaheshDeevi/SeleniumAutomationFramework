package com.md.utils;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.md.enums.ConfigProperties;

import io.restassured.response.Response;

/**
 * Dec 20, 2023 
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 */
public final class ELKUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ELKUtils() {}

	
	/**
	 * Sends details to ELK (Elasticsearch, Logstash, Kibana) for test result tracking.
	 *
	 * @param testname  The name of the test.
	 * @param status    The status of the test (e.g., "Pass" or "Fail").
	 * @param author    The author of the test (e.g., Mahesh Deevi).
	 * @param browser   The browser used for the test.
	 * @param version   The version of the browser used for the test.
	 */
	public static void sendDetailsToElk(String testname, String status, String author, String browser, String version) {

	    if (PropertyUtils.get(ConfigProperties.SENDRESULTSTOELK).equalsIgnoreCase("yes")) {
	        Map<String, String> map = new HashMap<>();
	        map.put("testName", testname);
	        map.put("status", status);
	        map.put("author", author);
	        map.put("browser", browser);
	        map.put("version", version);
	        map.put("executionTime", TimeStampUtils.createTimeStampForELK());

	        Response response = given().header("Content-Type", "application/json")
	                .log()
	                .all()
	                .body(map)
	                .post(PropertyUtils.get(ConfigProperties.ELASTICSEARCHURL));

	        Assert.assertEquals(response.statusCode(), 201);

	        response.prettyPrint();
	    }
	}

}
