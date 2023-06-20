package com.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.base.BaseClass;

public class AccountSuccessPage extends BaseClass {

	
	
	@FindBy(xpath =("//h1[normalize-space()='Your Account Has Been Created!']"))
	private WebElement registrationSuccessHeader; 

	
	
	public AccountSuccessPage() {
		
	
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public boolean checkRegisterSuccessMessage() {
		
		Boolean messageDisplay = registrationSuccessHeader.isDisplayed();	
		return messageDisplay;
	}
	
	
	public String getRegisterSuccessMessage() {
		
		Boolean isMessageDisplayed = checkRegisterSuccessMessage();
		
		String message = "";
		
		if(isMessageDisplayed) {
			
			message = registrationSuccessHeader.getText();
			
			return message;
				
		} else 
			
			return "Message Did not display. Please Check Registration may have failed";
		
		
		
		
	}
	
	

}
