package common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseSelenium {
	
	@BeforeMethod
	@Before
	public void beforeEachTest()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/vaibhavzodge/Documents/selenium/chromedriver");
				
		
		WebDriverFactory.setDriver(new ChromeDriver());
		
		
		WebDriverFactory.getDriver().manage().window().maximize();
	}
	
	@AfterMethod
	@After
	public void AfterEachTest()
	{
		WebDriverFactory.getDriver().quit();
	}

}
