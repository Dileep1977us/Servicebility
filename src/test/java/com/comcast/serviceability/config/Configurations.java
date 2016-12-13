package com.comcast.serviceability.config;

public class Configurations {
	
	public static final String TestSiteProd = "https://einstein360.cable.comcast.com/einstein360#Layout=1";
	
	public static final String TestSiteUAT = "https://einstein360-uat.cable.comcast.com/einstein360";
	
	public static final String TestSiteQA= "https://mcsweb-dt-s1q.cable.comcast.com/Einstein360";
	
	public static final String browser="Chrome";
	
	public static final String Start="//*[@id=\"divEinsteinReleaseCheck\"]/div/div[3]/div/button";
	
	public static final String IhaveGotIt = "//*[@id=\"go-to-help-center\"]";
	
	//HomePage
	
	public static final String accountLookUp = "//*[@id=\"recent-customers\"]/a";
	
	public static final String newCustomer_Start = "//*[@id=\"RecentlyViewedAccounts\"]/li[";
	
	public static final String newCustomer_End = "]/a";
	
	public static final String strAddress = "//*[@id=\"txtPostalAddress\"]";
	
	public static final String zipCode = "//*[@id=\"txtZip\"]";
	
	public static final String lookUpAccount = "//*[@id=\"btnNewExistCustSearch\"]";
	
	public static final String Aprt = "//*[@id=\"txtSecondaryAddress\"]";
	
	public static final String ExAccounts_start = "//*[@id=\"tblSearchResultGrid\"]/tbody/tr[" ;
	
	public static final String ExAccounts_last  = "]/td[2]";
	
	//Serviceabilty Page
	public static final String servcMsg = "//*[@id=\"alert-1\"]/span";
	
	public static final String chkAnotherAddress = "//*[@id=\"Serviceability\"]/div/div/div/div[2]/div/div[1]/div[2]/div/div/div[2]/button";
	

}
