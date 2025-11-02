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
 *         25-May-2025
 */
public class ManageFamilyMemberTest extends ManageFamilyMemberPage {

	public ManageFamilyMemberPage managefamilymemberaddmob = new ManageFamilyMemberPage();
	DbConnectionManageFamily db = new DbConnectionManageFamily();

	@Test(priority = 2)
	public void connectAndFetchSMSManageFamily() throws IOException, InterruptedException {

		logger = extent.createTest("Manage Family Member page ", "This is the Manage Family Member DB Connection get OTP Password.");
		db.enterMoblieManageFamilyDb("4133309");
		Thread.sleep(3000);
		db.clickOnOtpButtonManageFamliyDb("Click on Otp button....");

		String otp = db.connectAndFetchSMSManageFamily();
		db.enterGetOtpManagrFamily(otp);
		Thread.sleep(3000);
		db.clickOnSubmitOtpManageFamily("Read And submit moblie otp password");
		managefamilymemberaddmob.clickOnAddFamilyMember("Add on Exiting family member successfully message........");

	}

	@Test(priority = 1)

	public void manageFamilyMemberMobileNo() throws IOException, InterruptedException, InvalidFormatException {

		logger = extent.createTest("Manage Family Member page ", "This is the Manage Family Member.");
		managefamilymemberaddmob.clickOnSkipButton();
		managefamilymemberaddmob.clickOnManageFamilyMemberButton("Click On Side Icon Manage Family Member");
		Thread.sleep(3000);
		managefamilymemberaddmob.clickOnAddNewFamilyMember("Click add New Family Member Buttom");
		Thread.sleep(3000);
		managefamilymemberaddmob.clickOnAddProfilePop("Click on add profile pop");
		Thread.sleep(3000);
		// managefamilymemberaddmob.enterMoblie("9876543210"); //
		// managefamilymemberaddmob.clickOnOtpButton("Click On OTP Button");
		Thread.sleep(500);
		// managefamilymemberaddmob.enterGetOtp("123456");
		// managefamilymemberaddmob.clickOnSubmitOtp("otpSubmit");
		Thread.sleep(3000);
		// managefamilymemberaddmob.clickOnAddFamilyMember("Add on Exiting family member
		// successfully message........");
	}

	@Test(priority = 3)
	public void manageFamilyAddEdite() throws IOException, InterruptedException, InvalidFormatException {
		logger = extent.createTest("Manage Family Member page ", "This is the Manage Family Member Edite Family Member.");
		Thread.sleep(5000);
		managefamilymemberaddmob.clickOnEditeButton("click edite button");
		Thread.sleep(5000);
		managefamilymemberaddmob.selectOnRelationshipDropDwon("Sister");
		Thread.sleep(5000);
		managefamilymemberaddmob.clickOnEditeSaveButton("Select and find relationship in family member.......");
	}

	@Test(priority = 4)
	public void ManageFamilyDeleted() throws IOException, InterruptedException, InvalidFormatException {
		logger = extent.createTest("Manage Family Member page ", "This is the Manage Family Member Inster Worng Family Member Delete.");
		Thread.sleep(5000);
		managefamilymemberaddmob.clickOnDeleteIcon("Remove family member.........");

	}

}
