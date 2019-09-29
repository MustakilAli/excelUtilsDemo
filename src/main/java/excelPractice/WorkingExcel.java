package excelPractice;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WorkingExcel {
	
	

	public static void main(String[] args) throws Exception{

		//workbook --> sheet ---> Row --> Cell
		
		//Earlier version of poi library 
		//Have 2 different set of classes to work with xls, xlsx files
		/*
		 * xls files -a-k-a-> MS Excel 1997-2003 (old version)
		 * (object)HSSFWorkbook, HSSFSheet, HSSFRow, HSSFCell
		 * xlsx (newer version of excel) 
		 * XSSFWorkbook, XSSFSheet, XSSFRow, XSSFCell
		 * 
		 */
		File excelFile = new File("MOCK_DATA.xlsx");
		Workbook wb = WorkbookFactory.create(excelFile);
		//Getting number of sheets in Excel File VVV
//		System.out.println(wb.getNumberOfSheets());
		//Can retrieve sheet either through cell name 
		Sheet data = wb.getSheet("data");
		//or through indexes
		
//		Row row1 = data.getRow(0);
//		Cell c1 = row1.getCell(1);
//		System.out.println(c1);
		
//		int rowCount = sh.getLastRowNum();
//		System.out.println(rowCount);
		
		
		
		//getPhysicalNumberOfRows will return actual rowNumber
		//whether you have empty value row or not
		int actualRowCount = data.getPhysicalNumberOfRows();
		
		System.out.println(actualRowCount);
		//Getting how many columns are in first row 
		int columnCountInFirstRow =  data.getRow(0).getLastCellNum();
		System.out.println(columnCountInFirstRow);
		
		//Using Nested Loops to loop through data sheet's columns and rows
		for (int i = 0; i < actualRowCount; i++) {
			//If you want to get the row number. 
			System.out.println("ROW NUMBER : " + (i+1));
			Row row = data.getRow(i);
			for (int j = 0; j < columnCountInFirstRow; j++) {
				//pure data from Cell Class
				Cell cell = row.getCell(j);
				System.out.print(cell + "---");
			}
			System.out.println();
		}
		
		//Every time you finish using workbook, make sure to close workbook to avoid Exceptions. 
		wb.close();
	}

}
