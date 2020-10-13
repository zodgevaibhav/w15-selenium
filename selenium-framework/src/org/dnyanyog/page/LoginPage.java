package org.dnyanyog.page;

import org.dnyanyog.common.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="txtUsername")WebElement userName;
	
	
	@FindBy(xpath="//input[@id='txtPassword' and @name='txtPassword']")
	WebElement password;
	
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	// Default constructor
	
	public LoginPage() //No argument Constructor
	{
		PageFactory.initElements(WebDriverFactory.dr, this); //Constructor
	}

	public LoginPage(String pageName) //parameterized Constructor
	{
		System.out.println("******* New page Object created of Class - "+pageName);
		PageFactory.initElements(WebDriverFactory.dr, this); //Constructor
	}
	
	public void login()//group of action
	{
		WebDriverFactory.dr.get("https://opensource-demo.orangehrmlive.com/"); // Statically access
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		loginButton.click();
	}
	
	public HomePage login(String strUserName, String strPassword)//group of action
	{
		WebDriverFactory.dr.get("https://opensource-demo.orangehrmlive.com/"); // Statically access
		userName.sendKeys(strUserName);
		password.sendKeys(strPassword);
		loginButton.click();
		
		return new HomePage();
	}
	
	public void enterUserName()//action
	{
		userName.sendKeys("Admin");
	}

}
