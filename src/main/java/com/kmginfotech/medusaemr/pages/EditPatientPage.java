package com.kmginfotech.medusaemr.pages;

import org.openqa.selenium.WebDriver;

import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class EditPatientPage extends BaseClass {

	WebDriver driver;

	// Constructor created for class "CreatePatientPage"
	public EditPatientPage(WebDriver driver) {

		this.driver = driver;

	
	}

	public void editPatientInfo(String scenarioName, String browserName, String methodName,
			ExtentReportUtility testReportObj, String dob, String prevEthnicity, String ethnicity, String prevRace,
			String race, String address1, String phoneHome, String emailId, String comMode, String prevLanguage,
			String language) {

		if (createPatientPageOr.txtBxDateOfBirth(dob)) {
			testReportObj.pass("DOB is Updated successfully.");
		} else {
			testReportObj.fail("DOB is not Updated successfully.");
		}

		if (createPatientPageOr.chkBxEthnicity(prevEthnicity)) {
			testReportObj.pass("Prev Ethnicity is de-selected successfully.");
		} else {
			testReportObj.fail("Prev Ethnicity is not de-selected successfully.");
		}

		if (createPatientPageOr.chkBxEthnicity(ethnicity)) {
			testReportObj.pass("Ethnicity is updated successfully.");
		} else {
			testReportObj.fail("Ethnicity is not updated successfully.");
		}

		if (createPatientPageOr.chkBxRace(prevRace)) {
			testReportObj.pass("Prev Race is de-selected successfully.");
		} else {
			testReportObj.fail("Prev Race is not de-selected successfully.");
		}

		if (createPatientPageOr.chkBxRace(race)) {
			testReportObj.pass("Race is updated successfully.");
		} else {
			testReportObj.fail("Race is not updated successfully.");
		}

		if (createPatientPageOr.txtBxAddress1(address1)) {
			testReportObj.pass("Address1 is Updated successfully.");
		} else {
			testReportObj.fail("Address1 is not Updated successfully.");
		}

		if (createPatientPageOr.txtBxPhoneHome(phoneHome)) {

			testReportObj.pass("Phone Home is Updated successfully.");
		} else {
			testReportObj.fail("Phone Home is not Updated successfully.");
		}

		if (createPatientPageOr.txtBxEmail(emailId)) {
			testReportObj.pass("Email-Id is Updated successfully.");
		} else {
			testReportObj.fail("Email-Id is not Updated successfully.");
		}

		if (createPatientPageOr.ddSelectCommunicationMode(comMode)) {
			testReportObj.pass("Comunication Mode is Updated successfully.");
		} else {
			testReportObj.fail("Communication Mode is not Updated successfully.");
		}

		if (createPatientPageOr.chkBxLanguage(prevLanguage)) {
			testReportObj.pass("Prev Comunication Language is De-selected successfully.");
		} else {
			testReportObj.fail("Prev Communication Language is not De-selected successfully.");
		}

		if (createPatientPageOr.chkBxLanguage(language)) {
			testReportObj.pass("Comunication Language is Updated successfully.");
		} else {
			testReportObj.fail("Communication Language is not Updated successfully.");
		}

		if (createPatientPageOr.btnSavePatient()) {
			testReportObj.pass("The button Save Patient is clicked successfully.");

		} else {
			testReportObj.fail("The button Save Patient is not clicked successfully.");
		}

		if (createPatientPageOr.lblUpdatedSuccessfully()) {
			testReportObj.pass("The Patient Added Successfully.");
		} else {
			testReportObj.fail("The Patient Not Added Successfully.");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		createPatientPageOr.btnSaveAndClose();

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

}
