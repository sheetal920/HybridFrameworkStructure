package stepDefinations;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.loginPage;
import pageObjects.searchCustomer;
import org.apache.log4j.Logger;

public class baseClass {
	public WebDriver driver;
	public loginPage lp;
	public AddCustomerPage Addcum;
	public searchCustomer searchCus;
	public static Logger logger; //import org.apache.log4j.Logger; agr ye na show ho automatically to manually add krna hoga
	public Properties configProp;
	//random  string for unique email
	
	public static String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
}
