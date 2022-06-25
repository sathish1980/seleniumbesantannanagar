package Testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import Commons.CommonActions;
import Drivers.Browserdriver;
import Utils.ExcelfileRead;

public class FacebookLogin extends Browserdriver
{

	CommonActions c= new CommonActions();
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
		try
		{
		c.Explicitwaitforvisibilityofelement(driver, driver.findElement(By.id("email")));
		WebElement username=driver.findElement(By.id("email"));
		c.EnterintoTextbox(username, usnam);
		test.log(LogStatus.INFO,"User name entered : kumar.sathish189@gmail.com");
		WebElement password=driver.findElement(By.id("pass"));
		c.EnterintoTextbox(password, pwd);
		test.log(LogStatus.INFO,"password entered");
		WebElement loginbutton=driver.findElement(By.name("login"));
		c.ButtonClick(loginbutton);
		test.log(LogStatus.INFO,"Button clicked");
		c.Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("//div[@aria-label='Your profile']")));
		
		String loginscussfull=c.takescreenshot(driver);
		test.log(LogStatus.INFO,"Login sucessfull",test.addScreenCapture(loginscussfull));
		WebElement dropdownbutton=driver.findElement(By.xpath("(//div[@aria-label='Your profile'])[1]"));
		c.ButtonClick(dropdownbutton);
		test.log(LogStatus.INFO,"logout dropdown clicked sucessfull");
		Thread.sleep(1000);
		c.Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("//span[text()='Log Out']//parent::div")));
		WebElement logoutbutton= driver.findElement(By.xpath("//span[text()='Log Out']//parent::div"));
		c.ButtonClick(logoutbutton);
		test.log(LogStatus.INFO,"logout button clicked sucessfull");
		Thread.sleep(1000);
		String logoutscussfull=c.takescreenshot(driver);
		test.log(LogStatus.INFO,"Logout sucessfull",test.addScreenCapture(logoutscussfull));
	
		//c.Explicitwaitforvisibilityofelement(driver, username);
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Facebook – log in or sign up");
		test.log(LogStatus.PASS,"Login and logout is sucessfull");
		}
		catch(Exception e)
		{
			String logoutscussfull=c.takescreenshot(driver);
			test.log(LogStatus.INFO,e);
			test.log(LogStatus.FAIL,test.addScreenCapture(logoutscussfull));

			
		}
	}


}

