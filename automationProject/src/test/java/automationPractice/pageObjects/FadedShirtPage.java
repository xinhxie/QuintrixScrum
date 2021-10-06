package automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObject;

public class FadedShirtPage extends PageObject{

	protected FadedShirtPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	WebElement checkoutElement = 
			driver.findElement(By.xpath("//p[@id = 'add_to_cart']"));
	WebElement proceedToCheckout = 
			driver.findElement(By.xpath("//a[@title = 'Proceed to checkout']"));

	public FadedShirtPage ClickAddToCart() {
		checkoutElement.click();
		return new FadedShirtPage(driver, baseUrl);
	}
	
	public ShoppingCartPage ProceedToCart() {
		proceedToCheckout.click();
		return new ShoppingCartPage(driver, baseUrl);
	}
}
