package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class IInvokedMethodListenerImpl implements IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		System.setProperty("webdriver.chrome.driver", "/Users/vaibhavzodge/Documents/selenium/chromedriver");
		
		WebDriverFactory.setDriver(new ChromeDriver());

		WebDriverFactory.getDriver().manage().window().maximize();
	}

	
	
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		if(!testResult.isSuccess())
			takeScreenshot(method.getTestMethod().getMethodName()+".png");
		
		WebDriverFactory.getDriver().quit();
		
	}

	
	public static void takeScreenshot(String fileNameWithPath) {
		int a=10;
		
		float b = (float)a; //auto boxing  //10.00

		//Decorator Design Patern
		
		File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(fileNameWithPath));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
	}
}
