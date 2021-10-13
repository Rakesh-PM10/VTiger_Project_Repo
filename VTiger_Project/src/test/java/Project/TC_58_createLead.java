package Project;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_58_createLead {
	WebDriver driver;
	@BeforeMethod
	public void login() throws IOException {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FileUtility f=new FileUtility();
		String url = f.getPropertyData("url");
		System.out.println(url);
		String un = f.getPropertyData("username");
		String pwd = f.getPropertyData("password");
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd+Keys.ENTER);
	}
	@Test
	public void createLeadAndDelete () {
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.waitUntilPageLoad(driver);
		ExcelUtility ex= new ExcelUtility();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		WebElement lb1 = driver.findElement(By.name("salutationtype"));
		wdu.SelectOption(lb1, "Mr.");
		driver.findElement(By.name("firstname")).sendKeys("ram"+Keys.TAB+Keys.TAB+"KL"
		+Keys.TAB+"7418529630"+Keys.TAB+"TYSS");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).click();
        driver.findElement(By.xpath("(//input[@value='Delete'])[2]")).click();
        wdu.acceptAlert(driver);
        
        
		//driver.findElement(By.xpath("(//a[text()='ram'])[1]")).click();
		
		
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.waitUntilPageLoad(driver);
		Thread.sleep(3000);
		WebElement target = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		wdu.mouseHover(driver, target);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}

}
