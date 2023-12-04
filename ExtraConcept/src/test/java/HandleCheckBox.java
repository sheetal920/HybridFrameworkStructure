import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(cp);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
/*		
		//1. select specific element
		driver.findElement(By.id("sunday")).click();
		
		//. select all checkboxes
		
List<WebElement> checkboxes=driver.findElements(By.cssSelector(".form-check-input"));
for(WebElement checkbox:checkboxes)
{
	checkbox.click();
}

//3. select multiple check box by choice 
		// eg select monday, friday and sunday
		List<WebElement> checkboxes=driver.findElements(By.cssSelector(".form-check-input"));
		for(WebElement checkbox:checkboxes)
		{
			String day=checkbox.getAttribute("id"); // id attribute ki value week day ka name hi hai , check in inspect element
		if(day.equals("monday") || day.equals("friday") || day.equals("sunday"))
		{
			checkbox.click();
		}
		}	
*/		
		//4. select last 2 check box
		
		List<WebElement> checkboxes=driver.findElements(By.cssSelector(".form-check-input"));
		for(int i=checkboxes.size()-1;i>=checkboxes.size()-2;i--) //for(int i=checkboxes.size()-2;i<checkboxes.size;i++) 
		{
			checkboxes.get(i).click();
		}
	}

}
