package com.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.base.BaseClass;

public class LogInPage extends BaseClass {
	
	
	
	//Objects
	@FindBy(xpath = ("//input[@id='input-email']")) WebElement emailField; 
	@FindBy(xpath = ("//input[@id='input-password']")) WebElement passwordField; 
	@FindBy(xpath = ("//input[@value='Login']")) WebElement logInButton; 
	@FindBy(xpath = ("//div[@class='alert alert-danger alert-dismissible']")) WebElement warningMessage; 
	
	
	
	public LogInPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	
	//Actions

	
	public MemberHomePage logInToMemberAccount (String email, String password) {
		
		emailField.clear(); 
		emailField.sendKeys(email);
		passwordField.clear(); 
		passwordField.sendKeys(password);
		logInButton.click();
		
				
		return new MemberHomePage();				
	}
	
	
	public boolean checkWarningMessage() {
		
		return warningMessage.isDisplayed(); 
	}

	

}
