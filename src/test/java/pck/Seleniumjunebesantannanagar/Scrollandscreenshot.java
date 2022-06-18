package pck.Seleniumjunebesantannanagar;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrollandscreenshot {
	WebDriver browser;
	public void scroll()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("http://www.leafground.com/home.html");
		JavascriptExecutor js= (JavascriptExecutor)browser;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,750)", "");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenshot("testcase1");
		//vertical scroll up
		js.executeScript("window.scrollBy(0,-250)", "");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenshot("testcase2");
		//Horizontaly scroll right
		js.executeScript("window.scrollBy(250,0)", "");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenshot("testcase3");
		//Horizontaly scroll left
		js.executeScript("window.scrollBy(-250,0)", "");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenshot("testcase4");
		//scrollto the end
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenshot("testcase5");
		// scrollintospecificelement
		WebElement parent = browser.findElement(By.xpath
		("//h5[text()='Window']//parent::a"));

        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", parent);
        screenshot("testcase6");
	}
	
	public void screenshot(String testcasename)
	{
	
	TakesScreenshot ts =(TakesScreenshot)browser;
	File sourcefile= ts.getScreenshotAs(OutputType.FILE);
	File Destinationfile= new File(System.getProperty("user.dir")+
			"//screenshot//"+testcasename+".png");
	try {
		FileUtils.copyFile(sourcefile, Destinationfile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scrollandscreenshot s = new Scrollandscreenshot();
		s.scroll();
	}

}
