package com.qa.fcrm.common;

import org.testng.annotations.DataProvider;

import com.qa.fcrm.utils.Excel;

public class LoginData {
		
	@DataProvider
	
	public Object[][] testLoginData()
	{
		Object[][] data = new Object[4][2];
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<2;j++)
			{
				data[i][j] = Excel.getCellValue(AutomationConstant.INPUT_FILE, "MultipleLogin", i+1, j);				
			}
		}
		
		return data;
	}
}
