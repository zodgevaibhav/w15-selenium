package common;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	public static ThreadLocal<WebDriver> localStorage = new ThreadLocal<>(); //THREAD SPECIFIC
	

	public static void setDriver(WebDriver dr)
	{
		localStorage.set(dr);
	}
	
	public static WebDriver getDriver()
	{
		return localStorage.get();
	}
}
