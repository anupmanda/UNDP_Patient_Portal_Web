/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.testng.page.DBConnectionPre_Registration;
import com.test.testng.page.PreRegisterPage;

/**
 * @author Anup
 *
 *         02-Jun-2025
 */
public class InvalidTestCasePre_Registration extends PreRegisterPage{
     
	public PreRegisterPage register = new PreRegisterPage();
	DBConnectionPre_Registration db = new DBConnectionPre_Registration();

	@Test(priority = 1)
	public void fetchSMSDataFromDB() throws IOException, InterruptedException {

		logger = extent.createTest("PRE_REGISTRATION PAGE ",
				"Entered valid data in all fields except for the mobile number and email");

		register.clickOnSkipButton("Click on skip button.....");
		Thread.sleep(500);
		register.clickOnProfilePic("Login and logout go to pre_registration page......");
		register.clickOnPre_Registration("Click on pre_registration....");
		// db.connectAndFetchSMS(); // Use DB logic here
/*		db.enterMobileNumber1("98765439");
		db.clickOnVerifyMobileButton("Verify mobile buttun");
		Thread.sleep(3000);
		String otp = db.connectAndFetchSMS();
		db.enterMobileOtpVerify1(otp);
		Thread.sleep(3000);
		db.clickSubmitMobileOtpPop1("Read And submit moblie otp password");

		db.enterEmailID1("abc@gmail.com");
		db.clickOnVerifyEmailButton1("Vrify emailid button...");
		Thread.sleep(3000);
		String otp_email = db.connectAndFetchSMS();
		db.enterOTPOnEmailIdVerify1(otp_email);
		db.clickSubmitEmailOtpPop1("Read and submit emailid otp password");
*/
	}

	@Test(priority = 2)
	public void patientRegistrationTC() throws IOException, InterruptedException, InvalidFormatException {

		logger = extent.createTest("PRE_REGISTRATION PAGE ", "Entered valid data in all fields except for the mobile number and email.");

		register.SelectIdTypeDropDwon("NICN");
		register.enterIdNo("L2345678901234");
		Thread.sleep(3000);
		register.selectTitleDropDwon("Mr.");
		Thread.sleep(3000);
		register.enterSurName("Santosh");
		Thread.sleep(3000);
		register.enterOtherName("Shrma");
		Thread.sleep(3000);
		register.selectdate();

		register.selectGenderSelectDropDwon("Male");
		Thread.sleep(3000);
		register.selectMaritalStatusSelectDropDwon("Single");

		register.enterHouseNoFlatNo("DELHI");
		Thread.sleep(300);
		register.EnterPostCode("201301");
		Thread.sleep(300);
		register.selectDistrictSelectDropDwon("DELHI");
		Thread.sleep(300);
		register.selectCityTownVillageSelectDropDown("Noida");
		Thread.sleep(300);
		register.selectLocalitySelectDropDwon("sector 37");
		Thread.sleep(300);
		register.selectStreetSelectDropDwon("Street 44370");
		Thread.sleep(300);
		register.selectCheckBox(checkBox);
		Thread.sleep(300);
		register.clickProceedButton(clickProceedSubmit);
		Thread.sleep(1000);
		register.clickOnRegisterSuccessfullyPop("Register Successfully");

		System.out.println("clicked on the Create REGISTRATION !!!");
	}
	

}
