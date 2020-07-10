package com.kmginfotech.medusaemr.pages;

import org.openqa.selenium.WebDriver;
import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class SelectClientPage extends BaseClass {

	WebDriver driver;

	// Constructor created for class "SelectClientPage"
	public SelectClientPage(WebDriver driver) {

		this.driver = driver;
		
	}

	// This method will call the methods txBxSelectClient() of the Class
	// SelectClientPageOr and
	// lblSelectClientIsPresent() method of the Class PreferencePageOr
	public void selectingClient(String clientId, String scenarioName, String browserName, String methodName,
			ExtentReportUtility testReportObj) {

		if (selectClientPageOr.txBxSelectClient(clientId)) {

			testReportObj.pass("Client, ID : " + clientId + " is entered successfully.");
		} else {

			testReportObj.fail("Client, ID : " + clientId + " is not entered successfully.");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		mouseAndKeyboardUtil.pressEnter();

		if (preferencePageOr.lblSelectClientIsPresent()) {

			testReportObj.pass("Client With ID :" + clientId + " is available and selected successfully.");

		} else {
			testReportObj.fail("Client With ID :" + clientId + " is not available.");

		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

}
