package com.assignment_utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date()); // Time stamp
		String repName = "Test-Report" + timeStamp + ".html";
		
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName); // Specify
																											// the
          																									// Location
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {

			e.printStackTrace();
		}
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Envoirment", "QA");
		extent.setSystemInfo("user", "Naveen");

		htmlReporter.config().setDocumentTitle("OrangeHRM Demo Project"); // Title of the Report
		htmlReporter.config().setReportName("Testing Practicing Reports"); // Name of the Report
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult tr) {

		logger = extent.createTest(tr.getName()); // Create new entry in the Report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // Send the Passed test
																							// cases information
	}

	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // Create new entry in the Report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // Send the Failed test cases
																							// information

		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";
		
		File file = new File(screenshotPath);
		if (file.exists()) {

			try {
				logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // Create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE)); // Send the Skipped test
																								// cases information
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
