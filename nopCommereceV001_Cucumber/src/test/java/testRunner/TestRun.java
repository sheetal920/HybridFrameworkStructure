package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/", //features=".//Features/", asse krne se sare feature file run ho jayenge
		//features={".//Features/Login.feature",".//Features/Customers.feature"},
		glue="stepDefinations", //yaha bas package name btana hai
		dryRun=false,
		monochrome=true, //it will remove un-necessary character from console
		plugin= {"html:target/reports/cucumber-html-report.html", "json:target/reports/cucumber.json", "pretty"},
		tags= "@sanity" // if we want ki sare feature file se specific scenario run ho to hme tag ya grouping use krni pdegi, scenario ko koi name dena pdega
		//tags= {"@sanity","@regression"} agr multiple tag present hai kisi scenario ke liye to asse mention krna hoga it means ek scenario pr do tag mention hai
	    //tags= {"@sanity,@regression"} asse mention krna pdega agr multiple tag ek sath run krne hai to: ye jis par sanity hai and dusre jin par regression hai, un dono ko run krega
		)
public class TestRun {

}
