/**
 * 
 */
package com.test.browser.setup;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

/**
 * @author Anup
 *
 * 02-Sept-2025
 */
public class ExcelSheetData extends GeneralBrowserSetting{
	Sheet sheet;
	Workbook wb;
	public static String sheetName;


	public static String getData(String sheetName,int rowName,int colName) throws InvalidFormatException, IOException, InterruptedException{
		String data = null;
		Thread.sleep(500);
		try {
			String path = readPropertiesFileData("INPUTEXCELFILEPATH");
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowName);
			data = row.getCell(colName).getStringCellValue();


		} catch (Exception e) {
			System.out.println("Error: occure in input file path..." +e.getMessage());
		}
		return data.toString();	
	}
	}



