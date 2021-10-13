package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class Organizations {
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement orgSearchBx;
	
	@FindBy(name = "search_field")
	private WebElement listbx;
	
	public Organizations (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}

	public WebElement getOrgSearchBx() {
		return orgSearchBx;
	}

	public WebElement getListbx() {
		return listbx;
	}
	
	public void selectorgno() {
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.SelectOption(listbx, "Organization No");
	}
	
	
}
