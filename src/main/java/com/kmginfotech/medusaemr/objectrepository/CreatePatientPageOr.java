package com.kmginfotech.medusaemr.objectrepository;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kmginfotech.medusaemr.driverclass.BaseClass;

public class CreatePatientPageOr extends BaseClass {

	WebDriver driver;
	boolean status = false;

	private Logger logger = Logger.getLogger(CreatePatientPageOr.class);

	// Constructor created for class "CreatePatientPageOr"
	public CreatePatientPageOr(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[contains(@id,'firstName')]")
	WebElement txtBxFirstName;

	@FindBy(xpath = "//input[contains(@id,'lastName')]")
	WebElement txtBxLastName;

	@FindBy(xpath = "//select[contains(@id,'gender')]")
	WebElement ddSelectGender;

	@FindBy(xpath = "//input[contains(@id,'dateOfBirth')]")
	WebElement txtBxDateOfBirth;

	@FindBy(xpath = "//div[contains(@class,'Ethnicity')]/label")
	public List<WebElement> chkBxEthnicity;

	@FindBy(xpath = "//div[contains(@class,'Race')]/label")
	public List<WebElement> chkBxRace;

	@FindBy(xpath = "//input[contains(@id,'address1')]")
	WebElement txtBxAddress1;

	@FindBy(xpath = "//input[contains(@id,'zip')]")
	WebElement txtBxZip;

	@FindBy(xpath = "//input[contains(@id,'city')]")
	WebElement txtBxCity;

	@FindBy(xpath = "//select[contains(@id,'Phone')]")
	WebElement ddSelectCommunicationMode;

	@FindBy(xpath = "//input[contains(@id, 'Home')]")
	WebElement txtBxPhoneHome;

	@FindBy(xpath = "//input[contains(@value, 'Office')]")
	WebElement txtBxPhoneOffice;

	@FindBy(xpath = "//input[contains(@value, 'Cell')]")
	WebElement txtBxPhoneCell;

	@FindBy(xpath = "//input[contains(@id,'email')]")
	WebElement txtBxEmail;

	@FindBy(xpath = "//div[contains(@class,'Lang')]/label")
	public List<WebElement> chkBxLanguage;

	@FindBy(xpath = "//div[contains(@class,'header2fd')]//div[@id='savepatientButtonDiv']")
	WebElement btnSavePatient;

	@FindBy(xpath = "//div[contains(@class,'header2fd')]//div[@id='saveAndClosePatientButtonDiv']/a[1]")
	WebElement btnSaveAndClose;

	@FindBy(xpath = "//label[@id='errorLabel']")
	WebElement lblMrNumber;

	// Enter First Name on the input box.
	public boolean txtBxFirstName(String firstName) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxFirstName);

			webDriverUtil.input(txtBxFirstName, firstName);

			logger.info("First Name Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("First Name Not Entered Successfully.");

		}

