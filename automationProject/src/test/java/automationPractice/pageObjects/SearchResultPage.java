package automationPractice.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import framework.PageObject;

public class SearchResultPage extends PageObject {
	
	private final String productListElementSelector = "//div[@id='center_column']//ul[contains(@class, 'product_list')]";
	private final String notResultFoundWarningElementSelector = "//div[@id='center_column']//p[@class = 'alert alert-warning' and contains(text(), 'No results were found')]";
	@FindBy(how=How.XPATH, using=productListElementSelector)
	WebElement productListElement;
	boolean isSortedByPrice;
	@FindBy(id="selectProductSort")
	WebElement sortBySelectorElement;

	public SearchResultPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public SearchResultPage(WebDriver driver, String baseUrl, String keyword) {
		super(driver, baseUrl);
		this.subUrl = this.makeSuburl(keyword);
	}
	
	public String makeSuburl(String keyword) {
		String subUrlPart1 = "/index.php?controller=search&orderby=position&orderway=desc&search_query=";
		String subUrlPart2 = "&submit_search=";
		return subUrlPart1 + keyword + subUrlPart2;
	}

	public WebElement getProductListElement() {
		boolean isPresent = this.driver.findElements(By.xpath(productListElementSelector)).size() > 0;
		if (isPresent) {
			return this.driver.findElement(By.xpath(productListElementSelector));
		}
		return null;
	}
	
	public WebElement getNoResultFoundWarningElement() {
		boolean isPresent = this.driver.findElements(By.xpath(notResultFoundWarningElementSelector)).size() > 0;
		if (isPresent) {
			return this.driver.findElement(By.xpath(notResultFoundWarningElementSelector));
		}
		return null;
	}

	public boolean getIsSortedByNameAsc() {
		this.isSortedByPrice = this.checkProductsSortedByNameAsc();
		return this.isSortedByPrice;
	}

	private boolean checkProductsSortedByNameAsc() {
		List<WebElement> nameElements = this.productListElement.findElements(By.xpath(".//div[@class='right-block']//a[@class='product-name']"));
		String[] names = new String[nameElements.size()];
		for (int i = 0; i < names.length; i++) {
			names[i] = nameElements.get(i).getText();
		}
		for (int i = 0; i < names.length - 1; i++) {
			if (names[i].compareTo(names[i+1]) > 0) {
				return false;
			}
		}
		return true;
	}

	public SearchResultPage selectSortByNameAsc() {
		Select sortByDropDown = new Select(sortBySelectorElement);
		String value = "name:asc";
		sortByDropDown.selectByValue(value);
		return this;
	}
}
