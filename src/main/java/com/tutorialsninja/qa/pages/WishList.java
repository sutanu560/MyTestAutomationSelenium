package com.tutorialsninja.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WishList {
	
	WebDriver driver;

	public WishList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<String> wishListItems() {
		WebElement table=driver.findElement(By.xpath("//div[@class='table-responsive']"));
		List<WebElement> rows= table.findElements(By.tagName("tr"));
		List<String> products=new ArrayList<>();
		for(int i=1;i<rows.size();i++) {
			List<WebElement> col=rows.get(i).findElements(By.tagName("td"));
			String name=col.get(1).getText();
			products.add(name);
		}
		
		return products;
	}
	
}
