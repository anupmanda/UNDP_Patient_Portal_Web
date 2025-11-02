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
		register.clickOnProfilePicAndLogout("Click On Profile pic","Logout Button");
		register.clickOnPre_Registration("Click on pre_registration....");
		
		// db.connectAndFetchSMS(); // Use DB logic here
		db.enterMobileNumberAndVerifyBtn("98765439","Verify Mobile Number");
		
		String otp = db.connectAndFetchSMS("98765439");
		db.enterMobileOTPBox(otp);
		Thread.sleep(3000);
		db.clickSubmitMobileOtpPopup("Read And submit moblie otp password");

		db.enterEmailIDAndVerifyBtn("abc@gmail.com", "Verify button EmailId");
		Thread.sleep(3000);
		String otp_email = db.connectAndFetchEmail("abc@gmail.com");
		db.enterOTPOnEmailIdBox(otp_email);
		db.clickSubmitEmailOtpPopup("Read and submit emailid otp password");

	}

	@Test(priority = 2)
	public void patientRegistrationTC() throws IOException, InterruptedException, InvalidFormatException {

		logger = extent.createTest("Create PRE_REGISTRATION PAGE ", "Entered valid data in all the fields.");

		register.SelectIdTypeAndIdNumber("NIC","AUTOMATION1234");
		
		register.selectTitleAndSurNameAndOtherName("Mr.","Santosh","SHARMA");
		
		register.enterDateOfBrith("21/Feb/1990");
		
		 register.selectByTypeOfAge("Year(s)"); 
		
		register.selectGenderAndMaritalStatusDrp("Male" ,"Single");
		register.enterHouseNoFlatNo("DELHI");
		
		register.EnterPostCode("110033");
	
		register.selectByCountrydrp("India");
		register.DistrictCityVillageAndLocalityDrp("DELHI","New Delhi","Abhey Garden");
		
		Thread.sleep(300);
		//register.selectStreetSelectDropDwon("Street 44370");
		Thread.sleep(300);
		register.selectCheckBoxAndProceedBtn("Click Check Box", "Proceed Btn");
		
	

		
	}


}
