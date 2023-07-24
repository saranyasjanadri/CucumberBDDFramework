package utilities;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper
{
	public WebDriver driver;
	
	
	//Whenever i created a object for WaitHelper class somewhere
	//in the another classes that will automatically accept the driver
	//and here the driver will be initiated.
	public WaitHelper(WebDriver driver)//Constructor
	{
		this.driver=driver;
	}
	
	
	
	//Whenever i want to identify some element i will wait till that 
	//element is present on the web page or till that element is visible on
	//the web page.
	
	//So before performing any action on the element on the web page
	//till that element is visible on the web page i need to wait for sometime
	//for that this method is useful.
	public void WaitForElement(WebDriver driver, WebElement element, int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		
		//Explicit wait
		//Wait till the passed element is visible on the page
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	

}
