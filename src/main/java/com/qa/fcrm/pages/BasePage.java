package com.qa.fcrm.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.fcrm.common.AutomationConstant;
import com.qa.fcrm.common.Property;

public class BasePage 
{
	public Logger log = Logger.getLogger("BasePage");
	public WebDriver driver;
	public String config;
	public long timeout;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		config = AutomationConstant.CONFIG_FILE;
		timeout = Long.parseLong(Property.getCellValue(config, "EXPLICIT"));
	}
	
	public void verifyElementPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void verifyURLIs(WebDriver driver, String expURL)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.urlToBe(expURL));
	}
	
	public void verifyURLHas(WebDriver driver, String expURL)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.urlContains(expURL));
	}
}