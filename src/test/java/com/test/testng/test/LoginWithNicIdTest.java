/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.test.testng.page.LoginWithNicIdPage;

/**
 * @author Anup
 *
 * 10-Jun-2025
 */
         public class LoginWithNicIdTest extends LoginWithNicIdPage {
        	 
        	 public static LoginWithNicIdPage nicid = new LoginWithNicIdPage();
        	 
        	 @Test(priority =1)
        	 public void loginNicID() throws IOException, InterruptedException{
        		
        		 logger = extent.createTest("Login With NIC IDSS ","Login With Valid NIC");
        					
        		 nicid.clickOnSkipButton("Click On Skip Button.");
        		 nicid.clickOnProfilePic("Click On Profile Pic .");
        		 Thread.sleep(300);
        		 nicid.clickOnLoginButton(" Click On Login Button.");
        		 Thread.sleep(300);
        		 nicid.clickOnNicIDRadioButton("Select NIC Id radio Button.");
        		 nicid.enterNicID("0987654321");
        		 Thread.sleep(300);
        		 nicid.enterNicIDPassword("123");
        		 Thread.sleep(300);
        		 nicid.clickOnLoginPasswordButton("Click On Login Button.");
        		 
        		 
        	 }

  }
