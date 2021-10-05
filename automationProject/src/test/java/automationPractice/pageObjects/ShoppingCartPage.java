package automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObject;

public class ShoppingCartPage extends PageObject{

	public ShoppingCartPage(WebDriver driver, String baseUrl) {
		super(driver,baseUrl);
	}

	WebElement item = 
			driver.findElement(By.xpath("//p[@class='product-name']//a"));
	
	public String ReturnShoppingCartItems() {
		String itemsInCart = item.getAttribute("href");
		return itemsInCart;
		
	}
}
