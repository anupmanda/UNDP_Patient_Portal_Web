/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.readdata.ExcelSheetDataProvider;
import com.test.testng.page.DBConnectionPre_Registration;
import com.test.testng.page.PreRegisterPage;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 * 03-Sept-2025
 */
public class PatientPreRegisterTest_1 extends PreRegisterPage {

	public PreRegisterPage register = new PreRegisterPage();
	DBConnectionPre_Registration db = new DBConnectionPre_Registration();
	
	   private final String sheetName = "Pre_Registration_Page";

	    @DataProvider(name = "ExcelUniversalDataProvider")
	    public Object[][] getData() throws IOException {
	        return ExcelSheetDataProvider.getExcelData(sheetName);
	    }

   @Test(dataProvider = "ExcelUniversalDataProvider")
	public void fetchSMSDataFromDB(String mobile_number,String emailid ,String id, String id_no, String title_drp ,String sur_name , String 
			other_name , String Dob, String typeof_age, String gender_drp, String MaritalStatus_drp, String house_name, String post_code,
			String country_drp ,String District_drp , String city_town_village, String locality_drp , String street_drp ) 
			throws IOException, InterruptedException {

		logger = extent.createTest("Create PRE_REGISTRATION PAGE ",
				"Entered valid data in all the fields.");

		register.clickOnSkipButton("Click on skip button.....");
		Thread.sleep(500);
		register.clickOnProfilePicAndLogout("Click On Profile pic","Logout Button");
		register.clickOnPre_Registration("Click on pre_registration....");
	
		// db.connectAndFetchSMS(); // Use DB logic here
		db.enterMobileNumberAndVerifyBtn(mobile_number,"Verify Mobile Number");
		String otp = db.connectAndFetchSMS(mobile_number);
		Thread.sleep(500);
		db.enterMobileOTPBox(otp);
		Thread.sleep(3000);
		db.clickSubmitMobileOtpPopup("Read And submit moblie otp password");

		db.enterEmailIDAndVerifyBtn(emailid, "Verify button EmailId");
		Thread.sleep(3000);
		String otp_email = db.connectAndFetchEmail(emailid);
		db.enterOTPOnEmailIdBox(otp_email);
		db.clickSubmitEmailOtpPopup("Read and submit emailid otp password");

		logger = extent.createTest("Create PRE_REGISTRATION PAGE ", "Entered valid data in all the fields.");
        Thread.sleep(5000);
		//register.SelectIdTypeAndIdNumber(id, id_no);
		// TestNG test class
		register.SelectIdTypeAndIdNumber(id, id_no + CommanUtill.randomAlphabets(4));
		
		register.selectTitleAndSurNameAndOtherName(title_drp, sur_name, other_name);
		register.enterDateOfBrith_1(Dob);
		register.selectByTypeOfAge(typeof_age); 
		register.selectGenderAndMaritalStatusDrp(gender_drp ,MaritalStatus_drp);
		register.enterHouseNoFlatNo(house_name);
		register.EnterPostCode(post_code);
		register.selectByCountrydrp(country_drp);
		register.DistrictCityVillageAndLocalityDrp(District_drp ,city_town_village,locality_drp);
		
		Thread.sleep(300);
		//register.selectStreetSelectDropDwon(street_drp);
		Thread.sleep(300);
		register.selectCheckBoxAndProceedBtn("Click Check Box", "Proceed Btn");
		
		String preRegNo = register.getPreRegistrationNo();
		System.out.println("Pre Registration Number is: " + preRegNo);
	
	}

}
