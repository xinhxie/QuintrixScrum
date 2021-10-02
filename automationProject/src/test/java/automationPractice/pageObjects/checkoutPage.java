package automationPractice.pageObjects;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObject;

public class checkoutPage extends PageObject{
	String Uemail = "176914924@163.com";
	String Upassword="03060502a";
	protected checkoutPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}	


	public checkoutPage enterUsernameAndPassword() {
		WebElement emial = getUserInfoElement("email");
		emial.sendKeys(Uemail);
		WebElement password = getUserInfoElement("passwd");
		password.sendKeys(Upassword);

		WebElement ClickSigninElement = getClickSinginElement("SubmitLogin");

		ClickSigninElement.click();

		return new checkoutPage(this.driver, this.baseUrl);	
	}


	/*public checkoutPage clickAgreeDelieveryAddress() {
		//WebElement addProductElement = driver.findElement(By.xpath("//lable[@for='cgv']"));
		//addProductElement.click();
		clickTheProcessButtonInaddress();
		return new checkoutPage(this.driver, this.baseUrl);	
	}*/

	public checkoutPage clickAgreeDelieveryPolicy() throws InterruptedException {
		Thread.sleep(200);
		WebElement addProductElement = getDelieveryPolicyButtonElement("iframe");
		addProductElement.click();
		clickTheProcessButtonInaddress();
		return new checkoutPage(this.driver, this.baseUrl);	
	}

	public checkoutPage clickPaybyBank() {
		WebElement addProductElement = getBankElement("bankwire");
		addProductElement.click();
		return new checkoutPage(this.driver, this.baseUrl);	
	}

	public checkoutPage clickConfirmMyOrder() {
		WebElement addProductElement = getConfirmOrderButtonElement("icon-chevron-right right");
		addProductElement.click();
		return new checkoutPage(this.driver, this.baseUrl);	
	}

	public WebElement getbuttonAgreeAddressElement(String AgreeAddressElement) {
		return driver.findElement(By.xpath("//label[@for='"+ AgreeAddressElement +"']"));
	}

	public WebElement getDelieveryPolicyButtonElement(String DelieveryPolicyButtonElement) {
		return driver.findElement(By.xpath("//a[@class='"+ DelieveryPolicyButtonElement +"']"));
	}
	public WebElement getBankElement(String BankElement) {
		return driver.findElement(By.xpath("//a[@class='"+ BankElement +"']"));
	}
	public WebElement getConfirmOrderButtonElement(String confirmOrderButtonElement) {
		return driver.findElement(By.xpath("//i[@class='"+ confirmOrderButtonElement +"']"));
	}


	public WebElement getUserInfoElement(String nameElement) {
		return driver.findElement(By.xpath("//input[@id='"+ nameElement +"']"));	
	}

	public WebElement getClickSinginElement(String signinElement) {
		return driver.findElement(By.xpath("//button[@id='"+ signinElement +"']"));	
	}

	/*public checkoutPage clickTheProcessButton() {
		//WebElement clickProcesstoCheck =driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium"));
		//i[@class='icon-chevron-right right']
		WebElement clickProcesstoCheck =driver.findElement(By.xpath("i[@class='icon-chevron-right right']"));
		
		clickProcesstoCheck.click();
		return new checkoutPage(this.driver, this.baseUrl);

	}*/
	
	public checkoutPage clickTheProcessButton() {
		//WebElement clickProcesstoCheck =driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium"));
		//i[@class='icon-chevron-right right']
		WebElement addProductElement = getCheckoutElement1("processAddress");

		addProductElement.click();
		return new checkoutPage(this.driver, this.baseUrl);

	}
	
	public checkoutPage clickTheProcessButtonInaddress() {
		//WebElement clickProcesstoCheck =driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium"));
		//i[@class='icon-chevron-right right']
		WebElement addProductElement = getCheckoutElement1("processCarrier");

		addProductElement.click();
		return new checkoutPage(this.driver, this.baseUrl);

	}
	
	public WebElement getCheckoutElement1(String checkElement) {
		return driver.findElement(By.xpath("//button[@name='"+ checkElement +"']"));		
	}
	
}
