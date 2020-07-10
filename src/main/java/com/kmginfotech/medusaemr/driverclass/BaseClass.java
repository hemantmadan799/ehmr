package com.kmginfotech.medusaemr.driverclass;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.kmginfotech.medusaemr.utilities.ReadPropertyFile;

public class BaseClass extends Initialization {

	protected static WebDriver driver;

	static Initialization initAll;

	protected static ReadPropertyFile propertyFile = new ReadPropertyFile();
	private Logger logger = Logger.getLogger(BaseClass.class);

	@BeforeClass
	@Parameters("browserName")
	public void browserLaunch(String browserName) {

		PropertyConfigurator.configure("./src/test/resources/DriversAndConfig/log4j.properties");

		try {
			if (browserName.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver", "./src/test/resources/DriversAndConfig/geckodriver.exe");

				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "./src/test/resources/DriversAndConfig/chromedriver.exe");

				driver = new ChromeDriver();

			}

		} catch (Exception e) {

			logger.error(e);

		}

		finally {

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();

			try {
				driver.navigate().to(propertyFile.getconfig("URL"));

				logger.info(propertyFile.getconfig("URL") + " opened successfully");

			} catch (WebDriverException e) {
				logger.debug("Error occured while opening url- " + propertyFile.getconfig("URL"), e);

			} catch (NullPointerException e) {

				logger.debug("Error occured while opening url. webdriver object has null value - ", e);
			}

		}

		initAll = new Initialization();
		initAll.InitializationOfTheUtilities(driver);
		initAll.InitializationOfTheObjectRepository(driver);
		initAll.InitializationOfTheWebPages(driver);

		waitUtil.waitForBrowserToLoadCompletely();
		webDriverUtil.switchToTheFrameById("pmsiframe");

	}

//	@AfterClass
//	public void stopDriver() {
//
//		waitUtil.holdOn(2);
//		try {
//			if (driver != null) {
//				driver.quit();
//				driver = null;
//				logger.info("Browser has been closed successfully");
//			}
//		} catch (Exception ignore) {
//			logger.info("Browser has not been closed properly", ignore);
//		}
//	}

}
