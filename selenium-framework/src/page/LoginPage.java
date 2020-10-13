package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.WebDriverFactory;

public class LoginPage {

	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(WebDriverFactory.dr, this);
	}
	
	public HomePage login(String strUserName, String strPassword)
	{
		WebDriverFactory.dr.get("https://opensource-demo.orangehrmlive.com/");
		userName.sendKeys(strUserName);
		password.sendKeys(strPassword);
		loginButton.click();
		
		return new HomePage();
	}	
}
