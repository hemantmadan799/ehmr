package com.kmginfotech.medusaemr.pages;

import org.openqa.selenium.WebDriver;
import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class EhrPage extends BaseClass {

	WebDriver driver;

	// Constructor created for class "EhrPage"
	public EhrPage(WebDriver driver) {

		this.driver = driver;
	
	}

	// This method is call the method imgCloseAlertOpenChart() of the class
	// "EhrPageOr"

	public void closeAlertOpenChart(String scenarioName, String browserName, String methodName,
			ExtentReportUtility testReportObj) {

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

		if (ehrPageOr.imgCloseAlertOpenChart()) {
			testReportObj.pass("The Alert Box Closed Successfully");
		} else {
			testReportObj.fail("Could Not Find The Alert Box.");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

	public void clickOnHomeButton(ExtentReportUtility testReportObj) {

		if (ehrPageOr.btnHome()) {
			testReportObj.pass("Home Button Is Clicked Successfully.");
		} else {
			testReportObj.fail("Home Button Is Not Clicked Successfully.");
		}
	}

	// This method is call the method tileSelectFrontDesk() of the class "EhrPageOr"

	public void selectTileFrontDesk(String scenarioName, String browserName, String methodName,
			ExtentReportUtility testReportObj) {

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));
		
		waitUtil.holdOn(4);

		if (ehrPageOr.tileFrontDesk()) {
			testReportObj.pass("User Move To The Fron Desk Screen Successfully.");
		} else {
			testReportObj.fail("User Do Not Move To The Fron Desk Screen Successfully.");
		}

		testReportObj.attachScreenShot(webDriverUtil.takeScreenShot(scenarioName, browserName, methodName));

	}

}
