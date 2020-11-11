package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.WebDriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginPage {

	@FindBy(xpath="//*[@resource-id='txtUsername']")
	WebElement userName;
	
	@FindBy(xpath="//*[@resource-id	='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//*[@resource-id	='btnLogin']")
	WebElement loginButton;
	
	WebDriverWait wait;  //Explicit Wait
	
	public LoginPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
		
		wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
	}
	
	@Given("user navigate to orange hrm URL")
	public LoginPage navigateToOrangeHrmURL()
	{
		WebDriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		wait.until(ExpectedConditions.visibilityOf(userName));
		
		System.out.println(WebDriverFactory.getDriver().getPageSource());
		return this;
	}
	
	@When("uses enters user name as {string} and password as {string} and click on login button")
	public HomePage login(String strUserName, String strPassword)
	{
		userName.sendKeys(strUserName);
		password.sendKeys(strPassword);
		loginButton.click();

		
		return new HomePage();
	}	
}
