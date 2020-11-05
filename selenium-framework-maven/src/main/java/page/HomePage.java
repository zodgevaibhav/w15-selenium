package page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.WebDriverFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
		//Assert.assertEquals(welcomeText.getText(), expectedWelcomeText);
			assertEquals(welcomeText.getText(), expectedWelcomeText);
			assertNotEquals("", "");
		
		return this;
	}
	
	@When("user navigate to admin page")
	public AdminPage navigateToAdminPage()
	{
		adminTab.click();
		
		return new AdminPage();
	}	

}
