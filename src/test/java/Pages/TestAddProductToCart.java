package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAddProductToCart {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void testAddProductToCart() {
        homePage.openHomePage();
        homePage.goToDevicesSection();
        productPage.selectProduct();
        productPage.addToCart();

        // Add assertions here to verify expected results
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

