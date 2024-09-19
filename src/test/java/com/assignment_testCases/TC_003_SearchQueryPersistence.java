package com.assignment_testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.assignment_pageObjects.SearchContent;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_003_SearchQueryPersistence extends BaseClass {

	SearchContent searchContent = null;

	@Test(priority = 1, description = "Verify search query persistence ")
	@Description("Test Desrciption:  Verify search query persistence after performing a search")
	@Severity(SeverityLevel.NORMAL)

	public void verifySearchQueryPersistence() {

		logger.info("Starting of verifySearchQueryPersistence Method");
		searchContent = new SearchContent(driver);

		this.searchContent.searchQuery(content);
		try {

			Assert.assertEquals(searchContent.getSearchedQueryonSearchfield(), searchedQuery);

		} catch (Exception e) {
			Assert.fail("Exception occured while verifying the Page Title" + e.getMessage());
			logger.error("Error occured while verifying the Page Title" + e);

		}

		logger.info("Ending of verifySearchQueryPersistence Method");
	}

}
