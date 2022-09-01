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
import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.RegisterPageObject;

public class Level_07_Switch_Page extends BaseTest {

	private WebDriver driver;
	BasePage basePage;

	String projectPath = System.getProperty("user.dir");
	String emailAddress;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccountPage;

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
		registerPage = new RegisterPageObject(driver);
		myAccountPage = new MyAccountPageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mailinator.com";
		password = "123456";
	}



	@Test
	public void User_01_Register() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		homePage.clickToRegisterLink();
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		// Assert something
	}

	@Test
	public void User_03_My_Account() {
		myAccountPage = homePage.clickToMyAccountLink();
		myAccountPage.clickToNewsLetterCheckbox();
	}

	@Test
	public void User_04_Login() {

	}

	@Test
	public void User_05_Login() {

	}

	@Test
	public void User_06_Login() {

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
