package automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.PageObject;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public BlouseProductPage clickBlouseImageJumpProductPage(){

		WebElement BlouseProductElement = getBlouseImageElement("Blouse");

		BlouseProductElement.click();

		return new BlouseProductPage(this.driver, this.baseUrl);	
	}

	public BlouseProductPage clickBlouseTitleJumpProductPage(){

		WebElement BlouseProductElement = getBlouseTitleElement("Blouse");

		BlouseProductElement.click();

		return new BlouseProductPage(this.driver, this.baseUrl);	
	}

	public WebElement getBlouseImageElement(String BlouseImageElement) {

		return driver.findElement(By.xpath("//img[@title='"+ BlouseImageElement +"']"));
	}

	public WebElement getBlouseTitleElement(String BlouseTitleElement) {

		return driver.findElement(By.xpath("//a[@class='product-name' and @title='"+BlouseTitleElement+"']"));
	}
}
