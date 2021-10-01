package automationPractice.tests;

import org.testng.annotations.Test;
import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.BlouseProductPage;
import automationPractice.pageObjects.HomePage;
import static org.testng.Assert.assertTrue;

public class Fr007B1Tests extends AutomationPracticeTestBase {
  @Test
	public void CanclickBlouseProductPage(){
	  
	  	String expected = "Proceed to checkout";
	  	//String actual= 
	  			new HomePage(this.getDriver(),baseUrl)
				.clickBlouseImageJumpProductPage()
				.clickAddedProduct();
				//.getBloiseElementIntheCart();
				
		String actual = new BlouseProductPage(this.getDriver(),baseUrl ).getBloiseElementIntheCart();
		System.out.println(actual);
		assertTrue(actual.equals(expected));
	}
}
