package org.dnyanyog.page;

import org.dnyanyog.common.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	@FindBy(id="welcome")
	WebElement welcomeText;
	
	
	public HomePage() //constructor
	{
		PageFactory.initElements(WebDriverFactory.dr, this); //Constructor
	}
	
	public void verifyWelcomeText(String strWelcomeText)
	{
		Assert.assertEquals(welcomeText.getText(),strWelcomeText);
	}

}
