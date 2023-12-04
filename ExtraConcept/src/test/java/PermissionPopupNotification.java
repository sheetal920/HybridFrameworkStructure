import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopupNotification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		// for disable notification 
		cp.addArguments("--disable-notifications"); //these notification coming from browser not from URL
		
		
		
		WebDriver driver=new ChromeDriver(cp);
		driver.get("https://www.foundit.in/");
	}

}
