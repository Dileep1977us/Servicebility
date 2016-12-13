package com.comcast.serviceability.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.serviceability.common.pages.HomePage;
import com.comcast.serviceability.common.pages.Serviceability;
import com.comcast.serviceability.common.pages.serviceabilityTestCore;
import com.comcast.serviceability.util.servcExcel;





public class ExistingCustomerFound extends serviceabilityTestCore {

	@BeforeTest
	public void isSkip()
	
	{
		if
		( ! servcExcel.isExecutable("ExistingCustomerFound"))//tc id from test suite
		{
		 throw new SkipException("Skipping the Test Case");
		}
		
	}
	
	@Test(dataProvider = "getData")

	public static void main(String StAddress, String Zip,String Expected) throws InterruptedException {
		

		HomePage searchAddress = PageFactory.initElements(driver, HomePage.class);
		
		searchAddress.chkExistingAccount(StAddress,  Zip);
		

	
	}
	
	@DataProvider
	
	public Object [][] getData(){
	
	return servcExcel.getData("ExistingAddress");//Sheet Name of the test case

	}
}
