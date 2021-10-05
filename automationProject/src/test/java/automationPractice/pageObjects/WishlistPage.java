package automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObject;

public class WishlistPage extends PageObject {
	
	@FindBy(id="wishlist_39703")
	WebElement wishlistRowElement;

	public WishlistPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		this.subUrl = "/index.php?fc=module&module=blockwishlist&controller=mywishlist";
	}

	public int getWishlistQuantity() {
		WebElement quantityElement = this.wishlistRowElement.findElement(By.xpath("./td[2]"));
		return Integer.valueOf(quantityElement.getText());
	}
}
