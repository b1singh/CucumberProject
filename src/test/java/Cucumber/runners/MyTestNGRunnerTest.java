package Cucumber.runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"html:target/cucumber/Cucumber.html"},
		glue= {"Cucumber"},
		features = "src/test/resources/Cucumber"
		
)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
