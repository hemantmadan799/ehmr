package com.kmginfotech.medusaemr.objectrepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kmginfotech.medusaemr.driverclass.BaseClass;

public class PreferencePageOr extends BaseClass {

	WebDriver driver;
	boolean status = false;

	private Logger logger = Logger.getLogger(PreferencePageOr.class);

	// Constructor created for class "PreferencePageOr"
	public PreferencePageOr(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@title='EMR']")
	WebElement linkElectronicHealthRecord;

	@FindBy(xpath = "//input[@value='EMR']")
	WebElement lblElectronicHealthRecord;

	// Click on the link EMR (Image EHR)
	public boolean linkElectronicHealthRecord() {

		try {

			javaScriptUtil.javaScriptHighlightElementsBorder(linkElectronicHealthRecord);

			webDriverUtil.click(linkElectronicHealthRecord);

			logger.info("Link Image Electronic Health Record clicked successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Link Image Electronic Health Record is not clicked.");

		}

		return status;
	}

	// This function checked that the Electronic Health Record label is present in
	// the screen or not
	public boolean lblSelectClientIsPresent() {

		try {
			webDriverUtil.isVisible(lblElectronicHealthRecord);

			logger.info("The Input Box " + lblElectronicHealthRecord + " is visible.");

			status = true;
		}

		catch (ElementNotVisibleException | NoSuchElementException e) {

			logger.info("The Input Box " + lblElectronicHealthRecord + " is not visible.");
		}

		return status;

	}
}
