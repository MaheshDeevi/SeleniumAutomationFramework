package com.md.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.md.constants.FrameworkConstants;
import com.md.exceptions.FrameworkException;
import com.md.exceptions.InvalidFilePathException;

/**
 * Utility class to read or write to excel.
 * 
 * @since Dec 03, 2023
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 * @see com.md.listeners.MethodInterceptor
 * @see DataProviderUtils
 */
public final class ExcelUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExcelUtils() {}

	/**
	 * Encapsulates all the value from the mentioned excel sheet and store it in
	 * List holding HashMaps. Key for the map in the column header in the excel sheet.
	 * 
	 * @author Mahesh Deevi
	 * @since Dec 03, 2023
	 * @param sheetName : Excel sheetname to read the value from
	 * @return List where each index holds a map and Each map holds the details about the test
	 */
	public static List<Map<String, String>> getTestDetails(String sheetName) {

		List<Map<String, String>> data = null;
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelFilePath())) {
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rownum = sheet.getLastRowNum();
			int colnum = sheet.getRow(0).getLastCellNum();
			data = new ArrayList<>();
			Map<String, String> map;
			for (int i = 1; i <= rownum; i++) {
				map = new HashMap<>();
				for (int j = 0; j < colnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String val = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, val);
				}
				data.add(map);
			}

		} catch (FileNotFoundException e) {

			throw new InvalidFilePathException("Excel file path is not found. Please check");
		}

		catch (IOException e) {

			throw new FrameworkException("Not able to read or write from excel. Please check");
		}

		return data;

	}

}
