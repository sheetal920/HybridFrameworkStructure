package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.tools.sjavac.Log;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.loginPage;
import pageObjects.searchCustomer;

public class LoginSteps extends baseClass
{  //ek seperate methodcreate kr lenge setup
	@Before
	public void setUp() throws IOException
	{
		configProp=new Properties();
		FileInputStream ff=new FileInputStream("config.properties");
		configProp.load(ff);
		
		logger=Logger.getLogger("nopCommereceV001_Cucumber"); //here we will initiate the Logger
		PropertyConfigurator.configure("log4j.propertiies"); //agr same project me hi log4j file hai to bas uska name mention kr denge
			
		String brow=configProp.getProperty("browser");
		//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers/chromedriver.exe");
		
		if(brow.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath")); // config.properties file me chromepath mention hai 
			ChromeOptions cp=new ChromeOptions();
					cp.addArguments("--remote-allow-origins=*");
				  driver=new ChromeDriver(cp);
		}
		
		
		else if(brow.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath")); // config.properties file me chromepath mention hai 
			
					
				  driver=new FirefoxDriver();
		}
		
		else if(brow.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", configProp.getProperty("edgepath")); // config.properties file me chromepath mention hai 
			ChromeOptions cp=new ChromeOptions();
					cp.addArguments("--remote-allow-origins=*");
				  driver=new EdgeDriver(cp);
		}
	}
	@Given("User Launch Chrome driver")
	public void user_launch_chrome_driver() 
	{

	  lp=new loginPage(driver);
	  logger.info("****Launching Browser******");
	  
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("****Opening URL******");
		driver.get(url);
	  driver.manage().window().maximize();
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		logger.info("****Providing Login details******");
		lp.setuserName(email);
	    lp.setpassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		logger.info("****Clicking on Login Button******");
		lp.clickLogin();
	    
	}

	
	@Then("page title should be {string}")
	public void page_title_should_be(String string) throws InterruptedException 
	{ Thread.sleep(5000);
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			Thread.sleep(2000);
			driver.close();
		}
	  else
	  {
		  Assert.assertEquals(string, driver.getTitle());
		  //assert junit wala package download krna hai
	  }
		Thread.sleep(3000);
	}

	@When("user click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	    lp.clickLogOut();
	    Thread.sleep(3000);
	}

	//********************Add New Customers feature Steps******************************
	
	@Then("verify dashboard")
	public void verify_dashboard() {
	
	Addcum=new AddCustomerPage(driver);
	Assert.assertEquals("Dashboard / nopCommerce administration", Addcum.Verifydashboard());
	}
	
	@When("user click on Customerand Menu")
	public void user_click_on_customerand_menu() throws InterruptedException {
		Thread.sleep(3000);
		Addcum.clickCustomer();
	}
	@When("click on Customers Menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		Addcum.clickCustomerMenu();
		
	}
	@When("click on Add New button")
	public void click_on_add_new_button() throws InterruptedException {
		Addcum.addNew();
		Thread.sleep(2000);
	}
	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	   Assert.assertEquals("Add a new customer / nopCommerce administration", Addcum.Verifydashboard());
	}
	@When("user enter cutomer info")
	public void user_enter_cutomer_info() throws InterruptedException
	{
		logger.info("****Providing new customer details******");
		String email=randomeString()+"@gmail.com";
		Addcum.setEmail(email);
		Addcum.setpassword("test123");
		Addcum.setFirstName("Ram");
		Addcum.setLastName("Shyam");
		Addcum.setGender("Female");
		Addcum.setDateOfBirth_dateview("5/11/1996");
		
		Addcum.setCompany();
		//Register-default
		//The customer can not be both 'Guests' and 'registered' roles
		//Add the customers to 'Guests' or 'registered' customer role
		Addcum.setCustomerRole("Administrators");
		Addcum.setVender("Not a vendor");
		Addcum.setCommment("This is testing......");
	}
	@When("click on save button")
	public void click_on_save_button() throws InterruptedException 
	{
		logger.info("****Saving customer data******");
		Addcum.clicksave();
		Thread.sleep(3000);
	}
	@Then("user can view confirmed message {string}")
	public void user_can_view_confirmed_message(String string)
	{
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("successfully"));
	}

	//********************Search Customers By email Steps******************************
	
	
	@When("user enter email id")
	public void user_enter_email_id() throws InterruptedException 
	{
		
		logger.info("****Searching customer by email id******");
		searchCus=new searchCustomer(driver);
		Thread.sleep(2000);
		searchCus.enterEmail("admin@yourStore.com");
	}
	@When("click on search button")
	public void click_on_search_button() throws InterruptedException
	{
		searchCus.searchButton();
		Thread.sleep(3000);
	}
	@Then("user should found email in the search table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException
	{
		Thread.sleep(3000);
		boolean status=searchCus.verifyEmailFromTable("admin@yourStore.com");
		Assert.assertEquals(true, status);
		Thread.sleep(2000);
	}
	//********************Search Customers By Name Steps******************************
	
	@When("user enter first name and last name")
	public void user_enter_first_name_and_last_name() throws InterruptedException {
		logger.info("****Searching customer by Name******");
		searchCus=new searchCustomer(driver); // har scenario k liye class ka object create krna pdega wrna error dega "this.searchCus" is null
		searchCus.setfirstname("Virat");
		Thread.sleep(2000);
		searchCus.setlastname("Kohli");
	}
	@Then("user should found Name along with email in the search table")
	public void user_should_found_name_along_with_email_in_the_search_table() throws InterruptedException 
	{
		boolean status=searchCus.verifyNameFromTable("Virat Kohli");
		Assert.assertEquals(true, status);
		Thread.sleep(2000);
	}

	@Then("close browser")
	public void close_browser() throws InterruptedException {
		logger.info("****Browser closed******");
		Thread.sleep(2000);
		driver.close();
		
		
	}
}
