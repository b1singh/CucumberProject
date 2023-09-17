package Cucumber.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		glue={"Cucumber"},
		features = "src/test/resources/Cucumber"
		
)
public class MyjunitRunnerTest {

}
