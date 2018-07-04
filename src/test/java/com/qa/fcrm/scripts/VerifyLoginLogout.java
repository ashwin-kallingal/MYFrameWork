package com.qa.fcrm.scripts;

import org.testng.annotations.Test;
import com.qa.fcrm.base.BaseTest;
import com.qa.fcrm.pages.HomePage;
import com.qa.fcrm.pages.LoginPage;
import com.qa.fcrm.utils.Excel;

public class VerifyLoginLogout extends BaseTest
{
	
	
	public VerifyLoginLogout()
	{
		AutoLoginRequired=false;
		AutoLogoutRequired=false;
	}
	
	@Test(priority=2)
	
	public void testLoginLogout()
	{
		String usn = Excel.getCellValue(INPUT_FILE, "VerifyLoginLogout", 1, 0);
		String pwd   = Excel.getCellValue(INPUT_FILE, "VerifyLoginLogout", 1, 1);
		
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
		
		
		
	}
	
	

}
