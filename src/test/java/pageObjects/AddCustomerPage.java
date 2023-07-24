package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage 
{
	public WebDriver ldriver;
	
	
	//Create one constructor and it will accept remote driver from actual
	//test and store that into your local driver and
	//we need to initiate the PageFactory in this.
	//This is applicable for the entire class
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
	}
     
	
	//Different approach of POM
	//Capture only locator for all the elements and then identify those 
	//elements using findBy method later in action methods
	
	By lnkCustomers_menu=By.xpath("(//a[@class='nav-link'])[21]");
	By lnkCustomers_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	By btnAddnew=By.xpath("//a[normalize-space()='Add new']");
	
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword =By.xpath("//input[@id='Password']");
	
	By txtcustomerRoles=By.xpath("(//div[@role='listbox'])[2]");
	
	By lstitemAdministrators=By.xpath("//li[normalize-space()='Administrators']");
	By lstitemRegistered=By.xpath("//li[@id='9521c866-01b3-4c0f-976a-8ffc3e441b1e']");
	By lstitemGuests=By.xpath("//li[normalize-space()='Guests']");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpmgrOfVendor=By.xpath("//select[@id='VendorId']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFemaleGender=By.id("Gender_Female");
	
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
	
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	By deleteOption=By.xpath("//span[@title='delete']");
	
	
	
	//Actions Methods for every element
	//passing the locators inside the findElement
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu()
	{
		ldriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersMenuItem()
	{
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddnew()
	{
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException
	{
		//If role is Vendors should not delete Register as per 
		if(!role.equals("Vendors"))
		{
			ldriver.findElement(By.xpath("//ul[@id='SelectedCustomerRoleIds_listbox']"));
		}
		ldriver.findElement(txtcustomerRoles).click();
		WebElement listitem;
		Thread.sleep(3000);
		
		
		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(lstitemAdministrators);
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(lstitemGuests);
		}
		else if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(lstitemRegistered);
		}
		else if(role.equals("Vendors"))
		{
			listitem=ldriver.findElement(lstitemVendors);
		}
		else
		{
			listitem=ldriver.findElement(lstitemGuests);//Default
		}
		
		
		//listitem.click();
		
		//Whenever click action doesn't work go for js executor
		
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();",listitem);
	 }
	
	
	 public void setManagerOfVendor(String value)
	 {
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	 }
	 
	 
	 public void setGender(String gender)
	 {
		 if(gender.equals("Male"))
		 {
			ldriver.findElement(rdMaleGender).click();
		 }
		 else if(gender.equals("Female"))
		 {
			ldriver.findElement(rdFemaleGender).click();
		 }
		 else
		 {
			ldriver.findElement(rdMaleGender).click();//Default
		 }
	 }
	 
	 
	 public void setFirstName(String fname)
	 {
		 ldriver.findElement(txtFirstName).sendKeys(fname);
	 }
	
	 
	 public void setLastName(String lname)
	 {
		 ldriver.findElement(txtLastName).sendKeys(lname);
	 }
	 
	 public void setDob(String dob)
	 {
		 ldriver.findElement(txtDob).sendKeys(dob);
	 }
	 
	 public void setCompanyName(String comname)
	 {
		 ldriver.findElement(txtCompanyName).sendKeys(comname);
	 }
	 
	 public void setAdminContent(String content)
	 {
		 ldriver.findElement(txtAdminContent).sendKeys(content);
	 }
	 
	 public void clickOnSave()
	 {
		 ldriver.findElement(btnSave).click();
	 }
	
	
	 public void clickOnDelete()
	 {
		 ldriver.findElement(deleteOption).click();
	 }
	
	
	
	
	

}
