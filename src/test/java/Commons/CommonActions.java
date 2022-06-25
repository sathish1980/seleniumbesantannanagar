package Commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions 
{

	public void EnterintoTextbox(WebElement textWebelement,String textobeEnter)
	{
		if(textWebelement.isDisplayed())
		{
			textWebelement.clear();
			textWebelement.sendKeys(textobeEnter);
		}

	}
	
	public void ButtonClick(WebElement buttonWebelement)
	{
		if(buttonWebelement.isDisplayed())
		{
			buttonWebelement.click();
		}

	}
	
	public void RadioButtonClick(WebElement buttonWebelement)
	{
		if(buttonWebelement.isSelected()==false)
		{
			buttonWebelement.click();
		}

	}
	
	public void checkBoxClick(WebElement buttonWebelement)
	{
		if(buttonWebelement.isSelected()==false)
		{
			buttonWebelement.click();
		}

	}
	
	public void uncheckBoxClick(WebElement buttonWebelement)
	{
		if(buttonWebelement.isSelected()==true)
		{
			buttonWebelement.click();
		}

	}
	
	public void Explicitwaitforelementobeclickable(WebDriver driver,WebElement elementobeclickableWebelement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(elementobeclickableWebelement));

	}
	
	public void Explicitwaitforvisibilityofelement(WebDriver driver,WebElement elementobeclickableWebelement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(elementobeclickableWebelement));

	}
	
	public void Explicitwaitforpresencefelement(WebDriver driver,By elementobeclickableWebelement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(elementobeclickableWebelement));

	}
	
	public static String takescreenshot(WebDriver driver)
	{
		Date date = new Date();
	      //This method returns the time in millis
	    long timeMilli = date.getTime();
		String date_v= String.valueOf(timeMilli);
		//System.out.println(date_v);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File Destinationfile= new File(System.getProperty("user.dir")+"//screenshot//Testcase_1_"+date_v+".png");
		try {
			FileUtils.copyFile(sourcefile, Destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Destinationfile.toString();
	}
}
