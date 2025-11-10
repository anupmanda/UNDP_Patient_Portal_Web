/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 * 20-May-2025
 */
public class PreRegisterPage extends GeneralBrowserSetting {

	
	protected static String profile_click = "//div[@id='viewfamily_div']";
	protected static String logout = "//a[@id='btn_login']";
	protected static String registerNowButtonLink = "//button[@id='btnregister']";

	protected static String iDType = "//select[@id='ddlIdType']";
	protected static String iDNo = "//input[@id='txtIdNo']";
	protected static String title = "//select[@id='P_title']";
	protected static String surName = "//input[@id='txtSurName']";
	protected static String othername = "//input[@id='txtOtherName']";
	protected static String dob_1    = "//input[@id='dob']";
	protected static String ageType = "//select[@id='age_desc']";
	protected static String gender = "//select[@id='ddlGender']";
	protected static String maritalStatus = "//select[@id='ddlMaritalStatus']";

	protected static String enter_mobile = "//input[@id='txtMobileNo']";   //input[@id='txtMobileNo'] 
	protected static String Verify_mobile = "//button[@id='btnVerifyMobile']"; 

	protected static String enter_emailId = "//input[@id='txtEmailId']";
	protected static String verify_email = "//button[@id='btnVerifyEmail']";

	protected static String house_No_Flat_No_Plot_No = "//input[@id='txtsignupPataddress']";  
	protected static String street = "//select[@id='street']";
	protected static String locality = "//select[@id='ddlLocality']";
	protected static String city_Town_Village = "//select[@id='ddlCity']";
	protected static String district = "//select[@id='ddlDistrict']";
	protected static String country = "//select[@id='ddlCountry']";
	protected static String postCode = "//input[@id='txtPinCode']";
	protected static String checkBox = "//input[@id='donorAppCheckbox']";
	protected static String clickProceedSubmit = "//button[@id='btnProceed']";
	protected static String skipButton = "//button[@id='skip-btn']";
	protected static String pre_reg_button = "//button[normalize-space()='Ok']";

	protected static String mobile_submit_otp = "//button[@id='VerifyMobileOTP']"; //button[normalize-space()='Ok']
	protected static String email_submit_otp = "//button[@id='VerifyEmailOTP']";

	public void clickOnSkipButton(String skip_button) throws IOException, InterruptedException {

		//   CommanUtill.clickFunction(skipButton, skip);

		if (CommanUtill.isElementPresent(skipButton)) {
			CommanUtill.clickFunction(skipButton, skip_button);
			System.out.println("Notification appeared and was closed.");
		} else {
			System.out.println("Notification popup did not appear.");
		}
	}  
	public void clickOnProfilePicAndLogout(String pic, String LogOut_Button) throws IOException, InterruptedException{

		CommanUtill.clickFunction(profile_click, pic);
		Thread.sleep(300);
		CommanUtill.clickFunction(logout, LogOut_Button);
	}

	public void clickOnPre_Registration(String registration)throws IOException, InterruptedException{
		
		CommanUtill.clickFunction(registerNowButtonLink, registration);
	}
	public void SelectIdTypeAndIdNumber(String id_type_drp , String Id_Number) throws IOException, InterruptedException {

		CommanUtill.dropdownSelectByVisibleText(iDType, id_type_drp);
		Thread.sleep(300);
		CommanUtill.textEnter(iDNo, Id_Number);
	}
	
	public void selectTitleAndSurNameAndOtherName(String title_drp , String sur_name , String other_name) throws IOException, InterruptedException{

		CommanUtill.dropdownSelectByVisibleText(title, title_drp);
		CommanUtill.textEnter(surName, sur_name);
		CommanUtill.textEnter(othername, other_name);
		
	}
	public void enterDateOfBrith(String date) throws IOException, InterruptedException {
		
	    // expected format: 21/Feb/1990
	    String[] parts = date.split("/");
	    String day = parts[0];
	    String month = parts[1];
	    String year = parts[2];

	    // click on date field to open datepicker
	    driver.findElement(By.xpath("//input[@id='dob']")).click();

	    // select year
	    WebElement yearDrop = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
	    Select selectYear = new Select(yearDrop);
	    selectYear.selectByVisibleText(year);

	    // select month
	    WebElement monthDrop = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
	    Select selectMonth = new Select(monthDrop);
	    selectMonth.selectByVisibleText(month);

	    // select day
	    List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
	    for (WebElement d : allDates) {
	        if (d.getText().equals(day)) {
	            d.click();
	            break;
	        }
	    }
	}


