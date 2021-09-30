package framework.webDriverFactory;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager{
	private final String Edge_DRIVER_SYSTEM_PROPERTY = "webdriver.edge.driver";
	private final String edgeDriverPath = "resources/msedgedriver.exe";
	public EdgeDriverManager() {
		System.setProperty(Edge_DRIVER_SYSTEM_PROPERTY, edgeDriverPath);
	}
	public void createDriver() {
		setDriver(new EdgeDriver());
	}
}
