package com.kmginfotech.medusaemr.scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class SearchAndEdit extends BaseClass {

	// The below two lines provides the value of current class name
	String fullClassName = this.getClass().getName();
	String scenarioName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);

	ExtentReportUtility testReportObj = new ExtentReportUtility(scenarioName);

	// Login To The Application (Call the method of the Class IndexPage)
	@Test(priority = 1)
	@Parameters("browserName")
	public void login(String browserName) {

		waitUtil.holdOn(1);

		javaUtil.deleteDirectory("TestReports/ScreenShots/" + scenarioName);

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		// Define The Test Case
		testReportObj.logger("Test Case To Validate That Authorized User Is Able To Login or Not?");

		String userName = propertyFile.getconfig("UserName");

		String password = propertyFile.getconfig("Password");

		indexPage.loginToTheApplication(userName, password, scenarioName, browserName, methodName, testReportObj);

	}

	// Select Database (Call the method of the Class SelectDatabasePage)
	@Test(priority = 2)
	@Parameters("browserName")
	public void selectDatabase(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		// Define The Test Case
		testReportObj.logger("Test Case To Select Database ?");

		selectDatabasePage.selectingDatabase(propertyFile.getconfig("DatabaseName"), scenarioName, browserName,
				methodName, testReportObj);

	}

	// Select Client ID (Call the method of the Class SelectClientPage)
	@Test(priority = 3)
	@Parameters("browserName")
	public void selectClientId(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		// Define The Test Case
		testReportObj.logger("Test Case To Select Client ID ?");

		selectClientPage.selectingClient(propertyFile.getconfig("ClientId"), scenarioName, browserName, methodName,
				testReportObj);

	}

	// Select Preference Electronic Health Record (Call the method of the Class
	// PreferencePage)
	@Test(priority = 4)
	@Parameters("browserName")
	public void selectPreferenceEmr(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		// Define The Test Case
		testReportObj.logger("Test Case To Select Preference Electronic Health Record?");

		preferencePage.selectPreference(scenarioName, browserName, methodName, testReportObj);

	}

	// Move to the Screen EHR (Call the method of the Class EhePage)
	@Test(priority = 5)
	@Parameters("browserName")
	public void moveToTheWindowEhr(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		// Define The Test Case
		testReportObj.logger("Test Case To Check User Is Move To The Window Med Prime 2.0 Successfully ?");

		webDriverUtil.switchWindowFocusByTitle("Med Prime 2.1");

		ehrPage.closeAlertOpenChart(scenarioName, browserName, methodName, testReportObj);

	}

	@Test(priority = 6)
	@Parameters("browserName")
	public void moveToTheFrontDesk(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		// Define The Test Case
		testReportObj.logger("Test Case To Validate That The User Is Able To Move To The Front Desk?");

		ehrPage.selectTileFrontDesk(scenarioName, browserName, methodName, testReportObj);

	}

	@Test(priority = 7)
	@Parameters("browserName")
	public void searhThePatient(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		String mrNumber = null;

		// Define The Test Case
		testReportObj
				.logger("Test Case To Validate That The User Is Able To Search The Patient By His/Her MR Number ?");

		// to get or set data if scenario name exists in given sheet
		String[] colHeading = new String[excelUtil.getcolumnCount("EditPatient")];

		colHeading = excelUtil.getcolumnHeadingInArray("EditPatient");

		for (int counter = 1; counter < excelUtil.getcolumnCount("EditPatient"); counter++) {

			if (colHeading[counter].equalsIgnoreCase("MrNumber"))

				mrNumber = excelUtil.getData(1, counter, "EditPatient");
		}

		searchPatientPage.searchPatient(scenarioName, browserName, methodName, testReportObj, mrNumber);
	}

	@Test(priority = 8)
	@Parameters("browserName")
	public void moveToTheEditPatientInfoPage(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		// Define The Test Case
		testReportObj.logger("Test Case To Validate That The User Is Able To Move To The Edit Patient Info Page?");

		searchPatientPage.clickOnTheEditImage(scenarioName, browserName, methodName, testReportObj);

	}

	@Test(priority = 9)
	@Parameters("browserName")
	public void editPatient(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		String dob, prevEthnicity, ethnicity, prevRace, race, address1, phoneHome, emailId, comMode, prevLanguage,
				language;

		dob = prevEthnicity = ethnicity = prevRace = race = address1 = phoneHome = emailId = comMode = prevLanguage = language = null;

		// Define The Test Case
		testReportObj.logger("Test Case To Validate That The User Is Able To Edit The Partient Info or Not?");

		// to get the first active row if given scenario is available.
		int firstActiveRowEditPatient = excelUtil.isScenarioAvailable("EditPatient", scenarioName);

		// to get or set data if scenario name exists in given sheet
		String[] colHeading = new String[excelUtil.getcolumnCount("EditPatient")];

		colHeading = excelUtil.getcolumnHeadingInArray("EditPatient");

		if (firstActiveRowEditPatient != 0) {
			for (int counter = 1; counter < excelUtil.getcolumnCount("EditPatient"); counter++) {
				if (colHeading[counter].equalsIgnoreCase("DOB"))
					dob = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

				else if (colHeading[counter].equals("PrevEthnicity"))
					prevEthnicity = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

				else if (colHeading[counter].equals("Ethnicity"))
					ethnicity = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

				else if (colHeading[counter].equals("PrevRace"))
					prevRace = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

				else if (colHeading[counter].equals("Race"))
					race = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

				else if (colHeading[counter].equals("Address1"))
					address1 = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

				else if (colHeading[counter].equals("PhoneHome"))
					phoneHome = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

				else if (colHeading[counter].equals("EmailId"))
					emailId = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

				else if (colHeading[counter].equals("CommunicationMode"))
					comMode = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

				else if (colHeading[counter].equals("PrevLanguage"))
					prevLanguage = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

				else if (colHeading[counter].equals("Language"))
					language = excelUtil.getData(firstActiveRowEditPatient, counter, "EditPatient");

			}

			editPatientPage.editPatientInfo(scenarioName, browserName, methodName, testReportObj, dob, prevEthnicity,
					ethnicity, prevRace, race, address1, phoneHome, emailId, comMode, prevLanguage, language);

		}

	}

	// Generating Report
	@AfterClass
	public void writeReport() {
		testReportObj.writeOnToTheReport();
	}

}
