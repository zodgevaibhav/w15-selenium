package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.IInvokedMethodListenerImpl;
import page.LoginPage;

@Listeners({IInvokedMethodListenerImpl.class})
public class LoginTest {
	
	
	@Test
	public void verifyAdminUserLoginSuccessful()
	{
		LoginPage lp = new LoginPage();
		
		lp.login("admin", "admin123")
			.verifyWelComeText("Welcome Paul");
	}

}
