package excelPractice;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Methods {
	public static void main(String[] args) throws Exception {
//		printAllSheetData();
		System.out.println("--------------------");
//		String [][] result = getAllSheetData("MOCK_DATA.xlsx", "data");
//		System.out.print(Arrays.deepToString(result));
		String cellData = getCellData("MOCK_DATA_2.xlsx","data2", 2,4);
		System.out.println(cellData.toString());
	}
	//CREATING 3 METHODS
	// 1st Method
	// Create a utility method to store all sheetData 
	// in two dimensional String Array

	// method name : getAllSheetData
	// return type : none 
	// params  : () 
	// logic , print everything in nice format
	
	public static void printAllSheetData() throws Exception {
		File excelFile = new File("MOCK_DATA.xlsx");
		Workbook wb = WorkbookFactory.create(excelFile);
		Sheet sheet = wb.getSheet("data");
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(0).getLastCellNum();
		for (int i = 0; i < rows; i++) {
			System.out.println("Row Number:" + (i+1));
			for (int j = 0; j < columns; j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				System.out.print(cell + "---");
			}
			System.out.println();
		}
		wb.close();
	}
	
	// 2nd Method
    // Create a utility method to store all sheetData 
    // in two dimensional String Array
    
    // method name : getAllSheetDate
    // return type : String[][]
    // params  :  FileName as String , SheetName
	
public static String [][] getAllSheetData(String fileName, String sheetName) throws Exception{
	//File excelFile = new File("MOCK_DATA.xlsx");
	FileInputStream fis = new FileInputStream(fileName);
	Workbook wb = WorkbookFactory.create(fis);
	
	Sheet sheet = wb.getSheet(sheetName);
	int rows = sheet.getPhysicalNumberOfRows();
	int columns = sheet.getRow(0).getLastCellNum();
	
	String [][] data = new String[rows][columns];
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < columns; j++) {
			Cell cell = sheet.getRow(i).getCell(j);
			data[i][j] = cell.toString(); 
		}
	}
	fis.close();
	wb.close();
	return data;
}
	//3rd Method
	public static String getCellData(String fileName, String sheetName, int rowIndex, int colIndex) throws Exception{
		String [][] result = getAllSheetData(fileName, sheetName);
		return result [rowIndex][colIndex];
	}


	
}
