package com.crm.vtiger.GenericUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Vtiger.pomrepositorylib.HomePageInfo;
import com.Vtiger.pomrepositorylib.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver staticdriver;
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wdu=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	
	@BeforeSuite(groups= {"regression"})
	public void connectDB() {
		System.out.println("======DB connection successful=====");
	}
	
	@Parameters(value="browser")
	@BeforeClass(groups= {"regression"})
	public void launchBrowser (@Optional("chrome") String browservalue) throws IOException {
		/*Step 1: Launch the browser*/
		//String brow = fLib.getPropertyData("browser");
		String url = fLib.getPropertyData("url");
		if (browservalue.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browservalue.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else 
		{
			driver=new ChromeDriver();
		}
		staticdriver=driver;
		wdu.waitUntilPageLoad(driver);
		driver.get(url);
		
	}
	
	@BeforeMethod(groups= {"regression"})
	public void logintoApp() throws IOException {
		/*Step 2: Login to app*/
		wdu.waitUntilPageLoad(driver);
		String un = fLib.getPropertyData("username");
		String pwd = fLib.getPropertyData("password");
		LoginPage l=new LoginPage(driver);
		l.loginToapp(un, pwd);
		System.out.println("====Login successful====");
	}
	
	@AfterMethod(groups= {"regression"})
	public void logOutofApp() throws InterruptedException {
		/*logout of app*/
		wdu.waitUntilPageLoad(driver);
		Thread.sleep(3000);
		HomePageInfo hp=new HomePageInfo(driver);
		WebElement target = hp.getProfImg();
		wdu.mouseHover(driver, target);
		hp.getSignOutLink().click();
		System.out.println("=====Logout successfull=====");
	}
	
	@AfterClass(groups= {"regression"})
	public void closeBrowser () {
		driver.close();
	}
	
	@AfterSuite(groups= {"regression"})
	public void closeDBConnection() {
		System.out.println("======DB connection closed successfully=====");
	}

}
