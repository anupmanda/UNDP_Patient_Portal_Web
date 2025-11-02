package com.test.readdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.*;

public class ExcelSheetDataProvider {

    public static Object[][] getExcelData(String sheetName) throws IOException {

        String filePath = System.getProperty("user.dir") + "\\InputData\\UNDP_Patient_Portal.xlsx";
        FileInputStream ip = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(ip);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            ip.close();
            throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file: " + filePath);
        }

        int rows = sheet.getLastRowNum();       // header row excluded
        int cols = sheet.getRow(0).getLastCellNum();

        if (rows == 0) {
            workbook.close();
            ip.close();
            return new Object[0][0];  // koi data nahi, koi test nahi chalega
        }

        Object[][] data = new Object[rows][cols];

        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i + 1);
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    data[i][j] = "";
                    continue;
                }
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            data[i][j] = dateFormat.format(cell.getDateCellValue());
                        } else {
                            data[i][j] = String.valueOf(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;
                    default:
                        data[i][j] = "";
                        break;
                }
            }
        }

        workbook.close();
        ip.close();
        return data;
    }
}
