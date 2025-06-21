/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;

import org.openqa.selenium.By;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 * 23-May-2025
 */
public class PrescriptionPage extends GeneralBrowserSetting {
	
	protected static String skipButton = "//button[@id='skip-btn']";
	protected static String  prescription = "//a[@href='/eHealth_Portal_Performance/Prescription/Prescriptionpatient']";
	protected static String view_pre = "//tbody/tr[5]/td[6]/img[1]";
	
	protected static String pre_dwonload_page = "//tbody/tr[5]/td[6]/img[2]";
	protected static String download_pre_pop_close = "//a[@id='closesave']";
	
	
	 public void clickSkipButton(String filed_name) throws IOException, InterruptedException {
			
				CommanUtill.clickFunction(skipButton, filed_name);
				//driver.findElement(By.xpath(skipButton)).click();
				
	       }
	 public void clickOnprescriptionButton(String filed_name) throws IOException, InterruptedException{
		 
		 CommanUtill.clickFunction(prescription, filed_name);
		 //driver.findElement(By.xpath(prescription)).click();
	 }
	 
	 public void clickOnViewbuttonViewPage(String filed_name) throws IOException, InterruptedException{
		 
		 CommanUtill.clickFunction(view_pre, filed_name);
		// driver.findElement(By.xpath(view_pre)).click();
		 
	 }
	 //____________________________________DwonLoad_______________________________________________________________________
	 
	 public void clickOnDwonloadButton(String filed_name) throws IOException, InterruptedException{
		 
		// driver.findElement(By.xpath(pre_dwonload_page)).click();
		 CommanUtill.clickFunction(pre_dwonload_page, filed_name);
	 }
	 
	 public void clickOnDwonloadPageclosePop(String filed_name) throws IOException, InterruptedException{
		 
		 //driver.findElement(By.xpath(download_pre_pop_close)).click();
		 CommanUtill.clickFunction(download_pre_pop_close, filed_name);
		 
	 }
	 
	
	

}
