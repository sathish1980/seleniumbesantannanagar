package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.CommonActions;

public class Facebook_Logout_Page extends CommonActions
{
	WebDriver driver;
	@FindBy(xpath="(//div[@aria-label='Your profile'])[1]")
	WebElement dropdownbutton;
	@FindBy(xpath="//span[text()='Log Out']//parent::div")
	WebElement logoutbutton;
	
	
	public Facebook_Logout_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void logoutDropdown(WebDriver driver)
	{
		Explicitwaitforelementobeclickable(driver,dropdownbutton);
		ButtonClick(dropdownbutton);
	}
	
	public void logoutButton(WebDriver driver)
	{
		Explicitwaitforelementobeclickable(driver,logoutbutton);
		ButtonClick(logoutbutton);
	}
}
