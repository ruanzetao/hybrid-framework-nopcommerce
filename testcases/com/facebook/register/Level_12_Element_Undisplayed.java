package com.facebook.register;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_12_Element_Undisplayed extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {

	}

	@Test
	public void TC_01_Verify_Element_UnDisplayed_In_DOM() {
	}

	@Test
	public void TC_03_Verify_Element_UnDisplayed_Not_In_DOM() {
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return (int) rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
