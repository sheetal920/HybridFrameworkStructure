package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHelper 
{
	public WebDriver ldriver;

	public waitHelper(WebDriver rdriver)
	{
		ldriver=rdriver;
	}
	
	public void WaitForElement(WebElement element, long timeOutInSeconds)
	{
		WebDriverWait wait= new WebDriverWait(ldriver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
