package com.comcast.serviceability.common.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.comcast.serviceability.config.Configurations;

public class Serviceability {
	
	WebDriver driver;

	public Serviceability(WebDriver driver) {
		this.driver = driver; }
	
	
	@FindBy(xpath=Configurations.servcMsg)
	public WebElement servcMsg;
	
	@FindBy(xpath=Configurations.chkAnotherAddress)
	public WebElement chkAnotherAddress;
	
	
	public void actualServicebilityMsg(String Expected) throws IOException
	{
		
		String ActualMsg =servcMsg.getText();
		if (ActualMsg !=Expected)
			
		{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("c:\\Screenshots\\ERROR.jpg"));	

			
		}
		chkAnotherAddress.click();
		
	
		Assert.assertEquals(ActualMsg, Expected);

	}
	

}
