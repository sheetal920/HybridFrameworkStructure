import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptUtil {

	public static void FlashByJS(WebElement element,ChromeDriver driver)
	{
		JavascriptExecutor js=driver;
		String bgcolor= element.getCssValue("backgroundColor");
		for(int i=0;i<50;i++)
		{
			changeColor("#000000",element,driver);//1
			changeColor(bgcolor,element,driver);//2
		}
		
		
	}
	public static void drawBorder(WebElement element, ChromeDriver driver)
	{
		JavascriptExecutor js=driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	public static String getTitleByJS(ChromeDriver driver)
	{
		JavascriptExecutor js=driver;
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void clickElementByJS(WebElement element, ChromeDriver driver)
	{
		JavascriptExecutor js=driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void generateAlertByJS(ChromeDriver driver, String Message)
	{
		JavascriptExecutor js=driver;
		js.executeScript("alert('" + Message + "')");
		
	}
	
	
	public static void refreshBrowserByJS(ChromeDriver driver)
	{
		JavascriptExecutor js=driver;
		js.executeScript("history.go[0]");
		
	}
	
	public static void ScrollDownPageUPByJS(ChromeDriver driver)
	{
		JavascriptExecutor js=driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // 0 se start hoke document.body.scrollHeight this will go till end of the page
		
	}
	public static void scrollUPPageByJS(ChromeDriver driver)
	{
		JavascriptExecutor js=driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)"); 
		
	}
	public static void ZoomByJS(ChromeDriver driver)
	{
		JavascriptExecutor js=driver;
		js.executeScript("document.body.style.zoom='50%'");
		
	}
	
	
	public static void changeColor(String color,WebElement element,ChromeDriver driver)
	{
		JavascriptExecutor js=driver;
		js.executeScript("arguments[0].style.backgroundColor='" +color+ "'",element);
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			
		}
	}
}
