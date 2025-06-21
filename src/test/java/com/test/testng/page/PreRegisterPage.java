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
	
/*	private final By registerNowButtonLink = By.xpath("//button[@id='btnregister']");
	private final By iDType = By.xpath("//select[@id='ddlIdType']");
	private final By iDNo = By.xpath("//input[@id='txtIdNo']");
	private final By title = By.xpath("//select[@id='P_title']");
	private final By surName = By.xpath("//input[@id='txtSurName']");
	private final By othername = By.xpath("//input[@id='txtOtherName']");
	private final By DOB = By.xpath("//input[@id='dob']");
	private final By ageType = By.xpath("//select[@id='age_desc']");
	private final By gender = By.xpath("//select[@id='ddlGender']");
	private final By maritalStatus = By.xpath("//select[@id='ddlMaritalStatus']");
	private final By mobileNumberVerify = By.xpath("//input[@id='txtMobileNo']");
	private final By emailIdVerify  = By.xpath("//input[@id='txtEmailId']");
	private final By house_No_Flat_No_Plot_No = By.xpath("//input[@id='txtsignupPataddress']");
	private final By street = By.xpath("//select[@id='street']");
	private final By locality = By.xpath("//select[@id='ddlLocality']");
	private final By city_Town_Village = By.xpath("//select[@id='ddlCity']");
	private final By district = By.xpath("//select[@id='ddlDistrict']");
	private final By country = By.xpath("//select[@id='ddlCountry']");
	private final By postCode = By.xpath("//input[@id='txtPinCode']");
	private final By checkBox = By.xpath("//input[@id='donorAppCheckbox']");
	private final By clickProceedSubmit = By.xpath("//button[@id='btnProceed']");
*/	
	
	protected static String profile_click = "//img[@src='/eHealth_Portal_Performance/images/profileUser.png']";
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
	
	
	
	
	   public void clickOnSkipButton(String skip) throws IOException, InterruptedException {
		   
		    CommanUtill.clickFunction(skipButton, skip);
	   }
		
		public void clickOnProfilePic(String pic) throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(profile_click, pic);
			Thread.sleep(300);
			CommanUtill.clickFunction(logout, pic);
		}
							
		public void clickOnPre_Registration(String registration)throws IOException, InterruptedException{
			
			
			CommanUtill.clickFunction(registerNowButtonLink, registration);
		}
		
	 
 	public void SelectIdTypeDropDwon(String dropDwonValue) throws IOException, InterruptedException {
 		
 		CommanUtill.dropdownSelectByVisibleText(iDType, dropDwonValue);
       // Select select = new Select(driver.findElement(By.xpath(iDType)));
       // select.selectByVisibleText(dropDwonValue);
        
	}
	public void enterIdNo(String IDNO) throws IOException, InterruptedException{
		
		CommanUtill.textEnter(iDNo, IDNO);
		//driver.findElement(By.xpath(iDNo)).clear();
		//driver.findElement(By.xpath(iDNo)).sendKeys(IDNO);
	}
	
	public void selectTitleDropDwon(String TITLE) throws IOException, InterruptedException{
		
		CommanUtill.dropdownSelectByVisibleText(title, TITLE);
		//Select select = new Select(driver.findElement(By.xpath(title)));
		//select.selectByValue(TITLE);
		//select.selectByVisibleText(TITLE);
	}
		public void enterSurName(String filedName) throws IOException ,InterruptedException{
			
			CommanUtill.textEnter(surName, filedName);
			//driver.findElement(By.xpath(surName)).clear();
			//driver.findElement(By.xpath(surName)).sendKeys(filedName);
		}
		public void enterOtherName(String filedName) throws IOException, InterruptedException{
			
			CommanUtill.textEnter(othername, filedName);
			//driver.findElement(By.xpath(othername)).clear();
			//driver.findElement(By.xpath(othername)).sendKeys(filedName);
			
		}
		
		public void selectdate()throws IOException, InterruptedException{
			
			String year1= "1990";
			String month2 ="Feb";
			String date1 = "21";
			
			driver.findElement(By.xpath("//input[@id='dob']")).click();
			 //select year
			WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			Select selectyear = new Select(year);
			selectyear.selectByVisibleText(year1);
			
			//select month 
			WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			Select selectmonth = new Select(month);
			selectmonth.selectByVisibleText(month2);
			
			//date
			List<WebElement> alldate =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
			
			for(WebElement dat:alldate) {
			if(dat.getText().equals(date1))	{
				dat.click();
				break;
			}
			}
			
		}
		
		public void enterDateOfBrith(int i) throws IOException , InterruptedException{
		String year ="";
		String month ="";
		String Dates ="";
			
		WebElement date_picker = driver.findElement(By.xpath("//input[@id='dob']"));
		date_picker.click();
		 
		 while (true)
		 {
			 String currentmonth=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).getText();
			 String currentyear=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).getText();
			 
			 if(currentmonth.equals(month) && currentyear.equals(year))
           {
	           break;
              }
			// driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();     //next
			 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();    //privious
			
		 }
		 List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		 for(WebElement dt:allDates)
		 {
			 if(dt.getText().equals(Dates))
			 {
				 break;
			 }
		 }
		}
		
		public void enterDob(String DOB) throws IOException, InterruptedException{
			
		//	WebElement dob = driver.findElement(By.xpath(dob_1));
		//	dob.sendKeys(DOB);
		//	dob.click();
			
		//open the date picker
		driver.findElement(By.xpath(dob_1)).click();
		
		WebElement yeardropdwon = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		
		yeardropdwon.click();
		Select year = new Select(yeardropdwon);
		year.selectByVisibleText(DOB);
		
		
		
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		
		monthDropdown.click();
		Select month =new Select(monthDropdown);
		month.selectByVisibleText(DOB);
		
		WebElement datedropdown =driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		datedropdown.click();
		datedropdown.sendKeys("DOB");
	
	 
	 /*	
		 //OPen the date picker Year 
		
		WebElement yearDropDwon = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectyear = new Select(yearDropDwon);
		
		//selectyear.selectByValue(DOB);
		selectyear.selectByVisibleText(DOB);
		
		// OPen the date picker month
		
		WebElement monthropDwon= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select monthDropDwon = new Select(monthropDwon);
		//monthDropDwon.selectByValue(DOB);
		monthDropDwon.selectByVisibleText(DOB);

		//open the date picker Date
		Select date_drp = new Select(driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td")));
		//date_drp.selectByValue(DOB);
		date_drp.selectByVisibleText(DOB);
		
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));	
		for(WebElement els:allDates) {
			String dt=els.getText();
			if(dt.equals(date_drp)) {
				els.click();
				break;
			}
		}
	*/	
		}
	
		public void enterAge(String AGE) throws IOException, InterruptedException{
			
			
			driver.findElement(By.xpath(ageType)).clear();
			driver.findElement(By.xpath(ageType)).sendKeys(AGE);
			
		}
		public void selectGenderSelectDropDwon(String filedName) throws IOException, InterruptedException{
			
			CommanUtill.dropdownSelectByVisibleText(gender, filedName);
			//Select select = new Select(driver.findElement(By.xpath(gender)));
			//select.selectByVisibleText(filedName);
		}
		public void selectMaritalStatusSelectDropDwon(String filedName) throws IOException, InterruptedException{
			
			CommanUtill.dropdownSelectByVisibleText(maritalStatus, filedName);
			//Select select  = new Select (driver.findElement(By.xpath(maritalStatus)));
			//select.selectByVisibleText(filedName);
		}
		
		public void enterMobileNumber(String mobileNo) throws IOException, InterruptedException {   //otpMobileNumberVerify
			
			CommanUtill.textEnter(enter_mobile, mobileNo);
			//driver.findElement(By.xpath(enter_mobile)).clear();
			//Enter Mobile Number
			//WebElement mobileField = driver.findElement(By.xpath(enter_mobile));
			//mobileField.sendKeys(mobileNo);
		}
			
	       public void clickOnVerifyMobile(String verify) throws IOException, InterruptedException {
	    	   
				CommanUtill.clickFunction(Verify_mobile, verify);
				//WebElement verify1 = driver.findElement(By.xpath(Verify_mobile));
				//verify1.click();
				
			}
			
		
		//click on otp verify div[id='VerifyMobileModal'] div[class='col-md-7 OTPSection']
			public void enterMobileOtpVerify (String MOBILEOTP) throws IOException, InterruptedException{
				
			    WebElement enterotp = driver.findElement(By.cssSelector("div[id='VerifyMobileModal'] div[class='col-md-7 OTPSection']"));
			    WebElement otp1 =driver.findElement(By.xpath("//input[@id='MOTP1']"));
			    WebElement otp2 =driver.findElement(By.xpath("//input[@id='MOTP2']"));
			    WebElement otp3 =driver.findElement(By.xpath("//input[@id='MOTP3']"));
			    WebElement otp4 =driver.findElement(By.xpath("//input[@id='MOTP4']"));
			    otp1.sendKeys(MOBILEOTP);
			    otp2.sendKeys(MOBILEOTP);
			    otp3.sendKeys(MOBILEOTP);
			    otp4.sendKeys(MOBILEOTP);
			  
			}
			public void clickSubmitMobileOtpPop(String filedName)throws IOException, InterruptedException{
				
				CommanUtill.clickFunction(mobile_submit_otp, filedName);
				//WebElement submit = driver.findElement(By.xpath(mobile_submit_otp));
				//submit.click();
				
			}
		
		public void enterEmailID(String emailid) throws IOException ,InterruptedException {
			
			CommanUtill.textEnter(enter_emailId, emailid);
			driver.findElement(By.xpath(enter_emailId)).click();
			//Enter Email id
			//WebElement email =driver.findElement(By.xpath(enter_emailId));
			//email.sendKeys(emailid);
		}
		
			public void clickOnVerifyEmailButton(String email_verify_button) throws IOException, InterruptedException {
				
				CommanUtill.clickFunction(verify_email, email_verify_button);
				//WebElement verify = driver.findElement(By.xpath(verify_email));
				//verify.click();
				
			}
			
		public void enterOTPOnEmailIdVerify(String EmailOTP)throws IOException, InterruptedException{
			
			   WebElement otp1 =driver.findElement(By.xpath("//input[@id='EOTP1']")); 
			   WebElement otp2 =driver.findElement(By.xpath("//input[@id='EOTP2']"));
			   WebElement otp3 =driver.findElement(By.xpath("//input[@id='EOTP3']"));
			   WebElement otp4 =driver.findElement(By.xpath("//input[@id='EOTP4']"));
			    otp1.sendKeys(EmailOTP);
			    otp2.sendKeys(EmailOTP);
			    otp3.sendKeys(EmailOTP);
			    otp4.sendKeys(EmailOTP);
		}
		public void clickSubmitEmailOtpPop(String email_submit)throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(email_submit_otp, email_submit);
			//WebElement submit = driver.findElement(By.xpath(email_submit_otp));
			//submit.click();
			
		}
			
        public void enterHouseNoFlatNo(String houseNo) throws IOException ,InterruptedException {
        	
        	CommanUtill.textEnter(house_No_Flat_No_Plot_No, houseNo);
        	//driver.findElement(By.xpath(house_No_Flat_No_Plot_No)).clear();
        	//driver.findElement(By.xpath(house_No_Flat_No_Plot_No)).sendKeys(HOUSENO);
			
		}
		
		public void selectStreetSelectDropDwon(String filed_Name) throws IOException, InterruptedException {
			
			CommanUtill.dropdownSelectByVisibleText(street, filed_Name);
		//	driver.findElement(By.xpath(street)).clear();
		//	Select select  = new Select (driver.findElement(By.xpath(street)));
		//	select.selectByVisibleText(filed_Name);	
			
		}
		public void selectLocalitySelectDropDwon(String filed_Name) throws IOException, InterruptedException{
			
			CommanUtill.dropdownSelectByVisibleText(locality, filed_Name);
			//Select select = new Select (driver.findElement(By.xpath(locality)));
			//select.selectByVisibleText(filed_Name);	
			
		}
		public void selectCityTownVillageSelectDropDown(String city) throws IOException ,InterruptedException{
			
			CommanUtill.dropdownSelectByVisibleText(city_Town_Village, city);
			//Select select = new Select (driver.findElement(By.xpath(city_Town_Village)));
			//select.selectByVisibleText(city);
			
			
		}
		public void selectDistrictSelectDropDwon(String filedNmae) throws IOException, InterruptedException{
			
			CommanUtill.dropdownSelectByVisibleText(district, filedNmae);
			//Select select = new Select (driver.findElement(By.xpath(district)));
			//select.selectByVisibleText(filedNmae);
				
		}
		public void selectCountrySelectDropDwon(String fieldName) throws IOException, InterruptedException {
			
			CommanUtill.dropdownSelectByVisibleText(country, fieldName);
			//Select select = new Select (driver.findElement(By.xpath(country)));
			//.selectByVisibleText(fieldName);
				
		}
		public void EnterPostCode(String filedName) throws IOException, InterruptedException{
			
			CommanUtill.textEnter(postCode, filedName);
			//driver.findElement(By.xpath(postCode)).clear();
			//driver.findElement(By.xpath(postCode)).sendKeys(filedName);
			
		}
		public void selectCheckBox(String CHECKBOX) throws IOException, InterruptedException{
			
			
			//driver.findElement(By.xpath(checkBox)).clear();
			driver.findElement(By.xpath(checkBox)).click();
			
		}
		public void clickProceedButton(String filedName) throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(clickProceedSubmit, filedName);
			//driver.findElement(By.xpath(clickProceedSubmit)).click();
			
		}
		
		public void clickOnRegisterSuccessfullyPop(String Pre_RegistrationNo)throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(pre_reg_button, Pre_RegistrationNo);
		//	driver.findElement(By.xpath(pre_reg_button)).click();
			
		}
			
	}
	
	
	





