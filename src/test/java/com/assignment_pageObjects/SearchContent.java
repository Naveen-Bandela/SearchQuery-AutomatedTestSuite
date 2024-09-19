package com.assignment_pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchContent {

    public String query;

	WebDriver ldriver;

	private static final Logger logger = Logger.getLogger(SearchContent.class.getName());

	public SearchContent(WebDriver rdriver) {
		logger.info("Starting of SearchContext method");
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
		logger.info("Ending of SearchContext method");

	}

	@FindBy(xpath = "//textarea[@id='APjFqb']")
	@CacheLookup
	WebElement txtSearch;

	@FindBy(xpath = "//div[@class='co8aDb']")
	@CacheLookup
	WebElement lblSearhResult;

	@FindBy(xpath = "//span[text()='Top stories']")
	@CacheLookup
	WebElement lblRelevantResult;

	@FindBy(xpath = "(//span[contains(text(), 'recent rape cases')])[3]")
	@CacheLookup
	WebElement searchInput;

	@FindBy(xpath = "//span[contains(text(), 'recent rape cases')]")
	@CacheLookup
	List<WebElement> lstSearchResults;

	@FindBy(xpath = "//textarea[text()='Recent rape cases happening in India']")
	@CacheLookup
	WebElement txtSearchfiled;

	public void searchQuery(String content) {

		logger.info("Starting of searchContent method");

		this.txtSearch.sendKeys(content);
		
		query = "Recent rape cases happening in India";

		if (content.equals(query)) {

			this.txtSearch.sendKeys(Keys.ENTER);
		}

		logger.info("Ending of searchContent method");

	}

	public String getSearchedQueryonSearchfield() {
		
		return query;

	}

	public WebElement getReleventSearchContent() {
		logger.info("Starting of getReleventSearchContent method");
		logger.info("Ending of getReleventSearchContent method");

		return lblSearhResult;

	}

	public WebElement getRelevantSearchStories() {
		logger.info("Starting of getReleventSearchContent method");
		logger.info("Ending of getReleventSearchContent method");

		return lblRelevantResult;
	}

	public WebElement getSearchedQuery() {
		logger.info("Starting of getSearchedQuery method");
		logger.info("Ending of getSearchedQuery method");
		return txtSearchfiled;

	}

	public List<String> getSuggestionsText() {
		List<String> suggestionTexts = new ArrayList<>();
		for (WebElement suggestion : lstSearchResults) {
			suggestionTexts.add(suggestion.getText());
		}
		return suggestionTexts;
	}

	public String getSuggestion() {
		if (!lstSearchResults.isEmpty()) {
			return lstSearchResults.get(0).getText();
		}
		return null; // Return null if the suggestions list is empty
	}

}
