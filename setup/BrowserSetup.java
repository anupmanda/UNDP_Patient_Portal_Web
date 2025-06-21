/**
 * 
 */
package com.test.browser.setup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author anil
 *
 * Feb 01, 2025
 */

public class BrowserSetup {

	public static WebDriver driver;
	public static String URL = "";
	public static String BROWSERNAME = "";


	@BeforeClass
	public static void launchBrowser() throws IOException {
		if(BROWSERNAME.equalsIgnoreCase("Chrome") || BROWSERNAME.equalsIgnoreCase("CHROME")){
			try {
				WebDriverManager.chromedriver().setup();
			} catch (Exception E) {
				System.err.println("Error while loading the data from property file for chrome browser !!!" +E.getMessage());
			} 
			try {
				//DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ();       
				//handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
				//driver = new ChromeDriver (handlSSLErr);
			} catch (Exception e) {
				System.err.println("Error while reading the data from property file for chrome browser !!!" +e.getMessage());
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(URL);
		}

		else if(BROWSERNAME.equalsIgnoreCase("InternetExplorer") || BROWSERNAME.equalsIgnoreCase("IE")){

			try {
				WebDriverManager.iedriver().setup();

			} catch (Exception E) {
				System.err.println("Error while loading the data from property file for chrome browser !!!" +E.getMessage());
			}

			//it is used to define IE capability 
			try {
				//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

				//capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
				//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				//driver = new InternetExplorerDriver(capabilities);
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
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("Successfully execution done !!!!");
		driver.quit();
	}


	public void customWait(long millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void click(String locator, String fieldName) {
		try {
			driver.findElement(By.xpath(locator)).click();
		} catch (Exception e) {
			System.out.println("Error while clicking on ' " +fieldName+ " '"+e.getMessage());
			e.printStackTrace();
		}
	}

	public void click(WebElement webElement, String fieldName) {
		try {
			webElement.click();
		} catch (Exception e) {
			System.out.println("Error while clicking on ' " +fieldName+ " '"+e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterText(String locator, String inputText, String fieldName) {
		try {
			driver.findElement(By.xpath(locator)).clear();
			customWait(2000);
			driver.findElement(By.xpath(locator)).sendKeys(inputText);
		} catch (Exception e) {
			System.out.println("Error while entering the text on ' " +fieldName+ " '"+e.getMessage());
			e.printStackTrace();
		}
	}

}
