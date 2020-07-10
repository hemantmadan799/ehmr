package com.kmginfotech.medusaemr.pages;


import org.openqa.selenium.WebDriver;
import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class PreferencePage extends BaseClass {

	WebDriver driver;

	// Constructor created for class "PreferencePage"
	public PreferencePage(WebDriver driver) {

		this.driver = driver;
	
	}

	// This method will call the method linkElectronicHealthRecord() of the Class PreferencePageOr
	public void selectPreference(String scenarioName, String browserName, String methodName,
			ExtentReportUtility testReportObj) {

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		if (preferencePageOr.linkElectronicHealthRecord()) {
			testReportObj.pass("Link Image:  Electronic Health Record clicked successfully.");
		} else {
			testReportObj.fail("Link Image:  Electronic Health Record is not clicked successfully.");
		}

		testReportObj.pass("Preference is selected successfully.");

		waitUtil.holdOn(2);

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

}
