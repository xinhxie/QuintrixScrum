package automationPractice.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.HomePage;

public class Fr004B2Tests extends AutomationPracticeTestBase{
	
	@Test
	public void canClickProductTitleViewTheDetails() {
		String expected = "Compositions Cotton\n"
				+ "Styles Casual\n"
				+ "Properties Short Sleeve";
		String actual = new HomePage(this.getDriver(),baseUrl)
				.clickBlouseTitleJumpProductPage()
				.getBlouseProductDetails();

		assertEquals(actual, expected);
	}

	@Test
	public void canClickProductImageViewTheDetails() {
		String expected = "Compositions Cotton\n"
				+ "Styles Casual\n"
				+ "Properties Short Sleeve";
		String actual = new HomePage(this.getDriver(),baseUrl)
				.clickBlouseImageJumpProductPage()
				.getBlouseProductDetails();

		assertEquals(actual, expected);	  
	}
}
