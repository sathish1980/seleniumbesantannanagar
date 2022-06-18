package pck.Seleniumjunebesantannanagar;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseandKeyboardactions {
	
	WebDriver browser;
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
	}
	
	public void mouseactions()
	{
		browser.get("https://www.ebay.com/");
		Actions a = new Actions(browser);
		a.moveToElement(browser.findElement(By.xpath("(//div[@id='mainContent']//following::a[text()='Electronics'])[1]"))).perform();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Cameras and photos']")));
		a.moveToElement(browser.findElement(By.xpath("//a[text()='Samsung']"))).click().build().perform();
	}
	
	public void draganddrop()
	{
		browser.get("http://www.leafground.com/pages/drop.html");
		Actions a = new Actions(browser);
		a.moveToElement(browser.findElement(By.id("draggable"))).
		dragAndDrop(browser.findElement(By.id("draggable")), browser.findElement(By.id("droppable"))).perform();
		String actualtext= browser.findElement(By.xpath("//div[@id='droppable']//p")).getText();
		if (actualtext.equalsIgnoreCase("dropped!"))
		{
			System.out.println("Draganddrop sucessfull");
		}
		else
		{
			throw new NullPointerException("Text mismatched : actual text is: "+actualtext+ " The expected text is : dropped");
		}
	}

	public void mousefacebook()
	{
		browser.get("https://www.facebook.com/");
		Actions a = new Actions(browser);
		a.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	}
	
	public void mousefacebookkeyboard()
	{
		browser.get("https://www.facebook.com/");
		Actions a = new Actions(browser);
		a.moveToElement(browser.findElement(By.id("email"))).sendKeys("kumarsathish189@gmail.com").perform();
		//a.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Robot rob;
		try {
			rob = new Robot();
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_A);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_A);
			
			a.contextClick().perform();
			
			rob.keyPress(KeyEvent.VK_DOWN);
			rob.keyRelease(KeyEvent.VK_DOWN);
			rob.keyPress(KeyEvent.VK_DOWN);
			rob.keyRelease(KeyEvent.VK_DOWN);
			rob.keyPress(KeyEvent.VK_DOWN);
			rob.keyRelease(KeyEvent.VK_DOWN);
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			rob.keyPress(KeyEvent.VK_TAB);
			rob.keyRelease(KeyEvent.VK_TAB);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mousefacebookkeyboardwithrobot()
	{
		browser.get("https://www.facebook.com/");
		Actions a = new Actions(browser);
		a.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").perform();
		//a.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		Robot rob;
		try {
			rob = new Robot();
			rob.keyPress(KeyEvent.VK_TAB);
			rob.keyRelease(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseandKeyboardactions m = new MouseandKeyboardactions();
		m.launch();
		m.mousefacebookkeyboard();
	}

}
