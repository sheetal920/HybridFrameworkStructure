import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTablewithPagination {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(cp);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		//Login
		WebElement username=driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password=driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.cssSelector(".btn-primary")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn-close")).click();
		Thread.sleep(2000);
		
		//Move to order page
		driver.findElement(By.cssSelector("#menu-sale")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']/ul/li[1]")).click();
		
		//Capture total number of pages 
		String text=driver.findElement(By.cssSelector(".col-sm-6.text-end")).getText();
		int pagecount=Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1)); //+1:index 0 se start hai ,-1 page se phle space k liye:Showing 1 to 10 of 82 (9 Pages)
		System.out.println("Page Count is:"+ pagecount);
		
		//below is previous way to handle this
		/*
		String[] totalpage=text.split("Pages");
		String[] count=totalpage[0].split("\\("); // ( is a reserved char in regex, you need to escape it,using \\
		String exactcount=count[1].trim();
		System.out.println(exactcount);
		*/
		
		//Go to each and every page and then find out record, by default page 1 par hi land hote hai hm
		for(int p=1;p<=pagecount;p++)
		{
			WebElement activePage=driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));//active page ka tag:span hai and unactive page me anchor:a tag hai
			System.out.println("Active Page:"+activePage.getText());
			//activePage.click();
			List<WebElement> RowsData=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tr"));
			System.out.println("Row count:"+RowsData.size());
			
			String pageno=Integer.toString(p+1);
			System.out.println("Latest Page number is:"+pageno);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//ul[@class='pagination']//a[text()='"+pageno+"']")).click();
			//hmara uppercliknhi ho rha error de rha
			
			
 
		}
		
		
	}

}
