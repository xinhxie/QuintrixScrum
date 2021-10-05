package automationPractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObject;

public class CheckoutPage extends PageObject {
	
	@FindBy(id="summary_products_quantity")
	WebElement productQuantityElement;

	public CheckoutPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		this.subUrl = "/index.php?controller=order";
	}

	public int getProductQuantity() {
		String text = this.productQuantityElement.getText();
		int quantity = Integer.valueOf(text.split(" ", 2)[0]);
		return quantity;
	}
}
