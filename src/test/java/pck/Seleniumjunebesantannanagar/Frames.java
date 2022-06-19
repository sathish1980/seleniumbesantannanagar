package pck.Seleniumjunebesantannanagar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames 
{
	WebDriver browser;
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
	}
	
	public void frameconcept()
	{
		browser.get("http://www.leafground.com/pages/frame.html");
		
		List<WebElement> framecount=browser.findElements(By.tagName("iframe"));
		int framesize=framecount.size();
		
		for(int i=0;i<framesize;i++)
		{
			browser.switchTo().frame(i);
			List<WebElement> valueexist=browser.findElements(By.id("Click"));
			int valuesize=valueexist.size();
			if(valuesize>0)
			{
				browser.findElement(By.id("Click")).click();
				browser.switchTo().defaultContent();
				break;
			}
			browser.switchTo().defaultContent();
		}
	}
	
	public void frameconceptinsideanoherframe()
	{
		String identified="not done";
		browser.get("http://www.leafground.com/pages/frame.html");
		
		List<WebElement> framecount=browser.findElements(By.tagName("iframe"));
		int framesize=framecount.size();
		
		for(int i=0;i<framesize;i++)
		{
			browser.switchTo().frame(i);
			List<WebElement> innerframe=browser.findElements(By.tagName("iframe"));
			int innerframesize=innerframe.size();
			if(innerframesize>0)
			{
				//for(int j=0;j<innerframesize;j++)
				//{
					browser.switchTo().frame("frame2");
					List<WebElement> valueexist1=browser.findElements(By.id("Click1"));
					int valuesize1=valueexist1.size();
					if(valuesize1>0)
					{
						browser.findElement(By.id("Click1")).click();
						browser.switchTo().defaultContent();
						//identified="done";
						break;
					}
					browser.switchTo().defaultContent();
				//}
				/*if(identified=="done")
				{
					break;
				}*/
			}
			
			browser.switchTo().defaultContent();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frames f = new Frames();
		f.launch();
		f.frameconceptinsideanoherframe();
	}

}
