/**
* 
*/
package com.test.testng.page;
 
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
import com.test.browser.setup.BrowserSetup;
import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;
 
/**
* @author Anup
*
* 16, 05, 2025
*/
 
public class RegisterPageExample extends GeneralBrowserSetting {
 
	protected static String registerNowButtonLink = "//button[@id='btnregister']";
	protected static String surName = "//input[@id='txtSurName']";
	protected static String createAppointmentLink = "//a[contains(text(),'Create Appointment')]";
	protected static String skipButton = "//button[@id='skip-btn']";
	protected static String profileIcon = "//span[@class='client-name']";
	protected static String logOut = "//a[@id='btn_login']";
	
	public void clickOnRegisterNow() throws IOException, InterruptedException {
		CommanUtill.clickFunction(registerNowButtonLink, "Register Now Button");
	}
	public void createAppointment() throws IOException, InterruptedException {
		CommanUtill.clickFunction(skipButton, "Skip Button");
		CommanUtill.clickFunction(createAppointmentLink, "Create Appointment Link");
	}
	public void logOut() throws IOException, InterruptedException {
		// Locate the element to hover over
		CommanUtill.mouseHover(profileIcon);
		//CommanUtill.clickFunction(profileIcon, "Profile Icon");
		CommanUtill.clickFunction(logOut, "Log Out");
	}
 
	public void refreshThePage() {
		try {
			driver.navigate().refresh();
		} catch (Throwable t) {
		}
	}
	public void enterSurnameOnRegisterNow(String surNameInputData) throws IOException, InterruptedException {
		CommanUtill.textEnter(surName, surNameInputData);
	}
 
 
}