package automationPractice.tests;

import org.testng.annotations.Test;
import automationPractice.foundation.AutomationPracticeTestBase;
import org.testng.Assert;
import automationPractice.controlExtension.ProductItem;
import automationPractice.pageObjects.CheckoutPage;
import automationPractice.pageObjects.HomePage;
import automationPractice.pageObjects.LoginPage;
import automationPractice.pageObjects.ProductDetailsPage;
import automationPractice.pageObjects.WishlistPage;

public class Fr004B1Tests extends AutomationPracticeTestBase{

	@Test
	public void wind16CanAddProductToCart() {
		int itemIndex = 1;
		int expectedProductQuantity = 1;
		HomePage page = new HomePage(this.getDriver(), this.baseUrl);
		ProductItem product = page.getProductItem(itemIndex);

		CheckoutPage checkoutPage = 
				page.scrollToElement(product.getMappedElement())
				.hoverMouseOverElement(product.getMappedElement())
				.clickAddToCartButton(product)
				.waitForCartLayerDisplay()
				.clickProceedToCheckout();

		int actualProductQuantity = checkoutPage.getProductQuantity();
		Assert.assertEquals(actualProductQuantity, expectedProductQuantity, "Prodcut quantity does not match.");
	}

	@Test
	public void wind16CanAddProductToWishlist() {
		String email = "xinhang.testemail1@test.com";
		String password = "password";
		String loginPageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		String homePageUrl = "http://automationpractice.com";
		String wishlistPageUrl = "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist";
		int itemIndex = 1;
		int expectedQuantity = 1;

		this.getDriver().navigate().to(loginPageUrl);

		new LoginPage(this.getDriver(), this.baseUrl)
		.fillEmail(email)
		.fillPassword(password)
		.clickSignIn();

		this.getDriver().navigate().to(homePageUrl);

		HomePage page = new HomePage(this.getDriver(), this.baseUrl);
		ProductItem product = page.getProductItem(itemIndex);
		page.scrollToElement(product.getMappedElement());
		page.hoverMouseOverElement(product.getMappedElement());
		String productSubUrl = product.getDetailsPageSubUrl();
		product.clickMoreButton();

		ProductDetailsPage prodcutDetailsPage = new ProductDetailsPage(this.getDriver(), this.baseUrl, productSubUrl);
		prodcutDetailsPage.clickAddToWishlist();
		prodcutDetailsPage.waitToAddToWishlist();

		this.getDriver().navigate().to(wishlistPageUrl);
		WishlistPage wishlistPage = new WishlistPage(this.getDriver(), this.baseUrl);
		int actualQuantity = wishlistPage.getWishlistQuantity();

		Assert.assertTrue(actualQuantity >= expectedQuantity);
	}
}
