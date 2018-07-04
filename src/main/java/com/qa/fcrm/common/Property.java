package com.qa.fcrm.common;

import java.io.FileInputStream;
import java.util.Properties;

public class Property {
	
	public static String getCellValue(String path, String key)
	{
		String value="";
		
		Properties ppt = new Properties();
		
		try
		{
			ppt.load(new FileInputStream(path));
			value=ppt.getProperty(key);			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		return value;
	}
}