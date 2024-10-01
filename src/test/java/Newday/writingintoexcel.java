package Newday;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingintoexcel {
	public static void main (String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream("C:\\Users\\91828\\eclipse-workspace\\seleniumwebd\\testdata\\NoteBookDataloop.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet= workbook.createSheet("Data");
		
//		XSSFRow row = sheet.createRow(0);
//		row.createCell(0).setCellValue("Program");
//		row.createCell(1).setCellValue("ID");
//		row.createCell(2).setCellValue("Extension");
//		
//		
//		XSSFRow row1 = sheet.createRow(3);
//		row1.createCell(0).setCellValue("Java");
//		row1.createCell(1).setCellValue(11);
//		row1.createCell(2).setCellValue("Java");
//		
//		XSSFRow row2 = sheet.createRow(1);
//		row2.createCell(0).setCellValue("Python");
//		row2.createCell(1).setCellValue(12);
//		row2.createCell(2).setCellValue("py");
//		
//		XSSFRow row3 = sheet.createRow(2);
//		row3.createCell(0).setCellValue("Excel");
//		row3.createCell(1).setCellValue(13);
//		row3.createCell(2).setCellValue("xls");
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int totalRow = scn.nextInt();
		System.out.println("Enter number of cells");
		int totalCell = scn.nextInt();
		System.out.println("Enter Data");
		
		for(int i=0; i<=totalRow; i++) {
			XSSFRow row = sheet.createRow(i);
			for(int j=0; j<totalCell; j++) {
				row.createCell(j).setCellValue(scn.next());
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File created");
	}

}
