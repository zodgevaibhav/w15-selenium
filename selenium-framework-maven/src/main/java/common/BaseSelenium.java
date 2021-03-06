package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class BaseSelenium {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	//private static HSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	
	@DataProvider(name="loginArrayData")
	public String[][] getArrayData()
	{
		
		String loginData[][] = {
					{"1","admin123","Welcome Admin"},
					{"vaibhav","vaibhav123","Welcome Vaibhav"},
					{"avinash","avinash123","Welcome Avinash"},
					{"vishal","vishal123","Welcome Vishal"}
				};
		
		return loginData;
	}
	
	@DataProvider(name="loginCSVData")
	public String[][] getDataFromCSV() throws IOException
	{

		String fileName = "/Users/vaibhavzodge/git/w1415-selenium/selenium-framework-maven/src/main/java/test/LoginData.csv";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;

		boolean isFileHaveData = true;

		String[][] loginData = new String[3][2];
		int index = 0;
		while (isFileHaveData) {
			line = br.readLine();
			if (line == null) {
				isFileHaveData = false;
			} else {
				loginData[index]=line.split(",");
				index = index+1;
			}
		}
		
		return loginData;
	
	}
	
	@DataProvider(name="loginExcelData")
	public String[][] getDataFromExcel()
	{

		String[][] tabArray = null;
		
		String FilePath="/Users/vaibhavzodge/git/w1415-selenium/selenium-framework-maven/src/main/java/test/LoginTests.xlsx";
		String SheetName="TC1VerifyValidAdminUser";
		
		   try{
			   System.out.println("*************** getExcelTableArray - File path - "+FilePath);
			   FileInputStream ExcelFile = new FileInputStream(FilePath);
			   // Access the required test data sheet
			   ExcelWBook = new XSSFWorkbook(ExcelFile);
			   ExcelWSheet = ExcelWBook.getSheet(SheetName);
			
			   int totalRows = ExcelWSheet.getLastRowNum()+1;//3
			   int totalCols = ExcelWSheet.getRow(0).getLastCellNum();//2
			   
			   tabArray=new String[totalRows][totalCols];
			   
			   for(int intRowCounter =0;intRowCounter<totalRows;intRowCounter++){
				   for (int intColCounter=0;intColCounter<totalCols;intColCounter++)
				   {
					   tabArray[intRowCounter][intColCounter]=ExcelWSheet.getRow(intRowCounter).getCell(intColCounter).getStringCellValue();
				   }
			   }
			}
			catch (FileNotFoundException e)
			{
				System.out.println("!!!!!!!!!!!!!!! Excel File with class name not found, probably you have mentioned excel data provider to TestMethod but excel file not provided or incorrectly provided");
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
			}
			return tabArray;
	
	}
	
	/*
	@BeforeMethod
	public void beforeEachTest()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/vaibhavzodge/Documents/selenium/chromedriver");
				
		
		WebDriverFactory.setDriver(new ChromeDriver());
		
		
		WebDriverFactory.getDriver().manage().window().maximize();
	}
	
	@AfterMethod
	public void AfterEachTest()
	{
		WebDriverFactory.getDriver().quit();
	}
	*/

}
