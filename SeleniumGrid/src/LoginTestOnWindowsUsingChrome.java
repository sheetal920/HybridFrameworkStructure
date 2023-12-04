import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestOnWindowsUsingChrome {

	public static WebDriver driver;
	@Test(priority=1)
	void setup() throws MalformedURLException
	{
		String nodeURL="http://192.168.69.188:47937/wd/hub";
		
		
		ChromeOptions cp=new ChromeOptions();
		cp.setCapability("platform", Platform.WIN11);
		/*
		DesiredCapabilities cap= DesiredCapabilities.chrome(); //yaha error aa rhe hme: The method chrome() is undefined for the type DesiredCapabilities
	
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
	  */
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C://automation//Drivers//chromedriver-win32//chromedriver.exe");
		driver=new RemoteWebDriver(new URL(nodeURL),cp);
	}
	
	@Test(priority=2)
	void login()
	{
		driver.get("https://practice.automationtesting.in/my-account/");
		driver.findElement(By.id("username")).sendKeys("pavanoltraining");
		driver.findElement(By.id("password")).sendKeys("Test@selenium123");
		driver.findElement(By.name("login")).click();
		String txt=driver.findElement(By.cssSelector(".woocommerce-MyAccount-content p:first-child")).getText();
	if(txt.contains("pavanoltraining"))
	{
		System.out.println("test Passed");
	}
	else
	{
		System.out.println("Test Failed");
	}
	driver.close();
	}
}
