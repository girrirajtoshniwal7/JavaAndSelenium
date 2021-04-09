package com.SeleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsInSelenium {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Tutorials\\Chrome Jar\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// This is a Implicit Wait
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		// This Explicit Wait
		WebDriverWait Element = new WebDriverWait(driver,15);
		Element.until(ExpectedConditions.presenceOfElementLocated(By.id("XYZ")));
		 
	}

}
