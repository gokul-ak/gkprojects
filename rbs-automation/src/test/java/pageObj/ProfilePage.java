package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	
	public static WebElement AccountLink(WebDriver driver) {
		
		WebElement myAccLink = driver.findElement(By.xpath("//div[@class='breadcrumb clearfix']/a[@href='http://automationpractice.com/index.php?controller=my-account']"));
		
		return myAccLink;
	}
	
	public static WebElement PersonalInfo(WebDriver driver) {
		
		WebElement personalInfo = driver.findElement(By.xpath("//span[text() = 'My personal information']"));
		
		return personalInfo;
	}
	
	public static WebElement MenuInfo(WebDriver driver) {
		
		WebElement menuInfo = driver.findElement(By.xpath("//span[@class='navigation_page']"));
		
		return menuInfo;
	}

	public static WebElement FirstNameField(WebDriver driver) {
		
		WebElement firstName = driver.findElement(By.xpath("//div[@class='required form-group form-ok']/input[@name='firstname']"));
		
		return firstName;
	}
	
	public static WebElement SaveInfo(WebDriver driver) {
		
		WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']/span[text()='Save']"));
		
		return saveButton;
	}
	
	public static WebElement successMsg(WebDriver driver) {
		
		WebElement alertMsg = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
		
		return alertMsg;
	}
	
	public static WebElement updatePassword(WebDriver driver) {
		
		WebElement updatePasswrd = driver.findElement(By.xpath("//div[@class='required form-group form-error']/input[@id='old_passwd']"));
		
		return updatePasswrd;
	}
	
}
