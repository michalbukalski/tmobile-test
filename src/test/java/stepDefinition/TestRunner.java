package stepDefinition;//package stepDefinition;
//
//import io.cucumber.java.*;
//import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//import org.junit.AfterClass;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/features", // Ścieżka do plików z funkcjami
//        glue = "stepDefinitions", // Pakiet z krokami
//        plugin = {"pretty", "html:target/cucumber-reports"}, // Format raportu
//        tags = "@SmokeTest" // Tagi testów
//)
//public class TestRunner {
//
//    @AfterClass
//    public static void tearDown() {
//        // Zamknij przeglądarkę
//        // Przykładowo, jeśli używasz Selenium WebDriver zwracającego drivera:
//        // driver.quit();
//    }
//}

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"classpath:Steps"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}

