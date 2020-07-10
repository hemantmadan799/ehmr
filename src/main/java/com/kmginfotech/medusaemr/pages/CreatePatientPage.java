package com.kmginfotech.medusaemr.pages;

import org.openqa.selenium.WebDriver;
import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class CreatePatientPage extends BaseClass {

	WebDriver driver;

	// Constructor created for class "CreatePatientPage"
	public CreatePatientPage(WebDriver driver) {

		this.driver = driver;

	}

	public void fillAddPatientForm(String scenarioName, String browserName, String methodName,
			ExtentReportUtility testReportObj, String firstName, String lastName, String gender, String dob,
			String ethnicity, String race, String address1, String zip, String phoneHome, String emailId,
			String comMode, String language) {

		if (createPatientPageOr.txtBxFirstName(firstName)) {
			testReportObj.pass("First Name is entered successfully.");
		} else {
			testReportObj.fail("First Name is not entered successfully.");
		}

		if (createPatientPageOr.txtBxLastName(lastName)) {
			testReportObj.pass("Last Name is entered successfully.");
		} else {
			testReportObj.fail("Last Name is not entered successfully.");
		}

		if (createPatientPageOr.ddSelectGender(gender)) {
			testReportObj.pass("Gender is selected successfully.");
		} else {
			testReportObj.fail("Gender is not selected successfully.");
		}

		if (createPatientPageOr.txtBxDateOfBirth(dob)) {
			testReportObj.pass("DOB is entered successfully.");
		} else {
			testReportObj.fail("DOB is not entered successfully.");
		}

		if (createPatientPageOr.chkBxEthnicity(ethnicity)) {
			testReportObj.pass("Ethnicity is selected successfully.");
		} else {
			testReportObj.fail("Ethnicity is not selected successfully.");
		}

		if (createPatientPageOr.chkBxRace(race)) {
			testReportObj.pass("Race is selected successfully.");
		} else {
			testReportObj.fail("Race is not selected successfully.");
		}

		if (createPatientPageOr.txtBxAddress1(address1)) {
			testReportObj.pass("Address1 is entered successfully.");
		} else {
			testReportObj.fail("Address1 is not entered successfully.");
		}

		if (createPatientPageOr.txtBxZip(zip)) {
			testReportObj.pass("Zip is entered successfully.");
		} else {
			testReportObj.fail("Zip is not entered successfully.");
		}

		if (createPatientPageOr.txtBxPhoneHome(phoneHome)) {

			testReportObj.pass("Phone Home is entered successfully.");
		} else {
			testReportObj.fail("Phone Home is not entered successfully.");
		}

		if (createPatientPageOr.txtBxEmail(emailId)) {
			testReportObj.pass("Email-Id is entered successfully.");
		} else {
			testReportObj.fail("Email-Id is not entered successfully.");
		}

		if (createPatientPageOr.ddSelectCommunicationMode(comMode)) {
			testReportObj.pass("Comunication Mode is Selected successfully.");
		} else {
			testReportObj.fail("Communication Mode is not Selected successfully.");
		}

		if (createPatientPageOr.chkBxLanguage(language)) {
			testReportObj.pass("Comunication Language is Selected successfully.");
		} else {
			testReportObj.fail("Communication Language is not Selected successfully.");
		}

		if (createPatientPageOr.btnSavePatient()) {
			testReportObj.pass("The button Save Patient is clicked successfully.");
		} else {
			testReportObj.fail("The button Save Patient is not clicked successfully.");
		}

		if (createPatientPageOr.lblMrNumber()) {
			testReportObj.pass("The Patient Added Successfully.");
		} else {
			testReportObj.fail("The Patient Not Added Successfully.");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}



}
