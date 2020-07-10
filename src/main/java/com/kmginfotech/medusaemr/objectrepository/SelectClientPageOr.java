package com.kmginfotech.medusaemr.objectrepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kmginfotech.medusaemr.driverclass.BaseClass;

public class SelectClientPageOr extends BaseClass {

	WebDriver driver;
	boolean status = false;

	private Logger logger = Logger.getLogger(SelectClientPageOr.class);

	// Constructor created for class "SelectClientPageOr"
	public SelectClientPageOr(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//td[contains(text(),'Select Client#')]")
	WebElement lblSelectClient;

	@FindBy(xpath = "//input[@name='selectClientID']")
	WebElement txBxSelectClient;

	// This method enter the Client Id in the input box.
	public boolean txBxSelectClient(String clientId) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txBxSelectClient);

			webDriverUtil.input(txBxSelectClient, clientId);

			logger.info("Client ID " + clientId + " is entered Successfully");

			status = true;
		}

		catch (Exception e) {
			logger.error("Client ID Not Entered Successfully");

		}

		return status;

	}

	// This method will check the label "Select Client" is present or not

	public boolean lblSelectClientIsPresent() {

		try {
			webDriverUtil.isVisible(lblSelectClient);

			logger.info("The Input Box " + lblSelectClient + " is visible.");

			status = true;
		}

		catch (ElementNotVisibleException | NoSuchElementException e) {

			logger.info("The Input Box " + lblSelectClient + " is not visible.");
		}

		return status;
	}

}
