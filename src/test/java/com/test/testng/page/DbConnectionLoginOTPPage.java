/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 *         03-Jun-2025
 */
public class DbConnectionLoginOTPPage extends GeneralBrowserSetting {

	public String connectAndFetchSMSLoginOtp() {

		//String url = "jdbc:sqlserver://206.19.38.9:1433;databaseName=HISTreeUNDP_SIT;encrypt=true;trustServerCertificate=true";
		String url = "jdbc:sqlserver://103.234.185.88:2499;databaseName=UNDP_TestingNew;encrypt=true;trustServerCertificate=true";
		
		String username = "sa";
		String password = "ServerAdmin@123";
		//String username = "devuser2024";
		//String password = "$devuser2024";
		String otp = null;
		
		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement()) {

			ResultSet rs = stmt.executeQuery("SELECT * FROM O_OTP ORDER BY Id DESC;");

			if (rs.next()) {
				String message = rs.getString("otp");
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
	// ______________________*****************************____________________________________________

	protected static String enter_otp1 = "//input[@id='fieldarea1']";
	protected static String enter_otp2 = "//input[@id='fieldarea2']";
	protected static String enter_otp3 = "//input[@id='fieldarea3']";
	protected static String enter_otp4 = "//input[@id='fieldarea4']";
	
	protected static String submit_otp = "//div[@id='send_otpfun']";
	
	public void enterOTPBoxVerification(String filedName) throws IOException, InterruptedException {

	//	CommanUtill.textEnter(enter_otp1, filedName);
	//	CommanUtill.textEnter(enter_otp2, filedName);
	//	CommanUtill.textEnter(enter_otp3, filedName);
	//	CommanUtill.textEnter(enter_otp4, filedName);
       
		driver.findElement(By.xpath(enter_otp1)).sendKeys(filedName);
		driver.findElement(By.xpath(enter_otp2)).sendKeys(filedName);
		driver.findElement(By.xpath(enter_otp3)).sendKeys(filedName);
		driver.findElement(By.xpath(enter_otp4)).sendKeys(filedName);
	}
	
	  
	public void clickOnSubmitButton(String fieldName)throws IOException, InterruptedException{
		
		CommanUtill.clickFunction(submit_otp, fieldName);
		
	}


}
