package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin= {"pretty",
                "html:reports/cucumber_results.html",
                "json:reports/cucumber_results.json",
                "rerun:reports/rerun.txt"
        },
        features="./src/test/resources/features",
        glue="steps",
        tags="@regression"
)
public class TestRunner {
}
