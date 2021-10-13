package automationPractice.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.HomePage;
import automationPractice.pageObjects.ShoppingCartPage;
import automationPractice.pageObjects.CheckoutPage;

public class Purchase extends AutomationPracticeTestBase{

	@Test
	public void wind11TestBillingRequirments() {
		String expectedUrl = "http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=0";

		new HomePage(this.getDriver(), baseUrl)
		.ClickProduct()
		.ClickAddToCart()
		.ProceedToCart()
		.ClickProceed()
		.SignIn();

		String currentUrl = this.getDriver().getCurrentUrl();

		assertEquals(expectedUrl, currentUrl);
	}

	@Test
	public void wind12UserAbletoCompleteTheOrder() throws InterruptedException {

		String expectedOrderInformation = "Your order on My Store is complete.";
		new HomePage(this.getDriver(), baseUrl)
		.clickBlouseTitleJumpProductPage()
		.clickAddedProduct()
		.clickTheProcessButton()
		.clickProcessCheckout() 
		.enterUsernameAndPassword()   
		.clickTheProcessButton()
		.clickAgreeDelieveryPolicy()
		.clickPaybyBank()
		.clickConfirmMyOrder();

		String actualOrderInformation= new CheckoutPage(this.getDriver(), baseUrl).getOrderInformation();
		assertEquals(actualOrderInformation, expectedOrderInformation);	  	  	 
	}

	@Test
	public void wind13getToCheckOut() {
		String expectedHref = "http://automationpractice.com/index.php?id_product=1&controller=product#/size-s/color-orange";


		ShoppingCartPage scp = new HomePage(this.getDriver(), baseUrl)
				.ClickProduct()
				.ClickAddToCart()
				.ProceedToCart();

		String itemInCart = scp.ReturnShoppingCartItems();
		assertEquals( itemInCart , expectedHref);
	}

}
