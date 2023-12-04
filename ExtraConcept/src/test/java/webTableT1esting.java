import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webTableT1esting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(cp);
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		
		//1. get total no. of rows in table
		int row=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
		System.out.println(row);
		
		//2. get total no. of column: header se column pta chal jayega
		
		int column=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th")).size();
		System.out.println(column);
		
		//3. get particular value(specific row/column) from table 
				String value1=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td[3]")).getText();
				//int val=Integer.parseInt(value1);
				System.out.println(value1);
				
	    //4. retrieve all the data from table
		 for(int r=1;r<=row;r++)
		 {
			 for(int c=1;c<=column;c++)
			 {
				String data=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.println(data+ "     ");
//xpath path me direct value assign nhi kar skte, have to follow syntax eg;above
			 }
			 System.out.println(); //it will move to next line (row)
		 } 
		 
			 //5. based on certain condition retrieve the data : eg: get previous and current price of Coffee Day Enterpris company
		
				//

		for(int r=1;r<=row;r++)
		{
			String company=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+r+"]/td[1]")).getText();
			//System.out.println(company);
			if(company.equals("Hind. Petrol"))
            {
            	String prevPrice=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+r+"]/td[3]")).getText();
            
            	String curPrice=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+r+"]/td[4]")).getText();
           System.out.println(company+ " " + prevPrice+" " + curPrice);
            }

		 }
						
	}

}
