package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class AddCustomerPage
{
public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	By Clickcustomer= By.cssSelector(".nav-item.has-treeview:nth-child(4)");
	By ClickcustomerMenu= By.cssSelector(".nav-item.has-treeview:nth-child(4) .nav-item:nth-child(1)");
	By AddNew= By.cssSelector(".btn.btn-primary");
    By email=By.id("Email");
    By password=By.id("Password");
    By firstName=By.id("FirstName");
    By lastName=By.id("LastName");
    
    By gender_Male=By.id("Gender_Female");
    By gender_Female=By.id("Gender_Female");
    
    By dateOfBirth_dateview= By.id("DateOfBirth");
    By company=By.id("Company");
    
    By customerRoledropdown= By.xpath("//input[@aria-labelledby='SelectedCustomerRoleIds_label']");
    By customerRoleAsAdmin= By.cssSelector(" #SelectedCustomerRoleIds_listbox li[data-offset-index='0']");
    By customerRoleAsForum_Moderators= By.cssSelector(" #SelectedCustomerRoleIds_listbox li[data-offset-index='1']");
    By customerRoleAsGuests= By.cssSelector(" #SelectedCustomerRoleIds_listbox li[data-offset-index='2']");
    By customerRoleAsRegistered= By.cssSelector(" #SelectedCustomerRoleIds_listbox li[data-offset-index='3']");
    By customerRoleAsVenders= By.cssSelector(" #SelectedCustomerRoleIds_listbox li[data-offset-index='4']");
    
    By vendorId=By.id("VendorId"); //ID hm select use krke select krenge
    By AdminComment=By.id("AdminComment");
    By save=By.xpath("//button[@name='save']");
    
    //Action methods
    
    public Object Verifydashboard()
    {
    	return ldriver.getTitle();
    }
    public void clickCustomer()
    {
    	ldriver.findElement(Clickcustomer).click();
    }
    public void clickCustomerMenu()
    {
    	ldriver.findElement(ClickcustomerMenu).click();
    }
    
    public void addNew()
    {
    	ldriver.findElement(AddNew).click();
    }
    
    public void setEmail(String email2) //this email we get from actual test case
    {
    	ldriver.findElement(email).sendKeys(email2);
    }
    
    public void setpassword(String pwd) //this password we get from actual test case
    {
    	ldriver.findElement(password).sendKeys(pwd);
    }
    public void setFirstName(String fname)
    {
    	ldriver.findElement(firstName).sendKeys(fname);
    }
    
    public void setLastName(String lname)
    {
    	ldriver.findElement(lastName).sendKeys(lname);
    }
    

    public void setGender(String gender2)
    {
    	if(gender2.equals("Male"))
    	{
    		ldriver.findElement(gender_Male).click();
    	}
    	
    	else
    	{
    		ldriver.findElement(gender_Female).click();
    	}
    }
    

    public void setDateOfBirth_dateview(String dob) throws InterruptedException
    {
    	Thread.sleep(3000);
    	ldriver.findElement(dateOfBirth_dateview).sendKeys(dob);
    }
    
    public void setCompany()
    {
    	ldriver.findElement(company).sendKeys("XYZ");
    }
    
    public void setCustomerRole(String role) throws InterruptedException
    { 
    	ldriver.findElement(customerRoledropdown).click();
    	WebElement listrole = null;
    	Thread.sleep(3000);
    	if(role.equals("Administrators"))
    	{
    		
    		listrole=ldriver.findElement(customerRoleAsAdmin);
    	}
    	else if(role.equals("Forum Moderators"))
    	{
    		listrole=ldriver.findElement(customerRoleAsForum_Moderators);
    	}
    	
    	else if(role.equals("Guests"))
    	{
    		listrole=ldriver.findElement(customerRoleAsGuests);
    	}
    	else if(role.equals("Registered"))
    	{
    		
    	}
    	
    	else
    	{
    		listrole=ldriver.findElement(customerRoleAsVenders);
    	}
    	JavascriptExecutor js= (JavascriptExecutor) ldriver;
    	js.executeScript("window.scrollBy(0,350)");
    	js.executeScript("arguments[0].click();", listrole);
    	
    	
    }
    
    public void setVender(String value) throws InterruptedException
    {
    	Thread.sleep(2000);
    	WebElement dp=ldriver.findElement(vendorId);
    	Select ss=new Select(dp);
    	ss.selectByVisibleText(value);
    	
    }
    
    public void setCommment(String comment)
    {
    	ldriver.findElement(AdminComment).sendKeys(comment);
    }
    
    public void clicksave()
    {
    	ldriver.findElement(save).click();
    }
	
}
