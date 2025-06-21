/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.testng.page.PatientVitalAndTrackerPage;

/**
 * @author Anup
 *
 * 24-May-2025
 */
  public class PatientVitalAndTrackerTest extends PatientVitalAndTrackerPage {
	
	public PatientVitalAndTrackerPage patientValueVitalTracker = new PatientVitalAndTrackerPage();
	
	@Test(priority=2)
	public void vitalAndTracker()throws IOException, InterruptedException, InvalidFormatException{
		
		logger = extent.createTest("Patient Vital And Tracker", "Graph.");	
		//patientValueVitalTracker.skipAllNotification("Close Skip button.");	
		Thread.sleep(500);
		//patientValueVitalTracker.clickVitalAndTreackerButton("Click on side icon vital and tracker");
		
	//	patientValueVitalTracker.clickOnTemperature();
	}	
//_________________________Edite__________________________________
	
		@Test(priority=1)
		public void vitalAndTrackerEdite() throws IOException, InterruptedException, InvalidFormatException{
		
		logger = extent.createTest("Patient Vital And Tracker", "Vitals Entered With Normal Values.");	
		patientValueVitalTracker.skipAllNotification("Close Skip button.");
		patientValueVitalTracker.clickVitalAndTreackerButton("Click on side icon vital and tracker");
		patientValueVitalTracker.clickOnEditeButtonAllValue("Click on edite button vital and tracker.");
		Thread.sleep(300);
		patientValueVitalTracker.enterEditeTem("97");
		Thread.sleep(3000);
		patientValueVitalTracker.enterEditePulseRate("70");
		Thread.sleep(3000);
		patientValueVitalTracker.enterEditeBpSystolic("118");
		Thread.sleep(3000);
		patientValueVitalTracker.enterEditeBpDiastolic("82");
		Thread.sleep(3000);
		patientValueVitalTracker.enterEditeRespiratoryRate("15");
		Thread.sleep(3000);
		patientValueVitalTracker.enterEditeHight("160");
		Thread.sleep(3000);
		patientValueVitalTracker.enterEditeWeight("55");
		Thread.sleep(5000);
		patientValueVitalTracker.clickOnCloseYesPop("Click and conform you, sure ok button.....");
		Thread.sleep(300);
		patientValueVitalTracker.clickOnSaveEditeButton("Click save button.");
		Thread.sleep(300);
		patientValueVitalTracker.clickOnAddedSuccessfullyPop("Close conform pop.......");
		
	}
}
