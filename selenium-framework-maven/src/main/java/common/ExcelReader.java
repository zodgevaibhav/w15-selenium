package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	//private static HSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	public static void main(String[] args) throws Exception {
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
			System.out.println(tabArray);
	}
	

	public static int getUsedRows() throws Exception {
		try{
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	
	public static int getUsedColumns() throws Exception {
		try{
			int ColCount = ExcelWSheet.getRow(0).getLastCellNum();
			return ColCount;
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		   try{
			  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			  String CellData = Cell.getStringCellValue();
			  return CellData;
			  }catch (Exception e){
				return"";
				}
			}

}
