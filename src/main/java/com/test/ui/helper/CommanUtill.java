
package com.test.ui.helper;

//import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.relevantcodes.extentreports.LogStatus;
import com.test.browser.setup.GeneralBrowserSetting;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anup
 *
 * Feb 01, 2025
 */
@Slf4j
public class CommanUtill extends GeneralBrowserSetting {

	public String createfolder() throws IOException{

		try {
			SCREENSHOT = readPropertiesFileData("SCREENSHOT");
			String destFile="Screenshots/";
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-sssss");
			String destFolder = dateFormat.format(new Date());

			FOLDER = new File(destFile+ "Screenshot_" +destFolder);
			FOLDER.mkdir();
			System.out.println("Folder created for screenshot, Location : " +FOLDER);
			SUCCESSFOLDERPATH = FOLDER  +"/";

		} catch (Exception e) {
			System.err.println("Unable to create folder : "+e.getMessage());
			e.printStackTrace();
		}
		return SUCCESSFOLDERPATH;
	}

	//This method is for to create folder for extent report
	public String createReportFolder() throws IOException{

		try {
			REPORTS = readPropertiesFileData("REPORTS");
			String destFile="Extents_Reports/HTML_Report/";
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-sssss");
			String destFolder = dateFormat.format(new Date());

			FOLDER = new File(destFile+ "report_" +destFolder);
			FOLDER.mkdir();
			System.out.println("Folder created for Reports, Location : " +FOLDER);
			REPORTS_FOLDER = FOLDER  +"/";

		} catch (Exception e) {
			System.err.println("Unable to create folder : "+e.getMessage());
			e.printStackTrace();
		}
		return REPORTS_FOLDER;
	}

	//this function is not in use
	public String successCreateFolder() throws IOException{
		try {
			if(SCREENSHOT_PASS.equalsIgnoreCase("Yes")){
				String destFile="Screenshot/Success/";
				DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-sssss");
				String destFolder = dateFormat.format(new Date());

				FOLDER = new File(destFile  +destFolder);
				FOLDER.mkdir();
				System.out.println("Success Screenshot Location : " +FOLDER);
				PASSFOLDERPATH = destFile  +"/"+destFolder;
			}
			else{
				System.out.println("Success screenshot not required !!!");
			}
		} catch (Exception e) {
			System.err.println("Configuration file is not config properly for Success screenshot !!!" +e.getMessage());
			e.printStackTrace();
		}
		return PASSFOLDERPATH;
	}

	public String failCreateFolder() throws IOException{
		try {
			if(SCREENSHOT_FAIL.equalsIgnoreCase("Yes")){
				String destFile="Screenshot/Failure/";
				DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-sssss");
				String destFolder = dateFormat.format(new Date());

				FOLDER = new File(destFile  +destFolder);
				FOLDER.mkdir();
				System.out.println("Failure Screenshot Location : " +FOLDER);
				FAILFOLDERPATH = destFile  +"/"+destFolder;
			}
			else{
				System.out.println("Failed screenshot not required !!!");
			}
		} catch (Exception e) {
			System.err.println("Configuration file is not config properly for Failed screenshot !!!" +e.getMessage());
		}
		return FAILFOLDERPATH;
	}

	public static void passedScreenShotPics(WebDriver driver) throws IOException {

		SCREENSHOT_PASS = readPropertiesFileData("SCREENSHOT_PASS");

		try {
			if(SCREENSHOT_PASS.equalsIgnoreCase("Yes")){
				//File destFile;
				String destFile=""; 
				TakesScreenshot screenshotDriver = (TakesScreenshot)driver;
				File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
				DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");

				destFile = SUCCESSFOLDERPATH+"/Success";
				String destDir = dateFormat.format(new Date()) + ".png";
				FileUtils.copyFile(screenshot, new File(destFile+"/"+destDir));
			}
			else{
				System.out.println("Success screenshot not required !!!");
			}
		}

		catch (Exception e) {
			Assert.fail("Exception while capturing screenshot" +e.getMessage());
		}

	}

	public static void failureScreenShotPics(WebDriver driver) throws IOException{

		SCREENSHOT_FAIL = readPropertiesFileData("SCREENSHOT_FAIL");

		try {
			if(SCREENSHOT_FAIL.equalsIgnoreCase("Yes")){

				String destFile=null;
				TakesScreenshot screenshotDriver = (TakesScreenshot)driver;
				File screenshot=screenshotDriver.getScreenshotAs(OutputType.FILE);
				DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");

				destFile = SUCCESSFOLDERPATH+"/Failure";
				String destDir=dateFormat.format(new Date()) + ".png";
				FileUtils.copyFile(screenshot, new File(destFile+"/"+destDir));
			}
			else{
				System.out.println("Failed screenshot not required !!!");
			}
		} 

		catch (Exception e) {
			Assert.fail("Exception while capturing screen shot" +e.getMessage());
		}

	}
	
	public static void mouseHover(String mouseHover) {
		Actions actions = new Actions(driver);
		WebElement mouseHoverElement = driver.findElement(By.xpath(mouseHover));
		// Perform mouse hover action
        actions.moveToElement(mouseHoverElement).perform();
	}


	// Lunching the URL function
	public void geturl(WebDriver driver, String url) throws IOException, InterruptedException
	{
		int flag = 0;
		boolean status = true;
		try
		{
			Thread.sleep(400);
			System.out.println( "getting the URL ...");
			driver.get(url);
			Thread.sleep(2000);
			System.out.println( "Got the URL ..." +url);

		}
		catch (Exception E)
		{   
			System.out.println(url +": Not able to locate web element...");
			System.out.println("Error while getting the url... " +E.getMessage());
		}  
	}



	// Close the windows function
	public void closewindow(WebDriver driver) throws IOException, InterruptedException
	{
		int flag = 0;
		boolean status = true;
		try
		{
			System.out.println("End the execution...");
			logger.log(Status.INFO, "End the execution...");
			Thread.sleep(10000);
			driver.close();
			System.out.println("Closed the window...");
			logger.log(Status.INFO, "Closed the window...");
		}
		catch (Exception E)
		{   
			System.out.println("Error while closing the window... " +E.getMessage());
			logger.log(Status.INFO, "Error while closing the window... ");
		}    
	}

	// Close All the windows function
	public void closeallwindow(WebDriver driver) throws IOException, InterruptedException
	{
		int flag = 0;
		boolean status = true;
		try
		{
			System.out.println("End all the execution...");
			logger.log(Status.INFO, "End all the execution...");
			Thread.sleep(10000);
			driver.quit();
			System.out.println("Closed the all window...");
			logger.log(Status.INFO, "Closed the all window...");
		}
		catch (Exception E)
		{   
			System.out.println("Error while closing all the window... " +E.getMessage());
			logger.log(Status.INFO, "Error while closing all the window... ");
		}    
	}

	public void explicitwait(WebDriver driver, String xpath){

		try {
			System.out.println("start explicit wait...");
			//WebDriverWait wait = new WebDriverWait(driver, 120);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			System.out.println("end explicit wait...");
		} catch (Exception e) {
			System.out.println("Error while clicking on the webelement..." +e.getMessage());
			//e.printStackTrace();
		}

	}  
	
	//****************************************************************add 07-10-2025
	
