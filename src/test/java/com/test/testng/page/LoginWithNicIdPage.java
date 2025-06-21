/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 *         10-Jun-2025
 */
public class LoginWithNicIdPage extends GeneralBrowserSetting {

//	protected static String profile_click = "//img[@src='/eHealth_Portal_Performance/images/profileUser.png']";
	
	protected static String profile_click = "//div[@id='viewfamily_div']";
	protected static String logout = "//a[@id='btn_login']";
	protected static String skipButton = "//button[@id='skip-btn']";
	protected static String nic_radio = "//input[@id='radio1']";
	protected static String enter_nic = "//input[@id='NIC']";
	protected static String enter_password = "//input[@id='txtPassword1']";
	protected static String click_login_button = "//button[@id='btn_login_NIC']";
	protected static String login = "//button[@id='loginbtn']";
	
	

	public void clickOnSkipButton(String skip) throws IOException, InterruptedException {

		CommanUtill.clickFunction(skipButton, skip);
	}

	public void clickOnProfilePic(String pic) throws IOException, InterruptedException {

		CommanUtill.clickFunction(profile_click, pic);
		Thread.sleep(300);
		CommanUtill.clickFunction(logout, pic);
	}
	
	public void clickOnLoginButton(String filedName) throws IOException, InterruptedException {

		CommanUtill.clickFunction(login, filedName);
	}
	
	public void clickOnNicIDRadioButton(String filedName) throws IOException, InterruptedException {

		CommanUtill.clickFunction(nic_radio, filedName);
	}
	
	public void enterNicID(String filedName) throws IOException, InterruptedException{
		
		CommanUtill.textEnter(enter_nic, filedName);
		
	}
	
	public void enterNicIDPassword(String filedName) throws IOException, InterruptedException{
		
		CommanUtill.textEnter(enter_password, filedName);
		
	}
	
	public void clickOnLoginPasswordButton(String filedName) throws IOException, InterruptedException{
		
		CommanUtill.clickFunction(click_login_button, filedName);
		
	}
	

}
