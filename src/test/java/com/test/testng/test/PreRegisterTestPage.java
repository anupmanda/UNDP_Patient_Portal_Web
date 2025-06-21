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
 *         20-May-2025
 */
public class PreRegisterTestPage extends PreRegisterPage {

	public PreRegisterPage register = new PreRegisterPage();
	DBConnectionPre_Registration db = new DBConnectionPre_Registration();

	@Test(priority = 1)
	public void fetchSMSDataFromDB() throws IOException, InterruptedException {

		logger = extent.createTest("Create PRE_REGISTRATION PAGE ",
				"Entered valid data in all the fields.");

		register.clickOnSkipButton("Click on skip button.....");
		Thread.sleep(500);
		register.clickOnProfilePic("Login and logout go to pre_registration page......");
		register.clickOnPre_Registration("Click on pre_registration....");
		// db.connectAndFetchSMS(); // Use DB logic here
		db.enterMobileNumber1("98765439");
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

	}

	@Test(priority = 2)
	public void patientRegistrationTC() throws IOException, InterruptedException, InvalidFormatException {

		logger = extent.createTest("Create PRE_REGISTRATION PAGE ", "Entered valid data in all the fields.");

		// register.clickOnSkipButton("Click on skip button.....");
		// Thread.sleep(500);
		// register.clickOnProfilePic("Login and logout go to pre_registration
		// page......");
		// register.clickOnPre_Registration("Click on pre_registration....");
		register.SelectIdTypeDropDwon("NICN");
		register.enterIdNo("AUTOMATION1234");
		register.selectTitleDropDwon("Mr.");
		register.enterSurName("Santosh");
		register.enterOtherName("SHARMA");
		register.selectdate();

		// register.enterDob("2010/Jan/20"); //
		// register.enterAge("20"); //
		Thread.sleep(3000);
		register.selectGenderSelectDropDwon("Male");
		Thread.sleep(3000);
		register.selectMaritalStatusSelectDropDwon("Single");

		//register.enterMobileNumber("98765432");
		//register.clickOnVerifyMobile("Verify mobile buttun");
		//Thread.sleep(5000);
		//register.enterMobileOtpVerify("1234");
		//register.clickSubmitMobileOtpPop("Submit moblie otp");
		//Thread.sleep(5000);
		//register.enterEmailID("abc@gmail.com");
		//register.clickOnVerifyEmailButton("Click on verify emailid button ");
		//Thread.sleep(3000);
		//register.enterOTPOnEmailIdVerify("1234");
		//Thread.sleep(3000);
		//register.clickSubmitEmailOtpPop("Sumit email otp");
		//Thread.sleep(3000);
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
