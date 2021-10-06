
package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
	protected WebDriver driver;
	protected String baseUrl;
	protected String subUrl;
	
	protected PageObject(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;

		PageFactory.initElements(driver, this);
	}
	
	public String getFullUrl() {
		return this.baseUrl + this.subUrl;
	}

	public void goToUrl(String relativeUrl) {
		String fullUrl = this.baseUrl + relativeUrl;

		this.driver.navigate().to(fullUrl);		
	}
	
	public Object executeJavascript(String script, Object arguments) {
		JavascriptExecutor js = (JavascriptExecutor) this.driver;  
		return js.executeScript(script, arguments);
	}
}
