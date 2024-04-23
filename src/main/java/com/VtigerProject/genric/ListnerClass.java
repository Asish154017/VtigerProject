package com.VtigerProject.genric;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerClass implements ITestListener
{

	ExtentReports er;
	ExtentTest test;
	ExtentSparkReporter esr;
	
	public void onFinish(ITestContext context) {
		Reporter.log("Project is Finished",true);
		er.flush();
		}

	public void onStart(ITestContext context) {
		Reporter.log("Project is Started",true);
		
		ExtentSparkReporter esr = new ExtentSparkReporter(Iconstant.reportPath);
		esr.config().setDocumentTitle("Vtiger Report");
		esr.config().setReportName("Abhi");
		esr.config().setTheme(Theme.DARK);
		esr.config().setTimeStampFormat("3:05");
		
	    er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Window","10");
		er.setSystemInfo("Browser","Chrome");
		er.setSystemInfo("System","HP");
		
				
	}

	public void onTestFailure(ITestResult result) {
		String SSpath = null;
		WebDriverUtils wdu  = new WebDriverUtils();
		JavaUtils ju = new JavaUtils();
		String testCaseName= result.getName();
	
		Reporter.log("Test Case is Failed"+testCaseName,true);
		String path=Iconstant.ssPath +testCaseName+ju.dateGenrate()+"-"+ju.currentTimeGenrate()+".png";
		
		System.out.println(path);
		test.log(Status.FAIL,"Test Case Failed  "+testCaseName);

		
		try {
   		SSpath= wdu.screenshot(Driver.getDriver(),path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   test.addScreenCaptureFromPath(SSpath);
	}

	public void onTestSkipped(ITestResult result) {
	
		
		String testCaseName= result.getName();
		
 
		Reporter.log("Test Case is Skipped"+testCaseName,true);
		test.log(Status.SKIP,"Test Skipped  "+testCaseName);

	}

	public void onTestStart(ITestResult result) {
	
		String testCaseName= result.getName();
		
		Reporter.log("Test Case is Started"+testCaseName,true);
		test = er.createTest(testCaseName);
	
	}

	public void onTestSuccess(ITestResult result) {
	
		String testCaseName= result.getName();
		
		Reporter.log("Test Case executed sucessfully"+testCaseName,true);
	
		test.log(Status.PASS,"Test Case executed sucessfully   "+testCaseName);
	
	}

}
