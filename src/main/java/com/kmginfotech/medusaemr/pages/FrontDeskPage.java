package com.kmginfotech.medusaemr.pages;

import org.openqa.selenium.WebDriver;
import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class FrontDeskPage extends BaseClass {

	WebDriver driver;

	// Constructor created for class "FrontDeskPage"
	public FrontDeskPage(WebDriver driver) {

		this.driver = driver;
		
	}

	// This method is call the methods txtBxUserName()linkPatients(),
	// btnAddPatient() of the class FrontDeskPageOr
	public void moveToTheAddNewPatientPage(String scenarioName, String browserName, String methodName,
			ExtentReportUtility testReportObj) {

		if (frontDeskpageOr.linkPatients()) {
			testReportObj.pass("The Link PATIENTS in the FRONT DESK page is clicked Successfully.");
		} else {
			testReportObj.fail("The Link PATIENTS in the FRONT DESK page is not active.");
		}

		if (frontDeskpageOr.btnAddPatient()) {
			testReportObj.pass("The button Add Patient is clicked successfully.");
		} else {
			testReportObj.fail("The button Add Patient is not clicked successfully.");
		}

		testReportObj.pass("The Add Patient form opened successfully.");

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

}
