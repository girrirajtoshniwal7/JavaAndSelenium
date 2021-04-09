package com.SeleniumBasic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshotHandel {

	static WebDriver driver;
	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Tutorials\\Chrome Jar\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		takeScreenshot("Google_HomePage");
		System.out.println("Screenshot Captured");
		driver.quit();
	}
	
	public static void takeScreenshot(String fileName) throws IOException {
		//1. This is to take the screenshot 
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//2. Copy the SS and save it to the desired location using copyFile
		FileUtils.copyFile(file, new File("C:\\Users\\appcino\\Documents\\New folder\\"+fileName+".jpg"));
	}

}
