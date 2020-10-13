package common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseSelenium {
	
	@BeforeMethod
	public void beforeEachTest()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/vaibhavzodge/Documents/selenium/chromedriver");
		WebDriverFactory.dr = new ChromeDriver();
		WebDriverFactory.dr.manage().window().maximize();
	}
	
	@AfterMethod
	public void AfterEachTest()
	{
		WebDriverFactory.dr.quit();
	}

}
