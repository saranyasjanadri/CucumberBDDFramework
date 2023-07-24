package stepDefinitions;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
//import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;


public class Steps extends BaseClass
{
	
	//This is the hook for cucumber by adding this annotation, this method
	//executes only one time before the test cases starts.
	@Before  
	public void setup() throws IOException
	{
		//Added Logger configuration
        logger=LogManager.getLogger("CucumberBDDFramework.class");
		
        
        //Reading properties from the properties file
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
        configProp.load(configPropfile);
		
 
        
       	//1)This is for manually downloading and specifying the drivers seperately
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		
        /*
        //2)This can be used by specifying webDriver manager dependencies in the pom.xml
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		*/
        
        //3)Instead of putting the complete path this is used to reading the
        //path from the config.properties file
        
        
        String br=configProp.getProperty("browser");
        if(br.equals("chrome"))
        {
        System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
        //Initiating the driver
        driver =new ChromeDriver();
        }
        
        else if(br.equals("firefox"))
        {
        System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
        driver =new FirefoxDriver();
        }
        
        else if(br.equals("edge"))
        {
        System.setProperty("webdriver.edge.driver",configProp.getProperty("msedgepath"));
        driver =new EdgeDriver();
        }
        
        
        
		logger.info(" *******Launching Browser******* ");
	     
		
	}
	
	
	
	
	//To implement these methods we have to interact with the page 
	//object class
	
	
	//Login feature step Definitions--------------------------------------
	
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser()
	{
	    //Whenever we create login page object we need to pass the 
	    //driver parameter so that the constructor will be invoked 
	    //and receives the driver parameter in the page object class
		
	    lp=new LoginPage(driver);
	}

	
	//The feature file scenario step is passing some parameter and this 
	//method should accept that parameter 
	@When("User opens URL {string}")
	public void user_opens_URL(String url)
    {
	   logger.info(" *******Opening URL******* ");
	   driver.get(url); 
	   driver.manage().window().maximize();
	}

	
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) 
	{
		logger.info(" *******Providing login details******* ");
	    lp.setUserName(email);
	    lp.setPassword(password);
	}

	
	@When("Click on Login")
	public void click_on_Login()
	{
		logger.info(" *******Started login******* ");
	    lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title)
	{
	   
	   //Validation part
	   if(driver.getPageSource().contains("Login was unsuccessful"))
	   {
		   driver.close();
		   logger.info(" *******Login passed******* ");
		   //import assert from junit not from testng
		   Assert.assertTrue(false);
	   }
	   else
	   {
		 logger.info(" *******Login failed******* ");
		 Assert.assertEquals(title,driver.getTitle());
	   }
	}

	@When("User click on Logout link")
	public void user_click_on_Logout_link() throws InterruptedException 
	{
	  logger.info(" *******Click on logout link******* ");
	  lp.clickLogout();
	  Thread.sleep(3000);
	}

	@And("Close browser")
	public void close_browser() 
	
	{
	   logger.info(" *******Closing Browser******* ");
	   driver.quit();
	}
	
	
	
	
	
	
	
	
	//Add a new Customer(Scenario)---------------------------------
		
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard()
	{
	   addCust=new AddCustomerPage(driver); 
	   Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	}

	
	
	@When("User click on customer's Menu")
	public void user_click_on_customer_s_Menu() throws InterruptedException
	{
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	    
	}

	
	
	@When("Click on customer's Menu Item")
	public void click_on_customer_s_Menu_Item() throws InterruptedException
	{
		Thread.sleep(3000);
		addCust.clickOnCustomersMenuItem();
	    
	}

	
	
	@When("Click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException 
	{
		Thread.sleep(3000);
		addCust.clickOnAddnew();
	    
	}

	
	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page()
	{
		 Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
	}

	
	
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException
	{
		logger.info(" *******Adding new customer******* ");
		logger.info(" *******Providing customer details******* ");
	    String email=randomstring()+"@gmail.com";
	    addCust.setEmail(email);
	    
	    addCust.setPassword("test123");
	    
	    //By default-->customer is "Registered"
	    //The customer cannot be in both "Guests" and "Registered" customer roles
	    //Add the customer to "Guests" or "Registered" customer role
	    addCust.clickOnDelete();
	    Thread.sleep(3000);
	    addCust.setCustomerRoles("Guests");
	    Thread.sleep(3000);
	    
	    addCust.setManagerOfVendor("Vendor 1");
	    addCust.setGender("Male");
	    addCust.setFirstName("Pavan");
	    addCust.setLastName("Kumar");
	    addCust.setDob("07/05/1985");//Format-->DD/MM/YYYY
	    addCust.setCompanyName("busyQA");
	    addCust.setAdminContent("This is for Testing");
	    
	}

	
	
	@When("Click on Save button")
	public void click_on_Save_button() throws InterruptedException
	{
	  logger.info(" *******Saving customer data******* ");
	  addCust.clickOnSave();
	  Thread.sleep(3000);
	  
	}

	
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) 
	{
		//To capture the confirmation message from the page:
		
		//driver.findElement(By.tagName("body")--->This will give you 
		//the complete html code from the body and getText()is used to
		//retrieve the complete text from the html code and 
		//contains("") gives the below given value.
	    Assert.assertTrue(driver.findElement(By.tagName("body"))
	    		.getText().contains("The new customer has been added successfully"));
	
	}
	
	
	
	
	
	//Search Customer by Email ID(Scenario)--------------------------------------
	
	
	@When("Enter customer Email")
	public void enter_customer_Email()
	{
		logger.info(" *******Searching customer by using email id******* ");
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	   
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException
	{
		searchCust.clickSearch();
		Thread.sleep(3000);
	   
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() 
	{
	    boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	    Assert.assertEquals(true,status);
	}
	
	
	
	
	
	
	//Search Customer by Name(Scenario)-------------------------------
	
	@When("Enter customer FirstName")
	public void enter_customer_FirstName()
	{
		logger.info(" *******Searching customer by name******* ");
		searchCust=new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_LastName()
	{
		searchCust.setLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_Name_in_the_Search_table()
	{
	   boolean status=searchCust.searchCustomerByName("Victoria Terces");
	   Assert.assertEquals(true,status);
	}










}
