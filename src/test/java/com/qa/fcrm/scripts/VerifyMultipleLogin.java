package com.qa.fcrm.scripts;

import org.testng.annotations.Test;

import com.qa.fcrm.base.BaseTest;
import com.qa.fcrm.common.LoginData;
import com.qa.fcrm.pages.HomePage;
import com.qa.fcrm.pages.LoginPage;

public class VerifyMultipleLogin extends BaseTest
{
	
	public VerifyMultipleLogin()
	{
		AutoLoginRequired=false;
		AutoLogoutRequired=false;
	}
	
	@Test(dataProviderClass = LoginData.class, dataProvider="testLoginData")
	
	public void testMultipleLogin(String usn, String pwd)
	{
		LoginPage lp = new LoginPage(driver);
		lp.verifyLogin(usn, pwd);
				
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) 
		{			
			e.printStackTrace();
		}
		
		HomePage hp = new HomePage(driver);
		hp.verifylogout();
		
		AutoLoginRequired=false;
		AutoLogoutRequired=false;
	}
}