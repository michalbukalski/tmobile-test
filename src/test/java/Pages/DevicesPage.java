package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DevicesPage extends BasePage {
    public DevicesPage(WebDriver driver) {
        super(driver);
    }

    public void chooseDevicesSection(String section) {

        String xpath = String.format("//button[@type='button' and contains(.,'%s')]", section);
        WebElement devicesSection = driver.findElement(By.xpath(xpath));
        devicesSection.click();
    }

    public void chooseCategoryFromColumn(String category, String column) {
        //li[//span[@class and contains(.,'Bez abonamentu')]]//p[@class and contains(.,'Smartwatche i opaski')
        String xpath = String.format("(//span[@class and contains(.,'%s')])[2]",category);
        WebElement devicesSection = driver.findElement(By.xpath(xpath));
        devicesSection.click();

    }

}

