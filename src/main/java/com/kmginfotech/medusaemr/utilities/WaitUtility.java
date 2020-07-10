package com.kmginfotech.medusaemr.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	WebDriver driver;
	WebDriverWait wait;
	private Logger logger = Logger.getLogger(WaitUtility.class);

	/**
	 * Constructor to initialize WebDriver and object of the WebDriverWait Class.
	 * 
	 * @param driver Accept an argument of type WebDriver.
	 * 
	 */
	public WaitUtility(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver, 30);
	}

	/**
	 * Wait for the amount of time defined in the "WebDriverWait" class or the
	 * "ExpectedCondition:elementToBeClickable" to occur whichever occurs first.
	 * 
	 * @param element A WebElement for which the wait condition is to be applied.
	 * @return Does not return any value.
	 * 
	 */

	public void expWaitUntilElementToBeClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * Wait for the amount of time defined in the "WebDriverWait" class or the
	 * "ExpectedCondition:elementToBeSelected" to occur whichever occurs first.
	 * 
	 * @param element A WebElement for which the wait condition is to be applied.
	 * @return Does not return any value.
	 * 
	 */

	public void expWaitUntilElementToBeSelected(WebElement element) {

		wait.until(ExpectedConditions.elementToBeSelected(element));

	}

	/**
	 * Wait for the amount of time defined in the "WebDriverWait" class or the
	 * "ExpectedCondition:textToBePresentInElement" to occur whichever occurs first.
	 * 
	 * @param element A WebElement for which the wait condition is to be applied.
	 * @return Does not return any value.
	 * 
	 */

	public void expWaitUntilTextToBePresentInElement(WebElement element, String data) {

		wait.until(ExpectedConditions.textToBePresentInElement(element, data));

	}

	/**
	 * Fluent Wait : Wait for 30 seconds for an element to be present on the page,
	 * checking for its presence once every 5 seconds.
	 * 
	 * @param xpath The XPATH of the element for which the Fluent Wait is applied.
	 * @return The WebElement, if the WebElement present in the DOM.
	 * 
	 */

	public WebElement waitFluent(String xpath) {

		// Wait for 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> flWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		return (flWait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(By.xpath(xpath));

			}
		}));

	}

	/**
	 * This method is used to wait for the browser to load the page completely.
	 * 
	 */
	public void waitForBrowserToLoadCompletely() {
		String state = null;
		String oldstate = null;
		String waitingMsg = "Waiting for browser loading to complete";
		if (loadBrowser()) {
			return;
		}
		logger.info(waitingMsg);
		int i = 0;

		while (true) {
			state = (new JavaScriptUtility(driver).javaScriptCheckReadyStateOfThePage());
			if ("complete".equals(state))
				break;

			if (state.equals(oldstate))
				i++;
			else
				i = 0;
			if (i == 15 && "loading".equals(state)) {
				driver.navigate().refresh();
				logger.info(waitingMsg);
				i = 0;
			} else if (i == 6 && "interactive".equals(state)) {
				logger.info(waitingMsg);
				return;
			}
			oldstate = state;
		}
	}

	/**
	 * This method is used to check whether browser is loaded or not.
	 * 
	 * @return Returns the boolean value.
	 */
	protected boolean loadBrowser() {
		String state = null;
		int i = 0;
		while (i < 5) {

			state = (new JavaScriptUtility(driver).javaScriptCheckReadyStateOfThePage());
			if ("interactive".equals(state) || "loading".equals(state))
				break;
			if (i == 1 && "complete".equals(state)) {

				return true;
			}
			i++;
		}
		return false;
	}

	/**
	 * This function will pause the current thread by specified time in seconds.
	 * 
	 * @param timeOutInSeconds time in seconds.
	 */
	public void holdOn(int timeOutInSeconds) {
		try {
			long time = (long) 1000 * timeOutInSeconds;
			Thread.sleep(time);
		} catch (Exception e) {
			logger.debug("InterruptedException occured", e);
		}
	}

}
