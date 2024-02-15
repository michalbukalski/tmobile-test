package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds (5));
    }

    public boolean isCartIconVisible() {

        return false;
    }
}



/*---------------------------------------------------------------------------------------------------------------------
W BasePage stosując wrzocec Page Object Pattern powinno zawrzec się wiele przydatnych funkcji oraz metod,
które będą wspólne dla wszystkich stron w projekcie
-----------------------------------------------------------------------------------------------------------------------*/
//
//public class BasePage {
//


//    public static void openBrowser(String whichBrowser, String urlAdress){
//        String Firefox = "Firefox";
//        String Chrome = "Chrome";
//        String Edge = "Edge";
//
//        if (Chrome.equals (whichBrowser)){
//            WebDriverManager.chromedriver ().setup ();
//            driver = new ChromeDriver ();
//            driver.manage ().window ().maximize ();
//            driver.get (urlAdress);
//            driver.findElement (By.id ("didomi-notice-agree-button")).click ();
//        } else if (Edge.equals (whichBrowser)){
//            WebDriverManager.firefoxdriver ().setup ();
//            driver = new EdgeDriver ();
//            driver.manage ().window ().maximize ();
//            driver.get (urlAdress);
//            driver.findElement (By.id ("didomi-notice-agree-button")).click ();
//        } else if (Firefox.equals (whichBrowser)){
//            WebDriverManager.firefoxdriver ().setup ();
//            driver = new FirefoxDriver ();
//            driver.manage ().window ().maximize ();
//            driver.get (urlAdress);
//            driver.findElement (By.id ("didomi-notice-agree-button")).click ();
//        } else {
//            System.out.printf ("Not a valid choice!");
//        }

//    }

//    public static void openBrowserAndOpenPage(String urlAdress){
//        WebDriverManager.chromedriver ().setup ();
//        WebDriver driver = new ChromeDriver ();
//        driver.manage ().window ().maximize ();
//        driver.get (urlAdress);
//        driver.findElement (By.id ("didomi-notice-agree-button")).click ();
//    }


//
//}
