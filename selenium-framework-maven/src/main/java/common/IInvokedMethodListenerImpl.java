package common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import io.appium.java_client.android.AndroidDriver;

public class IInvokedMethodListenerImpl implements IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult arg1) {
		
		ExtentReportTestFactory.createNewTest(method.getTestMethod().getMethod().getDeclaringClass().getSimpleName(),method.getTestMethod().getMethodName());

	/*	System.setProperty("webdriver.chrome.driver", "/Users/vaibhavzodge/Documents/selenium/chromedriver");
		
		WebDriverFactory.setDriver(new ChromeDriver());
	*/	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browser", "android");
		capabilities.setCapability("deviceName", "android");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("noReset", "true");
		
		try {
			WebDriver dr = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
			WebDriverFactory.setDriver(dr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//WebDriverFactory.getDriver().manage().window().maximize();
		
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
		ExtentReportTestFactory.getTest().info(new Long(testResult.getEndMillis()-testResult.getStartMillis()).toString());
		ExtentReportTestFactory.flushReport(); //write on html file
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
