package automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObject;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	private WebElement elementItem = 
			driver.findElement(By.xpath("//a[@title = 'Faded Short Sleeve T-shirts']"));
	
	public FadedShirtPage ClickProduct() {
		elementItem.click();
		return new FadedShirtPage(driver, baseUrl);
	}
}