		return status;

	}

	// Enter Last Name on the input box.
	public boolean txtBxLastName(String lastName) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxLastName);

			webDriverUtil.input(txtBxLastName, lastName);

			logger.info("Last Name Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Last Name Not Entered Successfully.");

		}

		return status;

	}

	// Select The Gender Of The Patient
	public boolean ddSelectGender(String gender) {

		try {

			javaScriptUtil.javaScriptHighlightElement(ddSelectGender);

			webDriverUtil.selectValueFromDropDownByVisibleText(ddSelectGender, gender);

			logger.info("Patient's Gender Is Selected.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Patient's Gender Is Not Selected.");

		}

		return status;

	}

	// Enter Date Of Birth on the input box DOB
	public boolean txtBxDateOfBirth(String dob) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxDateOfBirth);

			webDriverUtil.input(txtBxDateOfBirth, dob);

			logger.info("Date Of Birth Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Date Of Birth Is Not Entered Successfully.");

		}

		return status;

	}

	// To click on the CheckBox Ethnicity
	public boolean chkBxEthnicity(String ethniCity) {

		try {

			for (WebElement ethnicityValues : chkBxEthnicity) {

				String ethnicity = ethnicityValues.getText();

				if (ethnicity.equalsIgnoreCase(ethniCity)) {
					javaScriptUtil.javaScriptHighlightElement(ethnicityValues);

					webDriverUtil.click(ethnicityValues);
				}
			}

			logger.info("The Ethnicity Of The Patient Is Selected.");

			status = true;
		}

		catch (Exception e) {
			logger.error("The Ethnicity Of The Patient Is Not Selected.");

		}

		return status;

	}

	// To click on the CheckBox Race
	public boolean chkBxRace(String race) {

		try {

			for (WebElement raceValues : chkBxRace) {

				String raceText = raceValues.getText();

				if (raceText.equalsIgnoreCase(race)) {

					javaScriptUtil.javaScriptHighlightElement(raceValues);

					webDriverUtil.click(raceValues);
				}
			}

			logger.info("The Race Of The Patient Is Selected.");

			status = true;
		}

		catch (Exception e) {
			logger.error("The Race Of The Patient Is Not Selected.");

		}

		return status;

	}

	// Enter Address1 on the input box Address1
	public boolean txtBxAddress1(String address1) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxAddress1);

			webDriverUtil.input(txtBxAddress1, address1);

			logger.info("Address1 Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Address1 Is Not Entered Successfully.");

		}

		return status;

	}

	// Enter Zip on the input box ZIP
	public boolean txtBxZip(String zip) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxZip);

			webDriverUtil.input(txtBxZip, zip);

			logger.info("Zip Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Zip Is Not Entered Successfully.");

		}

		return status;

	}

	// Enter City on the input box City
	public boolean txtBxCity(String city) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxCity);

			webDriverUtil.input(txtBxCity, city);

			logger.info("City Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("City Is Not Entered Successfully.");

		}

		return status;

	}

	// Select The Communication Mode
	public boolean ddSelectCommunicationMode(String communicationMode) {

		try {

			javaScriptUtil.javaScriptHighlightElement(ddSelectCommunicationMode);

			webDriverUtil.selectValueFromDropDownByVisibleText(ddSelectCommunicationMode, communicationMode);

			logger.info("Communication Mode Is Selected.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Communication Mode Is Not Selected.");

		}

		return status;

	}

	// Enter Email Id on the input box Email
	public boolean txtBxEmail(String emailId) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxEmail);

			webDriverUtil.input(txtBxEmail, emailId);

			logger.info("Email Id Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Email Id Is Not Entered Successfully.");

		}

		return status;

	}

	// Enter Phone : Home on the input box
	public boolean txtBxPhoneHome(String phoneHome) {

		try {

			waitUtil.holdOn(2);

			javaScriptUtil.javaScriptHighlightElement(txtBxPhoneHome);

			webDriverUtil.input(txtBxPhoneHome, phoneHome);

			logger.info("Phone : Home Is Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Phone : Home Is Not Entered Successfully.");

		}

		return status;

	}

	// Enter Phone : Office on the input box
	public boolean txtBxPhoneOffice(String phoneOffice) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxPhoneOffice);

			webDriverUtil.input(txtBxPhoneOffice, phoneOffice);

			logger.info("Phone : Office Is Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Phone : Office Is Not Entered Successfully.");

		}

		return status;

	}

	// Enter Phone : Office on the input box State
	public boolean txtBxPhoneCell(String phoneCell) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxPhoneCell);

			webDriverUtil.input(txtBxPhoneCell, phoneCell);

			logger.info("Phone : Cell Is Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Phone : Cell Is Not Entered Successfully.");

		}

		return status;

	}

	// To click on the CheckBox Language
	public boolean chkBxLanguage(String language) {

		try {

			for (WebElement langValue : chkBxLanguage) {

				String lang = langValue.getText();

				if (lang.equalsIgnoreCase(language)) {

					javaScriptUtil.javaScriptHighlightElement(langValue);

					webDriverUtil.click(langValue);
				}
			}

			logger.info("Language Is Selected.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Language Is Not Selected.");

		}

		return status;

	}

	// To click on the Save Patient button
	public boolean btnSavePatient() {

		try {

			javaScriptUtil.javaScriptHighlightElementsBorder(btnSavePatient);

			webDriverUtil.click(btnSavePatient);

			logger.info("The button Save Patient Clicked Successfully.");

			status = true;

			waitUtil.holdOn(2);
		}

		catch (Exception e) {
			logger.error("The Button Save Patient Do Not Clicked.");

		}

		return status;

	}

	// To click on the Save And Close button
	public boolean btnSaveAndClose() {

		try {

			javaScriptUtil.javaScriptHighlightElementsBorder(btnSaveAndClose);

			webDriverUtil.click(btnSaveAndClose);

			logger.info("The button Save And Close Patient Clicked Successfully.");

			status = true;

			waitUtil.holdOn(2);

		}

		catch (Exception e) {
			logger.error("The Button Save And Close Patient Do Not Clicked.");

		}

		return status;

	}

	// To get the MR Number
	public boolean lblMrNumber() {

		try {

			javaScriptUtil.javaScriptScrollUpAndDown(-300);

			javaScriptUtil.javaScriptHighlightElement(lblMrNumber);

			String mrNumber = javaUtil.getSubString(webDriverUtil.getText(lblMrNumber), 32);

			excelUtil.setData("CreatePatient", 1, 14, mrNumber);

			excelUtil.setData("EditPatient", 1, 1, mrNumber);

			excelUtil.setData("CheckIn", 1, 1, mrNumber);

			logger.info("The Patient Added Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("The Patient Not Added Successfully.");

		}

		return status;

	}

	// To Check Updated Successfully Message
	public boolean lblUpdatedSuccessfully() {

		try {

			javaScriptUtil.javaScriptScrollUpAndDown(-300);

			javaScriptUtil.javaScriptHighlightElement(lblMrNumber);

			String message = webDriverUtil.getText(lblMrNumber);

			if (message.contains("updated successfully")) {

				logger.info("Patient details updated successfully !");

				status = true;
			}
		}

		catch (Exception e) {
			logger.error("Patient details not updated successfully !");

		}

		return status;

	}

}
