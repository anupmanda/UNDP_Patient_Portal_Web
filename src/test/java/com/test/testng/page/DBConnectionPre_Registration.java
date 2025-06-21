/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 *         27-May-202
 * 
 */

public class DBConnectionPre_Registration extends GeneralBrowserSetting {

	public String connectAndFetchSMS() {

		// Database connection
		// String url =
		// "jdbc:sqlserver://localhost:103.234.185.88:2499;databaseName=UNDP_TestingNew";
		// String url =
		// "jdbc:sqlserver://103.234.185.88:2499;databaseName=UNDP_TestingNew";
		String url = "jdbc:sqlserver://103.234.185.88:2499;databaseName=UNDP_TestingNew;encrypt=true;trustServerCertificate=true";

		String username = "sa";
		String password = "ServerAdmin@123";
		String otp = null;

		/*
		 * try { Connection con = DriverManager.getConnection(url, username, password);
		 * 
		 * Statement stmt = con.createStatement(); // ResultSet rs =
		 * stmt.executeQuery("SELECT * FROM D_SMS order by 1 desc"); ResultSet rs =
		 * stmt.executeQuery("SELECT * FROM D_SMS where MobileNo like '98765439'");
		 * 
		 * while (rs.next()) {
		 * 
		 * System.out.println("Data: " + rs.getString("messageText"));
		 * 
		 * }
		 * 
		 * 
		 * con.close(); } catch (Exception e) { e.printStackTrace(); } return password;
		 * 
		 * }
		 */

		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement()) {

			ResultSet rs = stmt.executeQuery(
					"SELECT TOP 1 [MessageText] AS messageText FROM D_SMS WHERE MobileNo LIKE '98765439%' ORDER BY ID DESC");

			if (rs.next()) {
				String message = rs.getString("messageText");
				System.out.println("Full message from DB: " + message);

				// Extract 4 or 6 digit OTP using regex
				java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\b\\d{4,6}\\b").matcher(message);
				if (matcher.find()) {
					otp = matcher.group();
					System.out.println("Extracted OTP: " + otp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return otp;

	}

	protected static String enter_mobile = "//input[@id='txtMobileNo']";
	protected static String Verify_mobile = "//button[@id='btnVerifyMobile']";
	protected static String mobile_submit_otp = "//button[@id='VerifyMobileOTP']";

	protected static String enter_emailId = "//input[@id='txtEmailId']";
	protected static String verify_email = "//button[@id='btnVerifyEmail']";
	protected static String email_submit_otp = "//button[@id='VerifyEmailOTP']";

	public void enterMobileNumber1(String mobile) throws IOException, InterruptedException {

		WebElement m = driver.findElement(By.xpath(enter_mobile));
		m.click();
		m.sendKeys(mobile);

	}

	public void clickOnVerifyMobileButton(String mob_verify) throws IOException, InterruptedException {

		CommanUtill.clickFunction(Verify_mobile, mob_verify);

	}

	public void enterMobileOtpVerify1(String MOBILEOTP) throws IOException, InterruptedException {

		WebElement otp1 = driver.findElement(By.xpath("//input[@id='MOTP1']"));
		WebElement otp2 = driver.findElement(By.xpath("//input[@id='MOTP2']"));
		WebElement otp3 = driver.findElement(By.xpath("//input[@id='MOTP3']"));
		WebElement otp4 = driver.findElement(By.xpath("//input[@id='MOTP4']"));
		otp1.sendKeys(MOBILEOTP);
		otp2.sendKeys(MOBILEOTP);
		otp3.sendKeys(MOBILEOTP);
		otp4.sendKeys(MOBILEOTP);

	}

	public void clickSubmitMobileOtpPop1(String filedName) throws IOException, InterruptedException {

		CommanUtill.clickFunction(mobile_submit_otp, filedName);

	}

	public void enterEmailID1(String emailid) throws IOException, InterruptedException {

		CommanUtill.textEnter(enter_emailId, emailid);
		driver.findElement(By.xpath(enter_emailId)).click();

	}

	public void clickOnVerifyEmailButton1(String email_verify_button) throws IOException, InterruptedException {

		CommanUtill.clickFunction(verify_email, email_verify_button);

	}

	public void enterOTPOnEmailIdVerify1(String EmailOTP) throws IOException, InterruptedException {

		WebElement otp1 = driver.findElement(By.xpath("//input[@id='EOTP1']"));
		WebElement otp2 = driver.findElement(By.xpath("//input[@id='EOTP2']"));
		WebElement otp3 = driver.findElement(By.xpath("//input[@id='EOTP3']"));
		WebElement otp4 = driver.findElement(By.xpath("//input[@id='EOTP4']"));
		otp1.sendKeys(EmailOTP);
		otp2.sendKeys(EmailOTP);
		otp3.sendKeys(EmailOTP);
		otp4.sendKeys(EmailOTP);

	}

	public void clickSubmitEmailOtpPop1(String email_submit) throws IOException, InterruptedException {

		CommanUtill.clickFunction(email_submit_otp, email_submit);

	}

}
