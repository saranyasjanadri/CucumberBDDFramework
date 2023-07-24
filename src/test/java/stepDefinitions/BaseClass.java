package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import org.apache.logging.log4j.*;

//Only common things are separated into the  base class.
//Whenever we put the common things in the base class,it must be extended 
//into every steps definitions class
public class BaseClass
{
	
	    //To access from multiple packages we are specifying it as public
		public WebDriver driver;
		
		//We have to create object for login page, through that object 
		//only we can access the action methods in the page object class
		public LoginPage lp;
		
		//Creating object for AddCustomerPage
		public AddCustomerPage addCust;
		
		//Creating object for AddCustomerPage
		public SearchCustomerPage searchCust;
		
		//Creating object for logger class
		public static Logger logger;
		
		//Creating object for properties class
		public Properties configProp;
		
		
		
		
		//Created for generating random string for unique email ID
		//Becoz we need to pass unique email id for every customer
		
		//Whenever we need to create some random value/string we have
		//to call this method
		
		
		//RandomStringUtils---->Java PreDefined Class 
		//randomAlphabetic(5)--->This method will create random 5 
		//character string
		//created this method as static so we can call it without creating 
		//any objects
		public static String randomstring()
		{
			String generatedString1=RandomStringUtils.randomAlphabetic(5);
			return (generatedString1);
		}
	

}