	public void enterDateOfBrith_1(String date) throws IOException, InterruptedException {
	   
	    String[] parts = date.split("[/\\-]");

	  
	    String day = parts[0].startsWith("0") ? parts[0].substring(1) : parts[0];

	    String rawMonth = parts[1];
	    String month;
	   
	    if (rawMonth.matches("\\d+")) {
	        
	        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	        month = months[Integer.parseInt(rawMonth)-1];
	    } else {
	       
	        month = rawMonth;
	    }

	    String year = parts[2];

	    // click on date field to open datepicker
	    driver.findElement(By.xpath("//input[@id='dob']")).click();

	    // select year
	    WebElement yearDrop = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
	    new Select(yearDrop).selectByVisibleText(year);

	    // select month
	    WebElement monthDrop = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
	    new Select(monthDrop).selectByVisibleText(month);

	    // select day
	    List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td[not(contains(@class,'ui-datepicker-other-month'))]"));
	    for (WebElement d : allDates) {
	        if (d.getText().equals(day)) {
	            d.click();
	            break;
	        }
	    }
	}

	public void selectByTypeOfAge(String type_age_drp) throws IOException, InterruptedException{

     CommanUtill.dropdownSelectByVisibleText(ageType, type_age_drp);
	}
	public void selectGenderAndMaritalStatusDrp(String gender_drp, String maritalStatus_drp) throws IOException, InterruptedException{

		CommanUtill.dropdownSelectByVisibleText(gender, gender_drp);
		CommanUtill.dropdownSelectByVisibleText(maritalStatus, maritalStatus_drp);	
	}	
	
	public void enterHouseNoFlatNo(String houseNo) throws IOException ,InterruptedException {

		CommanUtill.textEnter(house_No_Flat_No_Plot_No, houseNo);
	}

	public void selectStreetSelectDropDwon(String filed_Name) throws IOException, InterruptedException {

		CommanUtill.dropdownSelectByVisibleText(street, filed_Name);	
	}
	
	public void DistrictCityVillageAndLocalityDrp(String district_drp , String city_Town_Village_drp , String locality_drp) throws IOException, InterruptedException{

		CommanUtill.dropdownSelectByVisibleText(district, district_drp);
		CommanUtill.dropdownSelectByVisibleText(city_Town_Village, city_Town_Village_drp);
		//CommanUtill.dropdownSelectByVisibleText(locality, locality_drp);

	}
	public void selectByCountrydrp(String country_drp) throws IOException, InterruptedException {

		CommanUtill.dropdownSelectByVisibleText(country, country_drp);
		
	}
	public void EnterPostCode(String enter_postcode) throws IOException, InterruptedException{

		CommanUtill.textEnter(postCode, enter_postcode);	
	}
	public void selectCheckBoxAndProceedBtn(String clickOn_checkBox , String ClickOn_Proced_btn) throws IOException, InterruptedException{

		//driver.findElement(By.xpath(checkBox)).click();
		CommanUtill.clickFunction(checkBox, clickOn_checkBox);
		CommanUtill.clickFunction(clickProceedSubmit, ClickOn_Proced_btn);

	}
	
	public String getPreRegistrationNo() throws IOException, InterruptedException {
		
	    String message = driver.findElement(By.cssSelector("div.modal-body.confirBody")).getText();
	    // extract digits inside square brackets
	    return message.replaceAll(".*\\[(\\d+)\\].*", "$1");
	}

	
	public void OkRegisterMessagePopup(String Pre_RegistrationNo)throws IOException, InterruptedException{

		CommanUtill.clickFunction(pre_reg_button, Pre_RegistrationNo);
		
	}

}
