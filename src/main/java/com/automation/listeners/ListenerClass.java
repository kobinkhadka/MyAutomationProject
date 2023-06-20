package com.automation.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.utils.ExtentReporterClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.project.base.BaseClass;

public class ListenerClass implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	
	
	

	@Override
	public void onStart(ITestContext context) {

		extentReport = ExtentReporterClass.generateExtentReports();

	}

	@Override
	public void onTestStart(ITestResult result) {

		testName = result.getName();

		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + " Execution has started ......");

		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		
		extentTest.log(Status.PASS, testName + "   Executed Succesfully and PASS the test");
		System.out.println(testName + " Execution was successfull");

	}

	
	@Override
	public void onTestFailure(ITestResult result) {

		
		
		System.out.println("Screenshot is Taken !!!!!");
		
	


		File srcScreenShot = ((TakesScreenshot)BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);

		String destinationScreenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";

		try {
			FileHandler.copy(srcScreenShot, new File(destinationScreenShotPath));
		} catch (Throwable e) {
			e.printStackTrace();
			
		}

		extentTest.addScreenCaptureFromPath(destinationScreenShotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + "Got Failed");

	}


	@Override
	public void onTestSkipped(ITestResult result) {

	
		extentTest.log(Status.SKIP, testName + " Got Skipped");
		extentTest.log(Status.INFO, result.getThrowable());

		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	
		
		extentTest.log(Status.WARNING, testName + "..WAS TIMED OUTTT");
		System.out.println(testName + "  Was TimedOUTTTTTTTT !!!");

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();
		
		//Open the result when test is complete and report is generated
		
		String pathOfExtentReport = System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html";
		
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse((extentReport.toURI()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

}
