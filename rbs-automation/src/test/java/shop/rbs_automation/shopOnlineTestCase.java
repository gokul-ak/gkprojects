package shop.rbs_automation;

import utilities.ConfigReaders;
import utilities.WaitUtilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObj.ShoppingCartPage;
import pageObj.AddressPage;
import pageObj.ProfilePage;

public class shopOnlineTestCase  extends BaseClass{
	
	ConfigReaders config;
	
	SoftAssert SAssert = new SoftAssert();
	String values;
	
	
	
	@Test (groups = "scenarios")
	public void testOrderHistory() throws Exception {
		
	
		WaitUtilities.isElementPresent(driver, "//*[@class='navigation_page']", 50);
		
		WebElement myaccount = driver.findElement(By.xpath("//*[@class='navigation_page']"));
		
		if(myaccount.isDisplayed()) {
			
			System.out.println("=======My Account page is displayed======");
		} else
		{
			System.out.println("=======My Account page is not displayed======");
		}
		
		Thread.sleep(5500);
		
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]")).click();
		
		
		WaitUtilities.isElementPresent(driver, "//*[@title='Faded Short Sleeve T-shirts']", 50);
		
		System.out.println("========Product is displayed===========");
		
		WebElement product = driver.findElement(By.xpath("//h5[@itemprop='name']/a[@title='Faded Short Sleeve T-shirts']"));

		Actions mouseAct = new Actions(driver);
				
		mouseAct.moveToElement(product).build().perform();
		
		Thread.sleep(2000);
				
		JavascriptExecutor js =  (JavascriptExecutor)driver;
				
		js.executeScript("scroll(0,600)");
		
		WebElement AddtoCart = driver.findElement(By.xpath("//div[@class='button-container']/a[@title='Add to cart']"));

		
		if(AddtoCart.isDisplayed()) {
			
			AddtoCart.click();
			System.out.println("====== Product added to cart ======");
		} else {
			
			System.out.println("=======Unable to add to cart========");
		}
		
		
		Thread.sleep(2500);
		
		WaitUtilities.isElementPresent(driver, "//*[@class='btn btn-default button button-medium']", 30);
		
		WebElement procedCheckout = driver.findElement(By.xpath("//*[@class='btn btn-default button button-medium']"));
		
		if(procedCheckout.isDisplayed()) {
			
			procedCheckout.click();
		} else {
			
			System.out.println("======= Unable to click on Checkout button");
		}
		
		WaitUtilities.isElementPresent(driver, "//span[@class='navigation_page']", 50);
		
		
		 ShoppingCartPage.shoppingCart(driver);
		 
		
		WebElement productDisplayed = driver.findElement(By.xpath("//p[@class='product-name']"));
		
		WaitUtilities.isElementPresent(driver, "//p[@class='product-name']", 40);
		
		if(productDisplayed.isDisplayed()) {
			
			SAssert.assertTrue(true);
			System.out.println("====== Product is available====");
		}
		else {
			
			SAssert.assertFalse(false);
			System.out.println("======Product is not available========");
		}
		
		WaitUtilities.isElementPresent(driver, "//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']", 40);
		
		WebElement checkout = driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']"));
		
		
		if(checkout.isDisplayed()) {
			
			SAssert.assertTrue(true, "Procced Checkout is displayed");
			checkout.click();
		}
		else 
		{
			SAssert.assertFalse(false,"Proceed Checkout is not displayed");
		}
		
		
		if(AddressPage.AddressDetails(driver).isDisplayed()) {
			
			System.out.println("==== Delivery Address is available");
			
			AddressPage.proceedCheckout(driver).click();
		}
		else {
			System.out.println("==== Deliver Address is not available");
			
			SAssert.assertFalse(false, "Unable to Proceed Checkout");
		}
		
		
		if(AddressPage.confirmShipping(driver).isDisplayed()) {
			
			System.out.println("======== Shipping Page is displayed====");
			
			AddressPage.agreeTerms(driver).click();
			
			if(AddressPage.agreeTerms(driver).isSelected()) {
				
				System.out.println("======Agreed Terms and Condition========");
				
				AddressPage.confirmShipping(driver).click();
				
				System.out.println("==== Confirm you Shipping Page ====");
			} else {
				
				SAssert.assertFalse(false, "Unable to Confrim Shipping");
			}
			
			
		}
		
