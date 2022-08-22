package com.computers.selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Ejercicio6 {
  @Test
  public void f() {
	  	  
	  //Step 1 - Launch browser
	  ChromeOptions chromeOpt = new ChromeOptions();
	  WebDriverManager.chromedriver().setup();	  
	  WebDriver driver = new ChromeDriver(chromeOpt);
	  
	  driver.get("https://computer-database.gatling.io/computers");
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.titleContains("Computers"));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchbox")));
	  
	  //Step2 - Click Add a new computer
	  driver.findElement(By.id("add")).click();
	  
	  //Step3 - Enter all information
	  driver.findElement(By.id("name")).sendKeys("LipeCompu");
	  driver.findElement(By.id("introduced")).sendKeys("2022-01-01");
	  driver.findElement(By.id("discontinued")).sendKeys("2022-08-01");
	  Select Company = new Select(driver.findElement(By.id("company")));
	  Company.selectByVisibleText("RCA");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
	  //Step6 - Validate computer was created
	  String actualComputerName = driver.findElement(By.xpath("//div[@class='alert-message warning']")).getText();
	  Assert.assertEquals(actualComputerName, "Done ! Computer LipeCompu has been created");
	  
	  //driver.close();
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
