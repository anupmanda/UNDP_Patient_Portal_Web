/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 * 23-May-2025
 */
   public class PatientVitalAndTrackerPage extends GeneralBrowserSetting{
	   
		protected static String skipButton = "//button[@id='skip-btn']";
		//protected static String vital_tracker = "//a[@href='/eHealth_SIT/Vital/Vital']";
		protected static String vital_tracker = "//li[@id='box13']//a[normalize-space()='Vital And Tracker']";
		protected static String temperature = "//div[@id='vitalTemp_1']//div[@class='vitalTemp']//div//i[@class='fa fa-angle-right']";
		protected static String pulse_rate = "";
		protected static String bp_systolic = "";
		protected static String bp_diastolic = "";
		protected static String respiratory_rate   = "";
		protected static String height = "";
		protected static String weight = "";
		protected static String bmi = "";
		
//__________________________________________________________________Edite_____________________________________________________________
		
		protected static String edite_vital_tracker = "//img[@id='editVitalsAdd']";
		protected static String temperature_edite = "//input[@id='ppvital1']";
		protected static String pulse_rate_edite = "//input[@id='ppvital2']";
		protected static String bp_systolic_edite = "//input[@id='ppvital3']";
		protected static String bp_diastolic_edite = "//input[@id='ppvital4']";
		protected static String respiratory_rate_edite = "//input[@id='ppvital5']";
		protected static String height_edite = "//input[@id='ppvital6']";
		protected static String weight_edite = "//input[@id='ppvital7']";
		protected static String bmi_edite = "//div[@id='vitalTemp_8']//div[@class='inputAnimation1']";
		protected static String edite_save = "//a[@id='btn_SubmitVital']";
		protected static String edite_yes_pop = "//a[@id='btn_vitalpops']";
		protected static String close_pop_aft_save = "//span[@class='AddeedClose']//i[@class='fa fa-times']";
			
		
		
		
		public void skipAllNotification(String skip)throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(skipButton, skip);
			//driver.findElement(By.xpath(skipButton)).click();
			
		}
		
		public void clickVitalAndTreackerButton(String side)throws IOException, InterruptedException{
			
		    CommanUtill.clickFunction(vital_tracker, side);
			//driver.findElement(By.xpath(vital_tracker)).click();
			
		}
		
		public void clickOnTemperature()throws IOException, InterruptedException{
			
			driver.findElement(By.xpath(temperature)).click();
			
		}	
			
//____________________________*********************Edite**********************__________________________________________________			
			
		public void clickOnEditeButtonAllValue(String edite) throws IOException, InterruptedException{
			
				CommanUtill.clickFunction(edite_vital_tracker, edite);
				//driver.findElement(By.xpath(edite_vital_tracker)).click();
				
		}
		public void enterEditeTem(String vaueTemperature ) throws IOException, InterruptedException{
				
			CommanUtill.textEnter(temperature_edite, vaueTemperature);
			//  WebElement tem = (driver.findElement(By.xpath(temperature_edite)));
			//   tem.clear();
			//   tem.sendKeys(vaueTemperature);
			   
			}
		public void enterEditePulseRate(String valuePulseRate)throws IOException, InterruptedException{
			
			CommanUtill.textEnter(pulse_rate_edite, valuePulseRate);
			//WebElement pulse_rate = (driver.findElement(By.xpath(pulse_rate_edite)));
		//	pulse_rate.clear();
		//	pulse_rate.sendKeys(valuePulseRate);
			
		}
		public void enterEditeBpSystolic(String valueBPStolic)throws IOException, InterruptedException{
		  
		  CommanUtill.textEnter(bp_systolic_edite, valueBPStolic);
		 // WebElement bp_Systolic = (driver.findElement(By.xpath(bp_systolic_edite)));
		 // bp_Systolic.clear();
		//  bp_Systolic.sendKeys(valueBPStolic);
	  }
		public void enterEditeBpDiastolic(String valueBPdiastolic) throws IOException, InterruptedException{
			
			CommanUtill.textEnter(bp_diastolic_edite, valueBPdiastolic);
		//	WebElement bp_diastolic = (driver.findElement(By.xpath(bp_diastolic_edite)));
		//	bp_diastolic.clear();
		//	bp_diastolic.sendKeys(valueBPdiastolic);
			
		}
		public void enterEditeRespiratoryRate(String valueRespiratoryrate) throws IOException, InterruptedException{
			
			CommanUtill.textEnter(respiratory_rate_edite, valueRespiratoryrate);
		//	WebElement respiratory_rate = (driver.findElement(By.xpath(respiratory_rate_edite)));
		//	respiratory_rate.clear();
		//	respiratory_rate.sendKeys(valueRespiratoryrate);
			
		}
		public void enterEditeHight(String valuehight) throws IOException, InterruptedException{
			
			CommanUtill.textEnter(height_edite, valuehight);
		//	WebElement height_e = (driver.findElement(By.xpath(height_edite)));
		//	height_e.clear();
		//	height_e.sendKeys(valuehight);
			
		}
		public void enterEditeWeight(String valueweight) throws IOException, InterruptedException{
			
			CommanUtill.textEnter(weight_edite, valueweight);
		//	WebElement weight_e = (driver.findElement(By.xpath(weight_edite)));
		//	weight_e.clear();
		//	weight_e.sendKeys(valueweight);
			
		}
		public void clickOnCloseYesPop(String closepop)throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(edite_yes_pop, closepop);
		//	driver.findElement(By.xpath(edite_yes_pop)).click();
			
		}
		public void enterEditeBmi(String calculatebmi) throws IOException, InterruptedException{
			
			CommanUtill.textEnter(bmi_edite, calculatebmi);
			//WebElement bmi_e =(driver.findElement(By.xpath(bmi_edite)));
			//bmi_e.clear();
			//bmi_e.sendKeys(calculatebmi);
			
		}
		
		public void clickOnSaveEditeButton(String save) throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(edite_save, save);
			//driver.findElement(By.xpath(edite_save)).click();
			
		}
		public void clickOnAddedSuccessfullyPop(String closePop) throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(close_pop_aft_save, closePop);
			//driver.findElement(By.xpath(close_pop_aft_save)).click();
		}
 }     
