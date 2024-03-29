package stepDefinition;//package stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature/WybieranieTelefonuZListyOferty.feature",
        glue = {"Steps"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}

