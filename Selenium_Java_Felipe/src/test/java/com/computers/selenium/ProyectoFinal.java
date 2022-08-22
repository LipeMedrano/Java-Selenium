package com.computers.selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.base.Base;
import com.selenium.base.GlobalVariables;
import com.selenium.poc.MainPage;
import com.selenium.poc.NewOrangePage;

public class ProyectoFinal {

	// POM

	WebDriver driver;
	Base base;
	MainPage mainPage;
	//Added
	NewOrangePage orangePage;
	//
	String expectedComputer;
	ExtentReports extent;
	ExtentTest logger;
	private String className = this.getClass().getSimpleName();

	@BeforeTest
	public void beforeTest() {
		base = new Base(driver);
		driver = base.chromeDriverCon();
		mainPage = new MainPage(driver);
		//Added
		orangePage = new NewOrangePage(driver);
		expectedComputer = base.getJSONValue("tc001", "computer");

		// Set up Extend reports
		extent = new ExtentReports(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.REPORT_PATH, true);
		extent.addSystemInfo(GlobalVariables.EXTENT_QA_URL, GlobalVariables.QA_URL);
		extent.loadConfig(new File(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.CONFIG_EXTENT));
	}

	@Test
	public void tc001() {

		// Extent report start test
		logger = extent.startTest(className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		//Step 1	Open browser "OrangeHRM" web page
		base.launchBrowser("https://opensource-demo.orangehrmlive.com/");
		//Step 2	Enter Username and Password
		//Step 3	Click login
		orangePage.enterUsernameAndPassword(GlobalVariables.QA_UserName,GlobalVariables.QA_Password);
		//Step 4	Validate user is logged successfully
		Assert.assertTrue(orangePage.verifyLoginSuccessful());
		//Step 5	Click Admin module
		orangePage.navigateToTab("Admin");
		//Step 6	Validate user is able to see Admin page 
		Assert.assertTrue(orangePage.verifyAdminTab());
		//Step 7	Click Add button
		//Step 8	Fill out the form to create the user
		//Step 9	Click on Save button.
		orangePage.createNewUserForEmployee("","John");
		//Step 10	Insert user recently created into Username textbox
		//Step 11	Click search
		orangePage.searchForUser(GlobalVariables.QA_NewUser);
		//Step 12	Validate user exist in the table result after click search
		Assert.assertTrue(orangePage.verifyExistingUser(""));
		//Step 13	Select user in the table result and click Delete
		//Step 14	Click on OK button in modal window (Delete records?)
		orangePage.deleteUser();
		//Step 15	Validate user was deleted successfully
		Assert.assertTrue(orangePage.verifyDeletedUser(""));

		// Log Extent Report
		logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName() + " was successfully");
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
//			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(base.takeScreenshot("fail")));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);

	}

	@AfterTest
	public void afterTest() {
		// Close Extend report
		extent.flush();
		extent.close();
		base.closeBrowser();
	}

}
