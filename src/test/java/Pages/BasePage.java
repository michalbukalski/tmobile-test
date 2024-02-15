package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/*---------------------------------------------------------------------------------------------------------------------
W BasePage stosując wrzocec Page Object Pattern powinno zawrzec się wiele przydatnych funkcji oraz metod,
które będą wspólne dla wszystkich stron w projekcie
-----------------------------------------------------------------------------------------------------------------------*/

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (5));
    }

    public void waitForElementUntilVisible(String Xpath) {
        wait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath (Xpath)));
    }

    public boolean isElementVisible() {
        WebElement element = driver.findElement (By.xpath ("(//a[@title='Koszyk'])[1]"));
        return element.isDisplayed ();
    }

    public boolean isCartIconVisible() {
        WebElement goToMainPageTmobileLogoBtn = driver.findElement (By.xpath ("//img[@alt='T-Mobile - przejdź na stronę główną']"));
        goToMainPageTmobileLogoBtn.click ();
        Assert.assertTrue (isElementVisible ());

        return true;
    }
}





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
