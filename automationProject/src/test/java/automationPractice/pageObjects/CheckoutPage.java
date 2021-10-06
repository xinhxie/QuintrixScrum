package automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObject;

public class CheckoutPage extends PageObject{
	String Uemail = "176914924@163.com";
	String Upassword="03060502a";
	public CheckoutPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		this.subUrl = "/index.php?controller=order";
	}


	public CheckoutPage enterUsernameAndPassword() {
		WebElement emial = getUserInfoElement("email");
		emial.sendKeys(Uemail);
		WebElement password = getUserInfoElement("passwd");
		password.sendKeys(Upassword);

		WebElement ClickSigninElement = getClickSinginElement("SubmitLogin");

		ClickSigninElement.click();

		return new CheckoutPage(this.driver, this.baseUrl);	
	}

	public CheckoutPage clickAgreeDelieveryPolicy() throws InterruptedException {
		Thread.sleep(200);
		WebElement addProductElement = driver.findElement(By.id("cgv"));
		addProductElement.click();
		clickTheProcessButtonInaddress();
		return new CheckoutPage(this.driver, this.baseUrl);	
	}

	public CheckoutPage clickPaybyBank() {
		WebElement addProductElement = getBankElement("bankwire");

		addProductElement.click();

		return new CheckoutPage(this.driver, this.baseUrl);	
	}

	public CheckoutPage clickConfirmMyOrder() {

		WebElement addProductElement = driver.findElement(By.xpath("//button[@class ='button btn btn-default button-medium']"));

		addProductElement.click();

		return new CheckoutPage(this.driver, this.baseUrl);	
	}

	public WebElement getbuttonAgreeAddressElement(String AgreeAddressElement) {
		return driver.findElement(By.xpath("//label[@for='"+ AgreeAddressElement +"']"));
	}

	public WebElement getDelieveryPolicyButtonElement(String DelieveryPolicyButtonElement) {
		return driver.findElement(By.xpath("//input[@itd='"+ DelieveryPolicyButtonElement +"']"));
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

	public CheckoutPage clickTheProcessButton() {

		WebElement addProductElement = getCheckoutElement1("processAddress");

		addProductElement.click();

		return new CheckoutPage(this.driver, this.baseUrl);
	}

	public CheckoutPage clickTheProcessButtonInaddress() {

		WebElement addProductElement = getCheckoutElement1("processCarrier");

		addProductElement.click();

		return new CheckoutPage(this.driver, this.baseUrl);
	}

	public WebElement getCheckoutElement1(String checkElement) {
		return driver.findElement(By.xpath("//button[@name='"+ checkElement +"']"));		
	}


	public String getOrderInformation() {
		return driver.findElement(By.xpath("//p[@class='cheque-indent']")).getText();
	}

	@FindBy(id="summary_products_quantity")
	WebElement productQuantityElement;

	public int getProductQuantity() {
		String text = this.productQuantityElement.getText();
		int quantity = Integer.valueOf(text.split(" ", 2)[0]);
		return quantity;
	}
}
