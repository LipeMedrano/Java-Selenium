package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.Base;

public class MainPage extends Base{

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	// Objects
	By txtFilterCompName = By.id("searchbox");
	By btnFilterByName = By.id("searchsubmit");
	By tblActualFirstRow = By.xpath("//tbody/tr[1]/td[1]");
	By btnAddNewComputer = By.id("add");
	By txtName = By.id("name");
	By txtIntroduced = By.id("introduced");
	By txtDiscountinued = By.id("discontinued");
	By selCompany = By.id("company");
	By btnSave = By.xpath("//input[@type='submit']");
	By txtComputerName = By.xpath("//div[@class='alert-message warning']");

	/*
	 * Filter computer by name
	 * @author Ricardo
	 * @date
	 */
	public void filterComputerByName(String computer) {
		verifyTitleContains("Computers");
		verifyVisibilityElement(txtFilterCompName);
		type(txtFilterCompName, computer);
		takeScreenshot("beforeClickFilter");
		click(btnFilterByName);
		takeScreenshot("afterClickFilter");
	}
	
	public void createNewComputer(String computer) {
		verifyTitleContains("Computers");
		click(btnAddNewComputer);
		type(txtName, computer);
		type(txtIntroduced, "2022-01-01");
		type(txtDiscountinued, "2022-08-01");
		dropDownSelect(selCompany, "RCA");
		takeScreenshot("beforeClickSave");
		click(btnSave);
		takeScreenshot("afterClickSave");
	}
	
	/*
	 * Verify computer displayed in table after filter
	 * @author Ricardo
	 * @date
	 */
	public boolean verifyComputerTable(String expectedComputer) {
		String actualComputer = getText(tblActualFirstRow);
		takeScreenshot("verifyComputer");
		if(expectedComputer.equals(actualComputer)) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * Verify computer created
	 * @author Felipe
	 * @date
	 */
	public boolean verifyComputerCreated(String expectedComputerName) {
		String actualComputerName = getText(txtComputerName);
		takeScreenshot("verifyMessage");
		if(("Done ! Computer "+expectedComputerName+" has been created").equals(actualComputerName)) {
			return true;
		}else {
			return false;
		}
	}
}
