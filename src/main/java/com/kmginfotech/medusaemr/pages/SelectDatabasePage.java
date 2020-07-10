package com.kmginfotech.medusaemr.pages;

import org.openqa.selenium.WebDriver;
import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class SelectDatabasePage extends BaseClass {

	WebDriver driver;

	// Constructor created for class "SelectDatabasePage"
	public SelectDatabasePage(WebDriver driver) {

		this.driver = driver;
		
	}

	// This method will call the methods txtBxSelectDataBase() of the class
	// SelectDatabaseOr and
	// lblSelectClientIsPresent() method of the Class SelectClientPageOr.
	public void selectingDatabase(String databaseName, String scenarioName, String browserName, String methodName,
			ExtentReportUtility testReportObj) {

		if (selectDatabasePageOr.txtBxSelectDataBase(databaseName)) {

			testReportObj.pass("Database, named : " + databaseName + " is entered successfully.");
		} else {

			testReportObj.fail("Database, named : " + databaseName + " is not entered successfully.");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		mouseAndKeyboardUtil.pressEnter();

		if (selectClientPageOr.lblSelectClientIsPresent()) {

			testReportObj.pass("Database Named :" + databaseName + " is available and selected successfully.");

		} else {
			testReportObj.fail("Database Named :" + databaseName + " is not available.");

		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

}
