package Project;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Vtiger.pomrepositorylib.CreateOrgInfo;
import com.Vtiger.pomrepositorylib.HomePageInfo;
import com.Vtiger.pomrepositorylib.LoginPage;
import com.Vtiger.pomrepositorylib.OrgInfoPage;
import com.Vtiger.pomrepositorylib.Organizations;
import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

@Listeners(com.crm.vtiger.GenericUtils.ListnerImplementation.class)
public class TC_41to45_organisation extends BaseClass {

	@Test(priority = 1, groups = { "smokeTest", "regression" })
	public void searchOrg() {
		/* Step 3: Search org by organisation id */
		wdu.waitUntilPageLoad(driver);
//		Organizations or = new Organizations(driver);
//		or.selectorgno();
//		or.getOrgSearchBx().sendKeys("ACC1");
		
		HomePageInfo hp=new HomePageInfo(driver);
     	hp.searchOrg("ACC1"+Keys.ENTER);
     	Assert.fail();

	}

	/*
	 * @Test(priority=2, groups= {"smokeTest"}) public void createOrg() throws
	 * IOException, Throwable { create objects ExcelUtility ex= new ExcelUtility();
	 * wdu.waitUntilPageLoad(driver);
	 * 
	 * Read test data String orgname = ex.getExcelData("sheet1", 1, 2);
	 * 
	 * Step 3: navigate to organizations HomePageInfo hp=new HomePageInfo(driver);
	 * hp.clickOrg();
	 * 
	 * Step 4: navigate to create org page
	 * 
	 * Organizations or=new Organizations(driver); or.getCreateOrgImg().click();
	 * 
	 * Step 5: create new organisation CreateOrgInfo co=new CreateOrgInfo(driver);
	 * co.getOrgName().sendKeys(orgname+JavaUtility.getRandomData());
	 * 
	 * co.getAssignTo().click(); WebElement lb1 = co.getGroupidLbx();
	 * wdu.SelectOption(lb1, "4"); co.getSaveBtn().click();
	 * 
	 * Step 6: verify the org information page OrgInfoPage oip= new
	 * OrgInfoPage(driver); String atext=oip.getOrgInfo().getText();
	 * 
	 * Assert.assertTrue(atext.contains(orgname));
	 * System.out.println("org is created successfully=====>pass");
	 * 
	 * }
	 * 
	 * @Test(priority=3, groups= {"regression"}) public void createOrg2() throws
	 * IOException, Throwable { wdu.waitUntilPageLoad(driver); ExcelUtility ex= new
	 * ExcelUtility();
	 * 
	 * 
	 * String orgname = ex.getExcelData("sheet1", 1, 2);
	 * 
	 * Step 3: navigate to organizations HomePageInfo hp=new HomePageInfo(driver);
	 * hp.clickOrg();
	 * 
	 * Step 4: navigate to create org page Organizations or=new
	 * Organizations(driver); or.getCreateOrgImg().click();
	 * 
	 * Step 5: create new organisation CreateOrgInfo co=new CreateOrgInfo(driver);
	 * co.getOrgName().sendKeys(orgname+JavaUtility.getRandomData());
	 * co.getAssignTo().click(); WebElement lb1 = co.getGroupidLbx();
	 * wdu.SelectOption(lb1, "2"); co.getSaveBtn().click(); Thread.sleep(2000);
	 * 
	 * Step 6: verify the org information page OrgInfoPage oip= new
	 * OrgInfoPage(driver); String atext=oip.getOrgInfo().getText();
	 * 
	 * Assert.assertTrue(atext.contains(orgname));
	 * System.out.println("org is created successfully=====>pass"); }
	 * 
	 * @Test(priority=4) public void createOrg3() throws IOException, Throwable {
	 * ExcelUtility ex= new ExcelUtility(); wdu.waitUntilPageLoad(driver);
	 * 
	 * Read test data String orgname = ex.getExcelData("sheet1", 1, 2);
	 * 
	 * Step 3: navigate to organizations HomePageInfo hp=new HomePageInfo(driver);
	 * hp.clickOrg();
	 * 
	 * Step 4: navigate to create org page Organizations o=new
	 * Organizations(driver); o.getCreateOrgImg().click();
	 * 
	 * Step 5: create new organisation CreateOrgInfo co=new CreateOrgInfo(driver);
	 * co.getOrgName().sendKeys(orgname+JavaUtility.getRandomData()); boolean
	 * checkBox = co.getEmailCheckbx().isSelected(); if (checkBox==false) {
	 * co.getSaveBtn().click(); } else { co.getEmailCheckbx().click(); }
	 * 
	 * Step 6: verify the org information page OrgInfoPage oip= new
	 * OrgInfoPage(driver); String atext=oip.getOrgInfo().getText();
	 * Assert.assertTrue(atext.contains(orgname));
	 * System.out.println("org is created successfully=====>pass"); }
	 * 
	 * 
	 * @Test(priority=5) public void createOrgWithoutNotify() throws IOException,
	 * Throwable { ExcelUtility ex= new ExcelUtility();
	 * //wdu.waitUntilPageLoad(driver);
	 * 
	 * Read test data String orgname = ex.getExcelData("sheet1", 1, 2);
	 * 
	 * Step 3: navigate to organizations HomePageInfo hp=new HomePageInfo(driver);
	 * hp.clickOrg();
	 * 
	 * Step 4: navigate to create org page Organizations o=new
	 * Organizations(driver); o.getCreateOrgImg().click();
	 * 
	 * Step 5: create new organisation CreateOrgInfo co=new CreateOrgInfo(driver);
	 * co.getOrgName().sendKeys(orgname+JavaUtility.getRandomData()); boolean cbox =
	 * co.getNotifyCbox().isSelected(); if (cbox==false) { co.getSaveBtn().click();
	 * } else { co.getNotifyCbox().click(); }
	 * 
	 * Step 6: verify the org information page OrgInfoPage oip= new
	 * OrgInfoPage(driver); String atext=oip.getOrgInfo().getText();
	 * 
	 * Assert.assertTrue(atext.contains(orgname));
	 * System.out.println("org is created successfully=====>pass");
	 * 
	 * }
	 */

}
