package com.tutorialsninga.qa.testcase;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.CameraPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.WishList;

public class CameraWishlistTest extends Base{
	
	public CameraWishlistTest() {
		
		super();
	}
	WebDriver driver;
	CameraPage cameraPage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setUp() {
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
     	HomePage homepage = new HomePage(driver);
     	loginpage=homepage.naviageToLoginPage();
//		cameraPage=homepage.clickOnCameraButton();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void addTocartFuvtionalty() {
	   // loginpage = new LoginPage(driver);
		AccountPage acp=loginpage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		cameraPage= acp.clickOncameraOption();
		System.out.println(cameraPage.listProductAddWishlist().toString());
		System.out.println("**************");
		WishList wishpage= cameraPage.clickOnWishList();
		List<String> productsonwish=wishpage.wishListItems();
		System.out.println(productsonwish.toString());
		
		//Assert.assertTrue(cameraPage.clickOnCompareButton().contains("Product Comparison"), "Product Comparison is not possible");
	}
	

}
