package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox() {
		
	}

	public void clickToLoginButton() {
		// TODO Auto-generated method stub

	}

	public String getErrorMessageAtEmailTextbox() {
		// TODO Auto-generated method stub
		return null;
	}

	public void inputToEmailTextbox(String invalidEmail) {
		// TODO Auto-generated method stub

	}

	public String getErrorMessageUnsuccessful() {
		// TODO Auto-generated method stub
		return null;
	}

	public void inputToPasswordTextbox(String password) {
		// TODO Auto-generated method stub

	}
}
