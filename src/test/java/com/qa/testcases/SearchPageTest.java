package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.automation.listeners.ListenerClass;
import com.automation.pageobjects.SearchPage;
import com.automation.utils.Log4JClass;
import com.project.base.BaseClass;

@Listeners(ListenerClass.class)
public class SearchPageTest extends BaseClass {


	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void startup(String browser) {

		initializeBrowserAndRun(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
		unloadDriver(); 
	}

	@Test(priority = 1, groups = { "Smoke" })
	
	public void verifySearchWithValidProduct() {

		Log4JClass.startTestCase("verifySearchWithValidProduct");

		SearchPage searchPage = new SearchPage();

		searchPage.searchItem(prop.getProperty("itemToSearch"));

		searchPage.clickOnSearchButton();

		Assert.assertFalse(searchPage.searchResult(), "Item didn't show or match");

		Log4JClass.endTestCase("verifySearchWithValidProduct");
	}

	@Test(priority = 2, groups = { "Sanity" })
	public void verifySearchWithInvalidProduct() {

		Log4JClass.startTestCase("verifySearchWithInvalidProduct");

		SearchPage searchPage = new SearchPage();

		searchPage.searchItem(prop.getProperty("invalidItemToSearch"));
		searchPage.clickOnSearchButton();
		String actualMessage = searchPage.getItemNotFoundMessage();
		String expectedItemNotFoundMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(actualMessage, expectedItemNotFoundMessage, "Incorrect message displayed.");

		Log4JClass.endTestCase("verifySearchWithInvalidProduct");

	}

}
