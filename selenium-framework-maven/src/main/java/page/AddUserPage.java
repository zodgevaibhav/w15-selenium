package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.WebDriverFactory;
import cucumber.api.java.en.Then;

public class AddUserPage {
	
	@FindBy(id="systemUser_password")
	WebElement password;
	
	@FindBy(id="systemUser_password_strength_meter")
	WebElement complexityMessage;
	
		
	public AddUserPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	
	public void addUser(String strUserRole, String strEmployeeName, String strUserName, String status, String strPassword, String strConfirmPassword)
	{
		/*
		
		
		
		*/
	}
	
	@Then("user add admin user with employee name as {string}, user name as {string}, password as {string} and confirm password as {string}")
	public void user_add_admin_user_with_employee_name_as_user_name_as_password_as_and_confirm_password_as(String string, String string2, String string3, String string4) {
	 
		
		
	}
	
	
	public void enterPasswordAndVerifyPasswordComplexityMessage(String strPassword, String strExpectedMessge)
	{
		password.sendKeys(strPassword);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(complexityMessage.getText(), strExpectedMessge);
	}

}
