import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleDatepickerDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		cp.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(cp);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.findElement(By.id("dob")).click(); // open date picker
		WebElement year=driver.findElement(By.cssSelector(".ui-datepicker-year"));
		Select ss=new Select(year);
		List<WebElement> years=ss.getOptions();
		for(WebElement year1:years)
		{
			
			if(year1.getText().equals("1996"))
			 {
				year1.click();
				break;
			 }
								
		}
		
		WebElement month=driver.findElement(By.cssSelector(".ui-datepicker-month"));
		Select ss1=new Select(month);
		List<WebElement> months=ss1.getOptions();
		for(WebElement month1:months)
		{
			
			if(month1.getText().equals("Aug"))
			 {
				month1.click();
				break;
			 }
		}
		
		
			List<WebElement> days=driver.findElements(By.cssSelector(".ui-state-default"));
			
			for(WebElement day1:days)
			{
				
				if(day1.getText().equals("5"))
				 {
					day1.click();
					break;
				 }		
			
					
			}
		
	}

}
