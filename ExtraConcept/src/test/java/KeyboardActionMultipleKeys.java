import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionMultipleKeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(cp);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		WebElement input1=driver.findElement(By.id("inputText1"));
		input1.sendKeys("Welcome to Selenium");
		WebElement input2=driver.findElement(By.id("inputText2"));
		Actions act=new Actions(driver);
		
		//Ctrl+A
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//CTRL+C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//tab-shift to input 2 
		act.sendKeys(Keys.TAB);
		act.perform();
		
		//then Ctrl+v
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		
		//compare text
		driver.findElement(By.xpath("//div[text()='Compare!']")).click();
		if(input1.getAttribute("value").equals(input2.getAttribute("value")))
		{
			System.out.println("Text is copied successfully");
		}
		//ye below code bas asse hi getAttribute check krne k liye hai
		WebElement check=driver.findElement(By.xpath("//div[text()='Compare!']"));
		System.out.println(check.getAttribute("value")); // op:null
		
	}

}
