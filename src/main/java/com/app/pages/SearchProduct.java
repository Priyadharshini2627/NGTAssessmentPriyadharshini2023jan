package com.app.pages;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchProduct {
	static WebDriver driver = null;
	
	public SearchProduct(WebDriver driver) {
		this.driver=driver;
	}
	
	public void searchItem() throws Exception, IOException {
		String rootFolder = System.getProperty("user.dir");
		Properties propobj = new Properties();
		propobj.load(new FileInputStream(rootFolder + "//src//test//resources//Myntra.properties"));
		String searchpath = propobj.getProperty("search");
		//String pass=propobj.getProperty("loginpassword");
		
		
		driver.findElement(By.xpath(searchpath)).sendKeys("shoe");
		Thread.sleep(1000);
		driver.findElement(By.xpath(searchpath)).sendKeys(Keys.ENTER);
		boolean actual=true;
		boolean expected=driver.findElement(By.xpath("//span[.=\"Shoe\"]")).isDisplayed();
		assertEquals(expected, actual, " shoe page not loaded");
		
	}
}
