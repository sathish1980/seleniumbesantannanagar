package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utils.PropertyfileRead;

public class Browserdriver 
{

	PropertyfileRead  p= new PropertyfileRead();
	public static WebDriver driver;
	String projectpath=System.getProperty("user.dir");
	public String Urlvalue;
	public static ExtentReports report;
	public static ExtentTest test;
	static String reportpath= System.getProperty("user.dir")+"\\Reports\\";
	
	
	public void launchBrowser()
	{
		String browsername=p.propreaddata().getProperty("Browser");
		Urlvalue=p.propreaddata().getProperty("URL");
		if(browsername.equalsIgnoreCase("chrome"))
		{	
			ChromeOptions c= new ChromeOptions();
			c.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver",projectpath+"\\Browserdriver\\Chromedriver\\chromedriver.exe");
			driver= new ChromeDriver(c);
		}
		else if (browsername.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",projectpath+"\\Browserdriver\\edgedriver_win64\\msedgedriver.exe");
			driver= new EdgeDriver();
		}
		extenterportstart();
	}
	
	public void extenterportstart()
	{
		report = new ExtentReports(reportpath+"extenreport.html",false);
		test= report.startTest("Extent report");	
	}
	
	public void extentreportclose()
	{
		report.flush();
		
	}
	
}
