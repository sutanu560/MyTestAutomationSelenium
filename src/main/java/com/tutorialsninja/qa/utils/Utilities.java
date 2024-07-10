package com.tutorialsninja.qa.utils;


import java.io.File;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.FileInputStream;
import java.io.IOException;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;
	
	public static String generateEmailWithTimeStamp() {
		
		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "sutanu560"+timestamp+"@gmail.com";
		
	}

	public static Object[][] getTestDataFromExcel(String sheetName) throws IOException {
		
		String path="C:\\Users\\sutan\\Downloads\\testData.xlsx";
		
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		int roNumber=sheet.getLastRowNum();
		
		Object[][] data = new Object[roNumber][sheet.getRow(0).getLastCellNum()];
		
		for(int i=1;i<=roNumber;i++) {
			data[i-1][0]=sheet.getRow(i).getCell(0).getStringCellValue();
			data[i-1][1]=sheet.getRow(i).getCell(1).getStringCellValue();
		}
		
		return data;
	}
	
	public static String takeScreenShot(WebDriver driver, String testName) {
		File sceenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath=System.getProperty("user.dir")+"\\ScreenShots\\"+testName+".png";
		try {
			FileHandler.copy(sceenShot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destinationScreenshotPath;
	}
	
	
	
}