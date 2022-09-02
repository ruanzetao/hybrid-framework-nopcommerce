package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInforPageUI;

public class CustomerInforPageObject extends BasePage {
	private WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

	public AddressPageObject openAddressPage() {
		waitForElementClickable(driver, CustomerInforPageUI.ADDRESS_LINK);
		clickToElement(driver, CustomerInforPageUI.ADDRESS_LINK);
		return PageGeneratorManager.getAddressPage(driver);
	}

}
