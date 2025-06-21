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
 * 21-May-2025
 */
public class DoctorAppointmentPage extends GeneralBrowserSetting {
	
	protected static String skipButton = "//button[@id='skip-btn']";
	protected static String appointment_1 = "//a[normalize-space()='Appointment']";
	protected static String createAppointment = "//a[@class='btn btn-primary btnPortal BTNCreateAP']";
	protected static String facility = "//select[@id='ddlLocation']";
	protected static String department = "//select[@id='ddlSpeciality']";
	protected static String doctor = "//select[@id='ddlDoctor']";
	protected static String date    = "//input[@id='txtdate']";
	protected static String view = "//a[@id='btnViewAppointment']";
	protected static String ok_button = "//button[@id='btn_closepopupapptRU']";
	//_________________________________________________________________________________________________
	
	protected static String Proceed = "//div[contains(text(),'Proceed')]";
	protected static String cancel = "//div[@id='btn_closepopupappt']";
	protected static String history = "//a[normalize-space()='Appointment History']";
	
	public void clickSkipButton(String Skip_Button) throws IOException, InterruptedException {
		
		//  driver.findElement(By.xpath(skipButton)).click();
	      CommanUtill.clickFunction(skipButton, Skip_Button);
		
	}
	
	public void clickOnDcoctorAppointmentButton(String appointment) throws IOException, InterruptedException{
		
		CommanUtill.clickFunction(appointment_1, appointment);
		//driver.findElement(By.xpath(appointment_1)).click();
		
	}
	public void clickOnCreateAppointmentButton(String  create_Appointment) throws IOException, InterruptedException{
		
		CommanUtill.clickFunction(createAppointment, create_Appointment);
		//driver.findElement(By.xpath(createAppointment)).click();
		
	}
	
	public void selectFacilitySelectDropDwon(String facilityName) throws IOException, InterruptedException{
		
	    CommanUtill.dropdownSelectByVisibleText(facility, facilityName);
		//Select select =new Select(driver.findElement(By.xpath(facility)));
		//select.selectByVisibleText(FACILITY);
		
	}
	public void selectDepartmentSelectDropDwon(String departmentName) throws IOException,InterruptedException{
		
		CommanUtill.dropdownSelectByVisibleText(department, departmentName);
		//Select select = new Select(driver.findElement(By.xpath(department)));
		//select.selectByVisibleText(departmentName);
		
	}
	public void selectDoctorSelectDropDwon(String doctorName) throws IOException, InterruptedException{
		
		CommanUtill.dropdownSelectByValue(doctor, doctorName);
		//Select select = new Select(driver.findElement(By.xpath(doctor)));
		//select.selectByValue(doctorName);
		
	
	}
	public void enterDate(String datePick) throws IOException, InterruptedException{
		
		CommanUtill.textEnter(date, datePick);
		//driver.findElement(By.xpath(date)).clear();
		//driver.findElement(By.xpath(date)).sendKeys(datePick);
		
	}
	public void clickViewButton(String SchudelAllDate) throws IOException,  InterruptedException{
		
		CommanUtill.clickFunction(view, SchudelAllDate);
		//driver.findElement(By.xpath(view)).click();
		
	}
/*	 public void selectAppointmentSlots(String Select_Tine) throws IOException, InterruptedException{
		 
		 driver.findElement(By.xpath("//div[@class='bg-white fl']//fieldset[@class='appointment-time-Aarea']")).click();
		 WebElement time = driver.findElement(By.xpath("//li[normalize-space()='12:00 to 13:00']"));
		 time.click();
		// Select sd = new Select (time); 
		//  sd.selectByValue(Select_Tine);
		// sd.selectByVisibleText(Select_Tine);
		
	 }
	 */
	 public void clickOnSelectTimeSlots()throws IOException, InterruptedException{
		 
		 driver.findElement(By.xpath("//div[@class='bg-white fl']//fieldset[@class='appointment-time-Aarea']"));
		 WebElement t = driver.findElement(By.xpath("//li[normalize-space()='19:00 to 20:00']"));
		 t.click();
	 	 
	}
	
	public void clickAppointmentProced(String conformationButton) throws IOException, InterruptedException{
		
	//LOcate procced 
		CommanUtill.clickFunction(Proceed, conformationButton);
		//WebElement Proccedbutton = driver.findElement(By.xpath(Proceed));
		//Proccedbutton.click();
		
	//	WebElement cancelbutton = driver.findElement(By.xpath(cancel));
	//	cancelbutton.clear();
		
	}	
	public void clickOkPopAppointment(String conformationokButton)throws IOException, InterruptedException{
		
		CommanUtill.clickFunction(ok_button, conformationokButton);
		//WebElement ok = driver.findElement(By.xpath("//button[@id='btn_closepopupapptRU']"));
		//ok.click();
	}
    public void clickOnApponitmentHistry(String appointmentHistroy)throws IOException, InterruptedException{
		
    	CommanUtill.clickFunction(history, appointmentHistroy);
		//WebElement history = driver.findElement(By.xpath("//a[normalize-space()='Appointment History']"));
		//history.click();
     }
      
}