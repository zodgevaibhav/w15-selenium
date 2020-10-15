package test;

import org.testng.annotations.Test;

import common.BaseSelenium;
import page.LoginPage;

public class AddUserTest extends BaseSelenium{
	
	@Test
	public void verifyAdminUsrGettingAddedSuccessfuly()
	{
		LoginPage lp = new LoginPage();
		lp.login("admin", "admin123")
			.verifyWelComeText("Welcome Paul")
				.navigateToAdminPage()
					.navigateToAddUserPage();
	}
	
	@Test
	public void verifyPasswordComplexityMessageDisplayAsWeak()
	{
		LoginPage lp = new LoginPage();
		lp.login("admin", "admin123")
			.verifyWelComeText("Welcome Paul")
				.navigateToAdminPage()
					.navigateToAddUserPage()
					.enterPasswordAndVerifyPasswordComplexityMessage("a", "Very Weak");
	}

}
