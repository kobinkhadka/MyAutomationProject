package com.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.base.BaseClass;

public class SearchPage extends BaseClass {

	
	
	@FindBy(xpath=("//input[@placeholder='Search']")) 
	private WebElement searchField; 
	
	@FindBy(xpath=("//button[@class ='btn btn-default btn-lg']"))
	private WebElement searchButton; 
	
	
	@FindBy(xpath=("//a[normalize-space()='iPhone']"))
	private WebElement searchResult;
	
	
	@FindBy(xpath=("//p[contains(text(),'There is no product that matches the search criteria')]"))
	
	private WebElement productNotFoundMessage;
	
	
	
	
	public SearchPage() {
		
		
		
		PageFactory.initElements(getDriver(), this);
			
		
	}
	
	
	public void searchItem(String item) {
		
		searchField.sendKeys(item);
	}
	
	
	public void clickOnSearchButton() {
		
		searchButton.click();
	}
	
	
	public boolean searchResult() {
			
		return searchResult.isDisplayed();		
	}
	
	
	public String getItemNotFoundMessage() {
		
		String message = productNotFoundMessage.getText();		
		return message;
	}
	
	

}
