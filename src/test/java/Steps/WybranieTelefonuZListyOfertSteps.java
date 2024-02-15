package Steps;
import Pages.CartPage;
import Pages.DevicesPage;
import Pages.HomePage;
import Pages.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class WybranieTelefonuZListyOfertSteps {
    private WebDriver driver;
    private HomePage homePage;
    private DevicesPage devicesPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Given("Otwórz odpowiednią przeglądarkę")
    public void openBrowser() {
        WebDriverManager.chromedriver ().setup ();
//        System.setProperty("webdriver.chrome.driver", "ścieżka/do/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        devicesPage = new DevicesPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        driver.manage ().window ().maximize ();
//        driver.get (urlAdress);
//        driver.findElement (By.id ("didomi-notice-agree-button")).click ();

    }


    @Then("Przeglądarka zostaje otwarta")
    public void BrowserOpens() {
        assertTrue(homePage.isBrowserOpened());
        System.out.println ("Browser has been successfully opened - PASS");
//        class Steps {
//            // Poprzednie definicje kroków testowych
//
//            @Then("Przeglądarka zostaje otwarta")
//            public void verifyBrowserIsOpened() {
//                assertTrue(homePage.isBrowserOpened());
//                System.out.println ("Browser has been successfully opened - PASS");
//            }
//        }
    }

    @When ("Przejdz na strone 'Tmobile'")
    public void goToTMobilePage(){
        homePage.goToHomePage();
        driver.findElement (By.id ("didomi-notice-agree-button")).click ();
    }

    @Then ("Strona glowna T-Mobile jest widoczna")
    public void stronaGlownaTMobile(){
        assertTrue(homePage.isHomePageDisplayed());
    }

    @When ("Z gornej belki wybierz {string}")
    public void chooseDevicesSection(String section){
        devicesPage.chooseDevicesSection(section);
    }

    @Then ("Rozwijana lista {string} jest widoczna")
    public void dropDownListIsVisible(String section){
        devicesPage.chooseDevicesSection(section);

    }

//    @Given("Wybierz sekcję {string}")
//    public void chooseDevicesSection(String section) {
//        devicesPage.chooseDevicesSection(section);
//    }

    @Given("Wybierz kategorię {string} z kolumny {string}")
    public void chooseCategoryFromColumn(String category, String column) {
        devicesPage.chooseCategoryFromColumn(category, column);
    }

    @Given("Wybierz pierwszy produkt z listy")
    public void chooseFirstProduct() {
        productPage.chooseFirstProduct();
    }

    @When("Dodaj produkt do koszyka")
    public void addProductToCart() {
        productPage.addProductToCart();
    }

    @Then("Strona {string} jest widoczna")
    public void verifyPageIsVisible(String pageName) {
        if (pageName.equals("Twój koszyk")) {
            assertTrue(cartPage.isCartPageDisplayed());
        } else if (pageName.equals("strona główna T-Mobile")) {
            assertTrue(homePage.isHomePageDisplayed());
        }
    }

    @Then("Kwoty {string} oraz {string} zgadzają się z kwotami z poprzedniej strony")
    public void verifyPricesMatch(String price1, String price2) {
        assertTrue(productPage.comparePrices(price1, price2));
    }

    @Then("Ikona koszyka z liczbą produktów w koszyku jest widoczna na stronie głównej T-Mobile")
    public void verifyCartIconIsVisibleOnHomePage() {
        assertTrue(homePage.isCartIconVisible());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}

