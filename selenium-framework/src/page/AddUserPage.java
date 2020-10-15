package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.WebDriverFactory;

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
