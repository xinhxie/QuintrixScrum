package automationPractice.tests;

import org.testng.annotations.Test;
import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.BlouseProductPage;
import automationPractice.pageObjects.HomePage;
import static org.testng.Assert.assertTrue;

public class Fr007B1Tests extends AutomationPracticeTestBase {
  @Test
	public void CanclickBlouseProductPage(){
	  
	  	String expect = "Proceed to checkout";
	  	new HomePage(this.getDriver(),baseUrl)
				.clickBlouseProductPage()
				.clickAddedProduct();
				
		String actural = new BlouseProductPage(this.getDriver(),baseUrl ).getBloiseElementIntheCart();
		
		assertTrue(actural.equals(expect));
	}
}
