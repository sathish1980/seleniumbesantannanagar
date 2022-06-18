package pck.Seleniumjunebesantannanagar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertconcept {
	WebDriver browser;
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("http://www.leafground.com/pages/Alert.html");
		browser.findElement(By.xpath("//button[text()='Alert Box']")).click();
		browser.switchTo().alert().accept();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		browser.switchTo().alert().dismiss();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		
		Alert alearvaraible=browser.switchTo().alert();
		alearvaraible.sendKeys("Besant");
		alearvaraible.accept();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		
		Alert alearvaraible1=browser.switchTo().alert();
		System.out.println(alearvaraible1.getText());;
		alearvaraible1.accept();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alertconcept a = new Alertconcept();
		a.launch();
	}

}
