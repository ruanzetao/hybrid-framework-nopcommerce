package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_02_Login {

	private WebDriver driver;
	BasePage basePage;

	String projectPath = System.getProperty("user.dir");
	String emailAddress;

	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	String firstName;
	String lastName;
	String password;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver",
				projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		// Init basePage
		basePage = new BasePage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		homePage = new HomePageObject(driver);
//		registerPage = new RegisterPageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mailinator.com";
		password = "123456";

//		homePage.clickToRegisterLink();
//		registerPage.inputToFirstnameTextbox(firstName);
//		registerPage.inputToLastnameTextbox(lastName);
//		registerPage.inputToEmailTextbox(emailAddress);
//		registerPage.inputToPasswordTextbox(password);
//		registerPage.inputToConfirmPasswordTextbox(password);
//		registerPage.clickToRegisterButton();
//		registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_01_Login_Empty_Data() {
		homePage.clickToLoginLink();

		// Tu trang Home chuyen sang trang Login
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your");

	}

	@Test
	public void TC_02_Login_Invalid_Email() {

	}

	@Test
	public void TC_03_Login_Email_Not_Found() {

	}

	@Test
	public void TC_04_Login_Exsting_Email_Empty_Password() {


	}

	@Test
	public void TC_05_Login_Exsting_Email_Incorrect_Password() {

	}

	@Test
	public void TC_06_Login_Valid_Email_Password() {

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
