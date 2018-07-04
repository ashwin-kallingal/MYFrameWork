package com.qa.fcrm.scripts;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;

public class TestRunner {
	
	public static void main(String[] args) 
	{
		
		TestNG runner = new TestNG();
		List<String> l = new ArrayList<String>();
		l.add("C:\\Users\\Ashwin\\Desktop\\MyFW\\MFW\\test-output\\testng-failed.xml");
		
		runner.setTestSuites(l);
		runner.run();
		
	}

}
