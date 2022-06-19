package pck.Seleniumjunebesantannanagar;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {
	
	WebDriver browser;
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
	}
	
	public void windowshandling()
	{
		browser.get("http://www.leafground.com/pages/Window.html");
		String parentwindow=browser.getWindowHandle();
		browser.findElement(By.id("home")).click();
		Set<String> childvalue=browser.getWindowHandles();
		
		for(String child:childvalue)
		{
			if(child!=parentwindow)
			{
				browser.switchTo().window(child);
				List<WebElement> elementexist=browser.findElements(By.xpath("//h5[text()='Edit']//parent::a"));
				int elementsize=elementexist.size();
				if(elementsize>0)
				{
					browser.manage().window().maximize();
					browser.findElement(By.xpath("//h5[text()='Edit']//parent::a")).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					browser.findElement(By.id("email")).sendKeys("kumar.sathish189@gmail.com");
					browser.close();
					browser.switchTo().window(parentwindow);
				}
				
			}
			
		}
		
	}
	
	public void windowshandlingmultiple()
	{
		browser.get("http://www.leafground.com/pages/Window.html");
		String parentwindow=browser.getWindowHandle();
		browser.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> childvalue=browser.getWindowHandles();
		
		for(String child:childvalue)
		{
			if(child!=parentwindow)
			{
				browser.switchTo().window(child);
				List<WebElement> elementexist=browser.findElements(By.linkText("Go to Home Page"));
				int elementsize=elementexist.size();
				if(elementsize>0)
				{
					browser.manage().window().maximize();
					browser.findElement(By.linkText("Go to Home Page")).click();
					System.out.println(browser.getTitle());
					browser.findElement(By.xpath("//h5[text()='Edit']//parent::a")).click();
					browser.findElement(By.id("email")).sendKeys("kumar.sathish189@gmail.com");
				
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					browser.quit();
					break;
					//browser.findElement(By.id("email")).sendKeys("kumar.sathish189@gmail.com");
					
					//browser.switchTo().window(parentwindow);
				}
				
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowsHandling W = new WindowsHandling();
		W.launch();
		W.windowshandlingmultiple();
	}

}
