package com.comcast.serviceability.common.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.serviceability.config.Configurations;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
	this.driver = driver; }

	
	@FindBy(xpath=Configurations.accountLookUp)
	public WebElement accountLookUp;
	

	@FindBy(xpath=Configurations.strAddress)
	public WebElement strAddress;
	
	@FindBy(xpath=Configurations.Aprt)
	public WebElement Aprt;
	
	
	@FindBy(xpath=Configurations.zipCode)
	public WebElement zipCode;
	
	@FindBy(xpath=Configurations.lookUpAccount)
	public WebElement lookUpAccount;
	
	
	public void chkExistingAccount(String StAddress,  String Zip)
	{
		int AddressRows = 0;
		strAddress.sendKeys(StAddress);
		zipCode.sendKeys(Zip);
		lookUpAccount.click();
		
		for(int i=1;i<AddressRows;i++)
			
		{
			AddressRows= i++;
			String AddressFound = (Configurations.ExAccounts_start+ i + Configurations.ExAccounts_last);
			String ActualAddress = driver.findElement(By.xpath(AddressFound)).getText();
			Assert.assertEquals(ActualAddress, StAddress);
		}
		
		
	}
	
	public Serviceability chkServiceablity(String StAddress, String Zip) {
		
		
		strAddress.sendKeys(StAddress);
		zipCode.sendKeys(Zip);
		lookUpAccount.click();

		

		return PageFactory.initElements(driver, Serviceability.class);
		
	
		
		
	}




		
	}
	
	
	
	
	
	
	
	
	
	





