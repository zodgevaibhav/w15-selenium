package org.dnyanyog.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseSelenium {
	/*
	 Access modifiers/specifier
	 	default - accessible within package. //Like public but within package
	 	public  - Open to all class
	 	private  - within class
	 	protected - Like default but accessible out side of package via inheritance
	
	 */

	@BeforeMethod
	public void beforeEveryTest() {
		System.setProperty("webdriver.chrome.driver", "/Users/vaibhavzodge/Documents/selenium/chromedriver");

		WebDriverFactory.dr = new ChromeDriver(); // Launch browser

		WebDriverFactory.dr.manage().window().maximize();

	}

	@AfterMethod
	public void afterEveryTest() {
		WebDriverFactory.dr.quit(); // browser quit
	}
	
}
