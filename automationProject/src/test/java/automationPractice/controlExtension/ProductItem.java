package automationPractice.controlExtension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductItem {
	
	private WebElement mappedElement;
	private WebElement addToCartButton;
	private WebElement moreButton;
	
	public ProductItem(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	
	public void clickAddToCartButton() {
		this.getAddToCartButton();
		this.addToCartButton.click();
	}
	
	public WebElement getAddToCartButton() {
		String xpathSelector = ".//span[text()='Add to cart']";
		this.addToCartButton = this.mappedElement.findElement(By.xpath(xpathSelector));
		return this.addToCartButton;
	}
	
	public WebElement getMoreButton() {
		String xpathSelector = ".//span[text()='More']";
		this.moreButton = this.mappedElement.findElement(By.xpath(xpathSelector));
		return this.moreButton;
	}
	
	public WebElement getMappedElement() {
		return this.mappedElement;
	}

	public void clickMoreButton() {
		this.getMoreButton();
		this.moreButton.click();
	}

	public String getDetailsPageSubUrl() {
		WebElement productImgElement = this.mappedElement.findElement(By.xpath(".//a[@class='quick-view']"));
		String produtDetailsHref = productImgElement.getAttribute("href");
		int subUrlStartIndex = produtDetailsHref.indexOf("/index");
		String subUrl = produtDetailsHref.substring(subUrlStartIndex);
		return subUrl;
	}
}
