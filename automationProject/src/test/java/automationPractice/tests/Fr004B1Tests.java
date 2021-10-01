package automationPractice.tests;

import org.testng.annotations.Test;

import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.HomePage;

public class Fr004B1Tests extends AutomationPracticeTestBase{
  @Test
  public void wind23CanShowListProductImage() {
	  HomePage page = new HomePage(this.getDriver(), this.baseUrl);
  }
}
