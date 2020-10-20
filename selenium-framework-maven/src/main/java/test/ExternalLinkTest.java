package test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExternalLinkTest {//window handling
	
	
	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver", "/Users/vaibhavzodge/Documents/selenium/chromedriver");
		
		WebDriver dr = new ChromeDriver();
		
		dr.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		dr.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		
		dr.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		
		dr.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		
		dr.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		//********
		
		
		String orangleHrmWindow = dr.getWindowHandle();//Current window handle/id
		
		Set<String> windowsHandle = dr.getWindowHandles();//Why not ArrayList/List ?
		
	for(String handle:windowsHandle)
		{
			if(handle.contentEquals(orangleHrmWindow)) {
				dr.switchTo().window(handle);
				System.out.println(dr.getTitle());	
			}else {
				dr.switchTo().window(handle);
				System.out.println(dr.getTitle());
				dr.close();
			}
		}
	
		//*********
		dr.switchTo().window(orangleHrmWindow);
		System.out.println(dr.findElement(By.xpath("//div[@id='forgotPasswordLink']/a")).getText());
		dr.quit();//  dr.quit();
	}

}
