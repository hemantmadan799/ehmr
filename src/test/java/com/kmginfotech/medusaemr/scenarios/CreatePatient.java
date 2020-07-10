package com.kmginfotech.medusaemr.scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kmginfotech.medusaemr.driverclass.BaseClass;
import com.kmginfotech.medusaemr.utilities.ExtentReportUtility;

public class CreatePatient extends BaseClass {

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

		driver.manage().window().maximize();

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
	public void moveToTheAddNewPatirntForm(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		// Define The Test Case
		testReportObj.logger("Test Case To Validate That The User Is Able To Move To The Add New Patient Form?");

		frontDeskPage.moveToTheAddNewPatientPage(scenarioName, browserName, methodName, testReportObj);

	}

	@Test(priority = 8)
	@Parameters("browserName")
	public void createNewPatient(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		String firstName, lastName, gender, dob, ethnicity, race, address1, zip, phoneHome, emailId, comMode, language;

		firstName = lastName = gender = dob = ethnicity = race = address1 = zip = phoneHome = emailId = comMode = language = null;

		// Define The Test Case
		testReportObj.logger("Test Case To Validate That The User Is Able To Add New Patient?");

		// to get the first active row if given scenario is available.
		int firstActiveRowCreatePatient = excelUtil.isScenarioAvailable("CreatePatient", scenarioName);

		// to get or set data if scenario name exists in given sheet
		String[] colHeading = new String[excelUtil.getcolumnCount("CreatePatient")];

		colHeading = excelUtil.getcolumnHeadingInArray("CreatePatient");

		if (firstActiveRowCreatePatient != 0) {

			for (int counter = 1; counter < excelUtil.getcolumnCount("CreatePatient"); counter++) {
				if (colHeading[counter].equals("FirstName")) {

					firstName = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient")
							+ javaUtil.getRandomNumber(100, 2000);

					excelUtil.setData("CreatePatient", firstActiveRowCreatePatient, counter, firstName);

				} else if (colHeading[counter].equals("LastName"))
					lastName = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

				else if (colHeading[counter].equals("Gender"))
					gender = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

				else if (colHeading[counter].equals("DOB"))
					dob = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

				else if (colHeading[counter].equals("Ethnicity"))
					ethnicity = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

				else if (colHeading[counter].equals("Race"))
					race = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

				else if (colHeading[counter].equals("Address1"))
					address1 = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

				else if (colHeading[counter].equals("Zip"))
					zip = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

				else if (colHeading[counter].equals("PhoneHome"))
					phoneHome = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

				else if (colHeading[counter].equals("EmailId"))
					emailId = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

				else if (colHeading[counter].equals("CommunicationMode"))
					comMode = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

				else if (colHeading[counter].equals("Language"))
					language = excelUtil.getData(firstActiveRowCreatePatient, counter, "CreatePatient");

			}

			firstActiveRowCreatePatient = firstActiveRowCreatePatient + 1;

		}

		createPatientPage.fillAddPatientForm(scenarioName, browserName, methodName, testReportObj, firstName, lastName,
				gender, dob, ethnicity, race, address1, zip, phoneHome, emailId, comMode, language);
	}

	@Test(priority = 9)
	@Parameters("browserName")
	public void checkedIn(String browserName) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		String appointmentWith, visitType, reason;

		appointmentWith = visitType = reason = null;

		// Define The Test Case
		testReportObj.logger("Test Case To Validate That The User Is Able To Check In The Created Patient?");

		// to get the first active row if given scenario is available.
		int firstActiveRowCreatePatient = excelUtil.isScenarioAvailable("CheckIn", scenarioName);
		// to get the last active row if given scenario is available.

		// to get or set data if scenario name exists in given sheet
		String[] colHeading = new String[excelUtil.getcolumnCount("CheckIn")];

		colHeading = excelUtil.getcolumnHeadingInArray("CheckIn");

		if (firstActiveRowCreatePatient >= 0) {
			for (int counter = 1; counter < excelUtil.getcolumnCount("CheckIn"); counter++) {
				if (colHeading[counter].equals("AppointmentWith"))
					appointmentWith = excelUtil.getData(firstActiveRowCreatePatient, counter, "CheckIn");

				else if (colHeading[counter].equals("VisitType"))
					visitType = excelUtil.getData(firstActiveRowCreatePatient, counter, "CheckIn");

				else if (colHeading[counter].equals("Reason"))
					reason = excelUtil.getData(firstActiveRowCreatePatient, counter, "CheckIn");

			}

		}

		checkInPopUp.checkedIn(scenarioName, browserName, methodName, testReportObj, appointmentWith, visitType,
				reason);
	}

	// Generating Report
	@AfterClass
	public void writeReport() {
		testReportObj.writeOnToTheReport();

		
	}

}
