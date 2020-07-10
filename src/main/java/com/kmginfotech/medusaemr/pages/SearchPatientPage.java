package com.kmginfotech.medusaemr.pages;

import org.openqa.selenium.WebDriver;
import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class SearchPatientPage extends BaseClass {

	WebDriver driver;

	// Constructor created for class "SearchPatientPage"
	public SearchPatientPage(WebDriver driver) {

		this.driver = driver;
	
	}

	public void searchPatient(String scenarioName, String browserName, String methodName,
			ExtentReportUtility testReportObj, String mrNumber) {

		if (searchPatientPageOr.txtBxMrNumber(mrNumber)) {
			testReportObj.pass("The MR Number is entered successfully.");
		} else {
			testReportObj.fail("The MR Number is not entered successfully..");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		if (searchPatientPageOr.btnOk()) {
			testReportObj.pass("OK Search Button Is Clicked Successfully.");
		} else {
			testReportObj.fail("OK Search Button Is Not Clicked Successfully.");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

	public void clickOnTheEditImage(String scenarioName, String browserName, String methodName,
			ExtentReportUtility testReportObj) {

		if (searchPatientPageOr.btnEdit()) {
			testReportObj.pass("Edit button(Image) is clicked successfully.");
		} else {
			testReportObj.fail("Edit button(Image) is not clicked successfully..");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

}
