package com.assignment_testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.assignment_pageObjects.SearchContent;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_002_AutosuggestionResult extends BaseClass {

	SearchContent searchContent = null;

	@Test(priority = 1, description = "Verify Test Auto-Suggestions")
	@Description("Test Desrciption: Verify Auto-Suggest Search result")
	@Severity(SeverityLevel.NORMAL)

	public void verifyAutosuggestSearchResults() {

		logger.info("Starting of verifyAutosuggestSearchResults Method");
		searchContent = new SearchContent(driver);

		this.searchContent.searchQuery(autoSuggestionContent);
		try {

			Assert.assertEquals(searchContent.getSuggestion(), autoSuggestionResult);

		} catch (Exception e) {
			Assert.fail("Exception occured while verifying the Page Title" + e.getMessage());
			logger.error("Error occured while verifying the Page Title" + e);

		}

		logger.info("Ending of verifyAutosuggestSearchResults Method");
	}

}
