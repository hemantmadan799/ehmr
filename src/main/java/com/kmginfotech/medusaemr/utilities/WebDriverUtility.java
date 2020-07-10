package com.kmginfotech.medusaemr.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import com.kmginfotech.medusaemr.driverclass.BaseClass;

public class WebDriverUtility extends BaseClass {

	WebDriver driver;
	String parentHandle;

	private Logger logger = Logger.getLogger(WebDriverUtility.class);

	/**
	 * Constructor to initialize WebDriver.
	 * 
	 * @param driver Accept an argument of type WebDriver.
	 * 
	 */
	public WebDriverUtility(WebDriver driver) {

		this.driver = driver;

	}

	/**
	 * This method is used to perform CLICK event on the passed element.
	 * 
	 * @param element A WebElement on which the CLICK event is to be performed.
	 * @return Does not return any value.
	 * 
	 */

	public void click(WebElement element) {

		waitUtil.holdOn(1);

		try {

			element.click();

		} catch (ElementNotVisibleException e) {

			logger.info("ElementNotVisibleException occured  for " + element + " , "
					+ "trying Actions method to perform click ", e);

			try {

				mouseAndKeyboardUtil.actionsClick(element);

			} catch (ElementNotVisibleException ae) {

				logger.info("ElementNotVisibleException occured  for  " + element
						+ " ,  trying JavaScript to perform click ", ae);

				try {

					javaScriptUtil.javaScriptClick(element);

				} catch (NoSuchElementException je) {

					logger.error(je);

					logger.info("The " + element + "Not present In the Page");
				}

			}

		}
	}

	/**
	 * This method is used to input the data into the WebElement.
	 * 
	 * @param element A WebElement on which the DATA is to be set.
	 * @param data    The DATA which is to be set into the WebElement
	 * @return Does not return any value.
	 * 
	 */

	public void input(WebElement element, String data) {

		try {

			element.clear();

			element.sendKeys(data);

			logger.info(data + " is entered in " + element + " text box");

		} catch (ElementNotVisibleException e) {

			logger.info("ElementNotVisibleException occured  for " + element + " , "
					+ "trying Actions method to input the data ", e);

			try {

				mouseAndKeyboardUtil.actionsSendKeys(element, data);

			} catch (ElementNotVisibleException ae) {

				logger.info("ElementNotVisibleException occured  for  " + element
						+ " ,  trying JavaScript  to input the data ", ae);

				try {

					javaScriptUtil.javaScriptSendKeys(element, data);

				} catch (NoSuchElementException je) {

					logger.error(je);

					logger.info("The " + element + "Not present In the Page");
				}

			}

		}
	}

	/**
	 * This method is used to get all the values from the Drop Down, which is
	 * created using HTML tag <SELECT>
	 * 
	 * @param element The Drop Down WebElement whose values are to be extracted.
	 * @return The method return a LIST of type STRING containing all the values
	 *         from the Drop Down.
	 * 
	 */

	public List<String> getAllSelectDropDownVaues(WebElement element) {

		logger.info("Getting Values From Drop Down.");

		List<String> ddValues = new ArrayList<>();

		Select select = new Select(element);

		List<WebElement> ddElements = select.getOptions();

		for (int i = 0; i < ddElements.size(); i++) {

			ddValues.add(ddElements.get(i).getText());
		}

		logger.info("Returning the values of the Drop Down in the form of List !");

		return ddValues;
	}

	/**
	 * This method will return status of the WebElement in boolean format.
	 * 
	 * @param element An Element whose status needs to be checked.
	 * @return True if element is enabled, otherwise false.
	 * 
	 */
	public boolean isEnabled(WebElement element) {

		logger.info("Checking that the WebElement is enabled or not.");

		return element.isEnabled();

	}

	/**
	 * This method will return display status of WebElement in boolean format.
	 * 
	 * @param element An Element whose display status needs to be checked.
	 * @return True if element is visible, otherwise false.
	 * 
	 */
	public boolean isVisible(WebElement element) {

		logger.info("Checking that the WebElement " + element + " is displaying on the screen or not.");

		return element.isDisplayed();
	}

