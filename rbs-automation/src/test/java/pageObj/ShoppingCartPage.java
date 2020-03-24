package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
	
	public static WebElement shoppingCart(WebDriver driver) {
		
		
      WebElement ShoppingCart = driver.findElement(By.xpath("//span[@class='navigation_page']"));
		
		//SAssert.assertSame(ShoppingCart, "Your shopping cart");
     
      return ShoppingCart;
	}
		
		
		
		
	}


