/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.testng.page.PatientEducationDocumentPage;

/**
 * @author Anup
 *
 * 23-May-2025
 */
   public class PatientEducationDocumentTest extends PatientEducationDocumentPage{
	   
	   public PatientEducationDocumentPage patientEducationDocument = new PatientEducationDocumentPage();
	   
	   @Test
	   public void patientED()throws IOException, InterruptedException, InvalidFormatException{
		   
		   logger = extent.createTest("Patient Education Document", "This is the Patient Education Document page.");
		   patientEducationDocument.clickSkipAllNotification("All notification skip button");
		   Thread.sleep(500);
		   patientEducationDocument.clickPatientEductionDocumentButton("Click Side icon patient education document");
		   Thread.sleep(500);
		   patientEducationDocument.clickOnFilterButtonOpen("Open Filter pop");
		   Thread.sleep(500);
		   patientEducationDocument.selectOnSelectBySort("0");
		   patientEducationDocument.enterFromDate("21-05-2025");
		   Thread.sleep(3000);
		   patientEducationDocument.enterToDate("26-06-2025");
		   Thread.sleep(3000);
		   patientEducationDocument.clickOnApply("filter Apply get data");
		   
		 //  patientEducationDocument.clickOnClearAll("Clear All filter button");
		   Thread.sleep(5000);
		 //  patientEducationDocument.clickOnClosePop("Close Pop");
		   
	   }

}