	// Common highlight method (for click, text, dropdown)
	public static void highlightElement(WebElement element, String color) {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].style.border='3px solid " + color + "'", element);
	        Thread.sleep(250);
	        js.executeScript("arguments[0].style.border=''", element);
	    } catch (Exception e) {
	        System.out.println("Highlight failed: " + e.getMessage());
	    }
	}

	
	public static void clickFunction(String xmlPath, String fieldName) throws IOException, InterruptedException
	{
	    try
	    {
	        System.out.println("Start Clicking on (" +fieldName+ ")");
	        logger.log(Status.INFO, "Start Clicking on (" +fieldName+ ")");
	        passedScreenShotPics(driver);		//Capturing Screenshot
	        WebElement element = driver.findElement(By.xpath(xmlPath));
	        highlightElement(element, "yellow");
	        element.click();
	        passedScreenShotPics(driver);		//Capturing Screenshot
	        Thread.sleep(300);
	        System.out.println("XPath-->> (" +xmlPath+ " )");
	        logger.log(Status.INFO, "( " +xmlPath +" )");
	        System.out.println("Clicked on (" +fieldName+ ")");
	        logger.log(Status.INFO, "Clicked on (" +fieldName+ ")");
	        log.info("Clicked on (" +fieldName+ ")");
	        Thread.sleep(300);
	    }
	    catch (Exception E)
	    {   
	        System.out.println(xmlPath +": Not able to locate web element for field (" +fieldName+ ")");
	        logger.log(Status.INFO, xmlPath +": Not able to locate web element...");
	        failureScreenShotPics(driver);		//Capturing Screenshot
	        logger.log(Status.FAIL, xmlPath +": Not able to locate web element for field (" +fieldName+ ")");
	        System.out.println("Error while Clicking on the web element... " +E.getMessage());
	        Assert.fail("Error while Clicking on the web element... ");
	    }  
	}

	
	//***************************************************************
	
	
	
