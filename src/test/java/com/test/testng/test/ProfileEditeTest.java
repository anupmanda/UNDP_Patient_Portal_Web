/**
 * 
 */
package com.test.testng.test;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.testng.page.ProfileEditePage;

/**
 * @author Anup
 *
 * 28-May-2025
 */
        public class ProfileEditeTest extends ProfileEditePage {
        	
        	public  ProfileEditePage profile = new ProfileEditePage();
        	
        	@Test(priority = 1)
        	
        	public void editeProfile()throws IOException, InterruptedException,InvalidFormatException, AWTException{
        		
        		logger= extent.createTest("Patient Profile Edite ", "This is the Patient Profile Edite Page.");		
        		profile.clickSkipButton("click skip button");
        		Thread.sleep(3000);
        		profile.clickOnProfileButton("Click on profile button.");
        		Thread.sleep(3000);
        		profile.clickOnProfileEditeButton("Click Edite button.");
        		Thread.sleep(3000);
        		profile.enterPinCode("201301");
        		Thread.sleep(3000);
        		profile.selectOnCountryDropDwon("India");
        		Thread.sleep(3000);
        		profile.selectOnDistrictDropDwon("Uttar Pradesh");
        		Thread.sleep(3000);
        		profile.selectOnCityDropDwon("Noida");
        		Thread.sleep(3000);
        		profile.selectOnLocalityDropDwon("Sector 63A");
        		Thread.sleep(3000);
        		profile.selectOnStreetDropDwon("Street 43170");
        		Thread.sleep(3000);
        	//	profile.clickUploadProfilePic();
        		Thread.sleep(5000);
        		profile.ClickOnSaveButton("Submit button.");
        		Thread.sleep(3000);
        		profile.ClickOnOkSuccessfullyUploadPop("Updated successfully");
        		
        		
        		
   }
}