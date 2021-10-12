package automationPractice.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationPractice.controlExtension.ProductItem;
import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.HomePage;
import automationPractice.pageObjects.ProductDetailsPage;

public class Fr005B6Tests extends AutomationPracticeTestBase{
  @Test
  public void wind33NotAbleToAddToWishlishBeforeLogin() {	  
		int itemIndex = 1;

		HomePage page = new HomePage(this.getDriver(), this.baseUrl);
		ProductItem product = page.getProductItem(itemIndex);
		page.scrollToElement(product.getMappedElement());
		page.hoverMouseOverElement(product.getMappedElement());
		String productSubUrl = product.getDetailsPageSubUrl();
		product.clickMoreButton();

		ProductDetailsPage prodcutDetailsPage = new ProductDetailsPage(this.getDriver(), this.baseUrl, productSubUrl);
		prodcutDetailsPage.clickAddToWishlist();
		prodcutDetailsPage.waitToAddToWishlist();

		WebElement addToWishlistError = prodcutDetailsPage.getAddToWishlistError();

		Assert.assertNotEquals(addToWishlistError, null, "Can not find add to wish list error box");
  }
}
