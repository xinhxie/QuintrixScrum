package automationPractice.controlExtension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FeaturedTable {

	private WebElement mappedElement;
	
	public FeaturedTable(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	public ProductItem getProductItem(int itemIndex) {
		String xpathSelector = ".//li["+itemIndex+"]";
		WebElement productElement = this.mappedElement.findElement(By.xpath(xpathSelector));
		return new ProductItem(productElement);
	}
	

}
