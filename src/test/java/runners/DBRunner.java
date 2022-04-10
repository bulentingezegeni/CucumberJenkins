package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",//This is used for more readable reports or outputs
                "html:target/default-cucumber-reports.html",//Use this reports
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "./src/test/resources/features",
        glue = "stepdefinitions", //run stepdefinitions
        tags = "@read_feature",
        dryRun = false
)
public class DBRunner {
}
