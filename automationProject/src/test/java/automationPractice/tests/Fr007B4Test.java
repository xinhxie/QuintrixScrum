package automationPractice.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.HomePage;
import automationPractice.pageObjects.ShoppingCartPage;

public class Fr007B4Test extends AutomationPracticeTestBase {
	
  @Test
  public void getToCheckOut() {
			String expectedHref = "http://automationpractice.com/index.php?id_product=1&controller=product#/size-s/color-orange";
			
			
			ShoppingCartPage scp = new HomePage(this.getDriver(), baseUrl)
					.ClickProduct()
					.ClickAddToCart()
					.ProceedToCart();
		
			String itemInCart = scp.ReturnShoppingCartItems();
			assertEquals( itemInCart , expectedHref);
		}
  }
