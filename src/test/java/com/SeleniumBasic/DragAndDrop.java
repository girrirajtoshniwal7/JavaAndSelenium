package com.SeleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Tutorials\\Chrome Jar\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		//System.out.println("Moved in Frame");
		//www.jqueryui.com/droppable/
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		System.out.println("Clicked on target");
		action.clickAndHold(driver.findElement(By.xpath("//*[@id=\"draggable\"]")))
				.moveToElement(driver.findElement(By.xpath("//*[@id=\"droppable\"]"))).release().build().perform();
		
		Thread.sleep(5000);
		driver.close();

	}

}
