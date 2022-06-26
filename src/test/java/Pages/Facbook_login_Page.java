package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.CommonActions;

public class Facbook_login_Page extends CommonActions
{
	WebDriver driver;
	@FindBy(id="email")
	WebElement uname;
	@FindBy(id="pass")
	WebElement pwd;
	@FindBy(name="login")
	WebElement lgbtn;
	@FindBy(linkText="Forgetten Password?\"")
	WebElement frgpwd;
	String dropdoen="//div//a";
	
	
	public Facbook_login_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void username(String usernameEnter)
	{
		EnterintoTextbox(uname,usernameEnter);
	}
	
	public void password(String passwordEnter)
	{
		EnterintoTextbox(pwd,passwordEnter);
	}
	
	public void loginButton()
	{
		ButtonClick(lgbtn);
	}
	
	public void ForgottenPassword()
	{
		ButtonClick(frgpwd);
	}
	
	public void CreateAccount(WebElement textboxWebElement)
	{
		//Need to be update later
		WebElement lgbutton=driver.findElement(By.linkText("Forgetten Password?"));
		ButtonClick(lgbutton);
	}

	public void AddAccount(WebElement textboxWebElement)
	{
		//Need to be update later
		WebElement lgbutton=driver.findElement(By.linkText("Forgetten Password?"));
		driver.findElements(By.xpath(dropdoen));
		ButtonClick(lgbutton);
	}


}
