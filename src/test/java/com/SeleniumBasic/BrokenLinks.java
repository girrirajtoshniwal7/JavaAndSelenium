package com.SeleniumBasic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Tutorials\\Chrome Jar\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://makemysushi.com/404");
		/*
		 * driver.findElement(By.name("username")).sendKeys("groupautomation");
		 * driver.findElement(By.name("password")).sendKeys("Test@12345");
		 * driver.findElement(By.xpath("//input[@value='Login']")).click();
		 * driver.switchTo().frame("mainpanel");
		 */

		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));

		System.out.println("Total Number of links at the site:- " + linkList.size());

		List<WebElement> activeLink = new ArrayList<WebElement>();

		for (int i = 0; i < linkList.size(); i++) {
			if (linkList.get(i).getAttribute("href") != null
					&& (!linkList.get(i).getAttribute("href").contains("javascript"))) {
				activeLink.add(linkList.get(i));
			}

		}

		System.out.println("Total Nuber of active Links at the Website" + activeLink.size());

		for (int j = 0; j < activeLink.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLink.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();

			System.out.println(activeLink.get(j).getAttribute("href") + "--->" + response);
		}

		Thread.sleep(5000);
		driver.quit();

	}

}
