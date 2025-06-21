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
 *         02-Jun-2025
 */
public class DbConnectionManageFamily extends GeneralBrowserSetting {

	public String connectAndFetchSMSManageFamily() {
		String url = "jdbc:sqlserver://103.234.185.88:2499;databaseName=UNDP_TestingNew;encrypt=true;trustServerCertificate=true";

		String username = "sa";
		String password = "ServerAdmin@123";
		String otp = null;

		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement()) {

			ResultSet rs = stmt.executeQuery(
					"SELECT TOP 1 [MessageText] AS messageText FROM D_SMS WHERE MobileNo LIKE '9876543210%' ORDER BY ID DESC");

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

	// _______________________________________*****************************___________________________________________________
	protected static String enter_phone_no = "//input[@id='phoneNumberField']";
	protected static String get_otp = "//span[@id='searchwith_otpfunMob']//a[@title='Verify'][normalize-space()='Get OTP']";
	protected static String submit = "//a[@id='send_otpfun']";

	public void enterMoblieManageFamilyDb(String enterMobileNo)
			throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.enter(enter_phone_no, enterMobileNo);

	}

	public void clickOnOtpButtonManageFamliyDb(String otp)
			throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(get_otp, otp);
	}

	public void enterGetOtpManagrFamily(String getOtp)
			throws IOException, InterruptedException, InvalidFormatException {

		WebElement otp1 = driver.findElement(By.xpath("//input[@id='fieldarea1']"));
		otp1.sendKeys(getOtp);
		WebElement otp2 = driver.findElement(By.xpath("//input[@id='fieldarea2']"));
		otp2.sendKeys(getOtp);
		WebElement otp3 = driver.findElement(By.xpath("//input[@id='fieldarea3']"));
		otp3.sendKeys(getOtp);
		WebElement otp4 = driver.findElement(By.xpath("//input[@id='fieldarea4']"));
		otp4.sendKeys(getOtp);
		WebElement otp5 = driver.findElement(By.xpath("//input[@id='fieldarea5']"));
		otp5.sendKeys(getOtp);
		WebElement otp6 = driver.findElement(By.xpath("//input[@id='fieldarea6']"));
		otp6.sendKeys(getOtp);

	}

	public void clickOnSubmitOtpManageFamily(String otpSubmit)
			throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(submit, otpSubmit);

	}

}