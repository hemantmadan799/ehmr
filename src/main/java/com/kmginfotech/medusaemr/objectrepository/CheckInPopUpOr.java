package com.kmginfotech.medusaemr.objectrepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kmginfotech.medusaemr.driverclass.BaseClass;

public class CheckInPopUpOr extends BaseClass {

	WebDriver driver;
	boolean status = false;

	private Logger logger = Logger.getLogger(CheckInPopUpOr.class);

	// Constructor created for class "CheckInPopUpOr"

	public CheckInPopUpOr(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(), 'Check-In')]")
	WebElement btnCheckIn;

	@FindBy(xpath = "//select[contains(@id,'appointment')]")
	WebElement ddAppointmentWith;

	@FindBy(xpath = "//select[contains(@name,'visitType')]")
	WebElement ddVisitType;

	@FindBy(xpath = "//td[contains(text(),'Reason')]//following-sibling::td/input")
	WebElement txtBxReason;

	@FindBy(xpath = "//form[@name='newPatientForm']/following-sibling::div/a[text()='Ok']")
	WebElement btnOk;

	// To click on the Button Check In
	public boolean btnCheckIn() {

		try {

			javaScriptUtil.javaScriptScrollUpAndDown(300);

			waitUtil.holdOn(2);

			javaScriptUtil.javaScriptHighlightElementsBorder(btnCheckIn);

			webDriverUtil.click(btnCheckIn);

			logger.info("The Button Check-In Clicked Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("The Button Check-In Do Not Clicked.");

		}

		return status;

	}

	// Select The Appointment With
	public boolean ddAppointmentWith(String appointmentWith) {

		try {

			waitUtil.holdOn(2);

			javaScriptUtil.javaScriptHighlightElement(ddAppointmentWith);

			webDriverUtil.selectValueFromDropDownByValue(ddAppointmentWith, appointmentWith);

			logger.info("Provider Selected Successfully !");

			status = true;
		}

		catch (Exception e) {
			logger.error("Provider Is Not Selected Successfully !");

		}

		return status;

	}

	// Select The Visit Type Of The Patient
	public boolean ddVisitType(String visitType) {

		try {

			javaScriptUtil.javaScriptHighlightElement(ddVisitType);

			webDriverUtil.selectValueFromDropDownByVisibleText(ddVisitType, visitType);

			logger.info("Visit Type Is Selected Successfully !");

			status = true;
		}

		catch (Exception e) {
			logger.error("Visit Type Is Not Selected Successfully !");

		}

		return status;

	}

	// Enter Reason Of The Visit Of The Patient
	public boolean txtBxReason(String reason) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxReason);

			webDriverUtil.input(txtBxReason, reason);

			logger.info("Reason Of Visit Is Entered Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Reason Of Visit Not Entered Successfully.");

		}

		return status;

	}

	// To click on the Button OK on The Assignment Pop-Up
	public boolean btnOk() {

		try {

			javaScriptUtil.javaScriptHighlightElementsBorder(btnOk);

			webDriverUtil.click(btnOk);

			logger.info("The Button OK Is Clicked Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("The Button OK Is Not Do Not Clicked.");

		}

		return status;

	}

}
