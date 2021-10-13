package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement succHeaderMsg;
	
	public WebElement getSuccHeaderMsg() {
		return succHeaderMsg;
	}
	
	

}
