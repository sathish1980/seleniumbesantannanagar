package pck.Seleniumjunebesantannanagar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropdown {
	WebDriver browser;
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.makemytrip.com/");
		browser.findElement(By.xpath("//label[@for='fromCity']//input")).click();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("langCardClose")));
		browser.findElement(By.className("langCardClose")).click();
	}
	public void fromandto(String requestedtext)
	{
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li[1]")));
		List<WebElement> totalRow=browser.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li"));
		int rowsize=totalRow.size();
		System.out.println(rowsize);
		for (int i=1;i<=rowsize;i++)
		{
		String actualText=browser.findElement(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li["+i+"]//div[contains(@class,'pushRight')]")).getText();
		System.out.println(actualText);	
		if (requestedtext.equalsIgnoreCase(actualText))
			{
				System.out.println("Matched");
				browser.findElement(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li["+i+"]")).click();
				break;
			}
		}
	
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dropdown d = new dropdown();
		d.launch();
		d.fromandto("NYC");
		d.fromandto("MAA");
	}

}
