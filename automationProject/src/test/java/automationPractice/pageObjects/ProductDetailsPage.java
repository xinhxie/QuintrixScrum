package automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObject;

public class ProductDetailsPage extends PageObject {
	
	@FindBy(id="wishlist_button")
	private WebElement wishlistButton;
	private final long WAIT_ADD_TO_WISHLIST_TIMEOUT = 5;
	
	public ProductDetailsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		this.subUrl = "/index.php?id_product=1&controller=product";
	}
	
	public ProductDetailsPage(WebDriver driver, String baseUrl, String subUrl) {
		super(driver, baseUrl);
		this.subUrl = subUrl;
	}

	public void clickAddToWishlist() {
		this.wishlistButton.click();
	}

	public void waitToAddToWishlist() {
		WebDriverWait wait = new WebDriverWait(this.driver, WAIT_ADD_TO_WISHLIST_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[text()='Added to your wishlist.']")));
	}
}