		if(AddressPage.paymentPage(driver).isDisplayed()) {
			
			System.out.println("====== Payment Page is displayed ========");
			
			SAssert.assertEquals(AddressPage.totalConfirm(driver), "$18.51");
			
			AddressPage.selectPayment(driver).click();
		} else {
			
			SAssert.assertFalse(false, "Unable to select payment method option");
		}
		
		if(AddressPage.confirmaPay(driver).isDisplayed()) {
			
			System.out.println("===== Order Summary Page ===========");
			
			if(AddressPage.checkTotal(driver).isDisplayed()) {
				
				AddressPage.orderConfirm(driver).click();
				
			}
				
		} else {
			
			SAssert.assertFalse(false, "Unable to navigate to next page");
		}
		
		//Order Confirmation Page
		
		if(AddressPage.finalOrderConfirm(driver).isDisplayed()) {
			
			System.out.println("====== Order Confirmation Page ========");

			System.out.println("Order refer is :=====" +AddressPage.orderRefer(driver).getText());
			
			String value = AddressPage.orderRefer(driver).getText();
			
			int location = value.indexOf("in the subject of your bank wire");
			
			System.out.println("Values is ==== " + value.substring(location-1,location).trim());
			
			 values = value.substring(location-10,location).trim();
			
			System.out.println("Reference ====:" + values);
			
			AddressPage.backToOrder(driver).click();

			
		} else {
			
			SAssert.assertFalse(false, "Unable to navigate to next page");
		}
		
		//Order History Page
		
		if(AddressPage.checkOrderHistoryPage(driver).isDisplayed()) {
			
			int rowsize = AddressPage.ReferenceOrderID(driver).size();
			
			int columnsize = AddressPage.ColumnOrders(driver).size();
			
			for(int i=1; i<= rowsize; i++) {
				
				WebElement OrderName = driver.findElement(By.xpath("//tbody/tr[" + i + "]"));
				
				String RowValue = OrderName.getText();
				
				
				for(int j=1; j<columnsize; j++) {
					
					WebElement OrderID = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td["+ j +"]"));
					
					String ColumnValue = OrderID.getText();
					
					System.out.println("======== Column Values =======" +ColumnValue);
					
					SAssert.assertEquals(ColumnValue, values);
				}
				
			}
					
		} else {
			
			System.out.println("===Test Failed Order ID not matching========");
		}
		
	}
	
	
	@Test (groups = "scenarios")
	public void testPersonalInformationUpdate() {
		
		config = new ConfigReaders();
		
		ProfilePage.AccountLink(driver).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='navigation_page']")));
		
		// Navigating to Personal Information Page
		
		ProfilePage.PersonalInfo(driver).click();
		
		if(ProfilePage.MenuInfo(driver).isDisplayed()) {
		
			System.out.println("=====Personal Information Page =========");
			
			//WaitUtilities.isElementPresent(driver,"//div[@class='required form-group form-ok']/input[@id='firstname']", 30);
			//Update FirstName
			
			
			ProfilePage.FirstNameField(driver).clear();
			
			ProfilePage.FirstNameField(driver).sendKeys(config.getFirstName());
			
			ProfilePage.updatePassword(driver).sendKeys(config.getCurrentPassword());
			
			ProfilePage.SaveInfo(driver).click();
			
			SAssert.assertEquals(ProfilePage.successMsg(driver), "Your personal information has been successfully updated");
		}
			
		
		
		
		
		
		
	}
}
