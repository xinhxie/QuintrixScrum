package automationPractice.tests;

import org.testng.annotations.Test;
import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.BlouseProductPage;
import automationPractice.pageObjects.HomePage;
import static org.testng.Assert.assertTrue;

public class Fr007B1Tests extends AutomationPracticeTestBase {
	@Test
	public void CanclickBlouseProductPage(){

		String expected = "Blouse";

		new HomePage(this.getDriver(),baseUrl)
		.clickBlouseImageJumpProductPage()
		.clickAddedProduct();

		String actual = new BlouseProductPage(this.getDriver(),baseUrl ).getBloiseElementIntheCart();

		assertTrue(actual.equals(expected));
	}
}
