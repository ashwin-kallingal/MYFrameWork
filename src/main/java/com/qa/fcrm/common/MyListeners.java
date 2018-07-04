package com.qa.fcrm.common;

import java.util.ArrayList;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.qa.fcrm.base.BaseTest;
import com.qa.fcrm.utils.Excel;
import com.qa.fcrm.utils.Utility;

public class MyListeners implements ITestListener
{
	
	public static int passCount=0;
	public static int failCount=0;
	public static int skipCount=0;
	
	public static List<String> passName = new ArrayList<String>();
	public static List<String> failName = new ArrayList<String>();
	public static List<String> skipName = new ArrayList<String>();

	@Override
	public void onFinish(ITestContext result) 
	{
		Reporter.log("Pass Count is:"+passCount,true);
		Reporter.log("Fail Count is:"+failCount,true);
		Reporter.log("Skip Count:"+skipCount,true);
		
		Reporter.log("Passed Test Cases:"+passName,true);
		Reporter.log("Failed Test Cases:"+failName, true);
		Reporter.log("Skipped Test Cases:"+skipName, true);		
	}

	@Override
	public void onStart(ITestContext result) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		Excel.setCellValue(result.getName(), "FAIL", Utility.getFormattedDateTime(), BaseTest.myBrowser);
		Utility.getDesktopScreenshot(AutomationConstant.SCREENSHOT_PATH, result.getName());
		failCount++;
		failName.add(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Excel.setCellValue(result.getName(), "SKIP", Utility.getFormattedDateTime(), BaseTest.myBrowser);
		skipCount++;
		skipName.add(result.getName());		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Excel.setCellValue(result.getName(), "PASS", Utility.getFormattedDateTime(), BaseTest.myBrowser);
		passCount++;
		passName.add(result.getName());		
	}
}