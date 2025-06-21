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
public class InvalidManageFamilyMemberWithUHIDTest extends ManageFamilyMemberPage{
	
	public ManageFamilyMemberPage managefamilymemberadduhid = new ManageFamilyMemberPage();
	DbConnectionManageFamily db = new DbConnectionManageFamily();
	
	@Test(priority = 1)
	public void manageFamilyMemberMobileNo() throws IOException, InterruptedException, InvalidFormatException {

		logger = extent.createTest("Manage Family Member page ", "Family Member Fetched With Invalid Patient UHID.");
		managefamilymemberadduhid.clickOnSkipButton();
		managefamilymemberadduhid.clickOnManageFamilyMemberButton("Click On Side Icon Manage Family Member");
		Thread.sleep(3000);
		managefamilymemberadduhid.clickOnAddNewFamilyMember("Click add New Family Member Buttom");
		Thread.sleep(3000);
		managefamilymemberadduhid.clickOnAddProfilePop("Click on add profile pop");
		Thread.sleep(3000);
		managefamilymemberadduhid.clickOnUHIDRadioButton("Click On Radio Button In UHID");
		Thread.sleep(3000);
		managefamilymemberadduhid.EnterpatientUHID("ISIC.pqr");
		Thread.sleep(3000);
		managefamilymemberadduhid.clickOnGetOtpButton("Verify Otp Button And Get Otp Password.");
		
	}
}
