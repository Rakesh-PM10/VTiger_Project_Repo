package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateNewCont{
	WebDriver driver;
	WebDriverUtility wdu=new WebDriverUtility();
	public CreateNewCont(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookupIcon;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookupIcon() {
		return orgLookupIcon;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
    public void createContWithOrg (String contactName, String orgname) {
    	
    	lastNameEdt.sendKeys(contactName);
    	orgLookupIcon.click();
    	wdu.switchToWindow(driver, "Accounts&action");
    	Organizations op=new Organizations(driver);
    	op.getOrgSearchBx().sendKeys(orgname+Keys.ENTER);
    	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
    	wdu.switchToWindow(driver, "Contacts&action");
    	saveBtn.click();
    }
}
