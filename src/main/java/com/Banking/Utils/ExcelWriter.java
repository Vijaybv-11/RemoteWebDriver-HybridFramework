package com.Banking.Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter implements FrameworkConstants {
       
      public void   updateCell(String sheetName,String columnName,String uniqueIdentifier, String dataToWrite  ) {
        try (FileInputStream fis = new FileInputStream(new File(ExcelFilePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = null;
            Row dataRow = null;

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().trim().equals(uniqueIdentifier)) {
                        dataRow = row;
                        break;
                    }
                }

                if (dataRow != null) {
                    // Use the previous row as column headers
                    int rowIndex = dataRow.getRowNum();
                    if (rowIndex > 0) {
                        headerRow = sheet.getRow(rowIndex - 1);
                    }

                    if (headerRow != null) {
                        int columnIndex = -1;
                        for (Cell headerCell : headerRow) {
                            if (headerCell.getCellType() == CellType.STRING) {
                                String header = headerCell.getStringCellValue();
                                // Assuming you know the column header name
                                if (header.trim().equals(columnName)) {
                                    columnIndex = headerCell.getColumnIndex();
                                    break;
                                }
                            }
                        }

                        if (columnIndex >= 0) {
                            Cell dataCell = dataRow.createCell(columnIndex, CellType.STRING);
                            dataCell.setCellValue(dataToWrite);

                            try (FileOutputStream fos = new FileOutputStream(new File(ExcelFilePath))) {
                                workbook.write(fos);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Column header not found.");
                        }
                    } else {
                        System.out.println("Header row not found.");
                    }
                    break;
                }
            }

            if (dataRow == null) {
                System.out.println("Unique identifier not found in the sheet.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
}
}
