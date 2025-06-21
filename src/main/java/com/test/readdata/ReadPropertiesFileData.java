/**
 * 
 */
package com.test.readdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.test.browser.setup.Setup;

/**
 * @author anikumar11
 *
 * April 14, 2025
 */
public class ReadPropertiesFileData extends Setup {

	public static Properties properties = new Properties();
	public static String FEATURE;
	static FileInputStream fileInput = null;
	static File file = null;
	public static String PROPERTIES_FILE_PATH = "src/main/java/configuration/configuration_setting.properties";
	public static String LOG_STATUS;


	//this is for to generate the log file based on the timestamp, so this will always execute before class
	static{

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	@SuppressWarnings("unused")
	protected static String readPropertiesFileData(String propertyName) throws IOException {

		try {
			file = new File(PROPERTIES_FILE_PATH);
			fileInput = null;
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			System.out.println("File not found on specified location: "+file);
			System.err.println("Error!!! "+e.getMessage());
		}
		try {
			properties.load(fileInput);
		} catch (Exception e) {
			System.out.println("Properties file not loaded !!!" +e.getMessage());
		}

		FEATURE = properties.getProperty(propertyName);
		//System.out.println("File: "+FEATURE);
		return FEATURE;

	}
}
