/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 *         03-Jun-2025
 */
public class LoginOtpWithMobileNoPage extends GeneralBrowserSetting {

	protected static String skipButton = "//button[@id='skip-btn']";
	protected static String profile_click = "//div[@id='viewfamily_div']";
	protected static String logout = "//a[@id='btn_login']";
	protected static String login = "//button[@id='loginbtn']";
	protected static String radio = "//input[@id='radio2']";
	protected static String uhid = "//input[@id='txtUhid']";
	protected static String login_otp = "//button[@id='btnlogin1']";
	protected static String mob_radio = "//input[@id='verifyMobile']";
	protected static String email_radio = "//input[@id='verifyEmail']";
	protected static String enter_email = "//input[@id='emailField']";
	protected static String enter_mob = "//input[@id='phoneNumberField']";
	protected static String send_otp = "//button[@id='loginwith_otpfun']";

	public void clickSkipButton() throws IOException, InterruptedException {

		// CommanUtill.clickFunction(skipButton, "Skip Button");
		driver.findElement(By.xpath(skipButton)).click();
	}

	public void clickOnProfilePicLogot(String pic) throws IOException, InterruptedException {

		WebElement profile = driver.findElement(By.xpath(profile_click));
		profile.click();
		WebElement Logout = driver.findElement(By.xpath(logout));
		Logout.click();

		// CommanUtill.clickFunction(profile_click, pic);
		// CommanUtill.clickFunction(logout, pic);

	}

	public void clickOnLoginButton(String log) throws IOException, InterruptedException {

		CommanUtill.clickFunction(login, log);

	}

	public void clickOnRadioButton(String filedName) throws IOException, InterruptedException {

		CommanUtill.click(radio, filedName);
	}

	public void enterUHID(String filedName) throws IOException, InterruptedException {

		CommanUtill.textEnter(uhid, filedName);
	}

	public void clickOnLoginWithOtpButton(String filedName) throws IOException, InterruptedException {

		CommanUtill.clickFunction(login_otp, filedName);
	}

	public void clickOnMobileRadioButton(String filedName) throws IOException, InterruptedException {

		CommanUtill.clickFunction(mob_radio, filedName);
		Thread.sleep(300);

	}

	public void clickOnEmailIdRadioButton(String filedName) throws IOException, InterruptedException {

		CommanUtill.clickFunction(email_radio, filedName);

	}
	 
	public void enterEmailId(String filedName) throws IOException, InterruptedException{
		
		CommanUtill.textEnter(enter_email, filedName);
	}

	public void enterOnMobileNo(String filedName) throws IOException, InterruptedException {

		CommanUtill.textEnter(enter_mob, filedName);

	}

	public void clickOnSendOtpButton(String FiledName) throws IOException, InterruptedException {

		CommanUtill.clickFunction(send_otp, FiledName);

	}

}