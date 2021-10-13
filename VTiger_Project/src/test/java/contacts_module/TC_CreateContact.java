package contacts_module;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.pomrepositorylib.ContactInfoPage;
import com.Vtiger.pomrepositorylib.Contacts;
import com.Vtiger.pomrepositorylib.CreateNewCont;
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

public class TC_CreateContact extends BaseClass{
	@Test
	public void createNewCont () throws Throwable {
		
		/*read test data*/
		String orgname = eLib.getExcelData("sheet1", 1, 2);
		String contactName=eLib.getExcelData("contacts", 1, 3);
		
		/*Step 3: navigate to organizations */
		HomePageInfo hp=new HomePageInfo(driver);
		hp.clickOrg();
		
		/*Step 4: navigate to create org page*/
		
		Organizations or=new Organizations(driver);
		or.getCreateOrgImg().click();
		
		/*Step 5: create new organisation*/
		CreateOrgInfo co=new CreateOrgInfo(driver);
		co.getOrgName().sendKeys(orgname+JavaUtility.getRandomData());
		co.getSaveBtn().click();
		
		/*Step 6: verify the org information page*/
		OrgInfoPage oip= new OrgInfoPage(driver);
		String atext=oip.getOrgInfo().getText();
	
		Assert.assertTrue(atext.contains(orgname));
		System.out.println("org is created successfully=====>pass");
		
	    /*Step 7: navigate to contacts*/
		wdu.waitUntilPageLoad(driver);
		hp.clickCon();
		
	    /*Step 8: navigate to create contact page*/
		Contacts con=new Contacts(driver);
		con.clickCreateContIcon();
		
	    /*Step 9: create new contact*/
		CreateNewCont cnc=new CreateNewCont(driver);
		cnc.createContWithOrg(contactName, orgname);
		
	    /*Step : verify the contact*/
		ContactInfoPage cip=new ContactInfoPage(driver);
		wdu.waitForElementVisibility(driver, cip.getSuccHeaderMsg());
		String actSucMsg = cip.getSuccHeaderMsg().getText();
		if (actSucMsg.contains(contactName))
		{
			System.out.println("Contact is created successfully===> pass");
		}
		else
		{
			System.out.println("Contact is not created successfully===>Fail");
		}
	}
}
