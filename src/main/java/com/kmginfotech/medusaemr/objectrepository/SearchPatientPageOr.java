package com.kmginfotech.medusaemr.objectrepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kmginfotech.medusaemr.driverclass.BaseClass;

public class SearchPatientPageOr extends BaseClass {

	WebDriver driver;
	boolean status = false;

	private Logger logger = Logger.getLogger(SearchPatientPageOr.class);

	// Constructor created for class "SearchPatientPageOr"

	public SearchPatientPageOr(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[contains(@id,'id')]")
	WebElement txtBxMrNumber;

	@FindBy(xpath = "//div[contains(@class,'secTitleFD')]/following-sibling :: div/a[contains(text(),'Ok')]")
	WebElement btnOk;

	@FindBy(xpath = "//img[contains(@title,'Edit')]")
	WebElement btnEdit;

	// Enter MR Number on the input box MNR
	public boolean txtBxMrNumber(String mrNumber) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxMrNumber);

			webDriverUtil.input(txtBxMrNumber, mrNumber);

			logger.info("MR Number Entered Successfully");

			status = true;
		}

		catch (Exception e) {
			logger.error("MR Number Not Entered Successfully");

		}

		return status;

	}

	// Click on the OK button to Search the Patient
	public boolean btnOk() {

		try {

			javaScriptUtil.javaScriptHighlightElementsBorder(btnOk);

			webDriverUtil.click(btnOk);

			logger.info("OK button clicked successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("OK button does not click successfully.");

		}

		return status;
	}

	// Click on the Edit button to Edit The Detail Of The Patient
	public boolean btnEdit() {

		try {

			javaScriptUtil.javaScriptHighlightElementsBorder(btnEdit);

			webDriverUtil.click(btnEdit);

			logger.info("Edit button(Image) clicked successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Edit button(Image) does not click successfully.");

		}

		return status;
	}

}
