package com.tutorialsninga.qa.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class PracticeTest {
	WebDriver driver;
  @Test
  public void test1() {
	  
	  driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	  driver.findElement(By.linkText("Login")).click();
	  driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("sutanu589@gmail.com");
	  driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
	  driver.findElement(By.xpath("//input[@value='Login']")).click();
	  
	  WebElement element = driver.findElement(By.id("elementId"));
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,500);");
	  js.executeScript("arguments[0].click()", element);
	  js.executeScript("arguments[0].value='imac'", element);
	  
	  Actions actions= new Actions(driver);
	  actions.moveToElement(element).perform();
	  actions.dragAndDrop(element, element).perform();
	  actions.doubleClick(element);
	  
	  
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
	  
	  
	 
	  
	  String mainwindow=driver.getWindowHandle();
	  
	  driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	  Set<String> list= driver.getWindowHandles();
	  
	  for(String w:list) {
		  driver.switchTo().window(w);
		  String url=driver.getCurrentUrl();
		  
		  if(url.equals("")) {
			 break;
		  }
	  }
	  driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	  
	  driver.switchTo().window(mainwindow);
	  
	  File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyFile(file, new File(""));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	  
	  try {
		FileInputStream fis=new FileInputStream("");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		sheet.getLastRowNum();
		for(int i=0;i<sheet.getLastRowNum();i++) {
			String value1=sheet.getRow(i).getCell(i).getStringCellValue();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
       
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver= new FirefoxDriver();
	  driver.get("https://tutorialsninja.com/demo/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
