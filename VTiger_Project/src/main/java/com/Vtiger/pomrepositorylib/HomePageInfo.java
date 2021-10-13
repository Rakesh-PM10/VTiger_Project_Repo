package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageInfo {
	@FindBy(name="query_string")
	private WebElement searchBox;
	
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement orgLink;
	
	@FindBy(xpath = "(//img[@style='padding: 0px;padding-left:5px'])[1]")
	private WebElement profImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contLink;
	

	public HomePageInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}
	
	public WebElement getProfImg() {
		return profImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public WebElement getContLink() {
		return contLink;
	}

	public void searchOrg(String orgid) {
		searchBox.sendKeys(orgid);
	}
	
	public void clickOrg() {
		orgLink.click();
	}
	
	public void clickCon() {
		contLink.click();
	}

}
