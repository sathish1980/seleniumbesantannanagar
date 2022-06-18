package pck.Seleniumjunebesantannanagar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verificationandvalidation {

	
	WebDriver browser;
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("http://www.leafground.com/home.html");
		System.out.println(browser.getTitle());
		System.out.println(browser.getCurrentUrl());
		browser.findElement(By.xpath("//h5[text()='Edit']//parent::a")).click();
		System.out.println("*********After click on edit***********");
		System.out.println(browser.getTitle());
		System.out.println(browser.getCurrentUrl());
		System.out.println(browser.findElement(By.id("email")).getAttribute("style"));
		System.out.println(browser.findElement(By.xpath("//label[@for='email']")).getText());
		System.out.println(browser.getWindowHandle());
		System.out.println(browser.getWindowHandles());
		
	}
	
	public void validation()
	{
		browser.get("http://www.leafground.com/pages/checkbox.html");
		Boolean check=browser.findElement(By.xpath("((//div[@class='example'])[1]//input)[1]")).isSelected();
		System.out.println(browser.findElement(By.xpath("((//div[@class='example'])[1]//input)[1]")).isSelected());
		System.out.println(browser.findElement(By.xpath("((//div[@class='example'])[1]//input)[1]")).isDisplayed());
		System.out.println(browser.findElement(By.xpath("((//div[@class='example'])[1]//input)[1]")).isEnabled());
		if(check==false)
		{
		browser.findElement(By.xpath("((//div[@class='example'])[1]//input)[1]")).click();
		}
		System.out.println(browser.findElement(By.xpath("((//div[@class='example'])[1]//input)[1]")).isSelected());
		System.out.println(browser.findElement(By.xpath("((//div[@class='example'])[1]//input)[1]")).isDisplayed());
		System.out.println(browser.findElement(By.xpath("((//div[@class='example'])[1]//input)[1]")).isEnabled());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Verificationandvalidation v = new Verificationandvalidation();
		v.launch();
		v.validation();
	}

}
