package common;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTestFactory {
	
	private static ExtentReports extentReport;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	private static Map<String, ExtentTest> moduleMap = new HashMap<String, ExtentTest>();

	
	
	static {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("index.html");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Test Result");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Results");
		ExtentReportTestFactory.extentReport = new ExtentReports();
		ExtentReportTestFactory.extentReport.attachReporter(htmlReporter);			
	}
	
	synchronized public static ExtentTest getTest(String test)
	{
		if(!moduleMap.isEmpty() && moduleMap.containsKey(test))
		{
			return moduleMap.get(test);
		}else {
			moduleMap.put(test, extentReport.createTest(test));
			return moduleMap.get(test);
		}
	}
	
	
	synchronized public static void createNewTest(String strTest,String strNode)
	{
		
		//(moduleName = "AddUserTest", testName="verifyAdminUsrGettingAddedSuccessfuly")
		
		ExtentTest test = getTest(strTest);//Module, ClassName, Test
		
		ExtentTest node = test.createNode(strNode); //Node, MethodName, @TestCase
		
		ExtentReportTestFactory.extentTest.set(node);
				
	}

	synchronized public static void flushReport()
	{
		extentReport.flush();
	}

	synchronized public static ExtentTest getTest() {
		return extentTest.get();
	}

}
