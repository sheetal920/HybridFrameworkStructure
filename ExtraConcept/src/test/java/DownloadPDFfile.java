import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//pdf , direct download nhi hota phle view mode me open hota hai , to hme kuch preference add krni hongi, ye sare browser me hota hai

public class DownloadPDFfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Location=System.getProperty("user.dir")+"\\downloadFile";
		
		/*HashMap preferences=new HashMap();
		
		preferences.put("plugins.always_open_pdf_externally", true); // bydefault ye false hota hai
		
		preferences.put("download.default_directory", Location); // ye chrome option me set krna pdega
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.setExperimentalOption("prefs", preferences);
		cp.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(cp);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a")).click();
		*/
		//same edge k liye hoga
		
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");//Mime type of word file, txt file ka mime diff, pdf ka diff : ye google se mil jayega
		profile.setPreference("download.default_folderList",2); //0-desktop, 1-download folder of laptop, 2-desired location
		profile.setPreference("browser.download.dir",Location); // agr 2 set kia hai upper line me tbhi ye step use krna hai
		profile.setPreference("pdfjs.disabled", true);
		
		FirefoxOptions fxOption=new FirefoxOptions();
		fxOption.setProfile(profile);
		
		System.setProperty("webdriver.gecko.driver", "C:\\automation\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver(fxOption);
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a")).click();
	}

}
