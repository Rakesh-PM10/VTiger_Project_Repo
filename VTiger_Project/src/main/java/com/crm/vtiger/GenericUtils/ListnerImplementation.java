package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListnerImplementation extends BaseClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
    
	
	public void onTestStart(ITestResult result) {
		//step 3 : create test method
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		//step 4: log for pass methods
		test.generateLog(Status.PASS, result.getMethod().getMethodName()+"  is passed" );
		
	}

	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		System.out.println(testName+"=====Execute  &  i m listening======");
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.staticdriver);
		//TakesScreenshot takescreenshot = (TakesScreenshot)BaseClass.staticdriver;
		File sourceFile = eDriver.getScreenshotAs(OutputType.FILE);
		String screenshotpath =System.getProperty("user.dir")+"//screenshot//"+result.getMethod().getMethodName()+"_"+JavaUtility.getCurrentDate()+".PNG";
        File dest=new File(screenshotpath);
		try {
			//FileUtils.copyFile(sourceFile,  new File("./screenshot/"+testName+".png"));
			FileUtils.copyFile(sourceFile, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//step 5: log for failure methods
		test.log(Status.FAIL, result.getMethod().getMethodName()+"  is failed");
		test.log(Status.FAIL, result.getThrowable());
		//File screenshotpath = new File("./screenshot/"+testName+".png");
		test.addScreenCaptureFromPath(screenshotpath);
	}

	public void onTestSkipped(ITestResult result) {
		//step 6: log for skip methods
		test.log(Status.SKIP,  result.getMethod().getMethodName()+"  is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/extentreport.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Vtiger_Automation_Report");
		htmlReporter.config().setReportName("Execution Report");
		
		ExtentReports report= new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("url", "http://localhost:8888");
		report.setSystemInfo("Platform", "Windows10");
		report.setSystemInfo("Reporter name", "Rakesh");
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	

}
