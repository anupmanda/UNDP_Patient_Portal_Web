/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.testng.page.DoctorAppointmentPage;

/**
 * @author Anup
 *
 * 21-May-2025
 */
   public class DoctorAppointmentTest extends DoctorAppointmentPage {
	 
	   public DoctorAppointmentPage patientAppointment = new DoctorAppointmentPage();
	   
	   
	   @Test(priority = 1)
	   public void PatientAppointment() throws IOException, InterruptedException, InvalidFormatException{
		   
		  logger = extent.createTest("Doctor appointment", "This is the doctor appointment page.");
		  
		 patientAppointment.clickSkipButton("Skip");
		// patientAppointment.createAppointment();
		 Thread.sleep(300);
		 patientAppointment.clickOnDcoctorAppointmentButton("Appointment Booking On Side Icon");
		 Thread.sleep(300);
		 patientAppointment.clickOnCreateAppointmentButton("create_Appointment");
		 Thread.sleep(3000);
		 patientAppointment.selectFacilitySelectDropDwon("Victoria Hospital");
		 patientAppointment.selectDepartmentSelectDropDwon("Cardiology");
		 Thread.sleep(200);
		 patientAppointment.selectDoctorSelectDropDwon("1174");
		//patientAppointment.selectDoctorSelectDropDwon("Dr. Dharwal  Himanshu");
		 patientAppointment.enterDate("14-06-2025");
		 Thread.sleep(500);
		 patientAppointment.clickViewButton("test");
		 Thread.sleep(500);
		 patientAppointment.clickOnSelectTimeSlots();
		 Thread.sleep(300);
		 patientAppointment.clickAppointmentProced("Date picker Conformation button ");
		 Thread.sleep(300);
		 patientAppointment.clickOkPopAppointment("Conformation Ok Button");
		 	 
	   }
	   
	   @Test(priority = 2)
	  public void checkApponintmentHistory() throws IOException, InterruptedException, InvalidFormatException{
		   
		  Thread.sleep(2000);
		  patientAppointment.clickOnApponitmentHistry("Cheek on appointment History");
	      
		 
		   
	   }
	

}
