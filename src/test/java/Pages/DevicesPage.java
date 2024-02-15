package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DevicesPage extends BasePage {
    public DevicesPage(WebDriver driver) {
        super(driver);
    }

    public void chooseDevicesSection(String section) {
//        WebElement devicesSection = driver.findElement(By.xpath("button[@type='button' and contains(.,'%s')]"));
//        devicesSection.click();
        String xpath = String.format("//button[@type='button' and contains(.,'%s')]", section);
        WebElement devicesSection = driver.findElement(By.xpath(xpath));
        devicesSection.click();
    }

    public void chooseCategoryFromColumn(String category, String column) {
    }

    // Dodaj inne metody specyficzne dla strony wyboru urządzeń, jeśli są potrzebne
}

