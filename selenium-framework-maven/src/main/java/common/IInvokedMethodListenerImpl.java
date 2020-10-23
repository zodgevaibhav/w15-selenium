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
		ExtentReportTestFactory.createNewTest(arg0.getTestMethod().getMethod().getDeclaringClass().getSimpleName(),arg0.getTestMethod().getMethodName());

		System.setProperty("webdriver.chrome.driver", "/Users/vaibhavzodge/Documents/selenium/chromedriver");
		
		WebDriverFactory.setDriver(new ChromeDriver());

		WebDriverFactory.getDriver().manage().window().maximize();
	}

	
	
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		if(!testResult.isSuccess())
		{
			String randomNumber = new Long(System.currentTimeMillis()).toString();
			
			takeScreenshot(method.getTestMethod().getMethodName()+"-"+randomNumber+".png");
			ExtentReportTestFactory.getTest().fail(testResult.getThrowable());
			try {
				ExtentReportTestFactory.getTest().addScreenCaptureFromPath(method.getTestMethod().getMethodName()+"-"+randomNumber+".png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ExtentReportTestFactory.flushReport();
		WebDriverFactory.getDriver().quit();
		
	}

	
	public static void takeScreenshot(String fileNameWithPath) {
	//	int a = 10;
	//	float f = (float)a;
		
		
		TakesScreenshot ts = (TakesScreenshot) WebDriverFactory.getDriver();
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(fileNameWithPath));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
	}
}
