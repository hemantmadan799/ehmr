package com.kmginfotech.medusaemr.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadPropertyFile {

	private Logger logger = Logger.getLogger(ReadPropertyFile.class);

	/**
	 * This method is used read property file
	 * 
	 * @param key KEY whose value you have to fetch.
	 * @return Return the value of the KEY; if the passed KEY is present in the
	 *         property file else return NULL.
	 * @throws IOException
	 * 
	 */
	public String getconfig(String key) {

		Properties prop = new Properties();

		try {

			FileInputStream fis = new FileInputStream("./src/test/resources/TestData/configuration.properties");

			prop.load(fis);

			logger.info("The Value Of The Passed Key : " + key + "Fetched Successfully !");

			return prop.getProperty(key);
		}

		catch (IOException e) {

			logger.info("The Configuration Properties File Not Found ! ");

		}
		return null;

	}

}