/*

	// Normal click function with field description
	public static void clickFunction(String xmlPath, String fieldName) throws IOException, InterruptedException
	{
		try
		{
			System.out.println("Start Clicking on (" +fieldName+ ")");
			logger.log(Status.INFO, "Start Clicking on (" +fieldName+ ")");
			passedScreenShotPics(driver);		//Capturing Screenshot
			driver.findElement(By.xpath(xmlPath)).click();
			passedScreenShotPics(driver);		//Capturing Screenshot
			Thread.sleep(300);
			System.out.println("XPath-->> (" +xmlPath+ " )");
			logger.log(Status.INFO, "( " +xmlPath +" )");
			System.out.println("Clicked on (" +fieldName+ ")");
			logger.log(Status.INFO, "Clicked on (" +fieldName+ ")");
			log.info("Clicked on (" +fieldName+ ")");
			//logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
			Thread.sleep(300);

		}
		catch (Exception E)
		{   
			System.out.println(xmlPath +": Not able to locate web element for field (" +fieldName+ ")");
			logger.log(Status.INFO, xmlPath +": Not able to locate web element...");
			failureScreenShotPics(driver);		//Capturing Screenshot
			logger.log(Status.FAIL, xmlPath +": Not able to locate web element for field (" +fieldName+ ")");
			System.out.println("Error while Clicking on the web element... " +E.getMessage());
			//logger.log(Status.FAIL, MarkupHelper.createLabel("Test Case Passed is failTest", ExtentColor.RED));
			Assert.fail("Error while Clicking on the web element... ");
		}  
	}
	
	*/
	
	// Normal click function with field description
	public static void click(String xmlPath, String fieldName) throws IOException, InterruptedException
	{
		try
		{
			System.out.println("Start Clicking on (" +fieldName+ ")");
			log.info(("Start Clicking on (" +fieldName+ ")"));
			passedScreenShotPics(driver);		//Capturing Screenshot
			driver.findElement(By.xpath(xmlPath)).click();
			passedScreenShotPics(driver);		//Capturing Screenshot
			System.out.println("XPath-->> (" +xmlPath+ " )");
			log.info("( " +xmlPath +" )");
			System.out.println("Clicked on (" +fieldName+ ")");
			log.info("Clicked on (" +fieldName+ ")");
			//logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));

		}
		catch (Exception E)
		{   
			System.out.println(xmlPath +": Not able to locate web element for field (" +fieldName+ ")");
			log.info((xmlPath +": Not able to locate web element..."));
			failureScreenShotPics(driver);		//Capturing Screenshot
			log.info((xmlPath +": Not able to locate web element for field (" +fieldName+ ")"));
			System.out.println("Error while Clicking on the web element... " +E.getMessage());
			//logger.log(Status.FAIL, MarkupHelper.createLabel("Test Case Passed is failTest", ExtentColor.RED));
			Assert.fail("Error while Clicking on the web element... ");
		}  
	}
	
	public static void enter(String xmlPath, String inputText) throws IOException, InterruptedException
	{
		Thread.sleep(500);
		int flag = 0;
		boolean status = true;
		if (inputText.toString().equals("")){
			System.out.println(xmlPath+": No input data");
			log.info("( " +xmlPath+ " ) No input data"); 
			passedScreenShotPics(driver);		//Capturing Screenshot
		}
		else{
			try{
				System.out.println( "Start Entering ...");
				log.info("Start Entering...");
				System.out.println(xmlPath +": Input Data : (" +inputText+ ")");
				log.info(xmlPath +": Input Data : (" +inputText+ ")");
				passedScreenShotPics(driver);		//Capturing Screenshot
				driver.findElement(By.xpath(xmlPath)).clear();
				driver.findElement(By.xpath(xmlPath)).sendKeys(inputText);
				passedScreenShotPics(driver);		//Capturing Screenshot
				System.out.println( "End Entering ...");
				log.info("End Entering...");

			}
			catch (Exception E){
				System.out.println("Error while entering the text... " +E.getMessage());
				System.out.println(xmlPath +": Not able to locate web element...");
				log.info(xmlPath +": Not able to locate web element...");
				failureScreenShotPics(driver);			//Capturing Screenshot
			}

		}
	}
	
	// input text entering method
	public static void textEnter(String xmlPath, String inputText) throws IOException, InterruptedException
	{
		Thread.sleep(500);
		int flag = 0;
		boolean status = true;
		if (inputText.toString().equals("")){
			System.out.println(xmlPath+": No input data");
			logger.log(Status.INFO, " ( " +xmlPath+ " ) No input data"); 
			passedScreenShotPics(driver);		//Capturing Screenshot
		}
		else{
			try{
				System.out.println( "Start Entering ...");
				logger.log(Status.INFO, "Start Entering...");
				System.out.println(xmlPath +": Input Data : (" +inputText+ ")");
				logger.log(Status.INFO, xmlPath +": Input Data : (" +inputText+ ")");
				passedScreenShotPics(driver);		//Capturing Screenshot
				//logger.log(Status.INFO, "Screencast below: " + logger.addScreenCapture("Screenshot/Success/"));	//instead of test use logger 
				driver.findElement(By.xpath(xmlPath)).clear();
				Thread.sleep(500);
				driver.findElement(By.xpath(xmlPath)).sendKeys(inputText);
				Thread.sleep(500);
				passedScreenShotPics(driver);		//Capturing Screenshot
				//logger.log(Status.INFO, "Screencast below: " + logger.addScreenCapture("Screenshot/Success/"));
				System.out.println( "End Entering ...");
				logger.log(Status.INFO, "End Entering...");

			}
			catch (Exception E){
				System.out.println("Error while entering the text... " +E.getMessage());
				System.out.println(xmlPath +": Not able to locate web element...");
				logger.log(Status.FAIL, xmlPath +": Not able to locate web element...");
				failureScreenShotPics(driver);			//Capturing Screenshot
			}

		}
	}
	
	public static void dropdownSelectByVisibleText(String xmlPath, String dropdronText) throws IOException, InterruptedException
	{
		Select select = new Select(driver.findElement(By.xpath(xmlPath)));
		
		Thread.sleep(500);
		int flag = 0;
		boolean status = true;
		if (dropdronText.toString().equals("")){
			System.out.println(xmlPath+": No Dropdwon value");
			logger.log(Status.INFO, " ( " +xmlPath+ " ) No Dropdwon Value"); 
			passedScreenShotPics(driver);		//Capturing Screenshot
		}
		else{
			try
			{
				System.out.println( "Start Selecting ...");
				logger.log(Status.INFO, "Start Selecting...");
				System.out.println(xmlPath +":  Dropdwon Value : (" +dropdronText+ ")");
				logger.log(Status.INFO, xmlPath +":  Dropdwon Value : (" +dropdronText+ ")");
				passedScreenShotPics(driver);		//Capturing Screenshot
				select.selectByVisibleText(dropdronText);
				Thread.sleep(500);
				passedScreenShotPics(driver);		//Capturing Screenshot
				System.out.println( "End Selecting ...");
				logger.log(Status.INFO, "End Selecting...");

			}
			catch (Exception E)
			{	//status = false;
				System.out.println("Error while Selecting the text... " +E.getMessage());
				System.out.println(xmlPath +": Not able to locate web element...");
				logger.log(Status.FAIL, xmlPath +": Not able to locate web element...");
				failureScreenShotPics(driver);			//Capturing Screenshot
				
			}

		}
	}

	
	
	public static void dropdownSelectByValue(String xmlPath, String dropdronValue) throws IOException, InterruptedException
	{
		Select select = new Select(driver.findElement(By.xpath(xmlPath)));
		
		Thread.sleep(500);
		int flag = 0;
		boolean status = true;
		if (dropdronValue.toString().equals("")){
			System.out.println(xmlPath+": No  Dropdwon Value");
			logger.log(Status.INFO, " ( " +xmlPath+ " ) No  Dropdwon Value"); 
			passedScreenShotPics(driver);		//Capturing Screenshot
		}
		else{
			try
			{
				System.out.println( "Start Selecting ...");
				logger.log(Status.INFO, "Start Selecting...");
				System.out.println(xmlPath +":  Dropdwon Value : (" +dropdronValue+ ")");
				logger.log(Status.INFO, xmlPath +":  Dropdwon Value : (" +dropdronValue+ ")");
				passedScreenShotPics(driver);		//Capturing Screenshot
				select.selectByValue(dropdronValue);
				Thread.sleep(500);
				passedScreenShotPics(driver);		//Capturing Screenshot
				System.out.println( "End Selecting ...");
				logger.log(Status.INFO, "End Selecting...");

			}
			catch (Exception E)
			{	//status = false;
				System.out.println("Error while Selecting the text... " +E.getMessage());
				System.out.println(xmlPath +": Not able to locate web element...");
				logger.log(Status.FAIL, xmlPath +": Not able to locate web element...");
				failureScreenShotPics(driver);			//Capturing Screenshot
				
			}

		}
	}

	public static void dropdownSelectByIndex(String xmlPath, int dropdronIndex) throws IOException, InterruptedException
	{
		Select select = new Select(driver.findElement(By.xpath(xmlPath)));
		
		Thread.sleep(500);
		int flag = 0;
			try
			{
				System.out.println( "Start Selecting ...");
				logger.log(Status.INFO, "Start Selecting...");
				System.out.println(xmlPath +":  Dropdwon Index : (" +dropdronIndex+ ")");
				logger.log(Status.INFO, xmlPath +":  Dropdwon Index : (" +dropdronIndex+ ")");
				passedScreenShotPics(driver);		//Capturing Screenshot
				select.selectByIndex(dropdronIndex);
				Thread.sleep(500);
				passedScreenShotPics(driver);		//Capturing Screenshot
				System.out.println( "End Selecting ...");
				logger.log(Status.INFO, "End Selecting...");

			}
			catch (Exception E)
			{	//status = false;
				System.out.println("Error while Selecting the text... " +E.getMessage());
				System.out.println(xmlPath +": Not able to locate web element...");
				logger.log(Status.FAIL, xmlPath +": Not able to locate web element...");
				failureScreenShotPics(driver);			//Capturing Screenshot
				
			}

		}
	

	

	//--------- isDisplay validation ----------------------------
	public void validateElementDisplayed(WebDriver driver, String xmlpath, String fieldName) throws IOException, InterruptedException
	{
		try
		{
			WebElement webinput = driver.findElement(By.xpath(xmlpath));
			String verifyText = webinput.getText();
			verifyText = verifyText.toUpperCase();
			if (webinput.isDisplayed())
			{	
				passedScreenShotPics(driver);
				System.out.println(fieldName +" Element is displayed");
				log.info(fieldName +" Element is displayed");
				logger.log(Status.PASS, fieldName +" Element is displayed");
				//logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
			}
			else
			{
				failureScreenShotPics(driver);
				System.out.println(fieldName +" Element is not displayed");
				log.info(fieldName +" Element is not displayed");
				Assert.fail("Element is not displayed");
				logger.log(Status.INFO, fieldName +" Element is not displayed");
				//logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is failTest", ExtentColor.RED));
			}   
		}
		catch (Exception E)
		{	
			failureScreenShotPics(driver);
			System.out.println("In (" +fieldName + ") and Xpath :(" +xmlpath+ " ) Not able to locate web element: FAILED");
			logger.log(Status.FAIL, xmlpath +": Not able to locate web element...");
		}
	}


	//--------- isEnabled validation ----------------------------
	public void validateElementEnabled(WebDriver driver, String xmlpath, String fieldName) throws IOException, InterruptedException
	{
		try
		{
			WebElement webinput = driver.findElement(By.xpath(xmlpath));
			String verifyText = webinput.getText();
			verifyText = verifyText.toUpperCase();
			if (webinput.isEnabled())
			{	
				passedScreenShotPics(driver);
				System.out.println(fieldName +" Element is enabled");
				log.info(fieldName +" Element is enabled");
				logger.log(Status.PASS, fieldName +" Element is enabled");
			}
			else
			{
				failureScreenShotPics(driver);
				System.out.println(fieldName +" Element is not enabled");
				log.info(fieldName +" Element is not enabled");
				Assert.fail("Element is not enabled");
				logger.log(Status.INFO, fieldName +" Element is not enabled");
			}   
		}
		catch (Exception E)
		{	
			failureScreenShotPics(driver);
			System.out.println("In (" +fieldName + ") and Xpath :(" +xmlpath+ " ) Not able to locate web element: FAILED");
			logger.log(Status.FAIL, xmlpath +": Not able to locate web element...");
		}
	}

	//--------- isSelected validation ----------------------------
	public void validateElementSelected(WebDriver driver, String xmlpath, String fieldName) throws IOException, InterruptedException
	{
		try
		{
			WebElement webinput = driver.findElement(By.xpath(xmlpath));
			String verifyText = webinput.getText();
			verifyText = verifyText.toUpperCase();
			if (webinput.isSelected())
			{	
				passedScreenShotPics(driver);
				System.out.println(fieldName +" Element is selected");
				log.info(fieldName +" Element is selected");
				logger.log(Status.PASS, fieldName +" Element is selected");
			}
			else
			{
				failureScreenShotPics(driver);
				System.out.println(fieldName +" Element is not selected");
				log.info(fieldName +" Element is not selected");
				Assert.fail("Element is not selected");
				logger.log(Status.INFO, fieldName +" Element is not selected");
			}   
		}
		catch (Exception E)
		{	
			failureScreenShotPics(driver);
			System.out.println("In (" +fieldName + ") and Xpath :(" +xmlpath+ " ) Not able to locate web element: FAILED");
			logger.log(Status.FAIL, xmlpath +": Not able to locate web element...");
		}
	}




	//=================================== Start JavaScript Executor Function ======================================================================================

	//JavaScript executor function using both Class Name and Id
	public void entertextjavascriptexecutor(WebDriver driver,String id,String className, int index, String inputText) throws InterruptedException{
		JavascriptExecutor jse=((JavascriptExecutor)driver);

		if (inputText.toString().equals("")){
			System.out.println(": No input data");
		}
		else{

			if(id!=""){
				try {
					System.out.println("start entering the input...");
					jse.executeScript("document.getElementById('"+id+"').value='"+inputText+"';");

					//jse.executeScript("document.getElementById('"+id+"').click();");		//this is for clicking

					System.out.println("end entering the input...");
				} catch (Exception e) {
					System.out.println("error while entering the input..." +e.getMessage());
					//e.printStackTrace();
				}
			}
			if(className!=""){
				Thread.sleep(400);
				//JavascriptExecutor jse=((JavascriptExecutor)driver);

				try {
					System.out.println("start entering the input...");
					jse.executeScript("document.getElementsByClassName('"+className+"')['"+index+"'].value='"+inputText+"';");
					System.out.println("end entering the input...");
				} catch (Exception e) {
					System.out.println("error while entering the input..." +e.getMessage());
					//e.printStackTrace();
				}

			}

		}


	}

	//JavaScript Executor function using class Name, only XPath as a Class name and Id ie index of the class name (If more than one class name is same)need to pass
	public void javaScriptentertextclassname(WebDriver driver, String className,int id, String inputText) throws InterruptedException{
		Thread.sleep(1000);
		JavascriptExecutor jse=((JavascriptExecutor)driver);

		if (inputText.toString().equals("")){
			System.out.println(": No input data");
		}
		else{

			try {
				System.out.println("start entering the input...");
				logger.log(Status.INFO, "start entering the input...");
				jse.executeScript("document.getElementsByClassName('"+className+"')['"+id+"'].value='"+inputText+"';");
				Thread.sleep(600);
				System.out.println("Class Name: " +className+ " and Id: " +id+ " Input Text: " +inputText);
				logger.log(Status.INFO, "Class Name: " +className+ " and Id: " +id+ " Input Text: " +inputText);
				System.out.println("end entering the input...");
				logger.log(Status.INFO, "end entering the input...");
				Thread.sleep(600);
			} catch (Exception e) {
				System.out.println("error while entering the input..." +e.getMessage());
				logger.log(Status.INFO, "error while entering the input...");
				//e.printStackTrace();
			}
		}


	}


	//JavaScript Executor function using ID, only XPath as a ID and Input Text need to pass
	public void javaScriptentertextId(WebDriver driver, String xmlId, String inputText) throws InterruptedException{
		Thread.sleep(1000);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);

		if (inputText.toString().equals("")){
			System.out.println(xmlId +" : No input data");
		}
		else{

			try {
				System.out.println("start entering the input...");
				logger.log(Status.INFO, "start entering the input...");
				jse.executeScript("document.getElementsByClassName('"+xmlId+"').value='"+inputText+"';");
				Thread.sleep(600);
				System.out.println("Class Name: " +xmlId+ " and Input Text: " +inputText);
				logger.log(Status.INFO, "Class Name: " +xmlId+ " Input Text: " +inputText);
				System.out.println("end entering the input...");
				logger.log(Status.INFO, "end entering the input...");
				Thread.sleep(600);
			} catch (Exception e) {
				System.out.println("error while entering the input..." +e.getMessage());
				logger.log(Status.INFO, "error while entering the input...");
				//e.printStackTrace();
			}
		}


	}


	// javascriptexecutor Click; only need to pass ID
	public void javascriptexecutorClick(WebDriver driver, String xmlid){
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		//if(id!=""){
		try {
			System.out.println("start clicking on the object...");

			jse.executeScript("document.getElementById('"+xmlid+"').click();");		//this is for clicking

			System.out.println("end clicking on the object...");
			logger.log(Status.INFO, "end clicking on the object: and Id id: " +xmlid);

		} catch (Exception e) {
			System.out.println("error while clicking on the object..." +e.getMessage());
			logger.log(Status.INFO, "error while Clicking..." +" in this Id: " +xmlid);
			//e.printStackTrace();
		}


	}

	//enter text using javascriptexecutor and using arguments[0]
	public boolean javascriptEnterTextargument(WebDriver driver, String xmlpath, String inputText){

		boolean status = true;	//this was false

		//driver.switchTo().activeElement().sendKeys("123");		//this will enter the value when the object is active
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		try {
			System.out.println("start entering the input..." +xmlpath);

			jse.executeScript("arguments[0].value='"+inputText+"';" +xmlpath);
			Thread.sleep(1000);

			//jse.executeScript("arguments[0].click();",xmlpath);
			//Thread.sleep(1000);

			//jse.executeScript("document.getElementById('"+xmlpath+"').value='"+inputText+"';");
			//Thread.sleep(2000);
			//jse.executeScript("document.getElementById('"+xmlpath+"').click();");		//this is for clicking


			System.out.println("end entering the input...");
		} catch (Exception e) {
			System.out.println("error while entering the input..." +e.getMessage());
			//e.printStackTrace();
		}

		return status;

	}

	//=================================== End JavaScript Executor Function ======================================================================================



	// All text validation, common function
	public void allVisibleTextValidationFunction(WebDriver driver,String xmlPath, String inputdata) throws IOException, InterruptedException
	{
		//logger = report.startTest("VTiger All Text Validation..");

		int flag = 0;
		boolean status = true;
		if (inputdata.toString().equals("")){
			System.out.println(xmlPath+": No input data");
		}
		else{
			try
			{
				Thread.sleep(500);
				System.out.println("Validation Start...");
				logger.log(Status.INFO, "Validation Start...");
				String webPageAvailableElements = null;
				String[] selectInputdata = inputdata.split("##");
				int inputDataSize = selectInputdata.length;
				System.out.println("Input Data value Size >>: " +inputDataSize);
				System.out.println("Input Data Text value >>: " +Arrays.toString(selectInputdata));
				List<WebElement> webPageElements = driver.findElements(By.xpath(xmlPath));
				int webPageElementsSize = webPageElements.size();
				System.out.println("Total Available list Size in Web Page: " +webPageElementsSize);		//this is web Page element size

				for(int i=0; i<webPageElementsSize; i++)
				{   
					for(int j=0; j<inputDataSize; j++)
					{
						webPageAvailableElements = webPageElements.get(i).getText();	//this is actual Web Page application elements
						System.out.println("Web Page Available Text -->> : " +webPageAvailableElements);		//this is will Web Page Elements text value
						//logger.log(Status.INFO, "Web Page Available Text -->> : "+webPageAvailableElements);
						Thread.sleep(1000);
						if((webPageAvailableElements).equalsIgnoreCase(selectInputdata[i]))
						{
							//flag = 0
							System.out.println("Expected-->> "+selectInputdata[i]);
							logger.log(Status.INFO, "Expected-->> "+selectInputdata[i]);
							System.out.println("(" +webPageAvailableElements+ ") is displaying in the web Page:>> PASSED");
							logger.log(Status.PASS, "(" +webPageAvailableElements+ ") is displaying in the web Page:>> PASSED");
							logger.log(Status.INFO, "Actual-->> "+webPageAvailableElements);
							System.out.println("Actual-->> "+webPageAvailableElements);
							Thread.sleep(500);
							break;
						}
						else{
							//flag = 1
							System.out.println("Expected-->> "+selectInputdata[i]);
							logger.log(Status.INFO, "Expected-->> "+selectInputdata[i]);
							System.out.println("(" +webPageAvailableElements+ ") is not displaying in the web Page:>> FAILED");
							logger.log(Status.FAIL, "(" +webPageAvailableElements+ ") is not displaying in the web Page:>> FAILED");
							logger.log(Status.INFO, "Actual-->> "+webPageAvailableElements);
							System.out.println("Actual-->> "+webPageAvailableElements);
						}

						//}
					}
				}
				System.out.println("Validation is complete");
				System.out.println("-------------------------------------------------------------------------------");
				logger.log(Status.INFO,"Validation is complete"); 
				logger.log(Status.INFO,"-------------------------------------------------------------------------------");

			}
			catch (Exception E)
			{	status = false;
			System.out.println("Error --->>" +E.getMessage());
			logger.log(Status.FAIL,"Failed");
			}

		}
	}


	public String getCategory(WebDriver driver, String xmlPath, String inputData) {

		int flag = 0;
		boolean status = true;
		if(inputData.toString().equals("")){
			System.out.println(xmlPath+": No input data");
			log.info(xmlPath+": No input data");
		}
		else{
			try
			{
				Thread.sleep(500);
				System.out.println("Validation Start...");
				log.info("Validation Start...");
				String webPageAvailableElements = null;
				String[] selectInputdata = inputData.split("##");
				int inputDataSize = selectInputdata.length;
				System.out.println("Input Data value Size >>: " +inputDataSize);
				System.out.println("Input Data Text value >>: " +Arrays.toString(selectInputdata));
				List<WebElement> webPageElements = driver.findElements(By.xpath(xmlPath));
				int webPageElementsSize = webPageElements.size();
				System.out.println("Total Available list Size in Web Page: " +webPageElementsSize);		//this is web Page element size

				for(int i=0; i<webPageElementsSize; i++)
				{   
					for(int j=0; j<inputDataSize; j++)
					{
						webPageAvailableElements = webPageElements.get(i).getText();	//this is actual Web Page application elements
						System.out.println("Web Page Available Text -->> : " +webPageAvailableElements);		//this is will Web Page Elements text value
						log.info("Web Page Available Text -->> : "+webPageAvailableElements);
						Thread.sleep(1000);
						if((webPageAvailableElements).equalsIgnoreCase(selectInputdata[i]))
						{
							//flag = 0
							System.out.println("Expected-->> "+selectInputdata[i]);
							log.info("Expected-->> "+selectInputdata[i]);
							System.out.println("(" +webPageAvailableElements+ ") is displaying in the web Page:>> PASSED");
							log.info("(" +webPageAvailableElements+ ") is displaying in the web Page:>> PASSED");
							log.info("Actual-->> "+webPageAvailableElements);
							System.out.println("Actual-->> "+webPageAvailableElements);
							Thread.sleep(500);
							break;
						}
						else{
							//flag = 1
							System.out.println("Expected-->> "+selectInputdata[i]);
							log.info("Expected-->> "+selectInputdata[i]);
							System.out.println("(" +webPageAvailableElements+ ") is not displaying in the web Page:>> FAILED");
							log.info("(" +webPageAvailableElements+ ") is not displaying in the web Page:>> FAILED");
							log.info("Actual-->> "+webPageAvailableElements);
							System.out.println("Actual-->> "+webPageAvailableElements);
						}

						//}
					}
				}
				System.out.println("Validation is complete");
				System.out.println("-------------------------------------------------------------------------------");
				log.info("Validation is complete"); 
				log.info("-------------------------------------------------------------------------------");

			}
			catch (Exception E)
			{	
				status = false;
				System.out.println("Error --->>" +E.getMessage());
				log.info("Failed");
			}

		}
		return inputData;

	}
	
	//------------- Start Drop down text box entering the text function -----------------------------
	public void dropdowntextinputfun(WebDriver driver,String xmlPath, String inputText) throws IOException, InterruptedException
	{
		Thread.sleep(500);
		int flag = 0;
		boolean status = true;
		if (inputText.toString().equals("")){
			System.out.println(xmlPath+": No input data");
			logger.log(Status.INFO, " ( " +xmlPath+ " ) No input data"); 
			passedScreenShotPics(driver);		//Capturing Screenshot
		}
		else{
			try
			{
				System.out.println( "Start Entering ...");
				logger.log(Status.INFO, "Start Entering...");
				System.out.println(xmlPath +": Input Data : (" +inputText+ ")");
				logger.log(Status.INFO, xmlPath +": Input Data : (" +inputText+ ")");
				passedScreenShotPics(driver);		//Capturing Screenshot
				//logger.log(Status.INFO, "Screencast below: " + logger.addScreenCapture("Screenshot/Success/"));	//instead of test use logger 
				//driver.findElement(By.xpath(xmlPath)).clear();
				//Thread.sleep(500);
				driver.findElement(By.xpath(xmlPath)).sendKeys(inputText);
				Thread.sleep(500);
				passedScreenShotPics(driver);		//Capturing Screenshot
				//logger.log(Status.INFO, "Screencast below: " + logger.addScreenCapture("Screenshot/Success/"));
				System.out.println( "End Entering ...");
				logger.log(Status.INFO, "End Entering...");

			}
			catch (Exception E)
			{	//status = false;
				System.out.println("Error while entering the text... " +E.getMessage());
				System.out.println(xmlPath +": Not able to locate web element...");
				logger.log(Status.FAIL, xmlPath +": Not able to locate web element...");
				failureScreenShotPics(driver);			//Capturing Screenshot
				//logger.log(Status.INFO, "Screencast below: " + logger.addScreenCapture("Screenshot/Failure"));
				//println("In (" +fieldName + ") Field >Text Validation: FAILED");
			}

		}
	}

	//------------- END Drop down text box entering the text function -----------------------------


	// Normal click function
	public void clickfun(WebDriver driver, String xmlPath) throws IOException, InterruptedException
	{
		Thread.sleep(600);
		int flag = 0;
		boolean status = true;
		try
		{
			System.out.println( "Start Clicking ...");
			logger.log(Status.INFO, "Start Clicking ...");
			passedScreenShotPics(driver);		//Capturing Screenshot
			driver.findElement(By.xpath(xmlPath)).click();
			passedScreenShotPics(driver);		//Capturing Screenshot
			Thread.sleep(300);
			System.out.println("XPath-->> (" +xmlPath+ " )");
			logger.log(Status.INFO, "( " +xmlPath +" )");
			System.out.println( "End Clicking ...");
			logger.log(Status.INFO, "End Clicking ...");
			Thread.sleep(300);

		}
		catch (Exception E)
		{   
			System.out.println(xmlPath +": Not able to locate web element...");
			//logger.log(Status.INFO, xmlPath +": Not able to locate web element...");
			failureScreenShotPics(driver);		//Capturing Screenshot
			logger.log(Status.FAIL, xmlPath +": Not able to locate web element...");
			System.out.println("Error while Clicking on the web element... " +E.getMessage());
			//Assert.fail("Error while Clicking on the web element... ");
		}  
	}

	// Normal click function with field description
	public void clickfun(WebDriver driver, String xmlPath, String fieldName) throws IOException, InterruptedException
	{
		Thread.sleep(600);
		int flag = 0;
		boolean status = true;
		try
		{
			System.out.println("Start Clicking on (" +fieldName+ ")");
			logger.log(Status.INFO, "Start Clicking on (" +fieldName+ ")");
			passedScreenShotPics(driver);		//Capturing Screenshot
			driver.findElement(By.xpath(xmlPath)).click();
			passedScreenShotPics(driver);		//Capturing Screenshot
			Thread.sleep(300);
			System.out.println("XPath-->> (" +xmlPath+ " )");
			logger.log(Status.INFO, "( " +xmlPath +" )");
			System.out.println("Clicked on (" +fieldName+ ")");
			logger.log(Status.INFO, "Clicked on (" +fieldName+ ")");
			Thread.sleep(300);

		}
		catch (Exception E)
		{   
			System.out.println(xmlPath +": Not able to locate web element for field (" +fieldName+ ")");
			//logger.log(Status.INFO, xmlPath +": Not able to locate web element...");
			failureScreenShotPics(driver);		//Capturing Screenshot
			logger.log(Status.FAIL, xmlPath +": Not able to locate web element for field (" +fieldName+ ")");
			System.out.println("Error while Clicking on the web element... " +E.getMessage());
			//Assert.fail("Error while Clicking on the web element... ");
		}  
	}


	// click function
	public void buttonclickfun(WebDriver driver, String xmlPath) throws IOException, InterruptedException
	{
		Thread.sleep(600);
		int flag = 0;
		boolean status = true;
		try
		{
			System.out.println( "Start Button Clicking ...");
			logger.log(Status.INFO, "Start Button Clicking ...");
			passedScreenShotPics(driver);		//Capturing Screenshot
			driver.findElement(By.xpath(xmlPath)).click();
			Thread.sleep(600);
			System.out.println("XPath-->> (" +xmlPath+ " )");
			logger.log(Status.INFO, "( " +xmlPath +" )");
			System.out.println( "End Button Clicking ...");
			logger.log(Status.INFO, "End Button Clicking ...");
			Thread.sleep(600);

		}
		catch (Exception E)
		{   
			failureScreenShotPics(driver);		//Capturing Screenshot
			System.out.println(xmlPath +": Not able to locate web element...");
			logger.log(Status.FAIL, xmlPath +": Not able to locate web element...");
			System.out.println("Error while Clicking on the web element... " +E.getMessage());
		}  
	}

	// ---------Start Drop Down list click function ----------------------------
	public void dropdownclickfun(WebDriver driver, String xmlPath) throws IOException, InterruptedException
	{
		Thread.sleep(600);
		int flag = 0;
		boolean status = true;
		try
		{
			System.out.println( "Start Drop Down list Clicking ...");
			logger.log(Status.INFO, "Start Drop Down list Clicking ...");
			passedScreenShotPics(driver);		//Capturing Screenshot
			driver.findElement(By.xpath(xmlPath)).click();
			Thread.sleep(300);
			System.out.println("XPath-->> (" +xmlPath+ " )");
			logger.log(Status.INFO, "( " +xmlPath +" )");
			System.out.println( "End Drop Down list Clicking ...");
			logger.log(Status.INFO, "End Drop Down list Clicking ...");
			Thread.sleep(300);

		}
		catch (Exception E)
		{   
			failureScreenShotPics(driver);		//Capturing Screenshot
			System.out.println(xmlPath +": Not able to locate web element...");
			logger.log(Status.FAIL, xmlPath +": Not able to locate web element...");
			System.out.println("Error while Clicking on the web element... " +E.getMessage());
		}  
	}

	// ---------End Drop Down list click function ----------------------------



	// Start switching the windows Handle pop up windows	Switching the windows   
	public void windowhandle(WebDriver driver, String xpath) throws InterruptedException
	{
		String parentBrowser = driver.getWindowHandle();
		String exception = null;

		System.out.println("------------------------------ Start switching the new Windows -----------------------------------------");
		logger.log(Status.INFO,"------------------------------ Start switching the new Windows -----------------------------------------"); 
		Thread.sleep(1000);
		exception = windowHandler(driver, xpath);
	}


	// Window Handling/ switching the frame and maximize the windows  -------------------------------------------
	public String windowHandler(WebDriver driver, String xTitle) throws InterruptedException
	{
		String exception = null;
		try
		{
			Iterator<String> window = driver.getWindowHandles().iterator();
			while(window.hasNext())
			{
				String wh = window.next();
				driver.switchTo().window(wh);
				try
				{
					passedScreenShotPics(driver);		//Capturing Screenshot
					String title = driver.findElement(By.xpath(xTitle)).getText();
					System.out.println( "Window Title: " + title);
					logger.log(Status.INFO,"Window Title: " + title);
					System.out.println( "Window selection done");
					logger.log(Status.INFO, "Window selection done");
					break;
				}
				catch(Exception E)
				{
					//System.out.println("Exception: Window selection " + E);
				}
			}
			driver.manage().window().maximize();
		}
		catch(Exception e)
		{
			logger.log(Status.FAIL, "Not able to locate web element.");
			exception = e.toString();
		}
		Thread.sleep(2000);
		System.out.println("------------------------------ End switching the new Windows -----------------------------------------");
		logger.log(Status.INFO, "------------------------------ End switching the new Windows -----------------------------------------");
		return exception;
	}

	//End switching the windows Handle pop up windows	Switching the windows -------------------------------------------------


	//Change to new active Window
	public void switchToNewActiveWindow(){
		try
		{
			Thread.sleep(15000);
			System.out.println("switch to new window");
			Set <String> handles =driver.getWindowHandles();
			Iterator<String> windows = handles.iterator();
			while (windows.hasNext()){
				String parent = windows.next();
				String newwin = windows.next();
				driver.switchTo().window(newwin);
				driver.manage().window().maximize();
				//driver.navigate().refresh()
				System.out.println("New window is Refreshed");
				driver.switchTo().defaultContent();
			}
		}
		catch(Exception e)
		{
			System.out.println("Browser Exception" +e.getMessage());
		}
	}

	//------- Start Handling Alert Pop up All three Accept, Dismiss and GetText from pop up ---------------------------
	public void alertAcceptPopUpHandle(WebDriver driver, String fieldName) throws IOException{

		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert pop up Title : " +driver.getTitle());
			logger.log(Status.INFO, "Alert pop up Title : " +driver.getTitle());
			passedScreenShotPics(driver);		//Capturing Screenshot
			Thread.sleep(1000);
			alert.accept();
			logger.log(Status.PASS, "Alert pop up is handled : ");

		} catch (Exception e) {
			System.out.println("Alert pop up not able to handle : " +driver.getTitle());
			logger.log(Status.FAIL, "Alert pop up not able to handle : " +driver.getTitle());
			failureScreenShotPics(driver);		//Capturing Screenshot
			e.printStackTrace();
		}

	}

	public void alertDimissPopUpHandle(WebDriver driver, String fieldName) throws IOException{

		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert pop up Title : " +driver.getTitle());
			logger.log(Status.INFO, "Alert pop up Title : " +driver.getTitle());
			passedScreenShotPics(driver);		//Capturing Screenshot
			Thread.sleep(1000);
			alert.dismiss();
			logger.log(Status.PASS, "Alert pop up is cancelled : ");

		} catch (Exception e) {
			System.out.println("Alert pop up not able to handle : " +driver.getTitle());
			logger.log(Status.FAIL, "Alert pop up not able to handle : " +driver.getTitle());
			failureScreenShotPics(driver);		//Capturing Screenshot
			e.printStackTrace();
		}

	}

	public void alertSendTextPopUpHandle(WebDriver driver, String InputText, String fieldName) throws IOException{

		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert pop up Title : " +driver.getTitle());
			logger.log(Status.INFO, "Alert pop up Title : " +driver.getTitle());
			passedScreenShotPics(driver);		//Capturing Screenshot
			Thread.sleep(1000);
			alert.sendKeys(InputText);
			logger.log(Status.PASS, "In the alert pop up entered the input : ");

		} catch (Exception e) {
			System.out.println("Alert pop up not able to enter the text : " +driver.getTitle());
			logger.log(Status.FAIL, "Alert pop up not able to the text : " +driver.getTitle());
			failureScreenShotPics(driver);		//Capturing Screenshot
			e.printStackTrace();
		}

	}

	//------- End Handling Alert Pop up All three Accept, Dismiss and GetText from pop up ---------------------------



	//--------- Start Button validation ----------------------------
	public boolean buttonvalidationfunction(WebDriver driver, String xmlpath, String inputText, String fieldName) throws IOException, InterruptedException
	{
		boolean status = true;	//this was false
		try
		{
			WebElement webinput = driver.findElement(By.xpath(xmlpath));
			String verifyText = webinput.getText();
			verifyText = verifyText.toUpperCase();
			inputText = inputText.toUpperCase();
			verifyText =verifyText.trim();
			inputText = inputText.trim();
			if (verifyText.equalsIgnoreCase(inputText))		//if (webinput.isDisplayed())	//
			{	status = true;
			System.out.println("Expected -->> " +inputText);
			System.out.println("In (" +fieldName + ") Field > Validaton: PASSED");
			System.out.println("Actual -->> " +verifyText);

			logger.log(Status.INFO, "Expected -->> " +inputText);
			logger.log(Status.PASS, "In (" +fieldName + ") Field > Validaton: PASSED");
			logger.log(Status.INFO, "Actual -->> " +verifyText);

			}else{	
				status = false;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: FAILED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.FAIL, "In (" +fieldName + ") Field > Validaton: FAILED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);
			}   
		}
		catch (Exception E){
			status = false;
			System.out.println("In (" +fieldName + ") Not able to locate web element: FAILED");
			logger.log(Status.FAIL, xmlpath +": Not able to locate web element...");
		}

		return status;
	}

	//----------- End Button Validation ---------------------------------------------



	//--------- Start text validation ----------------------------
	public boolean textvalidationfunction(WebDriver driver, String xmlpath, String inputText, String fieldName) throws IOException, InterruptedException
	{
		boolean status = true;
		try
		{
			WebElement webinput = driver.findElement(By.xpath(xmlpath));
			String verifyText = webinput.getText();
			verifyText = verifyText.toUpperCase();
			inputText = inputText.toUpperCase();
			verifyText =verifyText.trim();
			inputText = inputText.trim();
			if (verifyText.equalsIgnoreCase(inputText))	{	
				status = true;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: PASSED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.PASS, "In (" +fieldName + ") Field > Validaton: PASSED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);

			}else{	
				status = false;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: FAILED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.FAIL, "In (" +fieldName + ") Field > Validaton: FAILED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);
			}   
		}
		catch (Exception E){	
			status = false;
			System.out.println("In (" +fieldName + ") and Xpath :(" +xmlpath+ " ) Not able to locate web element: FAILED");
			logger.log(Status.FAIL, xmlpath +": Not able to locate web element...");
		}

		return status;
	}

	//----------- End Text Validation ---------------------------------------------





	//-------- Start Check box validation with Attribute ----------------------------
	public boolean chekboxvalidationfunction(String xmlpath, String attributeText, String inputText, String fieldName) throws IOException, InterruptedException
	{
		boolean status = true;
		try{
			WebElement webinput = driver.findElement(By.xpath(xmlpath));
			String verifyText = webinput.getAttribute(attributeText);
			verifyText = verifyText.toUpperCase();
			inputText = inputText.toUpperCase();
			verifyText =verifyText.trim();
			inputText = inputText.trim();
			if (verifyText.equalsIgnoreCase(inputText)){	
				status = true;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: PASSED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.PASS, "In (" +fieldName + ") Field > Validaton: PASSED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);

			}else{	
				status = false;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: FAILED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.FAIL, "In (" +fieldName + ") Field > Validaton: FAILED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);
			}
		}
		catch (Exception E){	
			status = false;
			System.out.println("In (" +fieldName + ") Not able to locate web element: FAILED");
			logger.log(Status.FAIL, xmlpath +": Not able to locate web element...");
		}

		return status;
	}

	//-------- End Check box validation with Attribute ----------------------------



	//-------- Start Radio Button validation with Attribute ----------------------------
	public boolean radiobuttonvalidationfunction(String xmlpath, String attributeText, String inputText, String fieldName) throws IOException, InterruptedException
	{
		boolean status = true;
		try
		{
			WebElement webinput = driver.findElement(By.xpath(xmlpath));
			String verifyText = webinput.getAttribute(attributeText);
			verifyText = verifyText.toUpperCase();
			inputText = inputText.toUpperCase();
			verifyText =verifyText.trim();
			inputText = inputText.trim();
			if (verifyText.equalsIgnoreCase(inputText))
			{	
				status = true;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: PASSED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.PASS, "In (" +fieldName + ") Field > Validaton: PASSED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);

			}else{	
				status = false;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: FAILED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.FAIL, "In (" +fieldName + ") Field > Validaton: FAILED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);
			}
		}
		catch (Exception E){	
			status = false;
			System.out.println("In (" +fieldName + ") Field > Not able to locate web element: FAILED");
			logger.log(Status.FAIL, xmlpath +": Not able to locate web element...");
		}

		return status;
	}

	//-------- End Radio Button validation with Attribute ----------------------------



	//-------- Start DropDown field validation with Attribute ----------------------------
	public boolean dropdownvalidationfunction(String xmlpath, String attributeText, String inputText, String fieldName) throws IOException, InterruptedException
	{
		boolean status = true;
		try{
			WebElement webinput = driver.findElement(By.xpath(xmlpath));
			String verifyText = webinput.getAttribute(attributeText);
			verifyText = verifyText.toUpperCase();
			inputText = inputText.toUpperCase();
			verifyText =verifyText.trim();
			inputText = inputText.trim();
			if (verifyText.equalsIgnoreCase(inputText))	{	
				status = true;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: PASSED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.PASS, "In (" +fieldName + ") Field > Validaton: PASSED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);

			}else{	
				status = false;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: FAILED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.FAIL, "In (" +fieldName + ") Field > Validaton: FAILED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);
			}
		}
		catch (Exception E){	
			status = false;
			System.out.println("In (" +fieldName + ") Field > Field >Not able to locate web element: FAILED");
			logger.log(Status.FAIL, xmlpath +": Not able to locate web element...");
		}

		return status;
	}

	//-------- End DropDown validation with Attribute ----------------------------


	//-------- Start Date Calendar field validation with Attribute ----------------------------
	public boolean datecalendarvalidationfunction(String xmlpath, String attributeText, String inputText, String fieldName) throws IOException, InterruptedException
	{
		boolean status = true;
		try{
			WebElement webinput = driver.findElement(By.xpath(xmlpath));
			String verifyText = webinput.getAttribute(attributeText);
			verifyText = verifyText.toUpperCase();
			inputText = inputText.toUpperCase();
			verifyText =verifyText.trim();
			inputText = inputText.trim();
			if (verifyText.equalsIgnoreCase(inputText))	{	
				status = true;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: PASSED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.PASS, "In (" +fieldName + ") Field > Validaton: PASSED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);

			}else{	
				status = false;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: FAILED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.FAIL, "In (" +fieldName + ") Field > Validaton: FAILED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);
			}
		}
		catch (Exception E){	
			status = false;
			System.out.println("In (" +fieldName + ") Field >Not able to locate web element: FAILED");
			logger.log(Status.FAIL, xmlpath +": Not able to locate web element...");
		}

		return status;
	}

	//-------- End Date Calendar validation with Attribute ---------------------------- 



	//--------Start Text validation / Default(Single or multi DropDown/Water-mark text/Normal text etc) Text validation with Attribute Value ------------
	public boolean textValuevalidationfunction(WebDriver driver, String xmlpath, String inputText, String fieldName, String attribute) throws IOException, InterruptedException
	{
		boolean status = true;	//this was false
		try{
			WebElement webinput = driver.findElement(By.xpath(xmlpath));
			String verifyText = webinput.getAttribute(attribute);
			verifyText = verifyText.toUpperCase();
			inputText = inputText.toUpperCase();
			verifyText =verifyText.trim();
			inputText = inputText.trim();

			if (verifyText.equalsIgnoreCase(inputText)){   
				status = true;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: PASSED");
				System.out.println("Actual -->> " +verifyText);

				logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.PASS, "In (" +fieldName + ") Field > Validaton: PASSED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);

			}else{  
				status = false;
				System.out.println("Expected -->> " +inputText);
				System.out.println("In (" +fieldName + ") Field > Validaton: FAILED");
				System.out.println("Actual -->> " +verifyText);
				logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is failTest", ExtentColor.RED));

				logger.log(Status.INFO, "Expected -->> " +inputText);
				logger.log(Status.FAIL, "In (" +fieldName + ") Field > Validaton: FAILED");
				logger.log(Status.INFO, "Actual -->> " +verifyText);
			}
		}
		catch (Exception E){	
			status = false;
			System.out.println("In (" +fieldName + ") Field >Not able to locate web element: FAILED");
			logger.log(Status.FAIL, xmlpath +": Not able to locate web element...");
		}
		return status;

	}

	//--------End Text validation with Attribute Value ------------------------------

	//Tab out function just pass the how many tab want to click.
	public void tabout(WebDriver driver, int counte) throws InterruptedException {
		Actions action=new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {
			System.out.println("Tab out Started");
			logger.log(Status.INFO, "Tab out Started");
			Thread.sleep(1000);
			for (int j =0; j<counte ; j++){
				action.sendKeys(Keys.TAB).perform();//1
				Thread.sleep(300);
			}
			System.out.println("Tab out ended");
			logger.log(Status.INFO, "Tab out ended");
		} 
		catch (Exception e) {
			System.out.println("Error occure while tab out..." +e.getMessage());

		}
	}   

	//Page Up function
	public void PageUpfunction(WebDriver driver, int counte) throws InterruptedException {
		Actions action  =new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		System.out.println("Page Up Started");
		Thread.sleep(2000);
		for (int j =0; j<counte ; j++)
		{
			action.sendKeys(Keys.PAGE_UP).perform();//1
			Thread.sleep(200);
		}
		System.out.println("Page Up ended");
	}   

	//Page Down function
	public void PageDownfunction(WebDriver driver, int counte) throws InterruptedException {
		Actions action  =new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		System.out.println("Page Down Started");
		Thread.sleep(2000);
		for (int j =0; j<counte ; j++)
		{
			action.sendKeys(Keys.PAGE_DOWN).perform();//1
			Thread.sleep(200);
		}
		System.out.println("Arrow Page Down ended");
	}  

	//Key Arrow Down function
	public void keyArrowDownfunction(WebDriver driver, int counte) throws InterruptedException {
		Actions action  =new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		System.out.println("Arrow Key Down Started");
		Thread.sleep(2000);
		for (int j =0; j<counte ; j++)
		{
			action.sendKeys(Keys.ARROW_DOWN).perform();//1
			Thread.sleep(200);
		}
		System.out.println("Arrow Key Down ended");
	} 

	//Key Arrow Down function
	public void keyArrowUpfunction(WebDriver driver, int counte) throws InterruptedException {
		Actions action  =new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		System.out.println("Arrow Key Up Started");
		Thread.sleep(2000);
		for (int j =0; j<counte ; j++)
		{
			action.sendKeys(Keys.ARROW_UP).perform();//1
			Thread.sleep(200);
		}
		System.out.println("Arrow Key Up ended");
	} 


	// All text validation, common function
	public void dropdownlistvalidationFunction(WebDriver driver, String xmlPathOne, String xmlPathTwo, String inputdata) throws IOException, InterruptedException
	{
		int flag = 0;
		boolean status = true;
		if (inputdata.toString().equals("")){
			System.out.println(xmlPathOne+": No input data");
		}
		else{
			try{
				Thread.sleep(500);
				System.out.println("Dropdown Validation Start...");
				logger.log(Status.INFO, "Dropdown Validation Start...");
				driver.findElement(By.xpath(xmlPathOne)).click();
				String drodownAvailableElementslist = null;
				String[] selectInputdata = inputdata.split("##");
				int inputDataSize = selectInputdata.length;
				System.out.println("Input Data value Size >>: " +inputDataSize);
				System.out.println("Input Data Text value >>: " +Arrays.toString(selectInputdata));
				xmlPathTwo = xmlPathTwo+"/li";
				List<WebElement> dropdownElements = driver.findElements(By.xpath(xmlPathTwo));
				int dropdownElementsSize = dropdownElements.size();
				System.out.println("Total Available list Size in Dropdown: " +dropdownElementsSize);		//this is dropdown list element size

				for(int i=0; i<dropdownElementsSize; i++){   
					for(int j=0; j<inputDataSize; j++){
						Thread.sleep(450);
						drodownAvailableElementslist = dropdownElements.get(i).getText();	//this is actual Web Page application dropdown elements
						System.out.println("Dropdown list Available Text -->> : " +drodownAvailableElementslist);	//this is Web Page dropdown Elements text value
						//logger.log(Status.INFO, "Web Page dropdown Available Text -->> : "+drodownAvailableElementslist);
						Thread.sleep(200);
						if((drodownAvailableElementslist.trim()).equalsIgnoreCase(selectInputdata[i].trim()))
						{
							//flag = 0
							System.out.println("Expected-->> "+selectInputdata[i]);
							System.out.println("(" +drodownAvailableElementslist+ ") is displaying in the dropdown web Page:>> PASSED");
							System.out.println("Actual-->> "+drodownAvailableElementslist);
							logger.log(Status.INFO, "Expected-->> "+selectInputdata[i]);
							logger.log(Status.PASS, "(" +drodownAvailableElementslist+ ") is displaying in the dropdown web Page:>> PASSED");
							logger.log(Status.INFO, "Actual-->> "+drodownAvailableElementslist);
							Thread.sleep(500);
							break;
						}
						else{
							//flag = 1
							System.out.println("Expected-->> "+selectInputdata[i]);
							System.out.println("(" +drodownAvailableElementslist+ ") is not displaying in the dropdown web Page:>> FAILED");
							System.out.println("Actual-->> "+drodownAvailableElementslist);

							logger.log(Status.INFO, "Expected-->> "+selectInputdata[i]);
							logger.log(Status.FAIL, "(" +drodownAvailableElementslist+ ") is not displaying in the dropdown web Page:>> FAILED");
							logger.log(Status.INFO, "Actual-->> "+drodownAvailableElementslist);

						}
					}
				}
				System.out.println("Dropdown Validation is Done");
				tabout(driver, 1);
				System.out.println("-------------------------------------------------------------------------------");
				logger.log(Status.INFO,"Dropdown Validation is Done"); 
				logger.log(Status.INFO,"-------------------------------------------------------------------------------");

			}
			catch (Exception E){	
				status = false;
				System.out.println("Error --->>" +E.getMessage());
				logger.log(Status.FAIL,"Failed"); 
				//println("In (" +fieldName + ") Field >Text Validaton: FAILED");
			}
		}
	}
	
	 
	 public static boolean isElementPresent(String xpath) {
		    try {
		        return driver.findElement(By.xpath(xpath)).isDisplayed();
		    } catch (NoSuchElementException e) {
		        return false;
		    }
		}

	/**
	 * @param cell
	 */
	public static void scrollIntoView(WebElement cell) {
		// TODO Auto-generated method stub
		
	}
	
	public static String randomAlphabets(int length) {
		
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        return sb.toString();
    }

    public static String randomDigits(int length) {
    	
        String digits = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(digits.charAt(random.nextInt(digits.length())));
        }
        return sb.toString();
    }

}



