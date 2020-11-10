package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.BaseSelenium;
import common.IInvokedMethodListenerImpl;
import page.LoginPage;

@Listeners({IInvokedMethodListenerImpl.class})
public class LoginTest extends BaseSelenium{
	
	
	@Test(dataProvider="loginExcelData")
	public void verifyAdminUserLoginSuccessful(String userName, String password)
	{
		LoginPage lp = new LoginPage();
		
		lp.navigateToOrangeHrmURL()
			.login(userName, password)			
				.verifyWelComeText("Welcome Pul");
	}
	
	/*@Test
	public void verifyAdminUserLoginSuccessful1()
	{
		LoginPage lp = new LoginPage();
		
		lp.navigateToOrangeHrmURL()
			.login("admin", "admin123")			
				.verifyWelComeText("Welcome Pul");
	}
	
	@Test
	public void verifyAdminUserLoginSuccessful2()
	{
		LoginPage lp = new LoginPage();
		
		lp.navigateToOrangeHrmURL()
			.login("admin", "admin123")			
				.verifyWelComeText("Welcome Pul");
	}
*/
}
