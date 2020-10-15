package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.WebDriverFactory;

public class AdminPage {
	
	@FindBy(id="btnAdd")
	WebElement addButton;
	
	public AdminPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	
	public AddUserPage navigateToAddUserPage()
	{
		addButton.click();
		
		return new AddUserPage();
		
	}

}
