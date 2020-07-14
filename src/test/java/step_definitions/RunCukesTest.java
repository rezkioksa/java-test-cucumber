package step_definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		glue={"step_definitions"},
		features="src/test/resources/features",
		plugin = {
				"pretty:target/prettyReport.txt", "html:target/cucumber", "json:target/cucumber.json", "rerun:target/rerun.txt",
				"junit:target/junit-report.xml" },
		monochrome=true)
public class RunCukesTest {
}