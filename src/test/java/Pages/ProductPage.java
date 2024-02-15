package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Dodaj do koszyka')]"));
        addToCartButton.click();
    }

    public void selectProduct() {
    }

    public void addToCart() {
    }

    public void chooseFirstProduct() {
    }

    public boolean comparePrices(String price1, String price2) {

        return false;
    }

    // Dodaj inne metody specyficzne dla strony produktu, jeśli są potrzebne
}
