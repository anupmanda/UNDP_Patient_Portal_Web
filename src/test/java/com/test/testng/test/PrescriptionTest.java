/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.testng.page.PrescriptionPage;

/**
 * @author Anup
 *
 * 23-May-2025
 */
  public class PrescriptionTest extends PrescriptionPage {
	  
	  public PrescriptionPage doctorprescription = new PrescriptionPage();
	  
	  @Test()
	  
	  public void viewDwonloadDoctorPrescription() throws IOException, InterruptedException, InvalidFormatException{
		  
		  logger = extent.createTest("Doctor prescription", "This is the doctor prescription page.");
		  doctorprescription.clickSkipButton("Skip button");
		  Thread.sleep(5000);
		  doctorprescription.clickOnprescriptionButton("Click On Side Icon prescription button");
		  Thread.sleep(5000);
		  doctorprescription.clickOnViewbuttonViewPage("View prescription page");      //Only VIEW
		  Thread.sleep(5000);
		  doctorprescription.clickOnDwonloadButton("prescription Download Successfuly");
		  Thread.sleep(5000);
		  doctorprescription.clickOnDwonloadPageclosePop("Download prescription close");
		  
		  System.out.println("clicked on the doctor prescription !!");
	  }
	

}
