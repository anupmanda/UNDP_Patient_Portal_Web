/**
 * 
 */
package com.test.browser.setup;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.test.readdata.ReadPropertiesFileData;
import com.test.report.Reports;

/**
 * @author anup
 *
 * Feb 01, 2025
 */
public class Setup {
	
	protected static File FOLDER;
	protected static String SUCCESSFOLDERPATH = "";
	protected static String FAILFOLDERPATH = "";
	protected static String PASSFOLDERPATH = "";
	protected static String SCREENSHOT = "";
	protected static String SCREENSHOT_PASS = "";
	protected static String SCREENSHOT_FAIL = "";
	protected static String REPORTS = "";
	protected static String REPORTS_FOLDER = "";
	
	protected static WebDriver driver;
	protected static String URL = "";
	protected static String BROWSERNAME = "";
	protected static Properties properties = new Properties();
	


}
