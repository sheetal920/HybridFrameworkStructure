import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDatePicker {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		cp.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(cp);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.redbus.in/ryde/");
		driver.manage().window().maximize();
		
		//1. sometimes send keys se bhi date select ho jati hai
		//2. select particular date
		
		String year="2024";
		String month="April";
		String date="10";
		Thread.sleep(2000);
		Actions aa=new Actions(driver);
		WebDriverWait ww=new WebDriverWait(driver,Duration.ofSeconds(15));
		ww.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".MuiInput-input")))).click();
		//aa.moveToElement(driver.findElement(By.cssSelector(".home_calendar"))).doubleClick();
		//driver.findElement(By.cssSelector(".home_date_wrap")).click();
		Thread.sleep(2000);
		
		while(true)
		{
			String monthYear=driver.findElement(By.xpath("//div[@class='MuiPickersSlideTransition-transitionContainer MuiPickersCalendarHeader-transitionContainer']")).getText();
			System.out.println(monthYear);
			String new11[]=monthYear.split(" ");
			String month1=new11[0];
			String year1=new11[1];
			System.out.println(month1 + year1);
			if(month1.equalsIgnoreCase(month) && year1.equals(year))
			  break;		
			else
			{
				driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiIconButton-root.MuiPickersCalendarHeader-iconButton:last-of-type")).click();
			}
		}
		
		//date selection
		List<WebElement> date1=driver.findElements(By.cssSelector(".MuiButtonBase-root.MuiIconButton-root.MuiPickersDay-day"));
		for(WebElement dt:date1)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
				
		}
		//driver.close();
	}

}
