/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.testng.page.PatientFeedbackPage;

/**
 * @author Anup
 *
 * 25-May-2025
 */
        public class PatientFeedbackTest extends PatientFeedbackPage{
        	
        	public PatientFeedbackPage freedback = new PatientFeedbackPage();
        	
        	@Test(priority = 1)
        	public void patientFeedBackTC() throws IOException, InterruptedException, InvalidFormatException{
        		
        		logger = extent.createTest("Patient Feedback", "This is the Patient Feedback page.");	
        		freedback.clickOnSkipButton("Click on all notification Skip button.");
        		Thread.sleep(300);
        		freedback.clickOnFeedbackButton("Click on side icon feedback button.");
        		Thread.sleep(500);
        		freedback.selectOnSelectFacility("7");
        		Thread.sleep(3000);
        		freedback.clickVisiteFacility("Click on emoji visite.");
        		Thread.sleep(3000);
        		freedback.clickDoctorConsulation("Click on emoji Doctor Consulation.");
        		Thread.sleep(3000);
        		freedback.clickSatisfactionLeval("Click on emoji Satisfaction leval.");
        		Thread.sleep(3000);
        		freedback.clickAppointmentBooking("Click on emoji Appointment Booking");
        		
        		Thread.sleep(4000);
        		freedback.enterCommentTextBox("THANK YOU ............!");
        		Thread.sleep(4000);
        		freedback.clickOnSubmitButton("Sbumit.");
        		Thread.sleep(4000);
        		freedback.clickFeedbackSubmittedPop("Close pop.");
        		
        		
        	}
        			

    }
