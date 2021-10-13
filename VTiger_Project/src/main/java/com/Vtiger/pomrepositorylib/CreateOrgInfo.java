package com.Vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgInfo {
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgName;
	
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement assignTo;
	
    @FindBy(xpath = "//select[@name='assigned_group_id']")
    private WebElement groupidLbx;
    
    @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
    private WebElement saveBtn;
    
    @FindBy(name = "emailoptout")
    private WebElement emailCheckbx;
    
    @FindBy(name = "notify_owner")
    private WebElement notifyCbox;
    
    public CreateOrgInfo(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getAssignTo() {
		return assignTo;
	}

	public WebElement getGroupidLbx() {
		return groupidLbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getEmailCheckbx() {
		return emailCheckbx;
	}

	public WebElement getNotifyCbox() {
		return notifyCbox;
	}
    
}
