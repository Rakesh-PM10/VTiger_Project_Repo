package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	public Contacts (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createConIcon;
	
	public WebElement getCreateConIcon() {
		return createConIcon;
	}
	
	public void clickCreateContIcon () {
		createConIcon.click();
	}
}
