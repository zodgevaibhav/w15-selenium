package test;

import org.testng.annotations.Test;

import common.BaseSelenium;
import page.LoginPage;

public class LoginTest extends BaseSelenium{
	
	
	@Test
	public void verifyAdminUserLoginSuccessful()
	{
		LoginPage lp = new LoginPage();
		
		lp.login("admin", "admin123")
			.verifyWelComeText("Welcome Paul");
	}

}
