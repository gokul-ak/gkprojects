package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitUtilities {

	public static WebElement isElementPresent(WebDriver driver, String xpath, int time) {
		
		WebElement element = null;
		
		for(int i=0; i<=time; i++) {
			
			try {
			element = driver.findElement(By.xpath(xpath));
			 break;
			}
			catch (Exception e) {
				
				try {
					Thread.sleep(3000);
				} catch(InterruptedException ie) {
					
					System.out.println("Waiting for element to apprear");
				}
			}
			
		}
		
		return element;
	}
		
	}
	
	
