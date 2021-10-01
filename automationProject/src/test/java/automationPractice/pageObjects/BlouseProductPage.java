package automationPractice.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.eventbus.SubscriberExceptionContext;

import framework.PageObject;

public class BlouseProductPage extends PageObject {
	
	public BlouseProductPage(WebDriver driver, String baseUrl){
		super(driver, baseUrl);
	}
	
	public BlouseProductPage clickAddedProduct() {
		
		WebElement addProductElement = getAddedProductElement("Submit");
		
		addProductElement.click();
		
		return new BlouseProductPage(this.driver, this.baseUrl);
	}
	
	public WebElement getAddedProductElement(String AddElement) {
		
		return driver.findElement(By.xpath("//button[@name='"+ AddElement +"']"));
	}
	
	public String getBloiseElementIntheCart(){
		
		WebDriverWait wait = new WebDriverWait(this.driver,7);
		
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='layer_cart' and @style='display: block; top: 0px;']")));
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='layer_cart']"), "style", "display: block; top: 0px;"));
		//wait.until(ExpectedConditions.attributeContains(locator, attribute, value)(By.xpath("//div[@style='display: block']")));
		return driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span")).getText();	
	}
	
	public String getBlouseProductDetails() {
		return driver.findElement(By.xpath("//table")).getText();
	}
}
