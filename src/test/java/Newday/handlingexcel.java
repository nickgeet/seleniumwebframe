package Newday;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class handlingexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("C:\\Users\\91828\\eclipse-workspace\\seleniumwebd\\testdata\\BookData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int countsheet = sheet.getLastRowNum();
		int countcells = sheet.getRow(1).getLastCellNum();
		System.out.println(countsheet);
		System.out.println(countcells);
		
		for(int i=0; i<=countsheet; i++) {
			XSSFRow currentrow = sheet.getRow(i);
			
			for(int j=0; j<countcells; j++) {
				XSSFCell cell = currentrow.getCell(j);
				System.out.print(cell.toString() +"\t");
				}
			System.out.println();
		}
		workbook.close();
		file.close();

	}

}
