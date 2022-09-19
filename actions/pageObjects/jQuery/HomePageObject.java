package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List getValuesEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);

		List<String> allRowValues = new ArrayList<String>();
		// Duyệt qua tất cả các Paging
		for (int index = 1; index < totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			sleepInSecond(1);

			// Get text tất cả row 1 page đưa vào array list
			List<WebElement> allRowEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowEachPage) {
				allRowValues.add(eachRow.getText());
			}
		}
		// In ra
		for (String value : allRowValues) {
			System.out.println(value);
		}
		return allRowValues;
	}
}
