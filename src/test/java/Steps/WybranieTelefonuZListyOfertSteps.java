package Steps;
import Pages.CartPage;
import Pages.DevicesPage;
import Pages.HomePage;
import Pages.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
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
    public void chooseDevicesSection(String section) throws InterruptedException {
        devicesPage.chooseDevicesSection(section);
    }

    @When ("Kliknij {string} z kolumny {string}")
    public void chooseCategoryFromColumn2(String category, String column) throws InterruptedException {
        devicesPage.chooseCategoryFromColumn(category, column);
    }

    @Then ("Lista produktow {string} jest widoczna")
    public void productslistwithoutSubscription(String string){
        homePage.isElementVisible (string);

    }

    @Then ("Lista produktów {string} jest widoczna")
    public void productListWithoutSubscription(String string){
        Assert.assertTrue (homePage.isElementVisible (string));
        Assert.assertTrue (homePage.isDeviceVisible ("//div[@data-qa='LST_ProductCard1']"));

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

    @When ("Kliknij w pierwszy element z listy")
    public void chooseFirstProductOnTheList(){
        productPage.chooseFirstProduct ();
    }

    @Then ("Strona produktu jest widoczna")
    public void webPageWithProductIsDisplayed() throws InterruptedException {
        Thread.sleep (5000);
        Assert.assertTrue (homePage.isDeviceVisible ("//span[@class='anchorText' and contains(.,'Przejdź do listy urządzeń')]"));
    }

    @When("Dodaj produkt do koszyka")
    public void addProductToCart() throws InterruptedException {
        productPage.addProductToCart();
        Thread.sleep (5000);
    }

    @Then("Strona {string} jest widoczna")
    public void verifyPageIsVisible(String pageName) {
        if (pageName.equals("Twój koszyk")) {
            assertTrue(cartPage.isCartPageDisplayed());
        } else if (pageName.equals("strona główna T-Mobile")) {
            assertTrue(homePage.isHomePageDisplayed());
        }
    }

    @Then("Kwoty Cena na start oraz Rata miesięczna zgadzają się z kwotami w koszyku")
    public void verifyPricesMatch() throws InterruptedException {
        productPage.comparePrices ();
//        assertTrue(productPage.comparePrices(price1, price2));
    }

    @And ("W prawym górnym rogu widoczna jest ikonka koszyka z liczbą produktów w koszyku")
    public void verifyCartIconIsVisibleOnHomePage() throws InterruptedException {
        assertTrue(homePage.isCartIconVisible());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}

