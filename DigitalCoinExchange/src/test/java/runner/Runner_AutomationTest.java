package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, features = "src/test/resources/Features", glue = { "stepDefinitions" }, tags = {
		"@Regression" }, plugin = { "html:target/cucumber-report/Regression",
				"json:target/cucumber-report/cucumber.json", "rerun:rerun/failed_scenarios.txt" })
public class Runner_AutomationTest {

}
