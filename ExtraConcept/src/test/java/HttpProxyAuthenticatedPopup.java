import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HttpProxyAuthenticatedPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(cp);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//syntax: with the url we have to pass username and password: https://username:password@URL
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		
	}

}
