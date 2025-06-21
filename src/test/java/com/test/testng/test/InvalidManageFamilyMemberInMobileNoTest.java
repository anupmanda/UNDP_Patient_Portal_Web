/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.testng.page.DbConnectionManageFamily;
import com.test.testng.page.ManageFamilyMemberPage;

/**
 * @author Anup
 *
 * 10-Jun-2025
 */
    public class InvalidManageFamilyMemberInMobileNoTest extends ManageFamilyMemberPage{
    	
    	public ManageFamilyMemberPage managefamilymemberaddmob = new ManageFamilyMemberPage();
    	DbConnectionManageFamily db = new DbConnectionManageFamily();
    	
    	@Test(priority = 1)
    	public void manageFamilyMemberMobileNo() throws IOException, InterruptedException, InvalidFormatException {

    		logger = extent.createTest("Manage Family Member page ", "Family Member Fetched With Invalid Mobile Number.");
    		managefamilymemberaddmob.clickOnSkipButton();
    		managefamilymemberaddmob.clickOnManageFamilyMemberButton("Click On Side Icon Manage Family Member");
    		Thread.sleep(3000);
    		managefamilymemberaddmob.clickOnAddNewFamilyMember("Click add New Family Member Buttom");
    		Thread.sleep(3000);
    		managefamilymemberaddmob.clickOnAddProfilePop("Click on add profile pop");
    		Thread.sleep(3000);
    		db.enterMoblieManageFamilyDb("9");
    		Thread.sleep(3000);
    		db.clickOnOtpButtonManageFamliyDb("Click on Otp button....");
    		
    		
    	}

}
