package com.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.utilities.XLUtilsPOI;



public class TC_LoginTest_DDT_002 extends BaseClass {

	@Test(dataProvider="LoginData1")
	public void loginDDT(String user,String pwd) throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username is provided");
		lp.setPassword(pwd);
		logger.info("Password is provided");
	    lp.ClickSubmit();
	    
	    if(isAlertPresent()==true)
	    {
	    	driver.switchTo().alert().accept();
	    	driver.switchTo().defaultContent();
	    	captureScreen(driver,"TC_LoginTest_DDT_002");
	    	Assert.assertTrue(false);
	    	logger.warn("Login Failed");
	    }	
	    
	    else
	    {
	    	Assert.assertTrue(true);
	    	logger.info("Login Passed");
	    	lp.ClickLogout();
	    	driver.switchTo().alert().accept();
	    	driver.switchTo().defaultContent();
	    }
	    
	}
	
	public boolean isAlertPresent()
	{
		try 
		{
		driver.switchTo().alert();
		return true;
		} 
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	
	@DataProvider(name="LoginData1")
	String [][] getData() throws IOException
	{
          String path = "src\\test\\java\\com\\testData\\LoginData.xls";
		
		int rownum = XLUtilsPOI.getRowCount(path, "Sheet1");
		int colcount = XLUtilsPOI.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j] = XLUtilsPOI.getCellData(path, "Sheet1", i, j);
			}
		}
	 return logindata;	
		
	}
	
}
