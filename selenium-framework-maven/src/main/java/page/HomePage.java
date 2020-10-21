package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.WebDriverFactory;
import cucumber.api.java.en.Then;

public class HomePage {
	
	@FindBy(id="welcome")
	WebElement welcomeText;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminTab;
	
	public HomePage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	@Then("user should be able to see {string} message")
	public HomePage verifyWelComeText(String expectedWelcomeText)
	{
		Assert.assertEquals(welcomeText.getText(), expectedWelcomeText);
		
		return this;
	}
	
	public AdminPage navigateToAdminPage()
	{
		adminTab.click();
		
		return new AdminPage();
	}	

}
