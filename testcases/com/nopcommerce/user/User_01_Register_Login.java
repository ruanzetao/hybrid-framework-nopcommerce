package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_01_Register_Login {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01() {
	}

	@Test
	public void TC_02() {
	}

	@Test
	public void TC_03() {
	}

	@Test
	public void TC_04() {
	}

	@Test
	public void TC_05() {
	}

	@Test
	public void TC_06() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
