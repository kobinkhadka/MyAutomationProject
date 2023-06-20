package com.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.base.BaseClass;

public class MemberHomePage extends BaseClass {

	
	@FindBy(xpath = ("//a[normalize-space()='Edit your account information']")) private WebElement EditAccountText; 
	
	
	public MemberHomePage() {
		
		PageFactory.initElements(getDriver(), this);
		
		
	}
	
	
	//Check if text is displayed
	public String  checkEditAccountText() {
		
		return EditAccountText.getText();
	}

}
