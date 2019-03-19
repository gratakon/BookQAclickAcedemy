package cucumberoptions;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
		
		//plugin = { "pretty","json:target/cucumberreports.json" },
		plugin = { "pretty", "html:target/cucumber-html-report" },
		
		features="Scenarios", 
		glue= {"StepDefinition"},
		tags={"@SmokeTest"},
		//dryRun=true,
		//strict=true,
		monochrome=true
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
