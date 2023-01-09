package com.app.pages;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMyntra {
static WebDriver driver = null;
	
	public LoginMyntra(WebDriver driver) {
		this.driver=driver;
	}
	public void loginToMyntra() throws Exception, Exception {
		String rootFolder = System.getProperty("user.dir");
		Properties propobj = new Properties();
		propobj.load(new FileInputStream(rootFolder + "//src//test//resources//Myntra.properties"));
		String emailid = propobj.getProperty("loginemail");
		String pass=propobj.getProperty("loginpassword");
		
		
		driver.findElement(By.xpath("//input[@id=\"mobileNumberPass\"]")).sendKeys(emailid);
		driver.findElement(By.xpath("//input[@id=\"\"]")).sendKeys(pass);
		driver.findElement(By.xpath("//button[.=\"LOGIN\"]")).click();
		Thread.sleep(31000);
		driver.findElement(By.xpath("//button[.=\"LOGIN\"]")).click();
		
		
		String expectedTitle="Myntra";
		String actualTitle=driver.getTitle();
		assertEquals(expectedTitle, actualTitle, " Myntra not loaded");
	}
	
	public void profileCheck() {
		boolean expected=true;
		boolean actual=driver.findElement(By.xpath("//span[.=\"Profile\"]")).isDisplayed();
		assertEquals(expected, actual, " Myntra not loaded");
		
		
		
	}
}
