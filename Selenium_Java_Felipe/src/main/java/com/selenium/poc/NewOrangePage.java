0package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.Base;

public class NewOrangePage extends Base{

	public NewOrangePage(WebDriver driver) {
		super(driver);
	}
	
	// Objects
	By txtUserName = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin = By.xpath("//button[@type='submit']");
	By DashboardTab = By.xpath("//li[2]/a[@class='oxd-topbar-body-nav-tab-item']");
	//By txtUser = By.xpath("//p[@class='oxd-userdropdown-name']");
	By btnAdminTab = By.xpath("//ul[@class='oxd-main-menu']/li[1]");
	By SubTab = By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent --visited']");
	By btnAdd = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	By txtEmployeeName = By.xpath("//div[@class='oxd-form-row']/div/div[2]/div/div/div/div/input");
	By txtEmployeeAfter = By.xpath("//div[@class='oxd-form-row']/div/div[2]/div/div/div/div/input");
	By btnAutocpomplete = By.xpath("//div[@class='oxd-autocomplete-option'][1]");
	By txtNewUser = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][4]//input[@class='oxd-input oxd-input--active']");
	By txtNewPass = By.xpath("//div[@class='oxd-form-row user-password-row']/div/div[1]/div/div/input");
	By txtConfPass = By.xpath("//div[@class='oxd-form-row user-password-row']/div/div[2]/div/div/input");
	By btnSave = By.xpath("//button[@type='submit']");
	By drpUserRole = By.xpath("//div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]/div/div/div/div");
	By drpRoleOption = By.xpath("//div[@class='oxd-select-option'][2]");
	By drpStatus = By.xpath("//div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[3]/div/div/div");
	By drpStatusOption = By.xpath("//div[@class='oxd-select-option'][2]");
	By txtSearchUsername = By.xpath("//div[2]/input[@class='oxd-input oxd-input--active']");
	By btnSearch = By.xpath("//div[@class='oxd-form-actions']/button[@type='submit']");
	By txtUserFound = By.xpath("//div[@class='oxd-table-body']/div/div/div[2]");
	By btnDeleteUser = By.xpath("//i[@class='oxd-icon bi-trash']");
	By btnYesDelete = By.xpath("//div[@class='orangehrm-modal-footer']/button[2]");
	By txtRecordsFound = By.xpath("//div[@class='orangehrm-paper-container']/div[2]//span[@class='oxd-text oxd-text--span']");
	/*
	 * X title
	 * @author Felipe M.
	 * @date
	 */
	public void enterUsernameAndPassword(String UserName,String Password) {
		//verifyVisibilityElement(LoginPanel);
		type(txtUserName, UserName);
		type(txtPassword, Password);
		takeScreenshot("beforeClickLogin");
		click(btnLogin);
		takeScreenshot("afterClicklogin");
	}
	
	public void navigateToTab(String TabName) {
		takeScreenshot("beforeClickTab");
		click(btnAdminTab);
		takeScreenshot("afterClickTab");
	}
	
	public void createNewUserForEmployee(String newUser,String employeeName) {
		click(btnAdd);
		//Select drpUserRole = new Select(txtEmployeeName);
		//Select UserRole = dropDown(drpUserRole);
		//UserRole.selectByVisibleText("Admin");
		divDropDownSelect(drpUserRole, drpRoleOption);
		type(txtEmployeeName, employeeName);
		//click(txtEmployeeAfter);
		implicitWait();
		click(btnAutocpomplete);
		type(txtNewUser, newUser);
		divDropDownSelect(drpStatus, drpStatusOption);
		type(txtNewPass, "Test1234!");
		type(txtConfPass, "Test1234!");
		implicitWait();
		takeScreenshot("beforeClickSave");
		click(btnSave);
		implicitWait();
		takeScreenshot("afterClickSave");
	}
	
	public void searchForUser(String NewUser) {
		implicitWait();
		type(txtSearchUsername,NewUser);
		takeScreenshot("beforeClickSearch");
		click(btnSearch);
		takeScreenshot("afterClickSearch");
		implicitWait();
	}
	
	public void deleteUser() {
		takeScreenshot("beforeClickSearch");
		click(btnDeleteUser);
		click(btnYesDelete);
		implicitWait();
		takeScreenshot("afterClickSearch");
		implicitWait();
	}
	
	public boolean verifyLoginSuccessful() {
		//String actualHeader = getText(txtUser);
		String actualHeader = getText(DashboardTab);
		takeScreenshot("verifyLandingPage");
		if("Employee List".equals(actualHeader)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean verifyAdminTab() {
		String actualSubTab = getText(SubTab);
		takeScreenshot("verifyAdminTab");
		if("User Management".equals(actualSubTab)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean verifyExistingUser(String existingUser) {
		String actualUser = getText(txtUserFound);
		takeScreenshot("verifyExistingUser");
		if(existingUser.equals(actualUser)) {
			return true;
		}else {
			return false;
		}
	
	}
	public boolean verifyDeletedUser(String deletedUser) {
		navigateToTab("Admin");
		searchForUser(deletedUser);
		String actualSearchResult = getText(txtRecordsFound);
		takeScreenshot("verifyDeletedUser");
		if("No Records Found".equals(actualSearchResult)) {
			return true;
		}else {
			return false;
		}
	
	}
}
