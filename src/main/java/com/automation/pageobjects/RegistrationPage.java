package com.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.base.BaseClass;

public class RegistrationPage extends BaseClass {
	
	
	
	
	
	@FindBy(xpath =("//input[@id='input-firstname']"))
	WebElement firstNameField; 
	
	@FindBy(xpath =("//input[@id='input-lastname']"))
	private WebElement lastNameField; 
	
	@FindBy(xpath =("//input[@id='input-email']"))
	private WebElement emailField; 
	
	
	@FindBy(xpath =("//input[@id='input-telephone']")) 
	private WebElement telePhoneField; 
	
	
	@FindBy(xpath =("//input[@id='input-password']")) 
	private WebElement passwordField; 
	
	@FindBy(xpath =("//input[@id='input-confirm']"))
	private WebElement confirmPasswordField; 
	
	@FindBy(xpath =("//input[@name='agree']"))
	private WebElement privacyPolicyCheckBox; 
	
	@FindBy(xpath =("//input[@value='Continue']"))
	private WebElement continueButton; 
	
	
	
	public RegistrationPage() {
		
	
		
		PageFactory.initElements(getDriver(), this);
			
		
	}
	
	public void enterFirstName(String firstNameText) {
		
		firstNameField.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		
		lastNameField.sendKeys(lastNameText);
		
	}
	
	public void enterEmailAddress(String emailText) {
		
		emailField.sendKeys(emailText);
		
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		
		telePhoneField.sendKeys(telephoneText);
		
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
		
	}
	
	public void enterConfirmPassword(String passwordText) {
		
		confirmPasswordField.sendKeys(passwordText);
		
	}
	
	public void selectPrivacyPolicy() {
		
		privacyPolicyCheckBox.click();
		
	}
	
	
	public AccountSuccessPage clickOnContinueButton() {
		
		continueButton.click(); 
		
		
		return new AccountSuccessPage();
				
	}
	
	
	
	
	
}
