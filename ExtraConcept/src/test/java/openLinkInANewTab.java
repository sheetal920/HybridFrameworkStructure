import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openLinkInANewTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(cp);
		driver.get("https://demo.nopcommerce.com/");
		String tab=Keys.chord(Keys.CONTROL,Keys.RETURN); //return is same as enter; return ki jgh enter bhi use kar skte hai
		WebElement registerlink=driver.findElement(By.cssSelector(".ico-register"));
		registerlink.sendKeys(tab);
	}

}
