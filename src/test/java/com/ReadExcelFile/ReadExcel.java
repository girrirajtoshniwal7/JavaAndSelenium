package com.ReadExcelFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcel {

	public static void main(String[] args) {
		
	Xls_Reader reader = new Xls_Reader("C:\\Users\\appcino\\Documents\\TestDataExcelFile.xlsx");
		
		String Firstname = reader.getCellData("FacebookCreateAccount","FirstName",2);
		System.out.println(Firstname);
		String Surname = reader.getCellData("FacebookCreateAccount", "SurName", 2);
		System.out.println(Surname);
		String MobileNo = reader.getCellData("FacebookCreateAccount", "MobileNo", 2);
		System.out.println(MobileNo);
		String Password = reader.getCellData("FacebookCreateAccount", "Password", 2);
		System.out.println(Password);
		
		

//		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Tutorials\\Chrome Jar\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//	
//		driver.get("https://www.facebook.com/");
//		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();

	}

}
