package org.dnyanyog.test;
import org.dnyanyog.common.BaseSelenium;
import org.dnyanyog.common.WebDriverFactory;
import org.dnyanyog.page.HomePage;
import org.dnyanyog.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseSelenium{	//inheritance

	
	
//	@Test
//	public void verifyUserGettingAddedSuccessfuly() {
//		
//	//	beforeEveryTest();// Method called in such a way that these method and Variable are written in SAME(THIS) CLASS
//
//		dr.get("https://opensource-demo.orangehrmlive.com/"); // Navigate to URL
//
//		dr.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin"); // Enter user name
//
//		dr.findElement(By.xpath("//input[@id='txtPassword' and @name='txtPassword']")).sendKeys("admin123"); // enter
//																												// password
//		dr.findElement(By.id("btnLogin")).click(); // Click on login button
//
//		WebElement welComeText = dr.findElement(By.id("welcome"));
//
//		String text = welComeText.getText();
//		
//		Assert.assertEquals(text, "Welcome Fortune","Welcome Test is not as per expecation, test case failed!!!");
//	//	afterEveryTest();
//
//	}
//	
	
	@Test
	public void verifyUserGettingAddedSuccessfuly() {

		LoginPage lp = new LoginPage("LoginPage");
		lp.login("admin", "admin123")
			.verifyWelcomeText("Welcome John");
	}
	
	
//	//@Test
//	public void verifyESSLoginSuccessfuly() {
//	
//		WebDriverFactory.dr.get("https://opensource-demo.orangehrmlive.com/"); // Navigate to URL
//
//		LoginPage lp = new LoginPage();
//		lp.login();
//		
//		WebElement welComeText = WebDriverFactory.dr.findElement(By.id("welcome"));
//		String text = welComeText.getText();
//		Assert.assertEquals(text, "Welcome Fortune","Welcome Test is not as per expecation, test case failed!!!");
//	}
	
}