/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.Test;
import com.test.testng.page.AllTypesReportsPage;


/**
 * @author Anup
 *
 * 23-May-2025
 */
public class AllTypesReportsTest extends AllTypesReportsPage {
	 
	public AllTypesReportsPage patientReports = new AllTypesReportsPage();
	
     @Test(priority = 1)
     public void  patientReports () throws IOException, InterruptedException, InvalidFormatException {
 		
    	 logger = extent.createTest("Reports", "This is the all type reports.");
    	 
    	 patientReports.clickOnSkipButton("Skip");
    	 Thread.sleep(3000);
    	 patientReports.clickOnReportsButton("Click on side icon reports");
    	 Thread.sleep(3000);
    	 patientReports.clickLabReportsButton("Lab_Reports");
    	 Thread.sleep(3000);
    	 patientReports.clickDiagnosticReports("Diagnostic_Reports");
    	 Thread.sleep(3000);
    	 patientReports.clickDischargeSummary("Discharge_summary");
    	 Thread.sleep(3000);
    	 patientReports.clickVaccinationReports("vaccination_reports");
    	 
    	 System.out.println("clicked on the all reports now !!!");
    	
    	 
    	
 	}


}
