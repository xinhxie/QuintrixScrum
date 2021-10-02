package automationPractice.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.HomePage;

public class Fr001B1Test extends AutomationPracticeTestBase{
	
  @Test
  public void SignInExsistingUser() {
	  	String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		
		
	  	new HomePage(this.getDriver(), baseUrl)
				.ClickSignIn()
				.SignIn();

		String CurrentUrl = this.getDriver().getCurrentUrl();
		assertEquals( CurrentUrl , expectedUrl);
	}
}
