import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(cp);
		driver.get("https://demo.nopcommerce.com/");
		Set<Cookie> cook=driver.manage().getCookies(); //import org.openqa.selenium.Cookie;
		System.out.println("Total cookies:" + cook.size());
		
		for(Cookie cook1:cook)
		{
			System.out.println(cook1.getName()+":" +cook1.getValue());
			
		}
		
		//how to add cookie to browser
		Cookie cookieObj=new Cookie("My cookies","123456"); // name of the cookie and value: ye 2 pass krne hoge
		driver.manage().addCookie(cookieObj);
		
		cook=driver.manage().getCookies();
		System.out.println("Total cookies after adding:" + cook.size());
		
		//how to delete cookie from browser: but hmara delete cookie work nhi kar rha
		//driver.manage().deleteCookie(cookieObj); // yaha object pass kia hai
		driver.manage().deleteCookieNamed("My cookies"); // yaha cookie name pass kia hai
		cook=driver.manage().getCookies();
		System.out.println("Total cookies after deletion:" + cook.size());
		
		//how to delete cookie from browser
		driver.manage().deleteAllCookies();
		
		System.out.println("cookies count after deletion of all cookies:" + cook.size());
	}

}
