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
 *         27-May-2025
 * 
 */

public class DBConnectionPre_Registration extends GeneralBrowserSetting {
	
	 private static final String url = "jdbc:sqlserver://206.19.38.11:1433;databaseName=HISTreeUNDP_UAT;encrypt=true;trustServerCertificate=true;";
	    private static final String username = "devuser2025";
	    private static final String password = "$devuser2025";

	    private String fetchOtpFromTable(String tableName, String filterColumn, String filterValue, String messageColumn) {
	        String otp = null;

	        String query = "SELECT TOP 1 " + messageColumn + 
	                       " FROM " + tableName +
	                       " WHERE " + filterColumn + " LIKE '%" + filterValue + "%' " +
	                       " ORDER BY ID DESC";

	        try (Connection con = DriverManager.getConnection(url, username, password);
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {

	            if (rs.next()) {
	                String message = rs.getString(messageColumn);
	                System.out.println("Full message from " + tableName + ": " + message);

	                // Extract 4 to 6 digit OTP from the message text using regex
	                java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\b\\d{4,6}\\b").matcher(message);
	                if (matcher.find()) {
	                    otp = matcher.group();
	                    System.out.println("Extracted OTP: " + otp);
	                } else {
	                    System.out.println("OTP not found in " + tableName + " message text.");
	                }
	            } else {
	                System.out.println("No record found in " + tableName + " for " + filterColumn + " LIKE '%" + filterValue + "%'");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return otp;
	    }

	    // Fetch latest OTP sent to given mobile number from D_SMS table
	    public String connectAndFetchSMS(String mobileNo) {
	        // Optional: small delay if OTP just generated to ensure DB record
	        try {
	            Thread.sleep(3000); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return fetchOtpFromTable("D_SMS", "MobileNo", mobileNo, "MessageText");
	    }

	    // Fetch latest OTP sent to given email ID from D_Email table
	    public String connectAndFetchEmail(String emailId) {
	        try {
	            Thread.sleep(3000); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return fetchOtpFromTable("D_Email", "ToEmailID", emailId, "BodyOfEmail");
	    }

	protected static String enter_mobile = "//input[@id='txtMobileNo']";
	protected static String Verify_mobile = "//button[@id='btnVerifyMobile']";
	protected static String mobile_submit_otp = "//button[@id='VerifyMobileOTP']";

	protected static String enter_emailId = "//input[@id='txtEmailId']";
	protected static String verify_email = "//button[@id='btnVerifyEmail']";
	protected static String email_submit_otp = "//button[@id='VerifyEmailOTP']";

	public void enterMobileNumberAndVerifyBtn(String mobile , String verify_mobile_no) throws IOException, InterruptedException {

		WebElement m = driver.findElement(By.xpath(enter_mobile));
		m.sendKeys(mobile);
		CommanUtill.clickFunction(Verify_mobile, verify_mobile_no);
	}

	public void enterMobileOTPBox(String MOBILEOTP) throws IOException, InterruptedException {

		WebElement otp1 = driver.findElement(By.xpath("//input[@id='MOTP1']"));
		WebElement otp2 = driver.findElement(By.xpath("//input[@id='MOTP2']"));
		WebElement otp3 = driver.findElement(By.xpath("//input[@id='MOTP3']"));
		WebElement otp4 = driver.findElement(By.xpath("//input[@id='MOTP4']"));
		WebElement otp5 = driver.findElement(By.xpath("//input[@id='MOTP5']"));
		WebElement otp6 = driver.findElement(By.xpath("//input[@id='MOTP6']"));
		otp1.sendKeys(MOBILEOTP);
		otp2.sendKeys(MOBILEOTP);
		otp3.sendKeys(MOBILEOTP);
		otp4.sendKeys(MOBILEOTP);
		otp5.sendKeys(MOBILEOTP);
		otp6.sendKeys(MOBILEOTP);

	}

	public void clickSubmitMobileOtpPopup(String filedName) throws IOException, InterruptedException {

		CommanUtill.clickFunction(mobile_submit_otp, filedName);

	}

	public void enterEmailIDAndVerifyBtn(String enter_emailid, String email_verify_button) throws IOException, InterruptedException {

		CommanUtill.textEnter(enter_emailId, enter_emailid);
		Thread.sleep(300);		
		CommanUtill.clickFunction(verify_email, email_verify_button);

	}

	public void enterOTPOnEmailIdBox(String EmailOTP) throws IOException, InterruptedException {

		WebElement otp1 = driver.findElement(By.xpath("//input[@id='EOTP1']"));
		WebElement otp2 = driver.findElement(By.xpath("//input[@id='EOTP2']"));
		WebElement otp3 = driver.findElement(By.xpath("//input[@id='EOTP3']"));
		WebElement otp4 = driver.findElement(By.xpath("//input[@id='EOTP4']"));
		WebElement otp5 = driver.findElement(By.xpath("//input[@id='EOTP5']"));
		WebElement otp6 = driver.findElement(By.xpath("//input[@id='EOTP6']"));
		otp1.sendKeys(EmailOTP);
		otp2.sendKeys(EmailOTP);
		otp3.sendKeys(EmailOTP);
		otp4.sendKeys(EmailOTP);
		otp5.sendKeys(EmailOTP);
		otp6.sendKeys(EmailOTP);

	}

	public void clickSubmitEmailOtpPopup(String email_submit) throws IOException, InterruptedException {

		CommanUtill.clickFunction(email_submit_otp, email_submit);

	}

}
