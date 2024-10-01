package utilties;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    // Method to load Excel file
    public static void loadExcel(String filePath, String sheetName) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(inputStream); // For .xlsx files
        sheet = workbook.getSheet(sheetName);     // Load the specific sheet
    }

    // Get number of rows in the Excel sheet
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Get number of columns in a specific row
    public static int getColumnCount(int rowNum) {
        return sheet.getRow(rowNum).getPhysicalNumberOfCells();
    }

    // Method to get data from Excel file
    public static Object[][] getTestData(String filePath, String sheetName) throws IOException {
        loadExcel(filePath, sheetName);

        int rowCount = getRowCount();
        int colCount = getColumnCount(0);

        Object[][] data = new Object[rowCount - 1][colCount]; // Create array to store data

        for (int i = 1; i < rowCount; i++) {  // Skipping the header row (i=1)
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = getCellValue(cell); // Fetch data cell by cell
            }
        }

        workbook.close();
        return data;
    }

    // Helper method to handle different data types
    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return null;
        }
    }
}
