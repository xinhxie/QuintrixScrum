package framework;

import java.util.HashMap;

public class Settings {
	
	public String browserType;

	public static Settings get() {
		String file = "config.properties";
		Settings settings = new Settings();
		HashMap<String,String> configFileProperties = null;
		
		try {
			configFileProperties = new ConfigurationProvider().getPropertiesFromResourceFile(file);
		} catch (Exception e) {
			throw new RuntimeException(new Exception("There was a problem reading reading the file " + file + ": " + e.getMessage()));
		}

		settings.browserType = configFileProperties.get("BrowserType").toLowerCase();
	
		return settings;
	}
}