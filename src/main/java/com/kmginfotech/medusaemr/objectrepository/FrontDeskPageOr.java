package com.kmginfotech.medusaemr.objectrepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kmginfotech.medusaemr.driverclass.BaseClass;

public class FrontDeskPageOr extends BaseClass {

	WebDriver driver;
	boolean status = false;

	private Logger logger = Logger.getLogger(FrontDeskPageOr.class);

	// Constructor created for class "FrontDeskPageOr"

	public FrontDeskPageOr(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[contains(@title,'Patients')]")
	WebElement linkPatients;

	@FindBy(xpath = "//a[@title='Add Patient']")
	WebElement btnAddPatient;

	// To check that the link PATIENTS in the FRONT DESK
	public boolean linkPatients() {

		try {

			javaScriptUtil.javaScriptHighlightElement(linkPatients);

			webDriverUtil.click(linkPatients);

			logger.info("Link Patients Clicked Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Link Patients Do Not Clicked.");

		}

		return status;

	}

	// To click on the Add Patient button
	public boolean btnAddPatient() {

		try {

			javaScriptUtil.javaScriptHighlightElementsBorder(btnAddPatient);

			webDriverUtil.click(btnAddPatient);

			logger.info("The button Add Patient Clicked Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("The Button Add Patient Do Not Clicked.");

		}

		return status;

	}

}
