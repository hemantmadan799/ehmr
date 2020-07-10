package com.kmginfotech.medusaemr.objectrepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kmginfotech.medusaemr.driverclass.BaseClass;

public class IndexPageOr extends BaseClass {

	WebDriver driver;
	boolean status = false;

	private Logger logger = Logger.getLogger(IndexPageOr.class);

	// Constructor created for class "IndexPageOr"
	public IndexPageOr(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[contains(@id,'usr_name')]")
	WebElement txtBxUserName;

	@FindBy(xpath = "//input[contains(@id,'usr_password')]")
	WebElement txtBxPassword;

	@FindBy(xpath = "//img[contains(@alt,'Cancel')]")
	WebElement btnCancel;

	@FindBy(xpath = "//img[contains(@alt,'Submit')]")
	WebElement btnSubmit;

	// Enter UserName on the input box usr_name
	public boolean txtBxUserName(String userName) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxUserName);

			webDriverUtil.input(txtBxUserName, userName);

			logger.info("Username Entered Successfully");

			status = true;
		}

		catch (Exception e) {
			logger.error("Username Not Entered Successfully");

		}

		return status;

	}

	// Enter Password in the Password Box
	public boolean txtBxPassword(String password) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxPassword);

			webDriverUtil.input(txtBxPassword, password);

			logger.info("Password Entered Successfully");

			status = true;
		}

		catch (Exception e) {
			logger.error("Password Not Entered Successfully");

		}

		return status;
	}

	// Click on the Cancel button
	public boolean btnCancel() {

		try {

			javaScriptUtil.javaScriptHighlightElement(btnCancel);

			webDriverUtil.click(btnCancel);

			logger.info("Cancel button clicked successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Cancel button does not click successfully.");

		}

		return status;
	}

	// Click on the Submit button
	public boolean btnSubmit() {

		try {

			javaScriptUtil.javaScriptHighlightElement(btnSubmit);

			webDriverUtil.click(btnSubmit);

			logger.info("Submit button clicked successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Submit button does not click successfully.");

		}

		return status;
	}

}
