package Pages;
import org.openqa.selenium.WebDriver;

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

    public boolean isBrowserOpened() {
        return driver != null; // Zwraca true, jeśli driver nie jest nullem
    }

    // Dodaj inne metody specyficzne dla strony głównej, jeśli są potrzebne
}
