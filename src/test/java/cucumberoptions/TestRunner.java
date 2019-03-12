package cucumberoptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = { "pretty","json:target/cucumberreports.json" },
		features="Scenarios", 
		glue="StepDefinition",
		tags={"@SmokeTestnow"},
		dryRun=false,
		strict=true,
		monochrome=true
		)

public class TestRunner{

}
