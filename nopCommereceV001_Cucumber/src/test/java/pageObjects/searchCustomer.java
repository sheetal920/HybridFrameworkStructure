package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.waitHelper;

public class searchCustomer 
{
	waitHelper wH;
	public WebDriver ldriver;
	public searchCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		wH= new waitHelper(ldriver);
	}
	
	By enterEmail=By.id("SearchEmail");
	By firstname=By.id("SearchFirstName");
	By lastname=By.id("SearchLastName");
	By serachButton=By.id("search-customers");
	By verifyEmail=By.cssSelector(".odd td:nth-child(2)");
	By rowcountInTable=By.xpath("//table[@id='customers-grid']/tbody/tr");
	By columncountInTable=By.xpath("//table[@id='customers-grid']/tbody/tr/td");
	
	public void enterEmail(String email)
	{
		wH.WaitForElement(ldriver.findElement(enterEmail), 15);
		ldriver.findElement(enterEmail).sendKeys(email);
	}
	
	public void setfirstname(String firstName)
	{
		
		ldriver.findElement(firstname).sendKeys(firstName);
	}
	public void setlastname(String lastName)
	{
		ldriver.findElement(lastname).sendKeys(lastName);
	}
	// yaha name se multiple data milega
	
	public int getRow()
	{
		return ldriver.findElements(rowcountInTable).size();
	}
	public int getColumn()
	{
		return ldriver.findElements(columncountInTable).size();
	}
	
	public void searchByRole(String role)
	{
		
		ldriver.findElement(lastname).sendKeys(role);
	}
	
	public void searchButton() throws InterruptedException
	{
		wH.WaitForElement(ldriver.findElement(serachButton), 15);
		ldriver.findElement(serachButton).click();
		Thread.sleep(3000);
	}
	
	public boolean verifyEmailFromTable(String email)
	{
		wH.WaitForElement(ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr/td")), 15);
		boolean flag=false;
		for(int i=1;i<=getRow();i++)
		{
			String email1=ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(email1);
			if(email1.equals(email))
			{
				flag=true;
			}
		}
		return flag;

	}
	
	public boolean verifyNameFromTable(String Name)
	{
		//wH.WaitForElement(ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")), 15);
		boolean flag=false;
		for(int i=1;i<=getRow();i++)
		{
			String name=ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			String[] newname=name.split(" ");
			
			if(newname[0].equals("Virat") && newname[1].equals("Kohli"))
			{
				
				flag=true;
			}
		}
		return flag;

	}
}
