/**
 * 
 */
package com.test.testng.test;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.testng.page.PatientExternalDocumentPage;

/**
 * @author Anup
 *
 * 24-May-2025
 */
    public class PatientExternalDocumentTest extends PatientExternalDocumentPage {
    	
    	public PatientExternalDocumentPage patientExretnaldocu = new PatientExternalDocumentPage();
    	
    	@Test(priority=1)
    	public void patientExternaldoc() throws IOException, InterruptedException, InvalidFormatException, AWTException{
    		
    		logger = extent.createTest("Patient External Document", "This is the patient external document page.");
    		patientExretnaldocu.clickSkipButton("Click all notification skip button");
    		Thread.sleep(500);
    		patientExretnaldocu.clickOnExternalDocumentButton("Click on side iocn external document button ");
    		Thread.sleep(3000);
    		patientExretnaldocu.clickOnUpLoadNewDocumentPop("Click and open new document pop.");
    		Thread.sleep(3000);
    		patientExretnaldocu.enterFileName("Anup");
    		Thread.sleep(200);
    		patientExretnaldocu.selectOnSelectCategoryType("Lab Reports");
    		Thread.sleep(100);
    		patientExretnaldocu.clickOnChooseFileUpLoad("DriverName");
    		Thread.sleep(3000);
    		patientExretnaldocu.clickOnUploadFileYes("Fille uploaded");
    		Thread.sleep(5000);
    	}
   //___________________________VIEW AND DOWNLOAD_____________________________________________ 		
    	@Test(priority=2)	
      public void uploadDocumentViewDwonload() throws IOException, InterruptedException, InvalidFormatException{
    	  
    		logger = extent.createTest("Patient External Document View and Download", "This is the patient external document View and Download page.");
    	//  patientExretnaldocu.clickOnExternalDocumentButton("Click on side iocn external document button ");
    	//  Thread.sleep(3000);
      	//  patientExretnaldocu.selectOnSelectCategory("Lab Reports");
      	//  Thread.sleep(5000);
      	    patientExretnaldocu.clickOnViewButton("Click on view page.");
      	    Thread.sleep(5000);
      	    patientExretnaldocu.clickOnDownloadButton("Click on Download page");
      	    Thread.sleep(3000);
      	  
        }
      }  
      
     	
    	

  
