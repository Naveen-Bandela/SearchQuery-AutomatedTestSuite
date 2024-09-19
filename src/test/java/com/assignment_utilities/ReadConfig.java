package com.assignment_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {

		File src = new File("./Configuration/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String getApplicationURL() {

		String url = prop.getProperty("baseUrl");
		return url;

	}

	public String searchContent() {

		String content = prop.getProperty("content");
		return content;
	}
	
	public String autoSuggestionsOfQuery() {

		String autosuggestContent = prop.getProperty("autosuggestContent");
		return autosuggestContent;
	}
	

	public String getChromepath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;

	}

	public String getFirefoxpath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;

	}

	public String getInterExplorerPath() {
		String iedriverpath = prop.getProperty("iedriverpath");
		return iedriverpath;

	}
}
