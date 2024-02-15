package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get("https://www.t-mobile.pl");
    }

    public void openHomePage() {
    }

    public void goToDevicesSection() {
    }

    public boolean isHomePageDisplayed() {

        String expectedUrl = "https://www.t-mobile.pl/";
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.equals(expectedUrl);

    }

    public boolean isElementVisible(String section) {
        String xpath = String.format ("//div[@class='sc-gzzPqb euFkBw dt_typography variant_caption stepChild_heading' and contains(.,'%s')]", section);
        WebElement element = driver.findElement (By.xpath (xpath));
        return element.isDisplayed ();
    }

    public boolean isDeviceVisible(String Xpath) {
        String xpath = String.format (Xpath);
        WebElement element = driver.findElement (By.xpath (xpath));
        return element.isDisplayed ();
    }

    public boolean isBrowserOpened() {
        return driver != null; // Zwraca true, jeśli driver nie jest nullem
    }

    // Dodaj inne metody specyficzne dla strony głównej, jeśli są potrzebne
}
