package com.assignment_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ExpectedAssertions {

	Properties prop;

	public ExpectedAssertions() {

		File src = new File("./Configuration/expectedassertions.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String getTitleofQuery() {
		String title = prop.getProperty("Title");
		return title;

	}

	public String getRelevantResult() {

		String relevantResult = prop.getProperty("RelevantResult");
		return relevantResult;

	}

	public String getRelevantStories() {

		String relevantTopResult = prop.getProperty("TopResults");
		return relevantTopResult;
	}
	
	public String getAutoSuggestionResults() {

		String autoSuggestionOfQuery = prop.getProperty("AutoSuggestionsOfQuery");
		return autoSuggestionOfQuery;
	}

	public String getSearchedQuery() {

		String searchedQuery = prop.getProperty("SearchedQuery");
		return searchedQuery;

	}
}
