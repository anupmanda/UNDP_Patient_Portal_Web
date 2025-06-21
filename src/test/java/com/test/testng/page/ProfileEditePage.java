/**
 * 
 */
package com.test.testng.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 * 28-May-2025
 */
     public class ProfileEditePage extends GeneralBrowserSetting{
    	 
    	      protected static String skipButton = "//button[@id='skip-btn']";
    	      protected static String profile = "//li[@id='Dbox4']//a";
    	      protected static String edite = "//i[@class='fa fa-edit']";
    	      protected static String pin_code = "//input[@id='txt_pin']";
    	      protected static String country = "//select[@id='ddlCountry']";
    	      protected static String dis = "//select[@id='ddlState']";
    	      protected static String city = "//select[@id='ddlcity']";
    	      protected static String locality = "//select[@id='txt_Locality']";
    	      protected static String street = "//select[@id='street']";
    	      
    	      protected static String upload_profile = "//label[normalize-space()='Choose File']";
    	      protected static String save = "//a[@id='btnsavedemo']";
    	      protected static String upload_ok_suss = "//a[@id='ReportpopupSecond']";
    	      
    	 
    	 public void clickSkipButton(String  skip) throws IOException, InterruptedException {
    			
    				CommanUtill.clickFunction(skipButton, "Skip Button");
    			//	driver.findElement(By.xpath(skipButton)).click();
    				
    			}
    	 public void clickOnProfileButton(String fieldName)throws IOException, InterruptedException{
    		 
    		 CommanUtill.clickFunction(profile, fieldName);
    		// driver.findElement(By.xpath(profile)).click();
    	 }
    	 
    	 public void clickOnProfileEditeButton(String changeProfile)throws IOException, InterruptedException, InterruptedException{
    		 
    		 CommanUtill.clickFunction(edite, changeProfile);
    		// driver.findElement(By.xpath(edite)).click();
    	 }
    	 
    	public void enterPinCode(String filedName ) throws IOException, InterruptedException,InterruptedException{
    		
    		CommanUtill.textEnter(pin_code,filedName );
    		//WebElement pin = driver.findElement(By.xpath(pin_code));
    		//pin.click();
    		//pin.sendKeys(filedName);	
    	}
    	 
    	public void selectOnCountryDropDwon(String countryDropdwon)throws IOException, InterruptedException, InterruptedException{
    		
    		CommanUtill.dropdownSelectByVisibleText(country, countryDropdwon);
    	//	driver.findElement(By.xpath(country)).click();
    	//	Select contry_country = new Select (driver.findElement(By.xpath(country)));
    	//	contry_country.selectByVisibleText(countryDropdwon);
    		
    		
    	}
    	
	  public void selectOnDistrictDropDwon(String DistrictDropdwon)throws IOException, InterruptedException, InterruptedException{
    		
		  CommanUtill.dropdownSelectByVisibleText(dis, DistrictDropdwon);
    		//driver.findElement(By.xpath(dis)).click();
    		//Select dist = new Select (driver.findElement(By.xpath(dis)));
    		//dist.selectByVisibleText(DistrictDropdwon);
    		
    	}
	
	   public void selectOnCityDropDwon(String cityDropdwon)throws IOException, InterruptedException, InterruptedException{
		
		  CommanUtill.dropdownSelectByVisibleText(city, cityDropdwon); 
		// driver.findElement(By.xpath(city)).click();
		// Select city1 = new Select (driver.findElement(By.xpath(city)));
		// city1.selectByVisibleText(cityDropdwon);
		
	}
	   public void selectOnLocalityDropDwon(String localityDropdwon)throws IOException, InterruptedException, InterruptedException{
   		
		 CommanUtill.dropdownSelectByVisibleText(locality, localityDropdwon);  
   		//driver.findElement(By.xpath(locality)).click();
   		//Select loc = new Select (driver.findElement(By.xpath(locality)));
   		//loc.selectByVisibleText(localityDropdwon);
   		
   	}
	   public void selectOnStreetDropDwon(String streetDropdwon)throws IOException, InterruptedException, InterruptedException{
	   		
		   CommanUtill.dropdownSelectByVisibleText(street, streetDropdwon);
	   		//driver.findElement(By.xpath(street)).click();
	   		//Select st = new Select (driver.findElement(By.xpath(street)));
	   		//st.selectByVisibleText(streetDropdwon);
	   		
	   	}
	   public void clickUploadProfilePic()throws IOException, InterruptedException, InterruptedException, AWTException{
		   
		  // driver.findElement(By.xpath(upload_profile)).click();
		 //  driver.findElement(By.xpath(upload_profile)).sendKeys("C:\\Users\\Anup.DESKTOP-V88DC5U\\Desktop\\Automation\\userProfile.png");
		   
	      WebElement chooseupload = driver.findElement(By.xpath(upload_profile));
			
			Actions act = new Actions(driver);
			act.moveToElement(chooseupload).click().perform();
			
			Robot rb = new Robot();
			rb.delay(2000);
			
			//copy file to clip board
			StringSelection ss = new StringSelection("C:\\Users\\Anup.DESKTOP-V88DC5U\\Desktop\\Automation\\userProfile.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			
			//perform control + v action to past file 
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);

	   }

	   public void ClickOnSaveButton(String submit)throws IOException, InterruptedException, InterruptedException{
		
		   CommanUtill.clickFunction(save, submit);
		  // WebElement save_s = driver.findElement(By.xpath(save));
		 //  save_s.click();
		
	}
	   public void ClickOnOkSuccessfullyUploadPop(String ok)throws IOException, InterruptedException, InterruptedException{
			
		   CommanUtill.clickFunction(upload_ok_suss, ok);
		  // WebElement suss = driver.findElement(By.xpath(upload_ok_suss));
		 //  suss.click();
	   }
   }
