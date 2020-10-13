package page;

import org.openqa.selenium.support.PageFactory;

import common.WebDriverFactory;

public class AddUserPage {
		
	public AddUserPage()
	{
		PageFactory.initElements(WebDriverFactory.dr, this);
	}
	

}
