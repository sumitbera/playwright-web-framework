package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"}
        , features = {"src/test/resources/feature/Login.feature"}
        , tags = {"@GB"}
        , glue = {"stepdefinition"}
        , monochrome = true)
public class RunnerTest {

}
