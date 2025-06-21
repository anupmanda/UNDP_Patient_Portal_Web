/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.test.testng.page.DbConnectionLoginOTPPage;
import com.test.testng.page.LoginOtpWithMobileNoPage;


/**
 * @author Anup
 *
 * 03-Jun-2025
 */
     public class LoginOtpWithMobileNoTest extends LoginOtpWithMobileNoPage {
    	 
    	 public LoginOtpWithMobileNoPage loginotp = new LoginOtpWithMobileNoPage();
    	 DbConnectionLoginOTPPage db = new DbConnectionLoginOTPPage();
    	 
    	 @Test(priority =1)
    	 public void LoginWithOtp() throws IOException, InterruptedException{
    		 
    		 logger = extent.createTest("Create login page", "This is the Verification Mobile No And Emailid Otp.");
    		 loginotp.clickSkipButton();
    		 loginotp.clickOnProfilePicLogot("Logout button.....");
    		 loginotp.clickOnLoginButton("Login Pre_RegistrationNo.......");
    		 loginotp.clickOnRadioButton("Click Radio Button");
    		 Thread.sleep(300);
    		 loginotp.enterUHID("SISC.100");
    		 Thread.sleep(300);
    		 loginotp.clickOnLoginWithOtpButton("Click on login with OTP ......");
    		 loginotp.clickOnMobileRadioButton("Click On Radio Button....");
    		 Thread.sleep(300);
    		 loginotp.enterOnMobileNo("98765432");
    		 Thread.sleep(300);
    		// loginotp.clickOnEmailIdRadioButton("Click On Radio Button.....");
    		// Thread.sleep(300);
    		// loginotp.enterEmailId("abcd@gmail.com");
    		// Thread.sleep(300);
    		 loginotp.clickOnSendOtpButton("Click On Send OTP.......");
    		 	 
    	 }
    	 
    	 @Test(priority =2)
    	 public void connectAndFetchSMSLoginOtp()throws IOException, InterruptedException{
    		  
    		 logger = extent.createTest("login page ", "This is the login DB Connection get OTP Password.");
    		 String otp =db.connectAndFetchSMSLoginOtp();
    		 db.enterOTPBoxVerification(otp);
    		 
    		db.clickOnSubmitButton("Click on submit otp....");	
    		
    		 
    	 }

    }
