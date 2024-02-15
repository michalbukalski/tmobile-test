import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class SeleniumTestWithLoggingAndScreenshots {
    private WebDriver driver;
    private LoggerUtil logger; // Dodaje LoggerUtil

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        logger = new LoggerUtil(); // Tworze instancję LoggerUtil
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result.getMethod().getMethodName());
        }
        driver.quit();
    }

    @Test
    public void exampleTest() {
        driver.get("https://example.com");
        logger.logInfo("Opened example.com");
    }

    private void takeScreenshot(String methodName) {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.logError("Screenshot saved: screenshots/" + methodName + ".png");
    }
}
