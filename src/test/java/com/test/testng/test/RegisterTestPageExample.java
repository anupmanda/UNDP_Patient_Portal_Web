/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.readdata.ExcelSheetData;
import com.test.testng.page.RegisterPageExample;

/**
 * @author anup
 *
 * Feb 01, 2025
 */
public class RegisterTestPageExample extends RegisterPageExample {
	
	public static RegisterPageExample regis = new RegisterPageExample();
	public static String SHEET_NAME = "Registration_Page";
	
	
	@Test(priority = 1)
	public void createAppointmentTC() throws IOException, InterruptedException, InvalidFormatException {
		logger = extent.createTest("Create Appointment page ", "This is the Create Appointment.");
		regis.createAppointment();
		regis.logOut();
		System.out.println("clicked on the Create Appointment !!!");
	}
	
	
	@Test(priority = 2)
	public void registerNow() throws IOException, InterruptedException, InvalidFormatException {
		logger = extent.createTest("Patient Registration page ", "This is the patient registration page.");
		regis.clickOnRegisterNow();
		String surName = ExcelSheetData.getData(SHEET_NAME, 1, 0);
		regis.enterSurnameOnRegisterNow(surName);
		System.out.println("clicked on the register now !!!");
		
	}

}
