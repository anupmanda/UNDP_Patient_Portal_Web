/**
 * 
 */
package com.test.testng.page;


import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
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
	
	 protected static String scheduleTableRows = "//table[@id='scheduleTable']//tr[position()>1]";
	protected static String ok_button = "//button[@id='btn_closepopupapptRU']";
	//_________________________________________________________________________________________________
	
	protected static String Proceed = "//div[contains(text(),'Proceed')]";
	protected static String cancel = "//div[@id='btn_closepopupappt']";
	protected static String history = "//a[normalize-space()='Appointment History']";
	
	public void clickSkipButton(String Skip_Button) throws IOException, InterruptedException {
		
	      CommanUtill.clickFunction(skipButton, Skip_Button);
		
	}
	
	public void clickOnDcoctorAppointmentButton(String appointment) throws IOException, InterruptedException{
		
		CommanUtill.clickFunction(appointment_1, appointment);
		
	}
	public void clickOnCreateAppointmentButton(String  create_Appointment) throws IOException, InterruptedException{
		
		CommanUtill.clickFunction(createAppointment, create_Appointment);
		
	}
	
	public void selectFacilitySelectDropDwon(String facilityName) throws IOException, InterruptedException{
		
	    CommanUtill.dropdownSelectByVisibleText(facility, facilityName);
			
	}
	public void selectDepartmentSelectDropDwon(String departmentName) throws IOException,InterruptedException{
		
		CommanUtill.dropdownSelectByVisibleText(department, departmentName);
		
	}
	public void selectDoctorSelectDropDwon(String doctorName) throws IOException, InterruptedException{
		
		//CommanUtill.dropdownSelectByValue(doctor, doctorName);
		CommanUtill.dropdownSelectByVisibleText(doctor, doctorName);
		
	}
	public void enterDate(String datePick) throws IOException, InterruptedException{
		
		CommanUtill.textEnter(date, datePick);
	/*	
		 String[] parts = date.split("[/\\-]");

		    // normalise day: 02 -> 2
		    String day = parts[0].startsWith("0") ? parts[0].substring(1) : parts[0];

		    String rawMonth = parts[1];
		    String month;
		    // agar number aa raha hai to usko month name me convert karo:
		    if (rawMonth.matches("\\d+")) {
		        // convert 1-based number to month abbreviation
		        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		        month = months[Integer.parseInt(rawMonth)-1];
		    } else {
		        // already month name hai
		        month = rawMonth;
		    }

		    String year = parts[2];

		    // click on date field to open datepicker
		    driver.findElement(By.xpath("//input[@id='dob']")).click();

		    // select year
		    WebElement yearDrop = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		    new Select(yearDrop).selectByVisibleText(year);

		    // select month
		    WebElement monthDrop = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		    new Select(monthDrop).selectByVisibleText(month);

		    // select day
		    List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td[not(contains(@class,'ui-datepicker-other-month'))]"));
		    for (WebElement d : allDates) {
		        if (d.getText().equals(day)) {
		            d.click();
		            break;
		        }
		    }
		    
		    */
		}

	
	public void clickViewButton(String SchudelAllDate) throws IOException,  InterruptedException{
		
		CommanUtill.clickFunction(view, SchudelAllDate);
		
	}
	
	public void clickViewButtonAndWait() throws IOException, InterruptedException {
	
		    // JS click
		    WebElement viewBtn = driver.findElement(By.id("btnViewAppointment"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewBtn);

		    // Wait for popup visible (Selenium 3 style)
		    WebDriverWait wait = new WebDriverWait(driver, 10);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openpopupapptRU")));
		}
	
	  private int selectedRowIndex = -1;
      private int selectedColIndex = -1;
	
	public void selectFirstAvailableGreenSlot() throws IOException, InterruptedException {
   	 
        List<WebElement> rows = driver.findElements(By.xpath(scheduleTableRows));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime now = LocalTime.now();

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String timeText = row.findElement(By.xpath("./td[1]")).getText().trim();
            try {
                LocalTime slotTime = LocalTime.parse(timeText, formatter);
                if (slotTime.isAfter(now)) {
               	 
                    List<WebElement> cells = row.findElements(By.xpath("./td[position()>1]"));
                    for (int j = 0; j < cells.size(); j++) {
                        WebElement cell = cells.get(j);
                        String bgColor = cell.getCssValue("background-color");
                        if (bgColor.contains("135, 235, 135")) { // green slot
                            CommanUtill.scrollIntoView(cell);
                            cell.click();
                            selectedRowIndex = i + 2; // add 2 (1 for header row, 1 for 0-based index)
                            selectedColIndex = j + 2; // skip time column + 0-based index
                            System.out.println("Clicked slot at row " + selectedRowIndex + " col " + selectedColIndex);
                            return;
                        }
                    }
                }
            } catch (DateTimeParseException e) {
                System.out.println("Could not parse time: " + timeText);
            }
        }
        throw new RuntimeException("No available green slot found in future time!");
    }
	
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