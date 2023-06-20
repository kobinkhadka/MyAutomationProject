package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utilities {
	
	
	public static final int IMPLICIT_WAIT_TIME = 10; 
	
	public static final int PAGE_LOAD_TIME = 10; 
	

	public static String generateEmailWithTimeStamp() {
		
		
		
		
		Date date = new Date();
	
		String timestamp = date.toString().replace(" ","_").replace(":", "_");
		
		return "test" + timestamp+ "@gmail.com";
		 
		}
	
	
	
	public static String  randomNameGenerator() {
			 
		    int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 6;
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int i = 0; i < targetStringLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    String generatedString = buffer.toString();
		    
		    
		    return generatedString;

		}
		
	
	
	
	//Read for Excel file
	public static Object[][] getDataFromExcelFile(String SheetName) {
		
		File file = new File(System.getProperty("user.dir") +"\\src\\main\\java\\com\\automation\\testdata\\test data.xlsx");
		XSSFWorkbook workbook = null;
		
		FileInputStream fisExcel = null;
	
			
		try {
			
			fisExcel = new FileInputStream(file);
			
			workbook = new XSSFWorkbook(fisExcel); 
			
			
		} catch (Throwable  e) {
			e.printStackTrace();
		} 
		
		
		XSSFSheet sheet = workbook.getSheet(SheetName);
		
		
		
		
		int rows = sheet.getLastRowNum(); 
		
		int cols = sheet.getRow(0).getLastCellNum();
		
		
		
		Object[][] data = new Object[rows][cols]; 
		
		
		
		for(int i = 0; i < rows; i++) {
			
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j = 0;  j < cols; j++) {
				
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType(); 
				
				switch(cellType) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue()); 
					break; 
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				default:
					break;					
				}
			}
			
			
		}
		
		
				
		return data;				
	}
	
	

}
