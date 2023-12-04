package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	public WebDriver ldriver;
	
	public loginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement pwd;
	
	@FindBy(css=".login-button")
	WebElement loginButton;
	
	@FindBy(linkText="Logout")
	WebElement logOutButton;
	
	public void setuserName(String uname)
	{
		email.clear();
		email.sendKeys(uname);
	}
	
	public void setpassword(String pwd1)
	{
		pwd.clear();
		pwd.sendKeys(pwd1);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void clickLogOut()
	{
		logOutButton.click();
	}
}
