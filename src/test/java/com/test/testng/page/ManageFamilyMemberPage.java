/**
 * 
 */
package com.test.testng.page;

import java.io.IOException;
import java.util.List;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.test.browser.setup.GeneralBrowserSetting;
import com.test.ui.helper.CommanUtill;

/**
 * @author Anup
 *
 *         25-May-2025
 */
public class ManageFamilyMemberPage extends GeneralBrowserSetting {

	protected static String skipButton = "//button[@id='skip-btn']";
	protected static String manage_family_member = "//a[@id='mainheader']";
	protected static String add_new_family_member = "//a[@class='btn btn-primary btnPortal']";
	protected static String add_profile = "//a[@class='btn-all col-md-12']";

	protected static String uhid_radio = "//input[@id='rdoUhid']";
	protected static String enter_uhid = "//fieldset[@id='searchbyuhid']//input[@id='divuhid']";
	protected static String send_otp = "//span[@id='searchwith_otpfunUhid']//a[@title='Verify'][normalize-space()='Get OTP']";

	protected static String enter_phone_no = "//input[@id='phoneNumberField']";
	protected static String get_otp = "//span[@id='searchwith_otpfunMob']//a[@title='Verify'][normalize-space()='Get OTP']";
	protected static String value_otp = "//div[@id='fieldareasforotp']";
	protected static String submit = "//a[@id='send_otpfun']";
	protected static String add_member_select = "//td[normalize-space()='ISIC.859098']";

	protected static String edite = "//img[@src='../images/New_icons/edit.svg']";
	protected static String relationship = "//select[@id='ddl_Relationship']";
	protected static String save = "//a[@id='saveNewMember']";
	protected static String deleted = "//img[@src='../images/New_icons/trash.svg']";

	public void clickOnSkipButton() throws IOException, InterruptedException {

		CommanUtill.clickFunction(skipButton, "Skip Button");
		// driver.findElement(By.xpath(skipButton)).click();
	}

	public void clickOnManageFamilyMemberButton(String fieldName) throws IOException, InterruptedException {

		CommanUtill.clickFunction(manage_family_member, fieldName);
		// driver.findElement(By.xpath(manage_family_member)).click();

	}

	public void clickOnAddNewFamilyMember(String addNewFamilyMemberButtom)
			throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(add_new_family_member, addNewFamilyMemberButtom);
		// driver.findElement(By.xpath(add_new_family_member)).click();
	}

	public void clickOnAddProfilePop(String clickOnProfilePop)
			throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(add_profile, clickOnProfilePop);
		// driver.findElement(By.xpath(add_profile)).click();

	}

	public void clickOnUHIDRadioButton(String clickOnProfilePop)
			throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(uhid_radio, clickOnProfilePop);

	}

	public void EnterpatientUHID(String fieldName) throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.textEnter(enter_uhid, fieldName);

	}

	public void clickOnGetOtpButton(String clickOnProfilePop)
			throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(send_otp, clickOnProfilePop);
	}

	public void enterMoblie(String enterMobileNo) throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.enter(enter_phone_no, enterMobileNo);
		// WebElement mob = driver.findElement(By.xpath(enter_phone_no));
		// mob.sendKeys(mobleNo);

	}

	public void clickOnOtpButton(String otp) throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(get_otp, otp);
		// driver.findElement(By.xpath(get_otp)).click();

	}

	/*
	 * public void enterValidOtp(String DATAREAD) throws IOException,
	 * InterruptedException, InvalidFormatException{
	 * 
	 * WebElement get_otp = driver.findElement(By.xpath(value_otp));
	 * get_otp.sendKeys(DATAREAD);
	 * 
	 * List<WebElement> valueotp =
	 * driver.findElements(By.xpath("//input[@id='fieldarea1']")); String value =
	 * "9873216540"; int i=0; for(WebElement e : valueotp) {
	 * e.sendKeys(String.valueOf(value.charAt(i))); i++; } }
	 */
	public void enterGetOtp(String GETOTP) throws IOException, InterruptedException, InvalidFormatException {

		WebElement otp1 = driver.findElement(By.xpath("//input[@id='fieldarea1']"));
		otp1.sendKeys(GETOTP);
		WebElement otp2 = driver.findElement(By.xpath("//input[@id='fieldarea2']"));
		otp2.sendKeys(GETOTP);
		WebElement otp3 = driver.findElement(By.xpath("//input[@id='fieldarea3']"));
		otp3.sendKeys(GETOTP);
		WebElement otp4 = driver.findElement(By.xpath("//input[@id='fieldarea4']"));
		otp4.sendKeys(GETOTP);
		WebElement otp5 = driver.findElement(By.xpath("//input[@id='fieldarea5']"));
		otp5.sendKeys(GETOTP);
		WebElement otp6 = driver.findElement(By.xpath("//input[@id='fieldarea5']"));
		otp6.sendKeys(GETOTP);

	}

	public void clickOnSubmitOtp(String otpSubmit) throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(submit, otpSubmit);
		// driver.findElement(By.xpath(submit)).click();
	}

	public void clickOnAddFamilyMember(String member) throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(add_member_select, member);
		// driver.findElement(By.xpath(add_member_select)).click();
	}
	// ___________________________**********Edite**********_____________________________________

	public void clickOnEditeButton(String fieldName) throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(edite, fieldName);
		// driver.findElement(By.xpath(edite)).click();

	}

	public void selectOnRelationshipDropDwon(String relationInFamilyMember)
			throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.dropdownSelectByVisibleText(relationship, relationInFamilyMember);

		// driver.findElement(By.xpath(relationship)).click();
		// Select relation = new Select (driver.findElement(By.xpath(relationship)));
		// relation.selectByVisibleText(relationInFamilyMember);

	}

	public void clickOnEditeSaveButton(String fieldName)
			throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(save, fieldName);
		// driver.findElement(By.xpath(save)).click();

	}

	public void clickOnDeleteIcon(String fieldName) throws IOException, InterruptedException, InvalidFormatException {

		CommanUtill.clickFunction(deleted, fieldName);
		// driver.findElement(By.xpath(deleted)).click();
	}
}
