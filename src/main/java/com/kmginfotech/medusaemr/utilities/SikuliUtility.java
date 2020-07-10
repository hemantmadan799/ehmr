package com.kmginfotech.medusaemr.utilities;

import org.apache.log4j.Logger;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliUtility {

	Screen scr = new Screen();
	Pattern pattern;

	private Logger logger = Logger.getLogger(SikuliUtility.class);

	/**
	 * This method is used to check that the passed path of the image is available
	 * in the UI or not
	 * 
	 * @param imgPath The path of the Image; which is to be check.
	 * @return Return the boolean value True and False. True if value is present in
	 *         the UI; False if not present in the UI.
	 * 
	 */
	public boolean isImageAvailable(String imgPath) {
		boolean val;
		pattern = new Pattern(imgPath);

		if ((scr.exists(imgPath) != null))

			val = true;
		else
			val = false;

		logger.info("Image Is Available On The UI !");

		return val;

	}

	/**
	 * This method is used to compare two images.
	 * 
	 * @param path1 The path of the first Image.
	 * @param path2 The path of the second Image.
	 * @return Return the Match Percentage of the images.
	 * 
	 */
	public double compareImageRatio(String path1, String path2) {

		Pattern img1 = new Pattern(path1);
		Pattern img2 = new Pattern(path2);

		double x = 0.0;

		Finder f = new Finder(img1.getImage());
		f.find(img2);
		if (f.hasNext()) {
			Match m = f.next();
			x = m.getScore() * 100;
		}

		return x;
	}

}
