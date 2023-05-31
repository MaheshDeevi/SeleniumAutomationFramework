package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.constants.FrameworkConstants;
import com.tmb.exceptions.FrameworkException;
import com.tmb.exceptions.InvalidExcelPathException;

public final class ExcelUtils {
	
	private ExcelUtils() {}
	
	public static List<Map<String,String>> getTestDetails(String sheetname) {
		
		List<Map<String,String>> list = null;
		
		
		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath())) {
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = workbook.getSheet(sheetname);
			
			Map<String,String> map = null;
			int lastrownum = sheet.getLastRowNum(); // gives last row number - starts with index 0
			int lastcolnum = sheet.getRow(0).getLastCellNum(); //gives last cell number - starts from 1
			
			list = new ArrayList<>();
			
			for(int i=1;i<=lastrownum;i++) {
				map = new HashMap<>();
				for(int j=0;j<lastcolnum;j++) {
					
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				
				list.add(map);
			}
		} 
		
		catch (FileNotFoundException e) {
			
			throw new InvalidExcelPathException("Excel file path is not found. Please check");
		}
		
		 catch (IOException e) {
			
			throw new FrameworkException("Not able to read or write from excel. Please check");
		}
		
		
		
		
		
		return list;
		
	}

}
