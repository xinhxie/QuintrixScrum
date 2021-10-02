package automationPractice.pageObjects;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.PageObject;

public class BlouseProductPage extends PageObject {
	//String Uemail = "176914924@163.com";
	//String Upassword="03060502a";

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

		wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='layer_cart']"), "display", "block"));

		//clickTheProcessButton();
		/*WebElement clickProcesstoCheck =driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span"));

		clickProcesstoCheck.click();*/

		return driver.findElement(By.xpath("//*[@id='product_2_7_0_0']/td[2]/p/a")).getText();	
	}

	public BlouseProductPage clickTheProcessButton() {

		WebDriverWait wait = new WebDriverWait(this.driver,5);
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='layer_cart']"), "display", "block"));
		WebElement clickProcesstoCheck =driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span"));

		clickProcesstoCheck.click();
		return new BlouseProductPage(this.driver, this.baseUrl);	
	}

	public String getBlouseProductDetails() {
		return driver.findElement(By.xpath("//table")).getText();
	}

	public checkoutPage clickProcessCheckout() {

		WebElement addProductElement = getCheckoutElement("button btn btn-default standard-checkout button-medium");

		addProductElement.click();

		return new checkoutPage(this.driver, this.baseUrl);

	}

	public WebElement getCheckoutElement(String checkElement) {
		return driver.findElement(By.xpath("//a[@class='"+ checkElement +"']"));	
	}
}
