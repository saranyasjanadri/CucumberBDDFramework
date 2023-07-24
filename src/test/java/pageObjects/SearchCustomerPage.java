package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage
{
	
	public WebDriver ldriver;
	WaitHelper waithelper;
	
	
	//This constructor will be invoked at the time of object creation 
    //for SearchCustomerPage
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
		waithelper=new WaitHelper(ldriver);
	}
	
	
	@FindBy(how=How.ID, using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID, using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID, using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID, using="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdobMonth;
	
	@FindBy(how=How.ID, using="SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDay;
	
	@FindBy(how=How.ID, using="SearchCompany")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(how=How.XPATH, using="//div[@role='listbox']")
	@CacheLookup
	WebElement txtcustomerRoles;
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement listitemAdministrators;
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement listitemModerators;
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement listitemGuests;
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement listitemRegistered;
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement listitemVendors;
	
	@FindBy(how=How.ID, using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how=How.XPATH, using="//table{@id='customers-grid]")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid'}//tbody/tr")
	@CacheLookup
	List <WebElement> tableRows;
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List <WebElement> tableColumns;
	
	
	
	
	
	//Action Methods
	
	public void setEmail(String email)
	{
		waithelper.WaitForElement(ldriver,txtEmail,30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	
	public void setFirstName(String fname)
	{
		waithelper.WaitForElement(ldriver,txtFirstName,30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	
	
	public void setLastName(String lname)
	{
		waithelper.WaitForElement(ldriver,txtFirstName,30);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	
	public void clickSearch()
	{
		btnSearch.click();
		waithelper.WaitForElement(ldriver,btnSearch,30);
	}
	
	
	public int getNoOfRows() 
	{
		return(tableRows.size());
	}
	
	
	public int getNoOfColumns() 
	{
		return(tableColumns.size());
	}
	
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equals(email))
			{
				flag=true;
			}
			
		}
		
		return flag;
		
	}
	
	
	
	public boolean searchCustomerByName(String Name)
	{
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			
			//Separating first name and last name and storing in the array
			String names[]=name.split("");
			
			if(names[0].equals("Victoria") && names[1].equals("Terces"))
			{
				flag=true;
			}
			
		}
		
		return flag;
		
	}
	
	
	
	
	

}
