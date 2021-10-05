package automationPractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObject;

public class LoginPage extends PageObject {

	@FindBy(id="email")
	WebElement emailTextbox;
	@FindBy(id="passwd")
	WebElement passwordTextbox;
	@FindBy(id="SubmitLogin")
	WebElement signInButton;
	
	public LoginPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		this.subUrl = "/index.php?controller=authentication&back=my-account";
	}

	public LoginPage fillEmail(String email) {
		this.emailTextbox.sendKeys(email);
		return this;
	}
	
	public LoginPage fillPassword(String password) {
		this.passwordTextbox.sendKeys(password);
		return this;
	}

	public AccountPage clickSignIn() {
		this.signInButton.click();
		return new AccountPage(this.driver, this.baseUrl);
	}
}
