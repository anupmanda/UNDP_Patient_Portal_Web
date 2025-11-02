/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.readdata.ExcelSheetDataProvider;
import com.test.testng.page.DoctorAppointmentPage;

/**
 * @author Anup
 *
 * 21-May-2025
 */
   public class DoctorAppointmentTest extends DoctorAppointmentPage {
	 
	   public DoctorAppointmentPage patientAppointment = new DoctorAppointmentPage();
	   private final String sheetName = "Create_Appointment";

	    @DataProvider(name = "ExcelUniversalDataProvider")
	    public Object[][] getData() throws IOException {
	        return ExcelSheetDataProvider.getExcelData(sheetName);
	    }

      @Test(dataProvider = "ExcelUniversalDataProvider")    
	   public void PatientAppointment(String facility_drp, String department_drp, String doctor_name , String appointment_date) 
			   throws IOException, InterruptedException, InvalidFormatException{
		   
		  logger = extent.createTest("Doctor appointment", "This is the doctor appointment page.");
		  
		 patientAppointment.clickSkipButton("Skip Button");
		// patientAppointment.createAppointment();
		 Thread.sleep(300);
		 patientAppointment.clickOnDcoctorAppointmentButton("Appointment Booking On Side Icon Button");
		 Thread.sleep(300);
		 patientAppointment.clickOnCreateAppointmentButton("create_Appointment");
		 Thread.sleep(3000);
		 patientAppointment.selectFacilitySelectDropDwon(facility_drp);
		 patientAppointment.selectDepartmentSelectDropDwon(department_drp);
		 Thread.sleep(200);
		// patientAppointment.selectDoctorSelectDropDwon(doctor_name);
		 patientAppointment.enterDate(appointment_date);
	
		//patientAppointment.clickViewButton("test");
		patientAppointment.clickViewButtonAndWait();
		 Thread.sleep(500);
		// patientAppointment.selectFirstAvailableGreenSlot();
		/*Thread.sleep(300);
		 patientAppointment.clickAppointmentProced("Date picker Conformation button ");
		 Thread.sleep(300);
		 patientAppointment.clickOkPopAppointment("Conformation Ok Button");
		*/ 	 
	   }
	   
	//   @Test(priority = 2)
	  public void checkApponintmentHistory() throws IOException, InterruptedException, InvalidFormatException{
		   
		  Thread.sleep(2000);
		  patientAppointment.clickOnApponitmentHistry("Cheek on appointment History");
	      
		 
		   
	   }
	

}
