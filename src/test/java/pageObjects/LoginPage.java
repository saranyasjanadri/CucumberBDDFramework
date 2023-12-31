package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This page object class contains one constructor which will initiates
//the driver and for every element which is present on the login page
public class LoginPage 
{
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	
	
	//After successful login if we want to take another input
	//We must logout from the application,when you are performing DDT
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	
	
	
	public void setUserName(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	
	
	
	
	
	
	
	

}
