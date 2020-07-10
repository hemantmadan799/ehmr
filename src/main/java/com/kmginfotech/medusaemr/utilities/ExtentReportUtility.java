package com.kmginfotech.medusaemr.utilities;

import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportUtility {

	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;

	/**
	 * A constructor for class ExtentReport
	 * 
	 * @param scenarioName Accept the Name Of The Scenario Executed
	 * 
	 */

	public ExtentReportUtility(String scenarioName) {

		// You Should Create Manually A Folder TestReports in your current directory.
		reporter = new ExtentHtmlReporter("TestReports/" + scenarioName + ".html");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		reporter.loadXMLConfig("./src/test/resources/DriversAndConfig/extent-config.xml");

	}

	/**
	 * This Method Is Used To Create Test Case For Extent Report
	 * 
	 * @param testCaseName Accept the name of the test case created.
	 * @return No return type.
	 * 
	 */

	public void logger(String testCaseName) {

		logger = extent.createTest(testCaseName);
	}

	/**
	 * This Method Is Used To Display The PASS Status Of The Test Case.
	 * 
	 * @param passStatus The Message to display when the test case is passed.
	 * @return No return type.
	 * 
	 */
	public void pass(String passStatus) {

		logger.log(Status.PASS, passStatus);

	}

	/**
	 * This Method Is Used To Display The FAIL Status Of The Test Case.
	 * 
	 * @param failStatus The Message to display when the test case is failed.
	 * @return No return type.
	 * 
	 */
	public void fail(String failStatus) {

		logger.log(Status.FAIL, failStatus);
	}

	/**
	 * This Method Is Used To Display The Information In The Report.
	 * 
	 * @param failStatus The message to display used to describe the each steps.
	 * @return No return type.
	 * 
	 */
	public void info(String message) {

		logger.log(Status.INFO, message);

	}

	/**
	 * This Method Is Used To Attach The Taken Screen Shot. Provide the PATH of the
	 * taken screen shot.
	 * 
	 * @param pathName The path name of the screen shot taken in the test case.
	 * @return No return type.
	 * 
	 */
	public void attachScreenShot(String pathName) {
		try {
			logger.addScreenCaptureFromPath(pathName);
		} catch (IOException e) {

			logger.error("Not able to take snapshot of current page of application");

		}

	}

	/**
	 * This Method Is Used To Generate The Report Of The Test Case.
	 * 
	 * @param No parameter required
	 * @return No return type.
	 * 
	 */
	public void writeOnToTheReport() {
		extent.flush();

	}

}
