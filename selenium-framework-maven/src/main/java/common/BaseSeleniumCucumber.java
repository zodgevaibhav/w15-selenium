package common;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseSeleniumCucumber {
	
	@Before
	public void beforeEachTest()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/vaibhavzodge/Documents/selenium/chromedriver");
				
		
		WebDriverFactory.setDriver(new ChromeDriver());
		
		
		WebDriverFactory.getDriver().manage().window().maximize();
	}
	
	@After
	public void AfterEachTest()
	{
		WebDriverFactory.getDriver().quit();
	}

}
