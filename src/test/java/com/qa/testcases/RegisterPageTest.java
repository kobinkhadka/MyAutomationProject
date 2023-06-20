package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.automation.listeners.ListenerClass;
import com.automation.pageobjects.AccountSuccessPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.RegistrationPage;
import com.automation.utils.Log4JClass;
import com.automation.utils.utilities;
import com.project.base.BaseClass;

@Listeners(ListenerClass.class)
public class RegisterPageTest extends BaseClass {


	HomePage homePage;
	RegistrationPage registrationPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	
	public void setup(String browser) {

		initializeBrowserAndRun(browser);
		homePage = new HomePage();
		homePage.clickOnMyAccount();
		registrationPage = homePage.selectRegisterOption();

	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	
	public void tearDown() {
		
		getDriver().quit();	
		unloadDriver(); 
	}
	
	

	

	@Test(priority = 1, groups = { "Regression" })
	public void verifyRegisterAccountWithMandatoryFields() {

		Log4JClass.startTestCase("verifyRegisterAccountWithMandatoryFields");

		String firstName = utilities.randomNameGenerator();

		System.out.println(firstName);
		

		registrationPage.enterFirstName(firstName);

		String lastName = utilities.randomNameGenerator();
		registrationPage.enterLastName(lastName);
		

		System.out.println(lastName);
		registrationPage.enterEmailAddress(utilities.generateEmailWithTimeStamp());
		registrationPage.enterTelephoneNumber(prop.getProperty("phoneNumber"));

		String password = "password";
		registrationPage.enterPassword(password);
		registrationPage.enterConfirmPassword(password);
		registrationPage.selectPrivacyPolicy();

		AccountSuccessPage accountSuccessPage = registrationPage.clickOnContinueButton();


		System.out.println(accountSuccessPage.getRegisterSuccessMessage());

		Assert.assertEquals(accountSuccessPage.getRegisterSuccessMessage(), "Your Account Has Been Created!",
				"Registration Failed");
		Log4JClass.endTestCase("verifyRegisterAccountWithMandatoryFields");
	}

}
