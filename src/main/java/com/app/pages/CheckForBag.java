package com.app.pages;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckForBag {
	static WebDriver driver = null;

	public CheckForBag(WebDriver driver) {
		this.driver = driver;
	}

	public void loginToMyntra() throws Exception, Exception {
		String rootFolder = System.getProperty("user.dir");
		Properties propobj = new Properties();
		propobj.load(new FileInputStream(rootFolder + "//src//test//resources//Myntra.properties"));
		String emailid = propobj.getProperty("loginemail");
		String pass = propobj.getProperty("loginpassword");
		
		driver.findElement(By.xpath("//input[@id=\"mobileNumberPass\"]")).sendKeys(emailid);
		driver.findElement(By.xpath("//input[@id=\"\"]")).sendKeys(pass);
		driver.findElement(By.xpath("//button[.=\"LOGIN\"]")).click();
		Thread.sleep(31000);
		driver.findElement(By.xpath("//button[.=\"LOGIN\"]")).click();

	}
	public void isBagEmpty() throws Exception {
		driver.findElement(By.xpath("//span[.=\"Bag\"]")).click();
		if(driver.findElement(By.xpath("//div[.=\"There is nothing in your bag. Let's add some items.\"]")).isDisplayed()) {
			driver.navigate().back();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@class='desktop-input']")).sendKeys("NOISE");
			driver.findElement(By.xpath("//input[@class='desktop-input']")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			//driver.findElement(By.xpath("(//h3[.=\"NOISE\"])[1]")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@title=\'NOISE Black ColorFit Icon Buzz Bluetooth Calling Smart Watch with Voice Assistance\']")).click();
			String currentHandle = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
			    if (!handle.equalsIgnoreCase(currentHandle)) {
			        driver.switchTo().window(handle);
			    }
			}
			WebElement addToBagButton= driver.findElement(By.cssSelector("div.pdp-add-to-bag"));
			addToBagButton.click();
			Thread.sleep(2000);
		      
			
		}
	}
	
//	public void addToCartItems() throws Exception {
//		
//        WebElement searchBar=driver.findElement(By.xpath("//input[@placeholder]"));
//        searchBar.sendKeys("redmi");
//        searchBar.sendKeys(Keys.RETURN);
//        driver.findElement(By.xpath("//img[@title=\'Bewakoof Black & Green Mickey Face Printed Xiaomi Redmi Note 8 Pro Back Case']")).click();
//        Thread.sleep(2000);
//        String currentHandle = driver.getWindowHandle();
//        for (String handle : driver.getWindowHandles()) {
//            if (!handle.equalsIgnoreCase(currentHandle)) {
//                driver.switchTo().window(handle);
//            }
//        }
//        Thread.sleep(2000);
//        WebElement addToBagButton= driver.findElement(By.cssSelector("div.pdp-add-to-bag"));
//        addToBagButton.click();
//        Thread.sleep(2000);
//
//    }


}
