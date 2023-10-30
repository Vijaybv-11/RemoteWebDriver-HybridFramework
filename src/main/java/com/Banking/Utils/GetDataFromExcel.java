package com.Banking.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcel implements FrameworkConstants {


	public Map<String, String> readData(String sheetname, String uniqueId, String UniqueDataHeader) {
		String sheetName = sheetname;
		String testcaseID = uniqueId;
		String textcaseheader = UniqueDataHeader;
		
		Map<String, String> map = new HashMap<String, String>();

		try {
	        FileInputStream fis = new FileInputStream(ExcelFilePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);

	      

	        int lastRow = sheet.getLastRowNum();
	        int rowIndx = 0;
	        for (int i = 0; i <= lastRow; i++) {
	            try {
	                Row currentRow = sheet.getRow(i);
	                if (currentRow != null) { // Check if the row is not null
	                    String data = currentRow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
	                    if (data.equals(testcaseID)) {
	                        rowIndx = i;
	                        break;
	                    }
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

			// end row number

			// fetch data from the cell

			int count = 0, headerRowNo = 0;
			String key = "";
			for (int i = rowIndx; i >= 0; i--) {
				String excelData = sheet.getRow(i).getCell(0).getStringCellValue();
				// header
				if (textcaseheader.equalsIgnoreCase(excelData)) {
					headerRowNo = i;
					break;
				}
				count++;
			}
			
			int cellCount = sheet.getRow(rowIndx).getLastCellNum();
			
			for (int i = 0; i < cellCount; i++) {
				Cell cell = sheet.getRow(rowIndx).getCell(i);
				String value1 = "";
				String key1 = sheet.getRow(headerRowNo).getCell(i).toString();

				switch (cell.getCellType()) {
				case NUMERIC:
					value1 = sheet.getRow(rowIndx).getCell(i).toString();
					value1 = value1.substring(0, value1.length() - 2);
					break;
				default:
					value1 = sheet.getRow(rowIndx).getCell(i).toString();
				}
				map.put(key1.trim(), value1);
			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
		
		

	}
}
