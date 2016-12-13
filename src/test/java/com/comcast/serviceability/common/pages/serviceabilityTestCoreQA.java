package com.comcast.serviceability.common.pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.AccessException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.management.MBeanException;

import org.openqa.selenium.By;

//import javax.mail.MessagingException;
//import javax.mail.internet.AddressException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.comcast.serviceability.config.Configurations;
//import com.comcast.orderlab.util.TestConfig;
import com.comcast.serviceability.util.Xls_Reader;
//import com.comcast.orderlab.util.monitoringMail;

public class serviceabilityTestCoreQA {
	
	/*
	 * initializing properties, xls, creating db connection, 
	 * generating logs, initializing WebDriver
	 *  
	 */
	
	public static Properties config = new Properties();
	public static Properties object = new Properties();
	public static Xls_Reader excel = null;
	public static WebDriver driver = null;
	
	@FindBy(xpath=Configurations.Start)
	public WebElement Start;
	

	

	
	@BeforeSuite
	public  void init() throws IOException, InterruptedException
	{
		if (driver == null)
			
		{
			//loading config properties

			excel = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\comcast\\serviceability\\testdata\\testdata.xlsx");
			
			if (Configurations.browser.equals("Chrome"))
			
			{
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if
			(Configurations.browser.equals("ie"))
			{
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			else if
			(Configurations.browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
			
			driver.get(Configurations.TestSiteQA);//Change the URL for Env
			Runtime.getRuntime().exec("C:\\Webdriver\\AuthWindow.exe");
            //driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 30L);
            ((WebElement) wait.until(ExpectedConditions
                                            .presenceOfElementLocated(By.xpath(Configurations.Start))))
                                                                            .click();

            driver.manage().window().maximize();

			

			
			
		}
		  
		
	}
	
	@AfterSuite
	public static void quitDriver() throws AccessException, MBeanException
	{
		driver.quit();
	
	}
	
	
}