	/**
	 * This method is used to switch the control to the newly opened window.
	 * 
	 * @param Not required.
	 * @return It will return the Title of the newly opened window.
	 * 
	 */
	public String switchToTheWindow() {

		parentHandle = driver.getWindowHandle(); // Get the current window handle

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);
			logger.info("Switch focus of WebDriver to the next found window handle (that's your newly opened window)");
		}
		logger.info("Return the title of the focussed page.");

		return driver.getTitle();

	}

	/**
	 * This function will switch focus on window or tab that has specified title.
	 * 
	 * @param title Title of the page.
	 * 
	 */
	public void switchWindowFocusByTitle(String title) {

		try {

			Set<String> handleValues = driver.getWindowHandles();

			for (String handleValue : handleValues) {

				driver.switchTo().window(handleValue);

				if (driver.getTitle().equalsIgnoreCase(title)) {
					break;
				}
			}

			driver.manage().window().maximize();

			logger.info(
					"Switching the focus of the driver into the window, whose title is matched with the passed title.");

		} catch (Exception e) {
			logger.debug("Window Not Available : ", e);
		}
	}

	/**
	 * This method is used to switch back the control to the Parent Window.
	 * 
	 * @param Not required.
	 * @return Does not return any value.
	 * 
	 */

	public void comeBackToTheParentWindow() {

		driver.close();

		logger.info("Closing newly opened window when done with it.");

		driver.switchTo().window(parentHandle); // switch back to the original window

		logger.info(" Switching driver back to the original window");

	}

	/**
	 * This method is used to switch the control to the IFrame by FrameName.
	 * 
	 * @param frameName The Name of the IFrame to which the control to be switched.
	 * @return Does not return any value.
	 * 
	 */
	public void switchToTheFrameByName(String frameName) {

		try {

			driver.switchTo().frame(frameName);

			logger.info("The driver is focussed into the passed frame : " + frameName);

		} catch (NoSuchElementException e) {

			logger.error("The frame with frame name " + frameName + "not present In the Page.");

		}

	}

	/**
	 * This method is used to switch the control to the IFrame by FrameId.
	 * 
	 * @param frameId The ID of the IFrame to which the control to be switched.
	 * @return Does not return any value.
	 * 
	 */
	public void switchToTheFrameById(String frameId) {

		try {
			driver.switchTo().frame(frameId);

			logger.info("The driver is focussed into the frame: " + frameId);

		} catch (NoSuchElementException e) {

			logger.error("The frame with frame id " + frameId + "not present in the Page.");

		}

	}

	/**
	 * This method is used to switch back the control to the Main Frame.
	 * 
	 * @param Not required
	 * @return Does not return any value.
	 * 
	 */
	public void switchBackToTheMainFrame() {

		driver.switchTo().parentFrame();

	}

	/**
	 * This method is used to get the Coordinate of the X-axis.
	 * 
	 * @param element A WebElement whose x-axis coordinate is required to get.
	 * @return Return the coordinate of the X-axis of the WebElement. Return 0, if
	 *         the WebElement is not present in the web page.
	 * 
	 */
	public int getElementLocationXaxis(WebElement element) {

		try {

			logger.info("The element is present in the page. Returning the co-ordinates of the X-axis of the element.");

			return (element.getLocation().getX());

		} catch (NoSuchElementException e) {

			logger.error("The WebElement " + element + " not present in the page.");

		}
		return 0;
	}

	/**
	 * This method is used to get the Coordinate of the Y-axis.
	 * 
	 * @param element A WebElement whose x-axis coordinate is required to get.
	 * @return Return the coordinate of the Y-axis of the WebElement. Return 0, if
	 *         the WebElement is not present in the web page.
	 * 
	 */
	public int getElementLocationYaxis(WebElement element) {

		try {

			logger.info("The element is present in the page. Returning the co-ordinates of the Y-axis of the element.");

			return (element.getLocation().getY());

		} catch (NoSuchElementException e) {

			logger.error("The WebElement " + element + " not prsent in the page.");

		}
		return 0;

	}

	/**
	 * This function will return inner-text of the web element provided.
	 * 
	 * @param element A WebElement whose inner-text needs to be gotten.
	 * @return String inner text of specified web element. Return null, if the
	 *         WebElement is not present in the web page.
	 * 
	 */
	public String getText(WebElement element) {

		try {

			logger.info(
					"The element is present in the page. Get the visible (i.e. not hidden by CSS) text of this element,"
							+ " including sub-elements.");

			return element.getText();

		} catch (NoSuchElementException e) {

			logger.error("The WebElement " + element + " not present in the page.");

		}
		return null;
	}

	/**
	 * This function will return attribute value of provided attribute name for
	 * specified WebElement.
	 * 
	 * @param element       A WebElement whose attribute value is to be gotten.
	 * @param attributeName Attribute name for which you want to get the value.
	 * @return String attribute value of provided attribute name.
	 * 
	 */
	public String getAttributeValue(WebElement element, String attributeName) {

		try {

			logger.info("The element is present in the page.Get the value of the given attribute of the element. "
					+ "Will return the current value, even if this has been modified after the page has been loaded. ");

			return element.getAttribute(attributeName);

		} catch (NoSuchElementException e) {

			logger.error("The WebElement " + element + " not present in the page.");

		}

		return null;

	}

	/**
	 * This function will return the Title of the current page.
	 * 
	 * @return String value of title.
	 */
	public String getPageTitle() {

		return driver.getTitle();
	}

	/**
	 * This function will take and save the screenshot of the current page.
	 * 
	 * @param scenarioName The currently running scenario.
	 * @param browserName  The name of the browser in which the scenario is
	 *                     executing.
	 * @param methodName   The current test case.
	 * @return Does not return any value.
	 */
	public String takeScreenShot(String scenarioName, String browserName, String methodName) {

		String currentDataTime = new JavaUtility().getCurrentTimeStamp();

		String path = "ScreenShots/" + scenarioName + "/" + browserName + "/" + methodName + " " + currentDataTime
				+ ".png";

		try {

			TakesScreenshot tksh = (TakesScreenshot) driver;

			File srcFile = tksh.getScreenshotAs(OutputType.FILE);

			File destFile = new File("./TestReports/" + path);

			FileUtils.copyFile(srcFile, destFile);

			logger.info("The screenshot has taken successfully.");

			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='200'/> </a>");

		} catch (IOException e) {

			logger.error("Not able to take the screen shot of the current page of the application", e);

		}

		return path;
	}

	/**
	 * 
	 * 
	 * @param element
	 * @return
	 */
	public WebElement refreshWebElement(WebElement element) {

		try {
			return element;
		} catch (StaleElementReferenceException e) {

			return refreshWebElement(element);
		}
	}

	/**
	 * To click on the 'OK' button of the alert.
	 * 
	 * @param Not required.
	 * @return Does not return any value.
	 * 
	 */

	public void acceptAlert() {

		driver.switchTo().alert().accept();

	}

	/**
	 * To click on the 'Cancel' button of the alert.
	 * 
	 * @param Not required.
	 * @return Does not return any value.
	 * 
	 */

	public void refuseAlert() {

		driver.switchTo().alert().dismiss();

	}

	/**
	 * This method is used to select the value from the SELECT drop down
	 * 
	 */
	public void selectValueFromDropDownByVisibleText(WebElement element, String value) {

		Select ddSelect = new Select(element);

		ddSelect.selectByVisibleText(value);
	}

	/**
	 * This method is used to select the value from the SELECT drop down
	 * 
	 */
	public void selectValueFromDropDownByValue(WebElement element, String value) {

		Select ddSelect = new Select(element);

		ddSelect.selectByValue(value);
	}

	/**
	 * This method is used to check that the element is present on to the UI or not.
	 * 
	 * @param element The XPATH of the element ; whose presence is to be checked.
	 * @return Return the boolean value "True" if the element present; "False" if
	 *         the element not present on the UI.
	 * 
	 */

	public boolean isElementPresent(String element) {
		try {

			driver.findElement(By.xpath(element));

			return true;

		} catch (NullPointerException e) {

			return false;
		}
	}

}
