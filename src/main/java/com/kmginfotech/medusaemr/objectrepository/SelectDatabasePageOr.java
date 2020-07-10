package com.kmginfotech.medusaemr.objectrepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kmginfotech.medusaemr.driverclass.BaseClass;

public class SelectDatabasePageOr extends BaseClass {

	WebDriver driver;
	boolean status = false;

	private Logger logger = Logger.getLogger(SelectDatabasePageOr.class);

	// Constructor created for class "SelectDatabasePageOr"
	public SelectDatabasePageOr(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[contains(@name,'Database')]")
	WebElement txtBxSelectDataBase;

	@FindBy(xpath = "//td[contains(text(),'Select Data')]")
	WebElement lblSelectDatabase;

	// Enter Database Name in the Input Box
	public boolean txtBxSelectDataBase(String databaseName) {

		try {

			javaScriptUtil.javaScriptHighlightElement(txtBxSelectDataBase);

			webDriverUtil.input(txtBxSelectDataBase, databaseName);

			logger.info("Database Name " + databaseName + " is entered Successfully");

			status = true;
		}

		catch (Exception e) {
			logger.error("Database Name Not Entered Successfully");

		}

		return status;

	}

	// This method will check that the Label "Select DataBase" is present or not.

	public boolean lblSelectDatabaseIsPresent() {

		try {
			webDriverUtil.isVisible(lblSelectDatabase);

			logger.info("The Input Box " + lblSelectDatabase + " is visible.");

			status = true;
		}

		catch (ElementNotVisibleException | NoSuchElementException e) {
			logger.info("The Input Box " + lblSelectDatabase + " is not visible.");
		}

		return status;
	}

}
