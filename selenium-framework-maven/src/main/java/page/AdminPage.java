package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.WebDriverFactory;
import cucumber.api.java.en.When;

public class AdminPage {
	
	@FindBy(id="btnAdd")
	WebElement addButton;
	
	public AdminPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	@When("user navigate to add user page")
	public AddUserPage navigateToAddUserPage()
	{
		addButton.click();
		
		return new AddUserPage();
		
	}

}
