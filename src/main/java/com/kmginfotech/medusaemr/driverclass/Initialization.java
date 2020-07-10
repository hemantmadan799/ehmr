package com.kmginfotech.medusaemr.driverclass;

import org.openqa.selenium.WebDriver;
import com.kmginfotech.medusaemr.objectrepository.CheckInPopUpOr;
import com.kmginfotech.medusaemr.objectrepository.CreatePatientPageOr;
import com.kmginfotech.medusaemr.objectrepository.EhrPageOr;
import com.kmginfotech.medusaemr.objectrepository.FrontDeskPageOr;
import com.kmginfotech.medusaemr.objectrepository.IndexPageOr;
import com.kmginfotech.medusaemr.objectrepository.PreferencePageOr;
import com.kmginfotech.medusaemr.objectrepository.SearchPatientPageOr;
import com.kmginfotech.medusaemr.objectrepository.SelectClientPageOr;
import com.kmginfotech.medusaemr.objectrepository.SelectDatabasePageOr;
import com.kmginfotech.medusaemr.pages.CheckInPopUp;
import com.kmginfotech.medusaemr.pages.CreatePatientPage;
import com.kmginfotech.medusaemr.pages.EditPatientPage;
import com.kmginfotech.medusaemr.pages.EhrPage;
import com.kmginfotech.medusaemr.pages.FrontDeskPage;
import com.kmginfotech.medusaemr.pages.IndexPage;
import com.kmginfotech.medusaemr.pages.PreferencePage;
import com.kmginfotech.medusaemr.pages.SearchPatientPage;
import com.kmginfotech.medusaemr.pages.SelectClientPage;
import com.kmginfotech.medusaemr.pages.SelectDatabasePage;
import com.kmginfotech.medusaemr.utilities.ExcelUtility;
import com.kmginfotech.medusaemr.utilities.JavaScriptUtility;
import com.kmginfotech.medusaemr.utilities.JavaUtility;
import com.kmginfotech.medusaemr.utilities.MouseAndKeyboardUtility;
import com.kmginfotech.medusaemr.utilities.ReadPropertyFile;
import com.kmginfotech.medusaemr.utilities.SikuliUtility;
import com.kmginfotech.medusaemr.utilities.WaitUtility;
import com.kmginfotech.medusaemr.utilities.WebDriverUtility;

public class Initialization {

	WebDriver driver;

	// Creating Reference Variable Of The Utilities

	protected static ExcelUtility excelUtil;
	protected static JavaScriptUtility javaScriptUtil;
	protected static JavaUtility javaUtil;
	protected static MouseAndKeyboardUtility mouseAndKeyboardUtil;
	protected static SikuliUtility sikuliUtil;
	protected static WaitUtility waitUtil;
	protected static WebDriverUtility webDriverUtil;

	// Creating Reference Variable Of The Object Repositories

	protected static IndexPageOr indexPageOr;
	protected static SelectDatabasePageOr selectDatabasePageOr;
	protected static SelectClientPageOr selectClientPageOr;
	protected static PreferencePageOr preferencePageOr;
	protected static EhrPageOr ehrPageOr;
	protected static FrontDeskPageOr frontDeskpageOr;
	protected static CreatePatientPageOr createPatientPageOr;
	protected static SearchPatientPageOr searchPatientPageOr;
	protected static CheckInPopUpOr checkInPopUpOr;

	// Creating Reference Variable Of The Web Pages

	protected static IndexPage indexPage;
	protected static SelectDatabasePage selectDatabasePage;
	protected static SelectClientPage selectClientPage;
	protected static PreferencePage preferencePage;
	protected static EhrPage ehrPage;
	protected static FrontDeskPage frontDeskPage;
	protected static CreatePatientPage createPatientPage;
	protected static SearchPatientPage searchPatientPage;
	protected static CheckInPopUp checkInPopUp;
	protected static EditPatientPage editPatientPage;

	protected static ReadPropertyFile propertyFile = new ReadPropertyFile();

	// Utilities Initialization
	public void InitializationOfTheUtilities(WebDriver driver) {

		excelUtil = new ExcelUtility(propertyFile.getconfig("Excel"));
		javaScriptUtil = new JavaScriptUtility(driver);
		javaUtil = new JavaUtility();
		mouseAndKeyboardUtil = new MouseAndKeyboardUtility(driver);
		sikuliUtil = new SikuliUtility();
		waitUtil = new WaitUtility(driver);
		webDriverUtil = new WebDriverUtility(driver);

	}

	// Object Repository Initialization
	public void InitializationOfTheObjectRepository(WebDriver driver) {

		indexPageOr = new IndexPageOr(driver);
		selectDatabasePageOr = new SelectDatabasePageOr(driver);
		selectClientPageOr = new SelectClientPageOr(driver);
		preferencePageOr = new PreferencePageOr(driver);
		ehrPageOr = new EhrPageOr(driver);
		frontDeskpageOr = new FrontDeskPageOr(driver);
		createPatientPageOr = new CreatePatientPageOr(driver);
		searchPatientPageOr = new SearchPatientPageOr(driver);
		checkInPopUpOr = new CheckInPopUpOr(driver);

	}

	// Web Page Initialization
	public void InitializationOfTheWebPages(WebDriver driver) {

		indexPage = new IndexPage(driver);
		selectDatabasePage = new SelectDatabasePage(driver);
		selectClientPage = new SelectClientPage(driver);
		preferencePage = new PreferencePage(driver);
		ehrPage = new EhrPage(driver);
		frontDeskPage = new FrontDeskPage(driver);
		createPatientPage = new CreatePatientPage(driver);
		searchPatientPage = new SearchPatientPage(driver);
		checkInPopUp = new CheckInPopUp(driver);
		editPatientPage = new EditPatientPage(driver);

	}

}
