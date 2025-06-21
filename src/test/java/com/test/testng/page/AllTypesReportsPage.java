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
public class AllTypesReportsPage extends GeneralBrowserSetting{
	
	protected static String skipButton = "//button[@id='skip-btn']";
	protected static String reports= "//a[normalize-space()='Reports']";
	protected static String lab_Reports = "//a[@href='#lab_reports_tab']";
	protected static String diagnostic_Reports = "//a[@href='#diagnostic_reports_tab']";
	protected static String discharge_summary = "//a[@href='#discharge_summary_tab']";
	protected static String vaccination_reports = "//a[normalize-space()='Vaccination Reports']";
	
	public void clickOnSkipButton(String Skip_Button) throws IOException, InterruptedException {
	
			//  driver.findElement(By.xpath(skipButton)).click();
		      CommanUtill.clickFunction(skipButton, Skip_Button);
			
		}
	
	public void clickOnReportsButton(String side_reports) throws IOException, InterruptedException {
		
		//driver.findElement(By.xpath(reports)).click();
		 CommanUtill.clickFunction(reports, side_reports);
	}
	
	public void clickLabReportsButton(String Lab_Reports) throws IOException, InterruptedException{
		
		 //driver.findElement(By.xpath(lab_Reports)).click();
		 CommanUtill.clickFunction(lab_Reports, Lab_Reports);
		
	}
	public void clickDiagnosticReports(String Diagnostic_Reports) throws IOException, InterruptedException{
		
		//driver.findElement(By.xpath(diagnostic_Reports)).click();
		CommanUtill.clickFunction(diagnostic_Reports, Diagnostic_Reports);
		
	}
	
	public void clickDischargeSummary(String Discharge_summary) throws IOException, InterruptedException{
		
		//driver.findElement(By.xpath(discharge_summary)).click();
		CommanUtill.clickFunction(discharge_summary, Discharge_summary);
		
	}
	public void  clickVaccinationReports(String Vaccination_reports) throws IOException, InterruptedException{
		
	    //driver.findElement(By.xpath(vaccination_reports)).click();
	    CommanUtill.clickFunction(vaccination_reports, Vaccination_reports);
	    
	}
		

}
