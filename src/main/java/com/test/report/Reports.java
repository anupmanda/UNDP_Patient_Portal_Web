/**
 * 
 */
package com.test.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.readdata.ReadPropertiesFileData;
import com.test.ui.helper.CommanUtill;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


/**
 * @author anup
 *
 * Feb 01, 2025
 */
public class Reports extends ReadPropertiesFileData {
		
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest logger;
	//public static ExtentSparkReporter sparkReporter;
	
	public static CommanUtill browser = new CommanUtill();
	public static String SCREENSHOT = "";
	public static Logger log = Logger.getLogger("");
	public static String LOG_FILE_PATH;
	
	
	//If we want the report separate class wise then we need to use @BeforeClass annotation method
	@BeforeSuite		
	public static void launch() throws IOException{
		InputStream input = new FileInputStream(PROPERTIES_FILE_PATH);
		properties.load(input);
		SCREENSHOT = readPropertiesFileData("SCREENSHOT");
		
		try {
			if(SCREENSHOT.equalsIgnoreCase("Yes")){
				browser.createfolder();  //Creating a new folder.
				//System.out.println("Screenshot folder created path : ");
			}
			else{
				System.out.println("Screenshot not required !!!");
			}
		} catch (Exception e) {
			System.err.println("Screenshot is not enable in the config file !!!"
					+ "\nPlease enable the Screenshot flag !!!" +e.getMessage());
		}
		
		REPORTS = readPropertiesFileData("REPORTS");
		String destFile=null;
		if(REPORTS.equalsIgnoreCase("Yes") || REPORTS.equalsIgnoreCase("YES")) {
			REPORTS_FOLDER = browser.createReportFolder();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
			destFile = REPORTS_FOLDER+"/";
			String destDir = dateFormat.format(new Date()) + ".html";

			htmlReporter = new ExtentHtmlReporter(destFile + "\\" +"New_Report_"+destDir);
			
		}
		else {
			//if you need only html report then this will generate the html report and need to remove the extent.flush() if statements
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
			destFile = "Extents_Reports/HTML_Report"+"/";
			String destDir = dateFormat.format(new Date()) + ".html";

			htmlReporter = new ExtentHtmlReporter(destFile + "\\" +"New_Report_"+destDir);
		}
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("User Name", "AK");
		extent.setSystemInfo("Anup", "Triotree Report");
		htmlReporter.config().setDocumentTitle("automation extent report"); 
		// Name of the report
		htmlReporter.config().setReportName("Triotree Health Care Report "); 
		// Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
	}
	
	  //This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" 
		                                                    + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;

	}
	@AfterMethod
	public void reportclosewindows() throws IOException, InterruptedException{
		extent.flush();
		/*if(REPORTS.equalsIgnoreCase("Yes") || REPORTS.equalsIgnoreCase("YES")) {
			extent.flush();
		}
		else {
			System.out.println("Please enable the report in properties file for html extent report !!!");
			log.info("Please enable the report in properties file for html extent report !!!");
		}*/
	}

}
