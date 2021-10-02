package framework.webDriverFactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	private WebDriver driver;
	public abstract void createDriver();
	
	public WebDriver getDriver() {
		if (this.driver == null) {
			throw new RuntimeException("Driver not started.");
		}
		return this.driver;
	}
	
	protected void setDriver(WebDriver targetDriver) {
		this.driver = targetDriver;
	}

	public void quitDriver() {
		//this.driver.quit();
		//this.driver = null;
	}
}
