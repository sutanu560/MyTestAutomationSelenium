package com.tutorialsninja.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CameraPage {
	WebDriver driver;
	
	@FindBy(id="compare-total")
	private WebElement compareOptions;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	private WebElement textCompared;
	
	@FindBy(xpath="//div[@id='top-links']/descendant::a[8]")
	private WebElement wishOption;
	
	//Cameras
	
	public CameraPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<String> listProductAddWishlist(){
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='product-thumb']/descendant::a[2]"));
		List<WebElement> wish=driver.findElements(By.xpath("//div[@class='product-thumb']/descendant::button[2]"));
		List<String> name=new ArrayList<>();
		int item=0;
		for(WebElement s:list) {
			name.add(s.getText());
			if(s.getText().equals("Nikon D300")) {
				wish.get(item).click();
			}
			item++;
		}
		return name;
	}
	
	public WishList clickOnWishList() {
		wishOption.click();
		return new WishList(driver);
	}
	
	public String clickOnCompareButton() {
		compareOptions.click();
		return textCompared.getText();
	}
	
	
}
