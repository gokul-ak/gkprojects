package shop.rbs_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReaders;

import utilities.WaitUtilities;
public class BaseClass {
	
	public WebDriver driver;
	ConfigReaders config;
	
@BeforeTest
	
	public void setup() throws Exception
	{
		config = new ConfigReaders();
		
		//System.setProperty("webdriver.chrome.driver", config.getChromeDriver());
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		System.out.println("===== Test Started =======");
		
        driver = new ChromeDriver();
		
		System.out.println("====== Launching Application URL=======");
		Thread.sleep(50000);

		driver.get(config.getUrl());
		
		Thread.sleep(20000);

		
		driver.manage().window().maximize();
		Thread.sleep(5000);
	
	//Click on Signin
		
		
		   WaitUtilities.isElementPresent(driver, "//*[@class='login']", 50);
		
			driver.findElement(By.xpath("//*[@class='login']")).click();
			
			WaitUtilities.isElementPresent(driver, "//*[@name='email']", 50);
			
			WebElement emailfield = driver.findElement(By.xpath("//*[@name='email']"));
			
			if(emailfield.isDisplayed()) {
				
				
				System.out.println("=======Sign in page is displayed=======");
			} else { 
			
				System.out.println("========Sign in page is not displayed========");
			}
			
			WaitUtilities.isElementPresent(driver, "//*[@name='email']", 60);
			
			driver.findElement(By.xpath("//*[@name='email']")).sendKeys(config.getUsername());
			
			driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys(config.getPassword());
			
			//Login into the application
			
			WaitUtilities.isElementPresent(driver, "//*[@class='icon-lock left']", 30);
			
			driver.findElement(By.xpath("//*[@class='icon-lock left']")).click();
			
			System.out.println("======Logged into the account======");
			
			Thread.sleep(2500);
        }

@AfterTest

public void BrowserQuit() {
	

driver.quit();

}



}
