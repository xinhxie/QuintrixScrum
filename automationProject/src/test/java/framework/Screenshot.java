package framework;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	private WebDriver driver;

	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenshot(String filePath) {
		TakesScreenshot ts=(TakesScreenshot)this.driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(source, new File(filePath));
			System.out.println("Screenshot taken");
		} 
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
		} 
	}
}
