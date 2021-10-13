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

import com.google.common.io.Files;

public class ListnerImplementation extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		System.out.println(testName+"=====Execute  &  i m listening======");
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.staticdriver);
		//TakesScreenshot takescreenshot = (TakesScreenshot)BaseClass.staticdriver;
		File sourceFile = eDriver.getScreenshotAs(OutputType.FILE);
//		String screenshotpath = System.getProperty("user.dir")+"//screenshot//"
//				+result.getMethod().getMethodName()+"_"+JavaUtility.getCurrentDate()+".PNG";
////		File dest=new File(screenshotpath);
		try {
			FileUtils.copyFile(sourceFile,  new File("./screenshot/"+testName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	

}
