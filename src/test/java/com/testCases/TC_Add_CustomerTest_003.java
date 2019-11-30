package com.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.AddCustomerPage;
import com.pageObjects.LoginPage;

public class TC_Add_CustomerTest_003 extends BaseClass {
	
    @Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
    	
    	LoginPage lp = new LoginPage(driver);
    	lp.setUserName(username);
    	lp.setPassword(password);
    	lp.ClickSubmit();
    	
    	Thread.sleep(2000);
    	
    	AddCustomerPage addcust = new AddCustomerPage(driver);
    	
    	addcust.clickOnAddNewCustomer();
    	addcust.setCustomerName("Pradip");
    	addcust.selectGender();
    	addcust.setDOB("12", "01", "1992");
    	Thread.sleep(2000);
    	addcust.setAddress("India");
    	addcust.setCity("Pune");
    	addcust.setState("Maharashtra");
    	addcust.setPin("445001");
    	addcust.setMobileNo("9623314087");    	
    	addcust.setEmailID(randomString()+"@gmail.com");  
    	addcust.setPassword("Test1234");
    	Thread.sleep(2000);
    	addcust.clickOnSubmit();
    	Thread.sleep(2000);
    	
    	boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
    	
    	if(res==true)
    	{
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		captureScreen(driver,"addNewCustomer");
    		Assert.assertTrue(false);
    		
    	}	
    		
		
	}
    
    public String randomString()
    {
    	String generatedString = RandomStringUtils.randomAlphanumeric(5);
    	return generatedString;
    }
}
