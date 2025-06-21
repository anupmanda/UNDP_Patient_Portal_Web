/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 * 23-May-2025
 */
     public class PatientEducationDocumentPage extends GeneralBrowserSetting {
    	 
    	 protected static String skipButton = "//button[@id='skip-btn']";
    	 protected static String patient_education_document = "//a[normalize-space()='Patient Education Doc...']";
    	 protected static String filter = "//img[@src='/eHealth_Portal_Performance/images/New_icons/filterSearch.svg']";
    	 protected static String filter_slot_dropdwon = "//select[@id='sortBy']";
    	 protected static String from_date = "//input[@id='fromDate']";
    	 protected static String to_date = "//input[@id='toDate']"; 
    	 protected static String apply_all = "//button[@id='btnApply']";
    	 
    	 protected static String clear_all = "//button[@id='btnClearAll']";
    	 protected static String close_pop = "//button[@id='btnClose']"; 
    	 
    	 public void clickSkipAllNotification(String skip) throws IOException, InterruptedException{
    		 
    		 CommanUtill.clickFunction(skipButton, skip);
    		// driver.findElement(By.xpath(skipButton)).click();
    		 
    	 }
    	 
    	 public void clickPatientEductionDocumentButton(String patientEducation) throws IOException, InterruptedException{
    		 
    		 CommanUtill.clickFunction(patient_education_document, patientEducation);
    		// driver.findElement(By.xpath(patient_education_document)).click();
    		 
    	 }
    	 
    	 public void clickOnFilterButtonOpen(String filterOpen) throws IOException ,InterruptedException{
    		 
    		 CommanUtill.clickFunction(filter, filterOpen);
    		 //driver.findElement(By.xpath(filter)).click();
    		 
    	 }
    	 
    	 public void selectOnSelectBySort(String value) throws IOException , InterruptedException{
    		 
    		CommanUtill.dropdownSelectByValue(filter_slot_dropdwon, value);
    		// Select select = new Select (driver.findElement(By.xpath(filter_slot_dropdwon)));
    		// select.selectByValue(OLDNEW);
    		  
    	 }
    	 
    	 public void enterFromDate(String DATE) throws IOException, InterruptedException{
    		 
    		 CommanUtill.textEnter(from_date, DATE);
    		// driver.findElement(By.xpath(from_date)).click();
    		// WebElement fromdate = (driver.findElement(By.xpath(from_date)));
    		// fromdate.sendKeys("DATE");
    		
    	 }
    	 
    	 public void enterToDate(String TODATE) throws IOException, InterruptedException{
    		 
    		  CommanUtill.textEnter(to_date, TODATE);
    		// driver.findElement(By.xpath(to_date)).clear();
    		// driver.findElement(By.xpath(to_date)).sendKeys("TODATE");
    		  
    	 }
    	 public void clickOnApply(String filterApply) throws IOException, InterruptedException{
    		 
    		 CommanUtill.clickFunction(apply_all, filterApply);
    		 //driver.findElement(By.xpath(apply_all)).click();
    		 
    	 }
    	 
    	 public void clickOnClearAll(String allClear)throws IOException, InterruptedException{
    		 
    		 CommanUtill.clickFunction(clear_all, allClear);
    		// driver.findElement(By.xpath(clear_all)).click();
    		 
    	 }
    	 
    	 public void clickOnClosePop(String close) throws IOException, InterruptedException{
    		 
    		 CommanUtill.clickFunction(close_pop, close);
    		//  driver.findElement(By.xpath(close_pop)).click();
    		  
    	 }
    	 
}
