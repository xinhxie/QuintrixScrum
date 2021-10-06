package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import framework.webDriverFactory.*;

public abstract class TestBase {
	protected String baseUrl;
	protected DriverManager manager;
	private Settings settings;
		
	protected TestBase(String baseUrl) {
		this.baseUrl = baseUrl;
		this.settings = Settings.get();
	}
	
	@BeforeTest
	public void setup() {
		this.manager = DriverManagerFactory.getManager(settings.browserType);
		this.manager.createDriver();
		
		this.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		this.getDriver().manage().window().maximize();
		this.getDriver().navigate().to(this.baseUrl);		
	}
	
	@AfterTest
	public void cleanup() {
		this.manager.quitDriver();
	}
	
	public WebDriver getDriver() {
		return this.manager.getDriver();
	}
}
