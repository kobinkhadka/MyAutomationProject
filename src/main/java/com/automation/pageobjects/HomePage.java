package com.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.base.BaseClass;

public class HomePage extends BaseClass{

	
	
	//Objects	
	@FindBy(xpath =("//span[normalize-space()='My Account']")) private  WebElement myAccountDropDown; 
	@FindBy(xpath =("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")) private WebElement logInOption; 
	@FindBy(xpath =("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")) private WebElement registerOption; 
	
	
	public HomePage() {
		
		PageFactory.initElements(getDriver(),  this);
		
	}
	
	
	
	
	//Actions
	public void clickOnMyAccount() {
		
		myAccountDropDown.click(); 
		
	}
	
	
	public LogInPage selectLogInOption() {
		
		logInOption.click(); 
	
		return new LogInPage(); 
		
	
	}
	
	
	public RegistrationPage selectRegisterOption() {
		
		registerOption.click();
		
		
		return new RegistrationPage();
	}
	
	
	

}
