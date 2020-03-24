package pageObj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage {
	
	public static WebElement AddressDetails(WebDriver driver) {
		
		WebElement deliveryaddressDetails = driver.findElement(By.xpath("//h3[@class='page-subheading']"));
		
		return deliveryaddressDetails;
	}
	
	public static WebElement proceedCheckout(WebDriver driver) {
		
		WebElement proceedtoCheckout = driver.findElement(By.xpath("//button[@name='processAddress']"));
		
		return proceedtoCheckout;
	}
	
	public static WebElement shippingPage(WebDriver driver) {
		
		WebElement shippingPageMenu = driver.findElement(By.xpath("//span[@class='navigation_page']"));
		
		return shippingPageMenu;
	}
	
	public static WebElement agreeTerms(WebDriver driver) {
		
		WebElement termsandCondition = driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		return termsandCondition;
	}
	
	public static WebElement confirmShipping (WebDriver driver) {
		
		WebElement shippingConfirm = driver.findElement(By.xpath("//button[@type='submit']/span[contains (text(),'Proceed to checkout')]"));
		
		return shippingConfirm;
	}
	
	// Payment Page Locators
	public static WebElement paymentPage(WebDriver driver) {
		
		WebElement paymentConfirm = driver.findElement(By.xpath("//span[@class='navigation_page'][contains(text,'')]"));
		
		return paymentConfirm;
	}

	public static WebElement totalConfirm(WebDriver driver) {
	
		WebElement totalCheck = driver.findElement(By.xpath("//tr[@class='cart_total_price']/td[2][@class='price']/span[@id='total_price']"));
		
		return totalCheck;
	}
	
	public static WebElement selectPayment(WebDriver driver) {
		
		WebElement paymentMethod = driver.findElement(By.xpath("//a[@class='bankwire']"));
		
		return paymentMethod;
	}
	
	//Confirm Order
	
	public static WebElement confirmaPay(WebDriver driver) {
		
		WebElement paymethodConfirm = driver.findElement(By.xpath("//span[@class='navigation_page']"));
		
		return paymethodConfirm;
	}
	
	public static WebElement checkTotal(WebDriver driver) {
		
		WebElement priceCheck = driver.findElement(By.xpath("//div[@class='box cheque-box']/p/span[@class='price']"));
		
		return priceCheck;
	}
	
	public static WebElement orderConfirm(WebDriver driver) {
		
		WebElement confirmOrder = driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']"));
		
		return confirmOrder;
	}
	
	//Order Confirmation Page
	
	public static WebElement finalOrderConfirm(WebDriver driver) {
	
		WebElement orderConfirmFinal = driver.findElement(By.xpath("//span[@class='navigation_page'][contains(text,'')]"));
		
		return orderConfirmFinal;
	}
	
	public static WebElement orderRefer(WebDriver driver ) {
	
		WebElement referOrderNum = driver.findElement(By.xpath("//div[@class='box']"));
		
		return referOrderNum;
	}
	
	public static WebElement backToOrder(WebDriver driver) {
		
		WebElement orderHistory = driver.findElement(By.xpath("//a[@class='button-exclusive btn btn-default']/i[@class='icon-chevron-left']"));
		
		return orderHistory;
		
	}
	
	//Order History Page
	
	public static WebElement checkOrderHistoryPage(WebDriver driver) {
		
		WebElement orderHistory = driver.findElement(By.xpath("//span[@class='navigation_page']"));
		
		return orderHistory;
	}
	
	public static List<WebElement> ReferenceOrderID(WebDriver driver) {
		
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr/td/span[@class='footable-toggle']"));
		
		return rows;
	}
	
	public static WebElement OrderTable(WebDriver driver) {
		
		WebElement tablename = driver.findElement(By.xpath("//th[contains(text(),'Order reference')]"));
		
		return tablename;
	}
	
public static List<WebElement> ColumnOrders(WebDriver driver) {
		
		List<WebElement> col = driver.findElements(By.xpath("//tbody/tr[@class='first_item']"));
		
		return col;
	}

//Table Xpath //tbody/tr[1]/td[1]
}
