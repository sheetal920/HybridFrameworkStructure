import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(cp);
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(0);
		WebElement inputbox=driver.findElement(By.id("age"));
		String tooltip=inputbox.getAttribute("title");
		System.out.println(tooltip);
	}

}
