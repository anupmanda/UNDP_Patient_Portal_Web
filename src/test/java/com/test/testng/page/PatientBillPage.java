/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;

import org.openqa.selenium.By;

import com.test.browser.setup.GeneralBrowserSetting;

/**
 * @author Anup
 *
 * 23-May-2025
 */
 public class PatientBillPage extends GeneralBrowserSetting {
	
	protected static String skipButton = "//button[@id='skip-btn']";
	protected static String bill = "//a[normalize-space()='Bills']";
	protected static String opd_Bill = "//a[normalize-space()='OPD Bill']";
	protected static String desc_asce_order = "//th[@aria-label='Sr. No.: activate to sort column descending: activate to sort column descending']";
	protected static String billtable = "//div[@id='OPD_Department_Bill']//div[@class='bill-table']";
	protected static String viewbill = "//tbody/tr[5]/td[5]/img[1]";
	protected static String  downloadbill = "//tbody/tr[5]/td[5]/img[2]";
	
	//_________________________IPD__________________________________________________________________________________________________
	protected static String ipd_button = "//a[normalize-space()='IPD Bill']";
	
   public void clickSkipButton() throws IOException, InterruptedException {
		
		//	CommanUtill.clickFunction(skipButton, "Skip Button");
			driver.findElement(By.xpath(skipButton)).click();
       }
   
   public void clickOnBillButton() throws IOException, InterruptedException {
	    
	   driver.findElement(By.xpath(bill)).click();
	   
   }
   public void clickOnOpdBill()throws IOException, InterruptedException {
	   
	   driver.findElement(By.xpath(opd_Bill)).click();
	   
   }
   public void refreshSetAssDecOrder()throws IOException, InterruptedException {
	   
	   driver.findElement(By.xpath(desc_asce_order)).click();
   }
   public void clickOnBillTable()throws IOException, InterruptedException{
	    
	   driver.findElement(By.xpath(billtable)).click();
	   
   }
   
   public void clickOnViewIconButton() throws IOException, InterruptedException{
	   
	   driver.findElement(By.xpath(viewbill)).click();
		   
	   }
   
   public void clickOnDwonloadBillButton()throws IOException, InterruptedException{
	   
	   driver.findElement(By.xpath(downloadbill)).click();
   }
   
   //_________________________IPD_______________________________________________________________________________________
   
  public void clickOnIpdBillButton()throws IOException, InterruptedException{
	  
	  driver.findElement(By.xpath(ipd_button)).click();
	  
  }

}
