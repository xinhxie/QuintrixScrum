package automationPractice.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		WebDriverWait wait = new WebDriverWait(this.driver,5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//i[@class='icon-ok']")));

		return driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span")).getText();	
	}
}