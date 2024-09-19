package com.assignment_testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.assignment_pageObjects.SearchContent;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_001_SearchResults extends BaseClass {

	SearchContent searchContent = null;

	@Test(priority = 1, description = "Search for the query and verify the page title")
	@Description("Test Desrciption: Verify the Page Title")
	@Severity(SeverityLevel.NORMAL)

	public void verifythePageTitle() {

		logger.info("Starting of VerifythePageTitle Method");

		searchContent = new SearchContent(driver);

		this.searchContent.searchQuery(content);

		try {

			String queryTitle = driver.getTitle();

			Assert.assertEquals(queryTitle, title);

		} catch (Exception e) {
			Assert.fail("Exception occured while verifying the Page Title" + e.getMessage());
			logger.error("Error occured while verifying the Page Title" + e);
		}

		logger.info("Ending of VerifythePageTitle Method");

	}

	@Test(priority = 2, description = "Verify search results contain relevant articles")
	@Description("Test Desrciption: Verify Search result")
	@Severity(SeverityLevel.NORMAL)

	public void verifyContentRelevantArticles() {

		logger.info("Starting of VerifyContentRelevantArticles Method");

		try {

			Assert.assertEquals(searchContent.getReleventSearchContent(), relevantResult);

		} catch (Exception e) {
			Assert.fail("Exception occured while verifying the Page Title" + e.getMessage());
			logger.error("Error occured while verifying the Page Title" + e);

		}

		try {

			Assert.assertEquals(searchContent.getRelevantSearchStories(), topSearchResult);

		} catch (Exception e) {
			Assert.fail("Exception occured while verifying the Page Title" + e.getMessage());
			logger.error("Error occured while verifying the Page Title" + e);
		}
		logger.info("Ending of VerifyContentRelevantArticles Method");
	}

}
