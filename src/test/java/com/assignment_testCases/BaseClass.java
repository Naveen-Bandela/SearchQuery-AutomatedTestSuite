package com.assignment_testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.assignment_utilities.ExpectedAssertions;
import com.assignment_utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	ExpectedAssertions expectedAssertions = new ExpectedAssertions();

	protected WebDriver driver = null;

	public String url = readConfig.getApplicationURL();
	public String content = readConfig.searchContent();
	public String autoSuggestionContent = readConfig.autoSuggestionsOfQuery();
	public String searchedQuery = expectedAssertions.getSearchedQuery();
	public String autoSuggestionResult = expectedAssertions.getAutoSuggestionResults();
	public String title = expectedAssertions.getTitleofQuery();
	public String relevantResult = expectedAssertions.getRelevantResult();
	public String topSearchResult = expectedAssertions.getRelevantStories();

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws Exception {

		logger = Logger.getLogger("Assignment Task");
		PropertyConfigurator.configure("log4j.properties");

		// System.getProperty("user.dir") + "Drivers//chromedriver.exe"

		if (br.equals("chrome")) {
			System.setProperty("webDriver.chrome.driver", readConfig.getChromepath());
			driver = new ChromeDriver();
		}

		else if (br.equals("firefox")) {
			System.setProperty("webDriver.firefox.driver", readConfig.getFirefoxpath());
			driver = new FirefoxDriver();

		} else if (br.equals("ie")) {
			System.setProperty("webDriver.ie.driver", readConfig.getInterExplorerPath());
			driver = new InternetExplorerDriver();

		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {

		logger.info("Starting of tearDown Method");

		Thread.sleep(5000);

		driver.close();

		logger.info("Ending of tearDown Method");
	}

	public void captureScreenshot(WebDriver driver, String tName) throws Exception {
		logger.info("Starting of captureScreenshot Method");

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(System.getProperty(("user.dir") + "/Screenshots/" + tName + ".png"));
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken");

		} catch (Exception e) {
			System.out.println(e);
		}

		logger.info("Ending of captureScreenshot Method");

	}

}
