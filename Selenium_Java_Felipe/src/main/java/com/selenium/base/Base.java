package com.selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Base {

	private WebDriver driver;

	/*
	 * Constructor
	 * 
	 * @author ricardo avalos
	 * 
	 * @param
	 * 
	 * @return
	 * 
	 * @throws
	 * 
	 * @date
	 */

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Chrome driver con
	 * 
	 */
	public WebDriver chromeDriverCon() {
		ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOpt);
		return driver;
	}
	
	/*
	 * Launch browser
	 */
	
	public void launchBrowser(String url) {
		 driver.get(url);
		 // addicional
		 driver.manage().window().maximize();
		 implicitWait();
	}
	
	/*
	 * Implicit wait
	 */
	public void implicitWait() {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	/*
	 * Explicit wait
	 */
	public void verifyTitleContains(String titleExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.titleContains(titleExpected));
	}
	
	public void verifyVisibilityElement(By objExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(objExpected));
	}
	
	/*
	 * Type
	 */
	public void type(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	/*
	 * Clear
	 */
	public void clear(By locator) {
		driver.findElement(locator).clear();
	}
	
	/*
	 * Click
	 */
	
	public void click(By locator) {
		try {
			driver.findElement(locator).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Get Text
	 */
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	//Added
		/*
		 * DropDown Select
		 */
	public void dropDownSelect(By locator,String option) {
		Select drpSelect = new Select(driver.findElement(locator));
		drpSelect.selectByVisibleText(option);
	}
	/*
	 * DropDown Select
	 */
	public void divDropDownSelect(By locator,By option) {
		click(locator);
		click(option);
	}
	/*
	 * Close Browser
	 */
	public void closeBrowser() {
		driver.close();
	}
	
	/**
	 * Get Data from JSON file (Directly)
	 * 
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey){
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}
	
	/*
	 * Take screenshot
	 * 
	 * @author Ricardo Avalos
	 * @throws IOException
	 */
	public String takeScreenshot(String fileName){
		try {
			String pathFileName= GlobalVariables.PATH_SCREENSHOTS + fileName + ".png";
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			return pathFileName;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
