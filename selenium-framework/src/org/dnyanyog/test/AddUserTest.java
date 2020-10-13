//package org.dnyanyog.test;
//
//import org.dnyanyog.common.BaseSelenium;
//import org.dnyanyog.page.LoginPage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;
//
//public class AddUserTest extends BaseSelenium{
//
//	@Test
//	public void verifyAdminLoginSuccessful() {
//
//		beforeEveryTest();
//
//		dr.get("https://opensource-demo.orangehrmlive.com/"); // Navigate to URL
//
//		LoginPage lp = new LoginPage();
//		lp.login();
//
//		// ############ Add User ############
//
//		dr.findElement(By.id("menu_admin_viewAdminModule")).click();
//
//		dr.findElement(By.id("btnAdd")).click();
//
//		dr.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Linda Anderson");
//
//		// ****** find element
//		WebElement userRole = dr.findElement(By.id("systemUser_userType"));
//
//		// ****** Create object of Select Class
//		Select userRoleDropDown = new Select(userRole);
//
//		// ****** Select value from dropdown
//		userRoleDropDown.selectByVisibleText("ESS");
//		// userRoleDropDown.selectByIndex(0);
//		// userRoleDropDown.selectByValue("1");
//
//		dr.findElement(By.id("systemUser_userName")).sendKeys("User123432");
//
//		dr.findElement(By.id("systemUser_password")).sendKeys("User123432");
//
//		dr.findElement(By.id("systemUser_confirmPassword")).sendKeys("User123432");
//
//		dr.findElement(By.id("btnSave")).click();
//
//		afterEveryTest();
//
//	}
//
//}