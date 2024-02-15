package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageDisplayed() {
        WebElement cartPageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Twój koszyk')]"));
        return cartPageTitle.isDisplayed();
    }

}
