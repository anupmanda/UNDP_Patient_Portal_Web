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
       public class InvalidLoginWithNicIdTest extends LoginWithNicIdPage {
           
    	   public static LoginWithNicIdPage nicid = new LoginWithNicIdPage();
      	 
      	 @Test(priority =1)
      	 public void loginNicID() throws IOException, InterruptedException{
      		
      		 logger = extent.createTest("Login With NIC ID. ","LOgin With Invalid NIC ID.");
      					
      		 nicid.clickOnSkipButton("Click On Skip button.");
      		 nicid.clickOnProfilePic(" Click On Profile Pic.");
      		 Thread.sleep(300);
      		 nicid.clickOnLoginButton(" Click On Login Button.");
      		 Thread.sleep(300);
      		 nicid.clickOnNicIDRadioButton("Select NIC radio  Button.");
      		 nicid.enterNicID("03");
      		 Thread.sleep(300);
      		 nicid.enterNicIDPassword("123");
      		 Thread.sleep(300);
      		 nicid.clickOnLoginPasswordButton("Click On Login Button.");
      		 
      		 
      	 }

   }
