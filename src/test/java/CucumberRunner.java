import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"step_definitions"},
        features="src/test/resources/features",
        plugin = {
                "pretty:target/prettyReport.txt", "html:target/cucumber", "json:target/cucumber.json", "rerun:target/rerun.txt",
                "junit:target/junit-report.xml" },
        monochrome=true, tags = {"@shipping"})
public class CucumberRunner {
}

