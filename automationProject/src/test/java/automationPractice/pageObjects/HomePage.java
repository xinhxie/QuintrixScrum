package automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationPractice.controlExtension.FeaturedTable;
import automationPractice.controlExtension.ProductItem;

import framework.PageObject;

public class HomePage extends PageObject {
	@FindBy(id="homefeatured")
	WebElement featuredTableElement;
	@FindBy(id="layer_cart")
	WebElement cartLayerElement;
	@FindBy(id="search_query_top")
	WebElement searchInputTextbox;
	@FindBy(how=How.XPATH, using="//form[@id='searchbox']/button[@type='submit']")
	WebElement searchButton;
	@FindBy(how=How.XPATH, using="//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckoutElement;

	public HomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public BlouseProductPage clickBlouseImageJumpProductPage(){

		WebElement BlouseProductElement = getBlouseImageElement("Blouse");

		BlouseProductElement.click();

		return new BlouseProductPage(this.driver, this.baseUrl);	
	}

	public BlouseProductPage clickBlouseTitleJumpProductPage(){

		WebElement BlouseProductElement = getBlouseTitleElement("Blouse");

		BlouseProductElement.click();

		return new BlouseProductPage(this.driver, this.baseUrl);	
	}

	public WebElement getBlouseImageElement(String BlouseImageElement) {

		return driver.findElement(By.xpath("//img[@title='"+ BlouseImageElement +"']"));
	}

	public WebElement getBlouseTitleElement(String BlouseTitleElement) {

		return driver.findElement(By.xpath("//a[@class='product-name' and @title='"+BlouseTitleElement+"']"));
  }
	public ProductItem getProductItem(int itemIndex) {
		FeaturedTable table = new FeaturedTable(featuredTableElement);
//		ProductItem product = table.getProductItem(itemIndex);
//		this.scrollToElement(product.getMappedElement());
		return table.getProductItem(itemIndex);
	}

	public HomePage scrollToElement(WebElement element) {
		this.executeJavascript("arguments[0].scrollIntoView(true);", element);
		return this;
	}

	public HomePage hoverMouseOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		return this;
	}
	
	public HomePage clickAddToCartButton(ProductItem item) {
		item.clickAddToCartButton();
		return this;
	}
	
	public WebElement getCartLayerElement() {
		return this.cartLayerElement;
	}

	public HomePage waitForCartLayerDisplay() {
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		wait.until(ExpectedConditions.attributeToBe(this.cartLayerElement, "display", "block"));
		return this;
	}

	public CheckoutPage clickProceedToCheckout() {
		proceedToCheckoutElement.click();
		return new CheckoutPage(this.driver, this.baseUrl);
	}

	public SearchResultPage search(String keyword) {
		this.fillSearchTextbox(keyword);
		this.clickSearchBottun();
		return new SearchResultPage(this.driver, this.baseUrl, keyword);
	}
	
	public void fillSearchTextbox(String keyword) {
		this.searchInputTextbox.sendKeys(keyword);
	}
	
	public void clickSearchBottun() {
		this.searchButton.click();
	}
	
	private WebElement elementItem = 
			driver.findElement(By.xpath("//a[@title = 'Faded Short Sleeve T-shirts']"));
	private WebElement signInBtn = 
			driver.findElement(By.xpath("//a[@title = 'Log in to your customer account']"));
	
	public FadedShirtPage ClickProduct() {
		elementItem.click();
		return new FadedShirtPage(driver, baseUrl);
	}

	public SignInPage ClickSignIn() {
		signInBtn.click();
		return new SignInPage(driver, baseUrl);
	}
}
