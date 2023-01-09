package com.app.test;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.CheckForBag;
import com.app.pages.LoginMyntra;
import com.app.pages.SearchProduct;

public class AppTest {
	static WebDriver driver = null;
	LoginMyntra loginpage;
	SearchProduct sproduct;
	CheckForBag check;

	@BeforeMethod
	public void setUp() throws Exception {

		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootFolder + "//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		
		

		loginpage=new LoginMyntra(driver);
		sproduct=new SearchProduct(driver);
		check=new CheckForBag(driver);
		
		Properties propobj = new Properties();
		propobj.load(new FileInputStream(rootFolder + "//src//test//resources//Myntra.properties"));
		String url = propobj.getProperty("appurl");
		System.out.println(url);

		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("launched webpage");
	}
	
	
	
	@Test
	public void verifyLogin() throws Exception {
		loginpage.loginToMyntra();
		Thread.sleep(5000);
		loginpage.profileCheck();
		
	}
	
	@Test
	public void verifySearch() throws Exception {
		sproduct.searchItem();
		
		
	}
	@Test
	public void verifyBag() throws Exception {
		check.loginToMyntra();
		check.isBagEmpty();
		WebElement count=driver.findElement(By.xpath("//span[@data-reactid=\"904\"]"));
	      String actualCount=count.getText();
	      Assert.assertEquals(actualCount, "1");
	}
	
	@AfterMethod
	public void teatDown() {
		driver.quit();
	}
}
