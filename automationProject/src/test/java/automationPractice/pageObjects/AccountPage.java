package automationPractice.pageObjects;

import org.openqa.selenium.WebDriver;

import framework.PageObject;

public class AccountPage extends PageObject {

	public AccountPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		this.subUrl = "/index.php?controller=my-account";
	}
}
