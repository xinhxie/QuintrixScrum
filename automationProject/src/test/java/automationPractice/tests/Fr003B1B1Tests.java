package automationPractice.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationPractice.foundation.AutomationPracticeTestBase;
import automationPractice.pageObjects.HomePage;
import automationPractice.pageObjects.SearchResultPage;

public class Fr003B1B1Tests extends AutomationPracticeTestBase{
  @Test
  public void wind7CanSearchByValidKeyword() {
	  
	  String keyword = "dress";
	  
	  SearchResultPage page = 
			  new HomePage(this.getDriver(), this.baseUrl)
			  .search(keyword);
	  this.getDriver().navigate().to(page.getFullUrl());
	  
	  WebElement productListElement = page.getProductListElement();
	  Assert.assertNotEquals(productListElement, null, "Product list is empty.");
  }
  
  @Test
  public void wind7CanSearchByInvalidKeyword() {
	  
	  String keyword = "asd";
	  
	  SearchResultPage page = 
			  new HomePage(this.getDriver(), this.baseUrl)
			  .search(keyword);
	  this.getDriver().navigate().to(page.getFullUrl());
	  
	  WebElement noResultFoundWarningElement = page.getNoResultFoundWarningElement();
	  Assert.assertNotEquals(noResultFoundWarningElement, null, "No result found warning is empty.");
  }
  
  @Test
  public void wind7CanSortByNameAsc() {
	  
	  String keyword = "dress";	  
	  
	  SearchResultPage page = 
			  new HomePage(this.getDriver(), this.baseUrl)
			  .search(keyword)
			  .selectSortByNameAsc();
	  
	  Assert.assertEquals(page.getIsSortedByNameAsc(), true, "Products not sorted by price.");
  }
}
