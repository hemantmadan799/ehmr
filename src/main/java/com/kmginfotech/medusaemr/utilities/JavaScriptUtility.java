package com.kmginfotech.medusaemr.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {

	WebDriver driver;
	JavascriptExecutor javaScript;

	private Logger logger = Logger.getLogger(JavaScriptUtility.class);

	/**
	 * Constructor to initialize WebDriver and the object of JavascriptExecutor.
	 * 
	 * @param driver Accept an argument of type WebDriver.
	 * 
	 */
	public JavaScriptUtility(WebDriver driver) {

		this.driver = driver;

		javaScript = (JavascriptExecutor) driver;
	}

	/**
	 * This method is used to perform CLICK event on the passed WebElement.
	 * 
	 * @param element An element into which the Click event is to be performed.
	 * @return Does not return any value.
	 * 
	 */
	public void javaScriptClick(WebElement element) {

		javaScript.executeScript("arguments[0].click();", element);

	}

	/**
	 * This method is used to send the data into the passed WebElement.
	 * 
	 * @param element An element into which the data is to be send.
	 * @param data    The data which is to be send into the passed WebElement.
	 * @return Does not return any value.
	 * 
	 */
	public void javaScriptSendKeys(WebElement element, String data) {

		javaScript.executeScript("arguments[0].value='" + data + "';", element);

	}

	/**
	 * This method is used to ScrollUp and ScrollDown event on the WebPage.
	 * 
	 * @param range How many pixels to scroll by, along the y-axis (vertical).
	 *              Positive values will scroll down, while negative values scroll
	 *              up.
	 * @return Does not return any value.
	 * 
	 */
	public void javaScriptScrollUpAndDown(int range) {

		javaScript.executeScript("window.scrollBy(0," + range + ")", "");
	}

	/**
	 * This method is used to ScrollRight and ScrollLeft event on the WebPage.
	 * 
	 * @param range How many pixels to scroll by, along the x-axis (horizontal).
	 *              Positive values will scroll right, while negative values scroll
	 *              left.
	 * @return Does not return any value.
	 * 
	 */
	public void javaScriptScrollRightAndLeft(int range) {

		javaScript.executeScript("window.scrollBy(" + range + ",0)");

		new WaitUtility(driver).holdOn(4);

	}

	/**
	 * This method is used to scroll until the WebElement is in the view.
	 * 
	 * @param element
	 * @throws InterruptedException
	 * @return Does not return any value.
	 * 
	 */
	public void javaScriptScrollIntoView(WebElement element) {

		javaScript.executeScript("arguments[0].scrollIntoView(true);", element);

		new WaitUtility(driver).holdOn(2);
	}

	/**
	 * This method is used to Highlight the passed element.
	 * 
	 * @param element
	 * @throws InterruptedException
	 * @return Does not return any value.
	 * 
	 */
	public void javaScriptHighlightElement(WebElement element) {

		try {
			javaScript.executeScript(
					"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

			new WaitUtility(driver).holdOn(2);

			// javaScript.executeScript("arguments[0].setAttribute('style','border: solid
			// 2px white');", element);

			logger.info("WebElement " + element + " is Highlighted Successfully.");

		}

		catch (Exception e) {

			logger.error("WebElement " + element + " is not Highlighted.");

		}
	}

	/**
	 * This method is used to get the Ready State of the Web Page.
	 * 
	 * @param No parameter passed.
	 * @return The current state of the WebPage.
	 * 
	 */

	public String javaScriptCheckReadyStateOfThePage() {
		return String.valueOf(javaScript.executeScript("return document.readyState"));
	}

	/**
	 * This method Highlight the Border Of The WebElement
	 * 
	 */
	public void javaScriptHighlightElementsBorder(WebElement element) {

		try {
			javaScript.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", element);

			new WaitUtility(driver).holdOn(2);

			logger.info("WebElement " + element + " is Highlighted Successfully.");

			
			
		}

		catch (Exception e) {

			logger.error("WebElement " + element + " is not Highlighted.");

		}
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int getWidthOfThePage() {
		return ((Number) javaScript.executeScript("return window.innerWidth")).intValue();
	}

	/**
	 * 
	 * 
	 */
	public void zoomIn() {
		javaScript.executeScript("document.body.style.zoom = '0.8'");
	}

}