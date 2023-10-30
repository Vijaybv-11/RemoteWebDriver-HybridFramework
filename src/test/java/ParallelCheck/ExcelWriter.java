package ParallelCheck;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {
    public static void main(String[] args) {
        String filePath = ".//tessData//DemoBankData.xlsx";
        String sheetName = "New Account";
        String uniqueIdentifier = "TC002"; // Unique data to find the row
        String dataToWrite = "Data to Write";

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = null;
            Row dataRow = null;

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(uniqueIdentifier)) {
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
                                if (header.trim().equals("Account_ID")) {
                                    columnIndex = headerCell.getColumnIndex();
                                    break;
                                }
                            }
                        }

                        if (columnIndex >= 0) {
                            Cell dataCell = dataRow.createCell(columnIndex, CellType.STRING);
                            dataCell.setCellValue(dataToWrite);

                            try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
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
