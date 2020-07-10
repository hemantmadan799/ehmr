package com.kmginfotech.medusaemr.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseAndKeyboardUtility {

	WebDriver driver;
	private Actions actions;

	private Logger logger = Logger.getLogger(MouseAndKeyboardUtility.class);

	/**
	 * Constructor to initialize WebDriver and object of the Actions Class.
	 * 
	 * @param driver Accept an argument of type WebDriver.
	 * 
	 */
	public MouseAndKeyboardUtility(WebDriver driver) {

		this.driver = driver;

		actions = new Actions(driver);
	}

	/**
	 * This method is used to perform Mouse Hover action on the passed WebElement.
	 * 
	 * @param element Accept a WebElement into which the Mouse Hover action
	 *                performed.
	 * @return Does not return any value.
	 * 
	 */

	public void mouseHover(WebElement element) {

		try {

			actions.moveToElement(element).build().perform();

			logger.info("Mouseover performed on " + element + "Successfully");

		} catch (StaleElementReferenceException e) {

			logger.info(e);

			actions.moveToElement(element).build().perform();
		}

	}

	/**
	 * This method is used to perform CLICK action on the passed WebElement.
	 * 
	 * @param element Accept a WebElement into which the CLICK action performed.
	 * @return Does not return any value.
	 * 
	 */
	public void actionsClick(WebElement element) {

		try {
			actions.moveToElement(element);

			actions.click().build().perform();

			logger.info("Mouse Click performed on " + element + " Successfully");

		} catch (StaleElementReferenceException e) {

			logger.info(e);

			actions.moveToElement(element);

			actions.click().build().perform();
		}

	}

	/**
	 * This method is used to perform SendKeys action on the passed WebElement.
	 * 
	 * @param element Accept a WebElement into which the SendKeys action performed.
	 * @param data    Accept the data which to be set into the passed WebElement.
	 * @return Does not return any value.
	 * 
	 */
	public void actionsSendKeys(WebElement element, String data) {

		try {

			actions.moveToElement(element);

			actions.sendKeys(data).build().perform();

			logger.info("Data is send to the " + element + "Successfully");
		}

		catch (StaleElementReferenceException e) {

			logger.info(e);

			actions.moveToElement(element);

			actions.sendKeys(data).build().perform();
		}

	}

	/**
	 * 
	 * 
	 * @param element
	 * @param xAxis
	 * @param yAxis
	 * @return Does not return any value.
	 * 
	 */

	public void moveByOffSet(WebElement element, int xAxis, int yAxis) {

		actions.moveToElement(element, xAxis, yAxis).build().perform();

	}

	/**
	 * This method is used to perform Drag And Drop action from the source to the
	 * destination WebElement.
	 * 
	 * @param from An Element which is to be dragged.
	 * @param to   An Element where to element is to be dropped.
	 * @return Does not return any value.
	 * 
	 */

	public void dragAndDrop(WebElement from, WebElement to) {

		try {

			actions.dragAndDrop(from, to).build().perform();

			logger.info(from + " Dragged and drop on " + to + " Successfully");

		} catch (StaleElementReferenceException e) {

			logger.info(e);

			actions.dragAndDrop(from, to).build().perform();

		}

	}

	/**
	 * This method is used to perform Right Click action on the passed WebElement.
	 * 
	 * @param element An element on which the Right Click action is to be performed.
	 * @return Does not return any value.
	 * 
	 */

	public void contextClick(WebElement element) {

		try {

			actions.moveToElement(element);

			actions.contextClick().build().perform();

			logger.info("Context Click performed on " + element + "Successfully");

		} catch (StaleElementReferenceException e) {

			logger.info(e);

			actions.moveToElement(element);

			actions.contextClick().build().perform();

		}
	}

	/**
	 * This method is used to press Enter.
	 * 
	 * @return Does not return any value.
	 * 
	 */

	public void pressEnter() {

		actions.sendKeys(Keys.RETURN);
		actions.perform();
	}

}
