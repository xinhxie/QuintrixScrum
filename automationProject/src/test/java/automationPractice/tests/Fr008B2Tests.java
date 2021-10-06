package automationPractice.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.HomePage;
import automationPractice.pageObjects.CheckoutPage;

public class Fr008B2Tests extends AutomationPracticeTestBase{

	@Test
	public void UserAbletoCompleteTheOrder() throws InterruptedException {

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

}
