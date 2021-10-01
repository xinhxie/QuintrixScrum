package automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.PageObject;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public BlouseProductPage clickBlouseProductPage(){
		
		WebElement BlouseProductElement = getBlouseImageElement("Blouse");
		
		BlouseProductElement.click();
		
		return new BlouseProductPage(this.driver, this.baseUrl);	
	}
	
	public WebElement getBlouseImageElement(String BlouseImageElement) {
		
		return driver.findElement(By.xpath("//img[@title='"+ BlouseImageElement +"']"));
	}

}
