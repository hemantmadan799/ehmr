package com.kmginfotech.medusaemr.pages;

import org.openqa.selenium.WebDriver;
import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class IndexPage extends BaseClass {

	WebDriver driver;

	// Constructor created for class "IndexPage"
	public IndexPage(WebDriver driver) {

		this.driver = driver;
	
	}

	// This method is call the methods txtBxUserName(), txtBxPassword() and
	// btnSubmit() of the class IndexPageOr
	public void loginToTheApplication(String userName, String password, String scenarioName, String browserName,
			String methodName, ExtentReportUtility testReportObj) {

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		if (indexPageOr.txtBxUserName(userName)) {
			testReportObj.pass("UserName is entered successfully.");
		} else {
			testReportObj.fail("UserName is not entered successfully.");
		}

		if (indexPageOr.txtBxPassword(password)) {
			testReportObj.pass("Password is entered successfully.");
		} else {
			testReportObj.fail("Password is not entered successfully.");
		}
		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		if (indexPageOr.btnSubmit()) {
			testReportObj.pass("Submit Button is  Clicked successfully.");
		} else {
			testReportObj.fail("Submit Button is  Clicked successfully.");
		}

		testReportObj.pass("Login to the application successfully.");

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

}
