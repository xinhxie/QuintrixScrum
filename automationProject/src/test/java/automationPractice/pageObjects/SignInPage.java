package automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObject;

public class SignInPage extends PageObject{

	protected SignInPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	WebElement userEmail = driver.findElement(By.xpath("//input[@id = 'email']"));
	WebElement userPassword = driver.findElement(By.xpath("//input[@id = 'passwd']"));
	WebElement SignInBtn = driver.findElement(By.xpath("//button[@id = 'SubmitLogin']"));
	
	public AccountMainPage SignIn() {
		userEmail.sendKeys("oballing88@gmail.com");
		userPassword.sendKeys("password");
		SignInBtn.click();
		return new AccountMainPage(driver, baseUrl);
	}

}
