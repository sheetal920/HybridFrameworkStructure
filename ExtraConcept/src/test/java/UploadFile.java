import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		
		cp.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(cp);
		driver.get("https://www.foundit.in/");
		driver.manage().window().maximize();
		//sendkey : file upload me tbhi use ho skta hai jb type=file attribute ho HTML me
		
		//Robot Class Methods
		driver.findElement(By.cssSelector(".heroSection-buttonContainer_secondaryBtn")).click();
		WebElement clickButton=driver.findElement(By.id("file-upload")); // ye click nhi ho rha , java script executor use karna hoga, ye error de rha  org.openqa.selenium.InvalidArgumentException: invalid argument
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",clickButton );
		
		//3 step , 1: copy the path 2. CTRL V in file name (paste)  3. press enter key
		
		Robot rb=new Robot();
		rb.delay(2000);
		
		//1: copy the path(File Location) in window upload
		StringSelection ss=new StringSelection("C:\\Users\\chaud\\Downloads\\file-sample_150kB");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//2. CTRL V the file name (paste) in window upload
		rb.keyPress(KeyEvent.VK_CONTROL); // Press on CTRL key on keybaord
		rb.keyPress(KeyEvent.VK_V);
		
		//Now release the key, upper wali key hi release krni hongi, press key krne k turant bad key ko release bhi krna hoga
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		//3. press enter key
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
