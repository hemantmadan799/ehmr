package com.kmginfotech.medusaemr.objectrepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kmginfotech.medusaemr.driverclass.BaseClass;

public class EhrPageOr extends BaseClass {

	WebDriver driver;
	boolean status = false;

	private Logger logger = Logger.getLogger(EhrPageOr.class);

	// Constructor created for class "EhrPageOr"

	public EhrPageOr(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@id='fancybox-close']")
	WebElement imgCloseAlertOpenChart;

	@FindBy(xpath = "//img[@title='Home']")
	WebElement btnHome;

	@FindBy(xpath = "//li[contains(@title,'Front')]/a")
	WebElement tileFrontDesk;

	@FindBy(xpath = "//li[contains(@title,'Office Administrator')]/a")
	WebElement tileOfficeAdministrator;

	// * This function will perform click operation on the CLOSE ( X ) image on the
	// alert box.

	public boolean imgCloseAlertOpenChart() {

		try {

			webDriverUtil.click(imgCloseAlertOpenChart);

			logger.info("Alert Box Is Closed Successfully.");

			status = true;

		}

		catch (NoAlertPresentException alertException) {
			logger.error("Could Not Find The Alert Box.");
		}

		return status;

	}

	// * This method will click on the Home Button
	public boolean btnHome() {

		try {

			javaScriptUtil.javaScriptHighlightElementsBorder(btnHome);

			webDriverUtil.click(btnHome);

			logger.info("Home Button Is Clicked Successfully !");

			status = true;
		}

		catch (Exception e) {
			logger.error("Home Button Is Not Clickable.");

		}

		return status;

	}

	// * This method will click on the tile Front Desk.
	public boolean tileFrontDesk() {

		try {

			javaScriptUtil.javaScriptHighlightElementsBorder(tileFrontDesk);

			webDriverUtil.click(tileFrontDesk);

			logger.info("Tile Front Desk Selected Successfully.");

			status = true;
		}

		catch (Exception e) {
			logger.error("Could Not Find The Tile : " + tileFrontDesk);

		}

		return status;

	}

}
