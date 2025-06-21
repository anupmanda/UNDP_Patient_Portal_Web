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
 * 24-May-2025
 */
    public class PatientExternalDocumentPage extends GeneralBrowserSetting {
    	
    	protected static String skipButton = "//button[@id='skip-btn']";
    	protected static String external_document = "//a[normalize-space()='Patient External Doc...']";
    	protected static String upload_document_button = "//div[@class='BTNLapUD']//a[@id='btnuploadPop']";
    	protected static String document_name = "//input[@id='docName']";
    	protected static String category_type = "//select[@id='ddlUpload']";
    	protected static String choose_file = "//input[@id='myfile']";
    	protected static String uploadfile = "//a[@id='closeDocumen']";
    	
   //________________________________View and DOWNLoad______________________________________________ 	
    	
    	protected static String category = "//select[@id='ddlCategList']";
    	protected static String view = "//tbody/tr[2]/td[5]/a[1]/img[1]";
    	protected static String downlod = "//tbody/tr[3]/td[5]/a[2]/img[1]";
    	
    	
    	  public void clickSkipButton(String skip) throws IOException, InterruptedException {
    			
    				CommanUtill.clickFunction(skipButton, skip);
    				//driver.findElement(By.xpath(skipButton)).click();
    	       }
    	  public void clickOnExternalDocumentButton(String external) throws IOException,InterruptedException{
    		  
    		  CommanUtill.clickFunction(external_document, external);
    		//  driver.findElement(By.xpath(external_document)).click();
    		  
    	  }
    	  
    	  public void clickOnUpLoadNewDocumentPop(String newDocumentButton)throws IOException, InterruptedException{
    		  
    		  CommanUtill.clickFunction(upload_document_button, newDocumentButton);
    		// WebElement uploaddoc = (driver.findElement(By.xpath(upload_document_button)));
    		// uploaddoc.click();
    		  
    	  }
    	  
    	 public void enterFileName(String fileName)throws IOException, InterruptedException{
    		 
    		 CommanUtill.textEnter(document_name, fileName);
    		//WebElement filename= (driver.findElement(By.xpath(document_name)));
    		//filename.clear();
    		//filename.sendKeys(fileName);
    		 
    	 }
		public void selectOnSelectCategoryType(String type) throws IOException, InterruptedException{
			
			CommanUtill.dropdownSelectByVisibleText(category_type, type);
		//	Select category = new Select (driver.findElement(By.xpath(category_type)));
		//	category.selectByVisibleText(type);
		
		}
		
		public void clickOnChooseFileUpLoad(String chooseFileDriverImport) throws IOException, InterruptedException, AWTException{
			
			driver.findElement(By.xpath(choose_file)).sendKeys("C:\\Users\\Anup.DESKTOP-V88DC5U\\Desktop\\Automation\\PAS.PNG");
			
			
	/*		WebElement choosefile = driver.findElement(By.xpath(choose_file));
			
			Actions act = new Actions(driver);
			act.moveToElement(choosefile).click().perform();
			
			Robot rb = new Robot();
			rb.delay(2000);
			
			//copy file to clip board
			StringSelection ss = new StringSelection("C:\\Users\\Anup.DESKTOP-V88DC5U\\Desktop\\Automation\\PAS.PNG");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			
			//perform control + v action to past file 
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
	*/		
			
		}
		public void clickOnUploadFileYes(String uploaded) throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(uploadfile, uploaded);
			//driver.findElement(By.xpath(uploadfile)).click();
			
		}
		
	 //_______________________________VIEW AND DOWNLOAD____________________________________________
		
		public void selectOnSelectCategory(String CATEGORY) throws IOException, InterruptedException{
			
			Select category_dropdwon = new Select (driver.findElement(By.xpath(CATEGORY)));
			category_dropdwon.selectByVisibleText(CATEGORY);
			
		}
		
		public void clickOnViewButton(String viewPage) throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(view, viewPage);
			//driver.findElement(By.xpath(view)).click();
			
		}
		
		public void clickOnDownloadButton(String downloadpage) throws IOException, InterruptedException{
			
			CommanUtill.clickFunction(downlod, downloadpage);
			//driver.findElement(By.xpath(downlod)).click();
			
		}
		
		
	   

}
