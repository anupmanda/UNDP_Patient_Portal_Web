
package com.test.browser.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.test.report.Reports;
import com.test.ui.helper.CommanUtill;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;


/**
 * @author anup
 *
 * Feb 01, 2025
 */
@Slf4j
public class GeneralBrowserSetting extends Reports {

	@SuppressWarnings("static-access")
	@BeforeClass
	public static void launchBrowser() throws IOException, InterruptedException {
		//this is for logger file read and config...
		LOG_STATUS = readPropertiesFileData("LOG_FILE_STATUS");
		if(LOG_STATUS.equalsIgnoreCase("Yes")){
			PropertyConfigurator.configure(readPropertiesFileData("LOG_FILE_PATH"));
		}
		else {
			System.out.println("log file not required, Please enable option in properties file ...");
		}

		try {
			InputStream input = new FileInputStream(PROPERTIES_FILE_PATH);
			//load a properties file
			properties.load(input);
			BROWSERNAME = readPropertiesFileData("BROWSERNAME");
		} catch (Exception e) {
			System.err.println("Error while reading the data from property file!!!" +e.getMessage());
		}
		if(BROWSERNAME.equalsIgnoreCase("Chrome") || BROWSERNAME.equalsIgnoreCase("CHROME")){
			URL = readPropertiesFileData("URL");
			try {
				System.setProperty("webdriver.chrome.driver", "D:\\Working_Space\\WebAutomationI_UI_Project\\ChromeDriver\\chromedriver.exe");
				//WebDriverManager.chromedriver().setup();
			} catch (Exception E) {
				System.err.println("Error while loading the data from property file for chrome browser !!!" +E.getMessage());
			} 
			try {

				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				//Turns off download prompt
				chromePrefs.put("download.prompt_for_download", false);

				chromePrefs.put("pdfjs.disabled", true);
				ChromeOptions options = new ChromeOptions();
				HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
				options.setExperimentalOption("prefs", chromePrefs);
				options.setCapability("acceptInsecureCerts", true);
				options.addArguments("--test-type");
				options.addArguments("--disable-extensions"); //to disable browser extension popup

				/*DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
				handlSSLErr.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
				handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
				handlSSLErr.setCapability(ChromeOptions.CAPABILITY, options);*/
				driver = new ChromeDriver(options);
			} catch (Exception e) {
				System.out.println("Error while reading the data from property file for chrome browser !!!" +e.getMessage());
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(URL);
		}
		else if(BROWSERNAME.equalsIgnoreCase("InternetExplorer") || BROWSERNAME.equalsIgnoreCase("IE")){

			try {
				URL = properties.getProperty("URL");
				WebDriverManager.iedriver().setup();

			} catch (Exception E) {
				System.err.println("Error while loading the data from property file for chrome browser !!!" +E.getMessage());
			}

			//it is used to define IE capability 
			try {
				//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

				//capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
				//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

				driver = new InternetExplorerDriver();
			} catch (Exception e) {
				System.err.println("Error while reading the data from property file for IE browser !!!" +e.getMessage());
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(URL);
		}


		else if(BROWSERNAME.equalsIgnoreCase("Safari") || BROWSERNAME.equalsIgnoreCase("SAFARI")){

			try {
				driver = new SafariDriver();  
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get(URL);
			} catch (Exception e) {
				System.err.println("Error while launching the safari browser !!!" +e.getMessage());
			}
		}
		applicationLogin();
		
	}
    
	
	public static void applicationLogin() throws IOException, InterruptedException {
		CommanUtill.click("//button[@id='loginbtn']", "Login Button");
		CommanUtill.click("//input[@id='radio2']", "UHID Radio Button");
		CommanUtill.enter("//input[@id='txtUhid']", readPropertiesFileData("UserName"));
		CommanUtill.enter("//input[@id='txtPassword']", readPropertiesFileData("Password"));
		CommanUtill.click("//button[@id='btn_login']", "Login Button");
	}


	@AfterClass
	public static void closeBroser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}