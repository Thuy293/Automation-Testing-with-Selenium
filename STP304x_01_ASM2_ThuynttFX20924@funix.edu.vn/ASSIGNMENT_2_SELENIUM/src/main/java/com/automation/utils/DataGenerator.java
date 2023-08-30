package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {
	@DataProvider(name = "excel")
	
	public static Object[][] getDataFromExel() throws IOException{
		FileInputStream file = new FileInputStream("./data/assignment2_data_test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet loginsheet = workbook.getSheet("Login");
		int numberOfRowData = loginsheet.getPhysicalNumberOfRows();
		
		Object[][] data = new Object[numberOfRowData][2];
		
		for (int i=0; i < numberOfRowData; i++) {
			 XSSFRow row = loginsheet.getRow(i);
			 XSSFCell email = row.getCell(0);
			 XSSFCell password = row.getCell(1);
			 data [i][0] = email.getStringCellValue();
			 data [i][1] = password.getStringCellValue();
			
		}
		return data;
	}

}
