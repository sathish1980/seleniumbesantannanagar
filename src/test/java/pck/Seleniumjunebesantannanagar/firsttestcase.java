package pck.Seleniumjunebesantannanagar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class firsttestcase {
	
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
	/*	browser.navigate().to("https://www.gmail.com/");
		browser.navigate().back();
		browser.navigate().forward();
		browser.navigate().refresh();*/
		//browser.quit();
		//WebElement username=browser.findElement(By.id("email"));
		//WebElement user=browser.findElement(By.cssSelector("input[type=text]"));
		WebElement user=browser.findElement(By.xpath("//input[contains(@class,'r1') and @type='text']"));
		user.sendKeys("username");
		WebElement username=browser.findElement(By.name("pass"));
		//WebElement username=browser.findElement(By.className("inputtext _55r1 _6luy _9npi"));
		
		username.sendKeys("kumarsathish189@gmail.com");
		//username.clear();
		username.sendKeys("sathish");
		/*browser.findElement(By.linkText("Forgotten password?")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.findElement(By.partialLinkText("Forgotten")).click();
		browser.findElement(By.id("emails")).sendKeys("plainwebelement");
		browser.findElement(By.id("emails")).clear();
		browser.findElement(By.id("emails")).sendKeys("plainwebelement");*/
		//browser.findElement(By.xpath("//button[starts-with(@id,'u_0_')]")).click();
		browser.findElement(By.xpath("//button[text()='Log In']")).click();
	}
	
	public void syncronization()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.findElement(By.name("firstname")).sendKeys("sathish");
		browser.findElement(By.name("reg_email__")).sendKeys("kumarsathish189@gmail.com");
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("reg_email_confirmation__")));
		browser.findElement(By.name("reg_email_confirmation__")).sendKeys("kumarsathish189@gmail.com");
		Select daydropdown = new Select(browser.findElement(By.id("day")));
		daydropdown.selectByIndex(16);
		Select mondropdown = new Select(browser.findElement(By.id("month")));
		mondropdown.selectByValue("10");
		Select yrdropdown = new Select(browser.findElement(By.id("year")));
		yrdropdown.selectByVisibleText("2006");
		
	}
	
	public void multiselect()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("http://www.leafground.com/pages/Dropdown.html");
		Select yrdropdown = new Select(browser.findElement(By.xpath("(//div[@class='example'])[6]//child::select")));
		Boolean ismultipleenabled=yrdropdown.isMultiple();
		if(ismultipleenabled)
		{
			yrdropdown.selectByIndex(1);
			yrdropdown.selectByValue("3");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			yrdropdown.selectByVisibleText("Loadrunner");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			yrdropdown.deselectByIndex(3);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			yrdropdown.deselectAll();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		firsttestcase f = new firsttestcase();
		f.multiselect();
	}

}
