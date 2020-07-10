package com.kmginfotech.medusaemr.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class CheckInPopUp extends BaseClass {

	WebDriver driver;

	// Constructor created for class "CheckInPopUp"
	public CheckInPopUp(WebDriver driver) {

		this.driver = driver;

	}

	public void checkedIn(String scenarioName, String browserName, String methodName, ExtentReportUtility testReportObj,
			String appointmentWith, String visitType, String reason) {

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		waitUtil.holdOn(4);

		if (checkInPopUpOr.btnCheckIn()) {
			testReportObj.pass("The Button Check-In Clicked Successfully !");
		} else {
			testReportObj.fail("The Button Check-In Is Not Clicked Successfully !");
		}

		if (checkInPopUpOr.ddAppointmentWith(appointmentWith)) {
			testReportObj.pass("Appointment With Is Selected.");
		} else {
			testReportObj.fail("Appointment With Is Not Selected.");
		}

		if (checkInPopUpOr.ddVisitType(visitType)) {
			testReportObj.pass("Visit Type With Is Selected.");
		} else {
			testReportObj.fail("Visit Type With Is Not Selected.");
		}

		if (checkInPopUpOr.txtBxReason(reason)) {
			testReportObj.pass("Reson Of The Visit Entered Successfully.!");
		} else {
			testReportObj.fail("Reson Of The Visit Is Not Entered Successfully.!");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		if (checkInPopUpOr.btnOk()) {
			testReportObj.pass("The Button OK Is Clicked Successfully !");
		} else {
			testReportObj.fail("The Button OK In Is Not Clicked Successfully !");
		}

		try {

			while (ExpectedConditions.alertIsPresent() != null) {

				waitUtil.holdOn(1);

				webDriverUtil.acceptAlert();

			}
		}

		catch (NoAlertPresentException e) {

		}

		waitUtil.holdOn(1);

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		if (createPatientPageOr.btnSaveAndClose()) {
			testReportObj.pass("The Button Save And Close Is Clicked Successfully !");
		} else {
			testReportObj.fail("The Button Save And Close Is Not Clicked Successfully !");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

}
