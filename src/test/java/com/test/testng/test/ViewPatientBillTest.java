/**
 * 
 */
package com.test.testng.test;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.Test;

import com.test.testng.page.PatientBillPage;

/**
 * @author Anup
 *
 * 23-May-2025
 */
public class ViewPatientBillTest extends PatientBillPage {
	 
	public PatientBillPage viewPatientOpdBill = new PatientBillPage();
	
	@Test(priority = 1)
	
	public void viewBill()throws IOException, InterruptedException, InvalidFormatException{
		
		viewPatientOpdBill.clickSkipButton();
		Thread.sleep(1000);
		viewPatientOpdBill.clickOnBillButton();
	    Thread.sleep(2000);
		viewPatientOpdBill.clickOnOpdBill();
		viewPatientOpdBill.refreshSetAssDecOrder();
		viewPatientOpdBill.clickOnBillTable();
	
		viewPatientOpdBill.clickOnViewIconButton();
		Thread.sleep(2000);
		//viewPatientOpdBill.clickOnDwonloadBillButton();
		
		Thread.sleep(1000);
		viewPatientOpdBill.clickOnIpdBillButton();
		
	}

}
