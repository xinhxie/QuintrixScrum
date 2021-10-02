package automationPractice.tests;

import org.testng.annotations.Test;

import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.HomePage;
import automationPractice.pageObjects.checkoutPage;

public class Fr008B2 extends AutomationPracticeTestBase{
	
  @Test
  public void UserAbletoCompleteTheOrder() {
	  
	  new HomePage(this.getDriver(), baseUrl)
	  .clickBlouseTitleJumpProductPage()
	  .clickAddedProduct()
	  .clickTheProcessButton()
	  .clickProcessCheckout() 
	  .enterUsernameAndPassword()
	  .clickAgreeDelieveryAddress()
	  .clickAgreeDelieveryPolicy()
	  .clickPaybyBank()
	  .clickConfirmMyOrder();
	  	 
  }

  
}
