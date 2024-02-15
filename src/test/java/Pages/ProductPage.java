package Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        WebElement addToCartButton = driver.findElement(By.xpath("(//div[@class='sc-gzzPqb fdaVoX dt_typography variant_bodyBold' and contains(text(),'Dodaj do koszyka')])[2]"));
        addToCartButton.click();
    }

    public void selectProduct() {
    }

    public void addToCart() {
    }

    public void chooseFirstProduct() {
        WebElement firstProductFromTheList = driver.findElement (By.xpath ("//div[@data-qa='LST_ProductCard0']"));
        firstProductFromTheList.click ();
    }

//    public void comparePrices() throws InterruptedException {
//        Thread.sleep (5000);
//        WebElement priceElementForStart1 = driver.findElement(By.xpath("(//div[@class='dt_price_change'])[3]"));
//        WebElement priceElementForMonthlyFee1 = driver.findElement(By.xpath("(//div[@class='dt_price_change'])[4]"));
//        String priceForStart1 = priceElementForStart1.getText();
//        String monthlyFee1 = priceElementForMonthlyFee1.getText();
//
//        Thread.sleep(5000);
//        addProductToCart();
//        Thread.sleep(5000);
//
//        WebElement priceElementForStart2 = driver.findElement(By.xpath("//span[@data-qa='BKT_TotalupFront']"));
//        WebElement PriceFrontSymbol = driver.findElement (By.xpath ("//span[@data-qa='BKT_TotalupFrontSymbol']"));
//        WebElement priceElementForMonthlyFee2 = driver.findElement(By.xpath("//span[@data-qa='BKT_TotalMonthly']"));
//        WebElement priceFontForMonthlyFee2 = driver.findElement (By.xpath ("//span[@data-qa='BKT_TotalMonthlySymbol']"));
//        String priceForStart2 = priceElementForStart2.getText();
//        String priceFontSymbol = PriceFrontSymbol.getText();
//        String FinalPrice = (priceForStart2 +" "+ priceFontSymbol);
//        String priceFontForMonthly = priceFontForMonthlyFee2.getText ();
//        String monthlyFee2 = priceElementForMonthlyFee2.getText();
//        String FinalMonthlyPrice = (monthlyFee2+" "+priceFontForMonthly);
//
//        Assert.assertEquals (priceForStart1,FinalPrice);
//        Assert.assertEquals (monthlyFee1,FinalMonthlyPrice);
//
//
//    }

    public void comparePrices() throws InterruptedException {
    Thread.sleep (5000);
    WebElement priceElementForStart1 = driver.findElement(By.xpath("(//div[@class='dt_price_change'])[3]"));
    String phrase = priceElementForStart1.getText();
    String[] splitPhrase = phrase.split(" ");
    String phrase_1 = splitPhrase[0];

    WebElement priceElementForMonthlyFee1 = driver.findElement(By.xpath("(//div[@class='dt_price_change'])[4]"));
    String phrase2 = priceElementForMonthlyFee1.getText();
    String[] splitPhrase2 = phrase2.split(" ");
    String phrase_2 = splitPhrase2[0];

    Thread.sleep(5000);
    addProductToCart();
    Thread.sleep(5000);

    WebElement priceElementForStart2 = driver.findElement(By.xpath("//span[@data-qa='BKT_TotalupFront']"));
    WebElement priceElementForMonthlyFee2 = driver.findElement(By.xpath("//span[@data-qa='BKT_TotalMonthly']"));
    String priceForStart2 = priceElementForStart2.getText();

    String monthlyFee2 = priceElementForMonthlyFee2.getText();

        Assert.assertEquals (phrase_1,priceForStart2);
        Assert.assertEquals (phrase_2,monthlyFee2);


}

}
