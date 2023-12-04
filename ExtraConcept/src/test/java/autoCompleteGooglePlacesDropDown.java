import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autoCompleteGooglePlacesDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
// yaha autocomplete run time par ho rha hai , server se hi value aa rhi hai , asse element ko inspect bhi nhi kar skte so how to check this:
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(cp);
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement searchbox=driver.findElement(By.id("autocomplete"));
		searchbox.clear();
		searchbox.sendKeys("Toronto");
		Thread.sleep(2000);
		String text;
		do
		{
			searchbox.sendKeys(Keys.ARROW_DOWN);
			text=searchbox.getAttribute("value");
			System.out.println(text);
			if(text.equals("Toronto, OH, USA"))
			{
				searchbox.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(2000);
		}while(!text.isEmpty());
		
		
		
		
	driver.close();
	}

}
