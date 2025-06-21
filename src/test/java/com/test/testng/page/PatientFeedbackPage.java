/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 * 25-May-2025
 */
      public class PatientFeedbackPage extends GeneralBrowserSetting{
    	  
    	  protected static String skipButton = "//button[@id='skip-btn']";
    	  protected static String feedback = "//a[normalize-space()='Feedback']";
    	  protected static String facility_drop = "//select[@id='ddl_Facility']";
    	  protected static String  visite_facility = "//img[@id='icon2_8']";
    	  protected static String  doctor_consulation = "//img[@id='icon3_12']";
    	  protected static String  satisfaction_leval = "//img[@id='icon3_22']";
    	  protected static String  appointment_booking = "//img[@id='icon3_25']";
    	  protected static String comment = "//input[@id='FeedbackRemark']";
    	  protected static String submit = "//button[@id='saveButton']";
    	  protected static String close_pop = "//button[@id='subOk']";
    	  
    	  
    	  
    	  public void clickOnSkipButton(String skip) throws IOException, InterruptedException {
  			
   		     	CommanUtill.clickFunction(skipButton, skip);
   				//driver.findElement(By.xpath(skipButton)).click();
   	       } 
    	  
    	  public void clickOnFeedbackButton(String feedbackbutton)throws IOException, InterruptedException {
    		  
    		  CommanUtill.clickFunction(feedback, feedbackbutton);
    		//  driver.findElement(By.xpath(feedback)).click();
    		  
    	  }
    	  
    	  public void selectOnSelectFacility(String dropdwonfacility)throws IOException, InterruptedException{
    		  
    		  CommanUtill.dropdownSelectByValue(facility_drop, dropdwonfacility);
    		//  Select facility = new Select (driver.findElement(By.xpath(facility_drop)));
    		//  facility.selectByValue(dropdwonfacility);
    		
    		  
    	  }
    	  public void clickVisiteFacility(String vist)throws IOException,InterruptedException{
    		  
    		  driver.findElement(By.xpath("//button[contains(text(),'1 How was your experience during your visit to our')]")).click();
    		//  driver.findElement(By.xpath(visite_facility)).click();
    		  CommanUtill.clickFunction(visite_facility, vist);
    	  }
    	  
         public void clickDoctorConsulation(String consulation)throws IOException,InterruptedException{
        	 
    		  driver.findElement(By.xpath("//button[contains(text(),'2 How do you rate your experience in regard to doc')]")).click();
    		 // driver.findElement(By.xpath(doctor_consulation)).click();
    		  CommanUtill.clickFunction(doctor_consulation, consulation);
    		  
    	  }
    	  
         public void clickSatisfactionLeval(String satisfaction)throws IOException, InterruptedException{
        	 
        	 driver.findElement(By.xpath("//button[contains(text(),'3 Are you satisfied with the service? Rate your sa')]")).click();
        	// driver.findElement(By.xpath(satisfaction_leval)).click();
        	 CommanUtill.clickFunction(satisfaction_leval, satisfaction);
        	 
         }
         
         public void clickAppointmentBooking(String booking) throws IOException, InterruptedException{
        	 
        	 driver.findElement(By.xpath("//button[contains(text(),'4 How was your experience during online appointmen')]")).click();
        	// driver.findElement(By.xpath(appointment_booking)).click();
        	 CommanUtill.clickFunction(appointment_booking, booking);
        	 
         }
         
    	 public void enterCommentTextBox(String text)throws IOException, InterruptedException{
    		
    		 CommanUtill.textEnter(comment, text);
    	//	WebElement comment_text = driver.findElement(By.xpath(comment));
    		//comment_text.clear();
    	//	comment_text.sendKeys(text);
    		
    	 }
    	 public void clickOnSubmitButton(String sub) throws IOException, InterruptedException{
    		 
    		CommanUtill.clickFunction(submit, sub);
    		// driver.findElement(By.xpath(submit)).click();
    		 
    	 }
    	 public void clickFeedbackSubmittedPop(String close) throws IOException, InterruptedException{
    		 
    	     CommanUtill.clickFunction(close_pop, close);
    		// driver.findElement(By.xpath(close_pop)).click();
    		 
    	 }

      }
