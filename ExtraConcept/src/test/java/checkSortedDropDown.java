import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
public class checkSortedDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeOptions cp=new ChromeOptions();
cp.addArguments("--remote-allow-origins=*");
WebDriver driver=new ChromeDriver(cp);
driver.get("https://demo.guru99.com/test/newtours/register.php");
driver.findElement(By.cssSelector(".dropdown:first-child")).click();
List<WebElement> l1=driver.findElements(By.cssSelector(".dropdown:first-child  .dropdown-menu li"));
//l1.sort(null); //ye webelement hai hme string chahiye jo ek empty list create kia: error:java.lang.ClassCastException: class org.openqa.selenium.remote.RemoteWebElement cannot be cast to class java.lang.Comparable

ArrayList Originallist = new ArrayList(); 
ArrayList Templist = new ArrayList(); // ArrayList<Object> Templist = new ArrayList<Object>(); ye asse use nhi karna hai
//List ltr; asse list nhi create hoti hai
//sort krne k liye array chahiye ; agr hmare pass array nhi hai to phle ArrayList create kro usme add kro then list ko wapas se array me conver kro then apply sort
for(WebElement newl:l1)
{
	Originallist.add(newl.getText());
	Templist.add(newl.getText());

}
System.out.println("Before sorting Temporaty list is " + Templist);
Collections.sort(Templist);
System.out.println("After sorting Temporaty list is " + Templist);
if(Originallist.equals(Templist))
{
	System.out.println("Drop Down Sorted");
}
else
{
	System.out.println("Drop Down UnSorted");
}
//Assert.assertEquals(list, list.sort(null));
/* set se duplicate remove hoga bas sort nhi, 
Set<String> s1=new HashSet<>();
for(WebElement l:l1)
{
	s1.add(l.getText());
}

System.out.println(s1);
*/

	}

}
