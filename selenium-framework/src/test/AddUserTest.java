package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.IInvokedMethodListenerImpl;
import page.LoginPage;

@Listeners({IInvokedMethodListenerImpl.class})
public class AddUserTest{
	
	@Test
	public void verifyAdminUsrGettingAddedSuccessfuly()
	{
		LoginPage lp = new LoginPage();
		lp.login("admin", "admin123")
			.verifyWelComeText("Welcome Paul")
				.navigateToAdminPage()
					.navigateToAddUserPage()
						.addUser("", "", "", "", "", "");
	}
	
	@Test
	public void verifyPasswordComplexityMessageDisplayAsVeryWeak()
	{
		LoginPage lp = new LoginPage();
		lp.login("admin", "admin123")
			.verifyWelComeText("Welcome Paul")
				.navigateToAdminPage()
					.navigateToAddUserPage()
					.enterPasswordAndVerifyPasswordComplexityMessage("a", "Very Weak");
	}
	
	@Test
	public void verifyPasswordComplexityMessageDisplayAsWeak()
	{
		LoginPage lp = new LoginPage();
		lp.login("admin", "admin123")
			.verifyWelComeText("Welcome Paul")
				.navigateToAdminPage()
					.navigateToAddUserPage()
						.enterPasswordAndVerifyPasswordComplexityMessage("asdfsf", "Weak");
	}

}
