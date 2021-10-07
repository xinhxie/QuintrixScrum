package automationPractice.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.HomePage;

public class Fr008B3Test extends AutomationPracticeTestBase{
	
  @Test
  public void testBillingRequirments() {
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
}
