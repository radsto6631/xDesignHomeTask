package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
        glue = "steps",
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:report/cucumber-reports/report.html"},
        monochrome = true,
        tags = {"@TestRunner"})
public class TestRunner {
}
