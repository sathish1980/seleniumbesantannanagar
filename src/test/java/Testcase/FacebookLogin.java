package Testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import Commons.CommonActions;
import Drivers.Browserdriver;
import Pages.Facbook_login_Page;
import Pages.Facebook_Logout_Page;
import Utils.ExcelfileRead;

public class FacebookLogin extends Browserdriver
{

	CommonActions c = new CommonActions();
	@BeforeSuite
	public void Beforelaunch()
	{
		launchBrowser();
	}
	
	@BeforeTest
	public void Maximize()
	{
		driver.manage().window().maximize();
		driver.get(Urlvalue);
	}
	
	@AfterSuite
	public void Teardown()
	{
		extentreportclose();
		driver.quit();
	}
	
	@Test(priority=0,dataProvider="FBlogindata",dataProviderClass=DataProviderclass.class)
	public void ValidLoginandlogout(String usnam,String pwd) throws InterruptedException
	{
		Facbook_login_Page FB= new Facbook_login_Page(driver);
		FB.username(usnam);
		test.log(LogStatus.INFO,"User name entered : "+ usnam);
		FB.password(pwd);
		test.log(LogStatus.INFO,"password entered");
		FB.loginButton();
		test.log(LogStatus.INFO,"Button clicked");
		Facebook_Logout_Page FLP = new Facebook_Logout_Page(driver);
		String loginscussfull=c.takescreenshot(driver);
		test.log(LogStatus.INFO,"Login sucessfull",test.addScreenCapture(loginscussfull));
		FLP.logoutDropdown(driver);
		test.log(LogStatus.INFO,"logout dropdown clicked sucessfull");
		Thread.sleep(1000);
		FLP.logoutButton(driver);
		test.log(LogStatus.INFO,"logout button clicked sucessfull");
		Thread.sleep(1000);
		String logoutscussfull=c.takescreenshot(driver);
		test.log(LogStatus.INFO,"Logout sucessfull",test.addScreenCapture(logoutscussfull));
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Facebook – log in or sign up");	
			
	}

	@AfterMethod
	public void afterMethod(ITestResult result)
	{
	    try
	 {
	    if(result.getStatus() == ITestResult.SUCCESS)
	    {

	        //Do something here
	        System.out.println("passed **********");
	        test.log(LogStatus.PASS,"Login and logout is sucessfull");
			
	    }

	    else if(result.getStatus() == ITestResult.FAILURE)
	    {
	         //Do something here
	        System.out.println("Failed ***********");
	        String logoutscussfull=c.takescreenshot(driver);
			test.log(LogStatus.FAIL,test.addScreenCapture(logoutscussfull));


	    }

	     else if(result.getStatus() == ITestResult.SKIP ){

	        System.out.println("Skiped***********");

	    }
	}
	   catch(Exception e)
	   {
	     e.printStackTrace();
	   }

	}

}

