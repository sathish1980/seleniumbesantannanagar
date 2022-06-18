package pck.Seleniumjunebesantannanagar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	
	WebDriver browser;
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
	}
	
	public void tableconcept(String expectedvalue)
	{
		browser.get("http://www.leafground.com/pages/table.html");
		
		List<WebElement> totalRows=browser.findElements(By.xpath("//div[@id='contentblock']//table//tr"));
		int rowsize=totalRows.size();
		
		for (int i=2;i<=rowsize;i++)
		{
			String actualText=browser.findElement(By.xpath("//div[@id='contentblock']//table//tr["+i+"]//td[1]//font")).getText();
			
			if (!expectedvalue.equalsIgnoreCase(actualText))
			{
				browser.findElement(By.xpath("//div[@id='contentblock']//table//tr["+i+"]//td[3]//input")).click();
				//break;
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebTable w =new WebTable();
		w.launch();
		w.tableconcept("Learn to interact with Elements");
	}

}
