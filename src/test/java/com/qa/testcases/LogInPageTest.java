package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.listeners.ListenerClass;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.LogInPage;
import com.automation.pageobjects.MemberHomePage;
import com.automation.utils.Log4JClass;
import com.automation.utils.utilities;
import com.project.base.BaseClass;

@Listeners(ListenerClass.class)
public class LogInPageTest extends BaseClass {



	LogInPage logInPage;

	MemberHomePage memberHomePage;

	HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {

		initializeBrowserAndRun(browser);
		homePage = new HomePage();
		homePage.clickOnMyAccount();


	}

	

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {

		getDriver().quit();
		unloadDriver(); 
	}

	@DataProvider(name = "ValidCredentialsProvider")
	public Object[][] dataSource() {

		Object[][] data = utilities.getDataFromExcelFile("Login");

		return data;

	}

	@Test(priority = 1, dataProvider = "ValidCredentialsProvider", groups = { "Smoke, Regression" })
	public void verifyLogInWithValidCredentials(String email, String password) {

		//Log4JClass.startTestCase("verifyLogInWithValidCredentials");


		logInPage = homePage.selectLogInOption();
		memberHomePage = logInPage.logInToMemberAccount(email, password);
		String actualMessage = memberHomePage.checkEditAccountText();
		String expectedMessage = "Edit your account information";

		Assert.assertEquals(actualMessage, expectedMessage);

		//Log4JClass.endTestCase("verifyLogInWithValidCredentials");

	}

	@Test(priority = 2, groups = { "Sanity" })
	public void verifyLogInWithInvalidCredentials() {

		//Log4JClass.startTestCase("verifyLogInWithInvalidCredentials");

		logInPage = homePage.selectLogInOption();
		logInPage.logInToMemberAccount(utilities.generateEmailWithTimeStamp(), "password");

		Assert.assertTrue(logInPage.checkWarningMessage(), "Message didn't display");

		Log4JClass.endTestCase("verifyLogInWithInvalidCredentials");

	}

}
