

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class DownloadWordFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Chrome(download file in specified location) , agr different browser me krna hai to EdgeOptions edge k liye and WebDriverManager.edgedriver().setup();
		
		String Location=System.getProperty("user.dir")+"\\downloadFile";
		/*HashMap preferences=new HashMap();
		preferences.put("download.default_directory", Location); // ye chrome option me set krna pdega
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.setExperimentalOption("prefs", preferences);
		cp.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(cp);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a")).click();
		*/
		
		
		//firefox me normal download me bhi popup aata hai ki openwith , jbki chrome and edge me wo khud handle ho jata hai
		//WebDriverManager.firefoxdriver().setup(); ye firefox me issue kar rha, nhi chal rha
		
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");//Mime type of word file, txt file ka mime diff, pdf ka diff : ye google se mil jayega https://www.sitepoint.com/mime-types-complete-list/
		profile.setPreference("download.default_folderList",2); //0-desktop, 1-download folder of laptop, 2-desired location
		profile.setPreference("browser.download.dir",Location); // agr 2 set kia hai upper line me tbhi ye step use krna hai
		
		
		FirefoxOptions fxOption=new FirefoxOptions();
		fxOption.setProfile(profile);
		
		System.setProperty("webdriver.gecko.driver", "C:\\automation\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver(fxOption);
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a")).click();
		
		
		
	}

}
